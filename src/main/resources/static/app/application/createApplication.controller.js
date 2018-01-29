(function(angular) {

	'use strict';

	function createApplicationController($http, $scope, $rootScope,
			$routeParams, $filter, $location, applicationService) {

		$scope.fieldTypes = [ "text", "number", "checkbox", "password",
				"dropdown", "email" ];
		$scope.fieldDataTypes = [ "string", "number", "alphanumberic" ];
		$scope.application = {
			"applicationMetaData" : []
		};
		$scope.resetProperty = function() {
			$scope.newProperty = {
				"fieldType" : $scope.fieldTypes[0],
				"fieldDataType" : $scope.fieldDataTypes[0]
			};
		};
		$scope.resetProperty();
		$scope.addProperty = function() {

			$scope.application.applicationMetaData.push(angular
					.copy($scope.newProperty));
			$scope.resetProperty();
			$scope.appForm.$setUntouched();
		};
		$scope.genrateApplication = function() {

			applicationService.addApplication($scope.application).then(
					function(response) {
						console.log(response.data.responseMessage);
						/*
						 * $scope.message = response.data.responseMessage;
						 * response.body
						 */
						applicationService.getApplication().then(
								function(getresponse) {
									$rootScope.appList = getresponse.data.body;
									$rootScope.$apply;
									$location.path('/application/'
											+ response.data.body.id);
								});
					});
		};
	}

	createApplicationController.$inject = [ '$http', '$scope', '$rootScope',
			'$routeParams', '$filter', '$location', 'applicationService' ];

	angular.module('translatorProject.application').controller(
			'createApplicationController', createApplicationController);

})(window.angular);