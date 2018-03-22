(function() {
  var module = angular.module('pomodoroapp');
  module.controller('TaskController', [ '$scope', 'taskService',
      function($scope, taskService) {

        $scope.getAllTasks = function() {
          taskService.getAllTasks().then(function(response) {
            $scope.allTasks = response.data;
          }, function(error) {
            console.log(error);
          });
        }

        var initialization = function() {
          $scope.getAllTasks();
        }
        initialization();

      } ]);
})();
