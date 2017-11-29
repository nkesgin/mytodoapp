/**
 * 
 */
(function(){
	'use strict';
	
	angular
		.module('app')
		.controller('LoginController', LoginController);
	
	LoginController.$inject = ['$http', '$scope'];
	
	function LoginController($http, $scope){
		var vm = this;
		init();
		function init(){
			
		}

		
		
	}
	
	function login(){
		var user = {
				"username" : $scope.username,
				"pass" : $scope.pass
		};
		$http.post('/customer/signIn', user).then(function (response) {
			if(response === "S"){
				window.location.href = "/";
			}else{
				alert(response);
			}
		}, function (response) {
			alert("fail");
		});
	}
	
	function create(){
		console.log($scope.username);
		var user = {
				"username" : $scope.username,
				"pass" : $scope.pass
		};
		$http.post('/customer/customerNew', user).then(function (response) {
			alert("success");
			window.location.href = "/";
		}, function (response) {
			alert("fail");
		});
	}
})();