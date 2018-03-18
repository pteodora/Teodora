(function(){
	var module = angular.module('pomodoroapp');
	module.controller('UserController', ['$scope', 'userService', function($scope, userService) {

		$scope.getLoggedInUser = function() {
			userService.getUser().then(function(response) {
				$scope.user = response.data;
			}, function(error) {
				console.log(error);
			});
		}
		
		$scope.getAllUsers = function() {
			userService.getAllUsers().then(function(response) {
				$scope.allUsers = response.data;
			}, function(error) {
				console.log(error);
			});
		}
		
		
		var initialization = function() {
			$scope.getLoggedInUser();
			$scope.getAllUsers();
		}
		initialization();
		
	}]);
})();
