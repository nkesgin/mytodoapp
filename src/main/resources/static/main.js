(function(){
	'use strict';
	var app = angular.module('app', ['ngRoute', 'ngResource']);
	app.config(['$routeProvider', '$locationProvider',
	  function($routeProvider, $locationProvider) {
	}]);
	
	app.controller('NoteController', ['$http','$scope', function NoteController($http, $scope){
		this.name = 'NoteController';
		$scope.userId =-1;
		$scope.notes = [];
		$scope.user = {};
		$scope.init = function(){
			$http.get('/customer/getId').then(function(response){
				console.log(response);
				$scope.userId = response.data;
				$http.get('/customer/'+$scope.userId).then(function(response){
					$scope.user = response.data[0];
				});
				$http.get('/note/userId='+$scope.userId).then(function(response){
					console.log(response.data);
					$scope.notes = response.data;
				});
			});
		}
		$scope.createNote = function(){
			var note = {
					"title" : $scope.title,
					"text" : $scope.text,
					"user_id" : $scope.userId,
					"userId" : $scope.userId
			};
			console.log(note);
			$http({
			    method  : 'POST',
			    url     : '/note/create',
			    data    : note,
			    headers : {'Content-Type': 'application/json'} 
			}).then(function(response) {
				if(response.status === 200){
					window.location.href = "/";
				}else{
					alert(response.data);
				}
			},function(error){
				alert(error)
			});
		}
		
		$scope.deleteNote = function(note){
			$scope.note = note;
			$http.get('/note/delete/' + note.id).then(function (response) {
				if(response.status === 200){
					window.location.href = "/";
				}
			}, function (error) {
				alert("cannot delete");
			});
		}
		
		$scope.setNoteAsChecked = function(note){
			$http.get('/note/update/' + note.id).then(function (response) {
				if(response.status === 200){
					window.location.href = "/";
				}
			}, function (error) {
				console.log(error);
			});
		}
	}]);
	
	app.controller('LoginController', ['$http','$scope',function LoginController($http, $scope){
		this.name = 'LoginController';
		$scope.login = function(){
			var user = {
					"username" : $scope.username,
					"password" : $scope.pass
			};
			
			$http({
			    method  : 'POST',
			    url     : '/customer/signIn',
			    data    : user,
			    headers : {'Content-Type': 'application/json'} 
			}).then(function (response) {
				console.log(response);
				if(response.status === 200){
					window.location.href = "/";
				}else{
					alert(response.status);
				}
			}, function (error) {
				if(error.status === 406){
					alert("wrong password");
				}else if(error.status === 404){
					alert("no such user");
				}else{
					alert(error.status);
				}
			});
		}
		
		$scope.create = function(){
			console.log($scope.username);
			var user = {
					"username" : $scope.username,
					"password" : $scope.pass
			};
			console.log(user);
			$http({
			    method  : 'POST',
			    url     : '/customer/newCustomer',
			    data    : user,
			    headers : {'Content-Type': 'application/json'} 
			}).then(function(response) {
				if(response.status === 200){
					window.location.href = "/";
				}else{
					alert(responser.data);
				}
			},function(error){
				alert(error)
			});
		}
	}]);
	
	
	$('a.js-scroll-trigger[href*="#"]:not([href="#"])').click(function() {
	    if (location.pathname.replace(/^\//, '') == this.pathname.replace(/^\//, '') && location.hostname == this.hostname) {
	      var target = $(this.hash);
	      target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
	      if (target.length) {
	        $('html, body').animate({
	          scrollTop: (target.offset().top)
	        }, 1000, "easeInOutExpo");
	        return false;
	      }
	    }
	  });

	  // Closes responsive menu when a scroll trigger link is clicked
	  $('.js-scroll-trigger').click(function() {
	    $('.navbar-collapse').collapse('hide');
	  });

	  // Activate scrollspy to add active class to navbar items on scroll
	  $('body').scrollspy({
	    target: '#sideNav'
	  });
})();

