(function() {
  var module = angular.module('pomodoroapp');
  module.service('teamService', [ '$http', '$q', function($http, $q) {

    var service = this;

    service.saveTeam = function(newTeam) {
      var deferred = $q.defer();
      $http.post('saveTeam', newTeam).then(function(response) {
        deferred.resolve(response);
      }, function(error) {
        deferred.reject(error);
      });
      return deferred.promise;
    }

    service.getUserTeams = function() {
      var deferred = $q.defer();
      $http.get('userTeams').then(function(response) {
        deferred.resolve(response);
      }, function(error) {
        deferred.reject(error);
      });
      return deferred.promise;
    }

    service.getSelectedTeam = function(teamId) {
      var deferred = $q.defer();
      $http.get('selectedTeam/' + teamId).then(function(response) {
        deferred.resolve(response);
      }, function(error) {
        deferred.reject(error);
      });
      return deferred.promise;
    }

    service.leaveTeam = function(teamId) {
      var deferred = $q.defer();
      $http.get('leaveTeam/'+ teamId).then(function(response) {
        deferred.resolve(response);
      }, function(error) {
        deferred.reject(error);
      });
      return deferred.promise;
    }

    service.inviteUser = function(email) {
      var deferred = $q.defer();
      $http.post('inviteUser', email).then(function(response) {
        deferred.resolve(response);
      }, function(error) {
        deferred.reject(error);
      });
      return deferred.promise;
    }

  } ]);
})();