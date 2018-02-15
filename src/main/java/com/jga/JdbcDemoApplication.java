package com.jga;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jga.dao.movie.MovieDao;
import com.jga.models.movie.Movie;

@SpringBootApplication
public class JdbcDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcDemoApplication.class, args);
		
//		MovieDao dao = MovieDao.getInstance();
		
//		Movie avatar = new Movie("tt0499549", "Avatar", "A paraplegic marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he feels is his home.", "https://images-na.ssl-images-amazon.com/images/M/MV5BMTYwOTEwNjAzMl5BMl5BanBnXkFtZTcwODc5MTUwMw@@._V1_SX300.jpg");
//		dao.createMovie(avatar);
//		Movie titanic = new Movie("tt0120338", "Titanic", "A seventeen-year-old aristocrat falls in love with a kind but poor artist aboard the luxurious, ill-fated R.M.S. Titanic.", "https://images-na.ssl-images-amazon.com/images/M/MV5BMDdmZGU3NDQtY2E5My00ZTliLWIzOTUtMTY4ZGI1YjdiNjk3XkEyXkFqcGdeQXVyNTA4NzY1MzY@._V1_SX300.jpg");
//		Movie br2049 = new Movie("tt1856101", "Blade Runner 2049", "A young blade runner's discovery of a long-buried secret leads him to track down former blade runner Rick Deckard, who's been missing for thirty years.", "https://images-na.ssl-images-amazon.com/images/M/MV5BNzA1Njg4NzYxOV5BMl5BanBnXkFtZTgwODk5NjU3MzI@._V1_SX300.jpg");
		
//		dao.deleteMovie("123");
		
//		dao.updateMovie("tt0083658", br2049);
		
//		Movie m1 = dao.findMovieByImdb("tt0120338");
//		System.out.println(m1);
//		
//		List<Movie> movies = dao.findAllMovies();
//		System.out.println(movies);
	}
}
