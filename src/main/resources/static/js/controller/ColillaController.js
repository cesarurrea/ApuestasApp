apuestasApp.controller("colillaController", function($scope, colillaService) {

	$scope.Colilla = {
		nrocolilla : '',
		estado : '',
		fechaestado : '',
		fechasorteo : '',
		numeroapuesta : '',
		valorapuesta : ''
	}

	$scope.ColillaSeleccionado = {};
	$scope.accion = '';

	$scope.onloadFun = function() {
		getColillas();
	}

	function getColillas() {

		$scope.colillas = {};

		var requestResponse = colillaService.getAll();

		requestResponse.then(function(response) {
			$scope.colillas = response.data;
		}, function() {

		})
	}
	;

	$scope.adicionar = function(data) {

		if (data.nrocolilla) {
			var requestResponse = colillaService.update(data);

			requestResponse.then(function(response) {
				getColillas();
				$('#formModal').modal('hide');
			}, function() {

			})

		} else {

			var requestResponse = colillaService.create(data);

			requestResponse.then(function(response) {
				getColillas();
			}, function() {

			})
		}

		$scope.Colillas = {};
		$scope.ColillaSeleccionado = {};

	}

	$scope.confirmUpdate = function(data) {

		$scope.accion = 'Editar Colilla';

		$scope.ColillaSeleccionado = angular.copy(data);
		$('#formModal').modal('show');
	}

	$scope.createDialog = function() {
		$scope.accion = 'Nueva Colilla';
		$scope.ColillaSeleccionado = {};
		$('#formModal').modal('show');
	}

	$scope.confirmDelete = function(data) {
		
		$scope.Colilla = data;
		
		$('#EliminarModal').modal('show');

	}

	$scope.eliminar = function() {

		var requestResponse = colillaService.destroy($scope.Colilla.nrocolilla);

		requestResponse.then(function(response) {
			getColillas();
			$('#EliminarModal').modal('hide');
		}, function() {

		})

		$scope.Colilla = {};

	}

});