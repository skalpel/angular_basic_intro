'use strict';

/**
 * @ngdoc function
 * @name yoblogApp.controller:BlogCtrl
 * @description
 * # BlogCtrl
 * Controller of the yoblogApp
 */
angular.module('yoblogApp')
  .controller('BlogCtrl', function ($scope, contentProvider) {
    contentProvider.getLatestPosts(
      function (posts) {
        $scope.posts = posts;
      }, function () {
        console.log('Unable to get posts from server.');
      });
  });
