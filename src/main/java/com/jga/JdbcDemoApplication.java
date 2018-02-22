package com.jga;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jga.lectures.xml.Library;
import com.jga.lectures.xml.Movie;
//import com.jga.dao.movie.MovieDao;
//import com.jga.experiments.dao.MovieXmlDao;
//import com.jga.experiments.models.*;
import com.jga.lectures.xml.MoviesXmlDao;

@SpringBootApplication
public class JdbcDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcDemoApplication.class, args);

		
		MoviesXmlDao xmlDao = MoviesXmlDao.getInstance();
		
		Movie movie1 = new Movie("123","movie 1", "plot 1", "poster 1");
		Movie movie2 = new Movie("234","movie 2", "plot 2", "poster 2");
		Collection<Movie> movieList = new ArrayList<Movie>();
		movieList.add(movie1);
		movieList.add(movie2);
		Library library = new Library();
		library.setMovies(movieList);

		xmlDao.writeLibraryOfMoviesToXmlFileUsingJaxB(library, "movieLibrary.xml");
		
//		xmlDao.parseXmlFile("movies.xml");
//		
//		Movie bladeRunner = new Movie("tt0083658", "Blade Runner", "A blade runner must pursue and try to terminate four replicants who stole a ship in space and have returned to Earth to find their creator.", "https://images-na.ssl-images-amazon.com/images/M/MV5BNzQzMzJhZTEtOWM4NS00MTdhLTg0YjgtMjM4MDRkZjUwZDBlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg");
//		xmlDao.writeMovieObjectToXmlFileUsingJaxB(bladeRunner, "bladeRunner.xml");
//		
//		MovieXmlDao xmlDao = MovieXmlDao.getInstance();

//		xmlDao.transformMovies("movies2movieTitles.xsl", "movies.xml", "titles.xml");
//		xmlDao.transformMovies("movies2html.xsl", "movies.xml", "movies.html");
//		xmlDao.transformMovies("groupMoviesByRating2html.xsl", "movies.xml", "moviesGroupedByRating.html");
//		xmlDao.transformMovies("groupMoviesByYearReleased2html.xsl", "movies.xml", "moviesGroupedByYearReleased.html");
		
//		List<Movie> movies = xmlDao.readMoviesFromXmlFile();
//		
//		for(Movie movie: movies) {
//			System.out.println(movie);
//		}
//		
//		Movie bladeRunner1 = new Movie("tt0083658", "Blade Runner", "A blade runner must pursue and try to terminate four replicants who stole a ship in space and have returned to Earth to find their creator.", "https://images-na.ssl-images-amazon.com/images/M/MV5BNzQzMzJhZTEtOWM4NS00MTdhLTg0YjgtMjM4MDRkZjUwZDBlXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg");
//		xmlDao.writeMovieToXmlFile(bladeRunner1, "bladeRunner1.xml");
//		
//		Movie bladeRunner2 = new Movie("tt1856101", "Blade Runner 2049", "A young blade runner's discovery of a long-buried secret leads him to track down former blade runner Rick Deckard, who's been missing for thirty years.", "https://images-na.ssl-images-amazon.com/images/M/MV5BNzA1Njg4NzYxOV5BMl5BanBnXkFtZTgwODk5NjU3MzI@._V1_SX300.jpg");
//		Collection<Movie> movieCollection = new ArrayList<Movie>();
//		movieCollection.add(bladeRunner1);
//		movieCollection.add(bladeRunner2);
//		Movies movieList = new Movies();
//		movieList.setMovies(movieCollection);
//
//		xmlDao.writeMoviesToXmlFile(movieList, "bladeRunners.xml");
//		
//		movieList = xmlDao.unmarshalMoviesFromXmlFile("bladeRunners.xml");
//		for(Movie movie: movieList.getMovies()) {
//			System.out.println(movie);
//		}
	}
}
