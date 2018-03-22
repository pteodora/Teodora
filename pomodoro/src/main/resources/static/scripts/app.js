'use strict';

angular.module('pomodoroapp', [ 'ngRoute' ]).config(
    [ "$routeProvider", "$locationProvider",
        function($routeProvider, $locationProvider) {
          $routeProvider.when('/', {
            templateUrl : 'views/home.html',
          }).when('/home', {
            templateUrl : 'views/home.html',
            controller : 'HomeController',
            controllerAs : 'homeController'
          }).when('/user', {
            templateUrl : 'views/user.html',
            controller : 'UserController',
            controllerAs : 'userController'
          }).otherwise({}).when('/userList', {
            templateUrl : 'views/userList.html',
            controller : 'UserController',
            controllerAs : 'userController'
          }).when('/userTeams', {
            templateUrl : 'views/userTeams.html',
            controller : 'TeamController',
            controllerAs : 'teamController'
          }).when('/teamDetails/:teamId', {
            templateUrl : 'views/teamDetails.html',
            controller : 'TeamDetailsController',
            controllerAs : 'teamDetailsController'
          }).when('/tasks', {
            templateUrl : 'views/tasks.html',
            controller : 'TaskController',
            controllerAs : 'taskController'
          }).otherwise({
            redirectTo : '/'
          });
        } ])
