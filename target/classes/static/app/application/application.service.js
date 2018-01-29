(function(angular) {

	'use strict';

	function applicationService($http){		  
		/* This call is used for add application */
		this.addApplication = function(application) {
			console.log("In service");
			console.log(application);
			var promise = $http.post('/application', application)
					.then(function(response) {
						console.log(response);
                      return response;
					});

			return promise;
		};
		
		this.getApplication = function(application) {
			var promise = $http.get('/application', application)
					.then(function(response) {
						console.log(response);
                      return response;
					});

			return promise;
		};
		this.getApplicationById = function(appId) {
			var promise = $http.get('/application/'+appId)
					.then(function(response) {
						console.log(response);
                      return response;
					});

			return promise;
		};
		
		this.editGroup = function(group) {
			var promise = $http.put('/applicationGroup', group)
					.then(function(response) {
						console.log(response);
                      return response;
					});
			return promise;
		};
		
		this.deleteGroup = function(group) {
			var promise = $http.delete('/applicationGroup/'+group.id)
					.then(function(response) {
						console.log(response);
                      return response;
					});
			return promise;
		};
		
	}

	applicationService.$inject = ['$http'];

	angular.module('translatorProject.application').service('applicationService', applicationService);

})(window.angular);