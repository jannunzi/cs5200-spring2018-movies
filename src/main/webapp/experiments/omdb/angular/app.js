(function(){
	angular
		.module('SimpleAngularOmdbClientApp', [])
		.controller('MovieController', movieController);
	
	function movieController($scope, $http) {
		$scope.findMoviesByKeyword = findMoviesByKeyword;

		function findMoviesByKeyword(keyword) {
			var url = 'http://www.omdbapi.com/';
			url += '?apikey=852159f0&s=' + keyword;
			$http.get(url).then(renderResults);
		}
		function renderResults(results) {
			$scope.movies = results.data.Search;
		}
	}

})();
