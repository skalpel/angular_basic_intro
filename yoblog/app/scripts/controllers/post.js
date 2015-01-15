'use strict';

/**
 * @ngdoc function
 * @name yoblogApp.controller:PostCtrl
 * @description
 * # PostCtrl
 * Controller of the yoblogApp
 */
angular.module('yoblogApp')
  .controller('PostCtrl', function ($scope, contentProvider) {
    $scope.showInfo = false;
    $scope.showError = false;

    $scope.save = function (post) {
      if(post === undefined) {
        post = {};
      }
      post.date = new Date().getTime();
      contentProvider.addPost(
        post,
        function () {
          $scope.post = {};
          $scope.showInfo = true;
          $scope.message = 'Successfully added new post.';
        },
        function () {
          $scope.showError = true;
          $scope.message = 'Unable to add new post (one of possible reason could be interrupted connection to the server).';
        });
    };
  });
