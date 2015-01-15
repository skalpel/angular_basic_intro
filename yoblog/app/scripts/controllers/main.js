'use strict';

/**
 * @ngdoc function
 * @name yoblogApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the yoblogApp
 */
angular.module('yoblogApp')
  .controller('MainCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
