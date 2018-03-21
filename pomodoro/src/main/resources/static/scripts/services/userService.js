(function() {
  var module = angular.module('pomodoroapp');
  module.service('userService', [ '$http', '$q', function($http, $q) {

    var service = this;

    service.getUser = function() {
      var deferred = $q.defer();
      $http.get('user').then(function(response) {
        deferred.resolve(response);
      }, function(error) {
        deferred.reject(error);
      });
      return deferred.promise;
    }

    service.getAllUsers = function() {
      var deferred = $q.defer();
      $http.get('allUsers').then(function(response) {
        deferred.resolve(response);
      }, function(error) {
        deferred.reject(error);
      });
      return deferred.promise;
    }

  } ]);
})();