(function(angular) {

	'use strict';

	function viewDashborad($http, $scope, $rootScope, $routeParams, $filter,applicationService) {
		
		// $http.get('project' + $routeParams).then(function(response) {

		// 	$scope.project = response.data.messages[0];

		// })
		$rootScope.appList;
		$scope.getPrerequisite = function(){
			applicationService.getApplication().then(
					function(response) {
						$rootScope.appList = response.data.body;
						/*$scope.message = response.data.responseMessage;
						response.body*/
					});
		};
		$scope.getPrerequisite();
		
	}

	viewDashborad.$inject = [ '$http', '$scope', '$rootScope', '$routeParams', '$filter','applicationService'];
	angular.module('translatorProject.dashboard').controller('viewDashborad', viewDashborad);

})(window.angular);