(function() {
  var module = angular.module('pomodoroapp');
  module.service('taskService', [ '$http', '$q', function($http, $q) {

    var service = this;

    service.getAllTasks = function() {
      var deferred = $q.defer();
      $http.get('allTasks').then(function(response) {
        deferred.resolve(response);
      }, function(error) {
        deferred.reject(error);
      });
      return deferred.promise;
    }

  } ]);
})();