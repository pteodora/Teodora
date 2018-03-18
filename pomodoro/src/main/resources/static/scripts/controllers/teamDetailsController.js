(function() {
	var module = angular.module('pomodoroapp');
	module.controller('TeamDetailsController', ['$routeParams', '$scope', 'teamService',
			function($routeParams, $scope, teamService) {
				$scope.teamId = $routeParams.teamId;
				
				$scope.selectedTeam = {};
				
				$scope.getSelectedTeam = function(id) {
					teamService.getSelectedTeam(id).then(function(response) {
						console.log(response);
						$scope.selectedTeam = response.data;
					}, function(error) {
						console.log(error);
					});
				}

				var initialization = function() {
					$scope.getSelectedTeam($scope.teamId);
				}
				initialization();

			} ]);
})();
