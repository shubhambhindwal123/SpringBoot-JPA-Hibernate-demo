(function(angular) {

	'use strict';

	function applicationController($http, $scope, $rootScope, $routeParams,
			$filter, applicationService) {
		// console.log($routeParams.appId);
		$scope.tempGroupObj = {
			"applicationVOs" : []
		};

		$scope.selectBoxData = [ "Data1", "Data2", "Data3" ];

		applicationService
				.getApplicationById($routeParams.appId)
				.then(
						function(response) {
							$scope.application = response.data.body;
							$scope.tempGroupObj = {
								"applicationVOs" : []
							};
							console.log("Harish");
							console.log($scope.application);

							for (var i = 0; i < $scope.application.applicationMetaData.length; i++) {
								var tempAppVO = {
									"field" : $scope.application.applicationMetaData[i].labelName,
									"type" : $scope.application.applicationMetaData[i].fieldType,
									"value" : ""
								};
								$scope.tempGroupObj.applicationVOs
										.push(tempAppVO);
							}

							//
						});
		$scope.addGroup = function() {

			$scope.application.applicationGroups.push(angular
					.copy($scope.tempGroupObj));

			applicationService.addApplication($scope.application).then(
					function(response) {
						$scope.application = response.data.body;
					});
			for (var i = 0; i < $scope.tempGroupObj.applicationVOs.length; i++) {
				$scope.tempGroupObj.applicationVOs[i].value = '';
			}
			;
			$scope.groupForm.$setPristine();
			$scope.groupForm.$setUntouched();

		};
		$scope.editGroupOpen = function(group) {
			$scope.editGroupTemp = angular.copy(group);
			angular.element('#edit').modal('show');
			// group.applicationVOs[0].value = "edit";
		};
		$scope.editGroup = function() {
			applicationService.editGroup($scope.editGroupTemp).then(
					function(response) {
						// console.log(response.data.responseMessage);
						$scope.editGroupTemp = response.data.body;
						angular.element('#edit').modal('hide');

						applicationService.getApplicationById(
								$routeParams.appId).then(function(response) {
							$scope.application = response.data.body;
							// $scope.application.$apply;
						});
					});
		};

		$scope.deleteGroupOpen = function(group) {
			$scope.deleteGroupObj = group;
			angular.element('#delete').modal('show');
		};

		$scope.deleteGroup = function() {
			applicationService.deleteGroup($scope.deleteGroupObj).then(
					function(response) {
						angular.element('#delete').modal('hide');
						applicationService.getApplicationById(
								$routeParams.appId).then(function(response) {
							$scope.application = response.data.body;
							// $scope.application.$apply;
						});
					});
		};

	}

	applicationController.$inject = [ '$http', '$scope', '$rootScope',
			'$routeParams', '$filter', 'applicationService' ];

	angular.module('translatorProject.application').controller(
			'applicationController', applicationController);

})(window.angular);