apuestasApp.controller("sorteoController", function($scope, sorteoService) {

	$scope.Sorteo = {
		idsorteo : '',
		numeroapuesta : '',
		fechasorteo : ''
	}

	$scope.SorteoSeleccionado = {};
	$scope.accion = '';

	$scope.onloadFun = function() {
		getSorteos();
	}

	function getSorteos() {

		$scope.sorteos = {};

		var requestResponse = sorteoService.getAll();

		requestResponse.then(function(response) {
			$scope.sorteos = response.data;
		}, function() {

		})
	}
	;

	$scope.adicionar = function(data) {

		if (data.idsorteo) {
			var requestResponse = sorteoService.update(data);

			requestResponse.then(function(response) {
				getSorteos();
				$('#formModal').modal('hide');
			}, function() {

			})

		} else {

			var requestResponse = sorteoService.create(data);

			requestResponse.then(function(response) {
				getSorteos();
			}, function() {

			})
		}

		$scope.Sorteo = {};
		$scope.SorteoSeleccionado = {};

	}

	$scope.confirmUpdate = function(data) {

		$scope.accion = 'Editar Sorteo';

		$scope.SorteoSeleccionado = angular.copy(data);
		$('#formModal').modal('show');
	}

	$scope.createDialog = function() {
		$scope.accion = 'Nuevo Sorteo';
		$scope.SorteoSeleccionado = {};
		$('#formModal').modal('show');
	}

	$scope.confirmDelete = function(data) {
		
		$scope.Sorteo = data;
		
		$('#EliminarModal').modal('show');

	}

	$scope.eliminar = function() {

		var requestResponse = sorteoService.destroy($scope.Sorteo.idsorteo);

		requestResponse.then(function(response) {
			getSorteos();
			$('#EliminarModal').modal('hide');
		}, function() {

		})

		$scope.Sorteo = {};

	}

});