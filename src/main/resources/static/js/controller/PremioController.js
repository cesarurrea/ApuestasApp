apuestasApp.controller("premioController", function($scope, premioService) {

	$scope.Premio = {
		idpremio : '',
		nrocolilla : '',
		idsorteo : '',
		valorpagar : '',
		estado : '',
		fechaestado : ''
	}
	
	$scope.colilla = '';

	$scope.PremioSeleccionado = {};
	$scope.accion = '';

	$scope.onloadFun = function() {
		//getPremios();
	}

	function getPremios() {

		$scope.premios = {};

		var requestResponse = premioService.consultarganador($scope.colilla);

		requestResponse.then(function(response) {
			$scope.premios = response.data;
		}, function() {

		})
	}
	;

	$scope.adicionar = function(data) {

		if (data.idpremio) {
			var requestResponse = premioService.update(data);

			requestResponse.then(function(response) {
				getPremios();
				$('#formModal').modal('hide');
			}, function() {

			})

		} else {

			var requestResponse = premioService.create(data);

			requestResponse.then(function(response) {
				getPremios();
			}, function() {

			})
		}

		$scope.Premios = {};
		$scope.PremioSeleccionado = {};

	}

	$scope.confirmUpdate = function(data) {

		$scope.accion = 'Editar Premio';

		$scope.PremioSeleccionado = angular.copy(data);
		$('#formModal').modal('show');
	}

	$scope.createDialog = function() {
		getPremios();		
	}

	$scope.confirmDelete = function(data) {
		
		$scope.Premio = data;
		
		$('#EliminarModal').modal('show');

	}

	$scope.eliminar = function() {

		var requestResponse = premioService.destroy($scope.Premio.idpremio);

		requestResponse.then(function(response) {
			getPremios();
			$('#EliminarModal').modal('hide');
		}, function() {

		})

		$scope.Premio = {};

	}

});