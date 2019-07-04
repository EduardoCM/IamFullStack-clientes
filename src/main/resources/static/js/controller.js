app.controller('listarClientesController',
		function($scope, $http, $location, $route){
	console.log("entro1");
	$http({
		method : 'GET',
		url : 'http://localhost:8080/api/v1/cliente',
	}).then(function(response) {
		$scope.clientes = response.data;
		
		console.log("entro3");
	});
	
	$scope.deleteCliente = function(clienteId) {
		$http({
			method : 'DELETE',
			url : 'http://localhost:8080/api/v1/cliente/' + clienteId
		}).then(function(response) {
			$location.path("/list-clientes");
			$route.reload();
		});
	}
	
});
	

app.controller('clienteRegistroController', function($scope, $http, $location,
		$route) {
	
	$scope.submitClienteForm = function(){
		
		$http({
			method : 'POST',
			url : 'http://localhost:8080/api/v1/cliente',
			data : $scope.cliente,
		}).then(function(response) {
			$location.path("/list-clientes");
			$route.reload();
		}, function(errResponse) {		
			$scope.errorMessage = errResponse.data.errorMessage;
		});
		
		
	}
	
	
	
});
	
