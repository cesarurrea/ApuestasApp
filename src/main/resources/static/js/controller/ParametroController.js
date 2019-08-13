apuestasApp.controller("parametroController", function($scope, parametroService) {

	$scope.Parametro = {
		nombre : '',
		valor : ''
	}

	$scope.ParametroSeleccionado = {};
	$scope.accion = '';

	$scope.onloadFun = function() {
		getParametros();
	}

	function getParametros() {

		$scope.parametros = {};

		var requestResponse = parametroService.getAll();

		requestResponse.then(function(response) {
			$scope.parametros = response.data;
		}, function() {

		})
	}
	;

	$scope.adicionar = function(data) {

		if (data.nombre) {
			var requestResponse = parametroService.update(data);

			requestResponse.then(function(response) {
				getParamtros();
				$('#formModal').modal('hide');
			}, function() {

			})

		} else {

			var requestResponse = parametroService.create(data);

			requestResponse.then(function(response) {
				getParametros();
			}, function() {

			})
		}

		$scope.Parametro = {};
		$scope.ParametroSeleccionado = {};

	}

	$scope.confirmUpdate = function(data) {

		$scope.accion = 'Editar Parametro';

		$scope.ParametroSeleccionado = angular.copy(data);
		$('#formModal').modal('show');
	}

	$scope.createDialog = function() {
		$scope.accion = 'Nuevo Parametro';
		$scope.ParametroSeleccionado = {};
		$('#formModal').modal('show');
	}

	$scope.confirmDelete = function(data) {
		
		$scope.Parametro = data;
		
		$('#EliminarModal').modal('show');

	}

	$scope.eliminar = function() {

		var requestResponse = parametroService.destroy($scope.Parametro.nombre);

		requestResponse.then(function(response) {
			getParametros();
			$('#EliminarModal').modal('hide');
		}, function() {

		})

		$scope.Parametro = {};

	}

});