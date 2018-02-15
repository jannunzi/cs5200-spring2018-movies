package com.jga.service.movie;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jga.dao.movie.MovieDao;
import com.jga.models.movie.Movie;

@RestController
public class MovieService {
	@RequestMapping("/api/movie")
	public List<Movie> findAllMovies() {
		MovieDao dao = MovieDao.getInstance();
		return dao.findAllMovies();
	}
	@RequestMapping("/api/movie/{imdbId}")
	public Movie findMovieById(@PathVariable(name="imdbId") String imdbId) {
		MovieDao dao = MovieDao.getInstance();
		return dao.findMovieByImdb(imdbId);
	}
	@RequestMapping(value="/api/movie/{imdbId}", method=RequestMethod.DELETE)
	public int deleteMovie(@PathVariable(name="imdbId") String imdbId) {
		MovieDao dao = MovieDao.getInstance();
		return dao.deleteMovie(imdbId);
	}
	@RequestMapping(value="/api/movie/{imdbId}", method=RequestMethod.PUT)
	public int updateMovie(@PathVariable(name="imdbId") String imdbId, @RequestBody Movie movie) {
		MovieDao dao = MovieDao.getInstance();
		return dao.updateMovie(imdbId, movie);
	}
	@RequestMapping(value="/api/movie", method=RequestMethod.POST)
	public int createMovie(@RequestBody Movie movie) {
		MovieDao dao = MovieDao.getInstance();
		return dao.createMovie(movie);
	}
}
