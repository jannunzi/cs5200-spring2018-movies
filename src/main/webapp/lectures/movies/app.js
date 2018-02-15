(function(){
	jQuery(init);
	
	var addMovieBtn;
	var posterFld;
	var titleFld;
	var imdbFld;
	var plotFld;

	function init() {
		
		addMovieBtn = $("#addMovieBtn");
		addMovieBtn.click(addMovie);
		
		function findAllMovies() {
			var url = "http://localhost:8080/api/movie";
			jQuery.ajax({
				url: url,
				success: renderMovies
			});
		}
		findAllMovies();
		
		function addMovie() {
			posterFld = $("#posterFld");
			titleFld = $("#titleFld");
			imdbFld = $("#imdbFld");
			plotFld = $("#plotFld");
			
			var poster = posterFld.val();
			var title = titleFld.val();
			var imdb = imdbFld.val();
			var plot = plotFld.val();
			var movie = {
					"title": title,
					"poster": poster,
					"plot": plot,
					"imdbId": imdb
				};
			$.ajax({
				url: '/api/movie',
				type: 'post',
				data: JSON.stringify(movie),
				contentType: 'application/json',
				dataType: 'json',
				success: findAllMovies
			})
		}
		
		function renderMovies(movies) {
			var tbody = $('tbody');
			tbody.empty();
			for(var m in movies) {
				var movie = movies[m];
				var tr = $('<tr>');
				var td = $('<td>');
				td.append(movie.poster);
				tr.append(td);
				
				td = $('<td>');
				td.append(movie.title);
				tr.append(td);
				
				td = $('<td>');
				td.append(movie.imdbId);
				tr.append(td);
				
				td = $('<td>');
				td.append(movie.plot);
				tr.append(td);
				
				td = $('<td><span class="glyphicon glyphicon-remove"></span></td>');
				td.click(deleteMovie);
				td.attr("id", movie.imdbId);
				tr.append(td);
				
				tbody.append(tr);
			}
		}
		
		function deleteMovie(event) {
			var td = $(event.currentTarget);
			var imdbId = td.attr("id");
			$.ajax({
				url: "/api/movie/"+imdbId,
				type: 'delete',
				success: findAllMovies
			});
		}
	}
	
})();