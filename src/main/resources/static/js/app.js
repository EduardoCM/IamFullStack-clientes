var app = angular.module('fullStackRegistroUsuarios', ['ngRoute', 'ngResource']);


app.config(function($routeProvider) {
	
	$routeProvider.when('/list-clientes', {
		templateUrl : '/template/listarClientes.html',
		controller: 'listarClientesController'
	}).when('/registrar-nuevo-cliente', {
		templateUrl : '/template/clienteRegistro.html',
		controller: 'clienteRegistroController'
	}).otherwise({
		redirect : '/home',
		templateUrl: '/template/home.html',
	}) ;
	
});