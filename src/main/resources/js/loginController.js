/**
 * 
 */
(function(){
	'use strict';
	
	angular
		.module('app')
		.controller('LoginController', loginController);
	
	LoginController.$inject = ['$http'];
	
	function LoginController($http){
		var vm = this;
	
		init();
		
		function init(){
			login();
		}

		function login(){
			var url = "/login";
			var loginPromise = $http.get(url);
			loginPromise.then(function(response){
				vm.login = response.data;
			});
		}
		
	}
})();