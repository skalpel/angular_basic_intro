'use strict';

/**
 * @ngdoc service
 * @name yoblogApp.contentProvider
 * @description
 * # contentProvider
 * Service in the yoblogApp.
 */
angular.module('yoblogApp')
  .service('contentProvider', function ($http) {

    function downloadPosts(onSuccess, onError) {
      $http.get('http://localhost:4567/posts')
        .success(function (data) {
          onSuccess(data.posts);
        })
        .error(function () {
          onError();
        });
    }

    function sortPosts(posts) {
      posts.sort(function (a, b) {
        return b.date - a.date;
      });
    }

    this.getLatestPosts = function (onSuccess, onError) {
      downloadPosts(
        function (posts) {
          sortPosts(posts);
          posts = posts.slice(0, 3);
          onSuccess(posts);
        },
        function () {
          onError();
        });
    };

    function transformation(obj) {
      var str = [];
      for (var p in obj) {
        str.push(encodeURIComponent(p) + '=' + encodeURIComponent(obj[p]));
      }
      return str.join('&');
    }

    this.addPost = function (blogPost, onSuccess, onError) {
      $http({
        method: 'POST',
        url: 'http://localhost:4567/posts',
        data: blogPost,
        transformRequest: transformation,
        headers: {'Content-Type': 'application/x-www-form-urlencoded'}
      })
        .success(function () {
          onSuccess();
        })
        .error(function () {
          onError();
        });
    };

  });
