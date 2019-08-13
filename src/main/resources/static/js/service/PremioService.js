apuestasApp.service('premioService', function($http) {
	$this = this;

	$this.getAll = function() {
		var request = $http({
			method : 'GET',
			url : '/services/vuelo'
		});
		return request;
	}

	$this.create = function(entity) {
		var request = $http({
			method : 'PUT',
			url : '/services/vuelo',
			data : JSON.stringify(entity),
			dataType : "json"
		});
		return request;
	}

	$this.update = function(entity) {
		var request = $http({
			method : 'POST',
			url : '/services/vuelo',
			data : JSON.stringify(entity),
			dataType : "json"
		});
		return request;
	}

	$this.consultarganador = function(id) {
		var request = $http({
			method : 'GET',
			url : '/services/premio/' + id
		});
		return request;

	}

})