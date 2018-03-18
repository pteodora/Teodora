(function() {
	var module = angular.module('pomodoroapp');
	module.controller('TeamController', [ '$scope', 'teamService',
			function($scope, teamService) {
				$scope.newTeam = {};
				
				$scope.addNewTeam = function() {
					teamService.saveTeam($scope.newTeam).then(function(response) {
						console.log(response);
						$scope.getUserTeams();
					}, function(error) {
						console.log(error);
					});
				}
				
				$scope.getUserTeams = function() {
					teamService.getUserTeams().then(function(response) {
						$scope.teams = response.data;
					}, function(error) {
						console.log(error);
					});
				}
				
				$scope.leaveTeam = function(teamId) {
					
				}

				var initialization = function() {
					$scope.getUserTeams();
				}
				initialization();

			} ]);
})();
