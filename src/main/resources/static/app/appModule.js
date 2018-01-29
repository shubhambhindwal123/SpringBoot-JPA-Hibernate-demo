﻿(function(angular) {

	'use strict';

	angular.module('translatorProject', [ 'ngRoute','translatorProject.dashboard','translatorProject.application']).config(Configure);	
	
	Configure.$inject = [ '$routeProvider'];
	function Configure($routeProvider) {

		$routeProvider.when("/createApplication", {
			templateUrl: "app/application/create.html",
			controller : 'createApplicationController'
		}).when("/application/:appId", {
			templateUrl: "app/application/application.html",
			controller : 'applicationController'
		});		
	}

})(window.angular);