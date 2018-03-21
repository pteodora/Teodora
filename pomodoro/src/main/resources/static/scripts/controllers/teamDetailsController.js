(function() {
  var module = angular.module('pomodoroapp');
  module.controller('TeamDetailsController', [ '$routeParams', '$scope',
      'teamService', function($routeParams, $scope, teamService) {
        $scope.teamId = $routeParams.teamId;
        $scope.selectedTeam = {};
        $scope.newUser = {};

        $scope.getSelectedTeam = function(id) {
          teamService.getSelectedTeam(id).then(function(response) {
            console.log(response);
            $scope.selectedTeam = response.data;
          }, function(error) {
            console.log(error);
          });
        }

        $scope.inviteUser = function(teamId, email) {
          teamService.inviteUser(teamId, email).then(function(response) {
            console.log(response);
            $scope.getSelectedTeam($scope.teamId);
          }, function(error) {
            console.log(error);
            console.log(teamId);
            console.log(email);
          });
        }

        var initialization = function() {
          $scope.getSelectedTeam($scope.teamId);
        }
        initialization();

      } ]);
})();
