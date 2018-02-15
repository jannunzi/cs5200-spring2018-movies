package com.jga.dao.movie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jga.models.movie.Movie;

public class MovieDao {
//	private static final String PASSWORD = "pa$$w0rd";
//	private static final String USERNAME = "jannunzi";
	//	private static final String URL = "jdbc:mysql://test-spring2018-annunziato.cne500ro4imj.us-west-2.rds.amazonaws.com/test_spring2018_annunziato";
	private static final String URL = "jdbc:mysql://localhost:3306/test_spring2018_annunziato";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "saltoangel11";
	public static MovieDao instance = null;
	public static MovieDao getInstance() {
		if (instance == null) {
			instance = new MovieDao();
		}
		return instance;
	}
	private MovieDao() {}
	
	public List<Movie> findAllMovies() {
		List<Movie> movies = new ArrayList<Movie>();
		Connection connection = null;
		Statement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			statement = connection.createStatement();
			String sql = "SELECT * FROM movies";
			results = statement.executeQuery(sql);
			while(results.next()) {
				String title = results.getString("title");
				String imdbId = results.getString("imdbId");
				String plot = results.getString("plot");
				String poster = results.getString("poster");
				Movie movie = new Movie(imdbId, title, plot, poster);
				movies.add(movie);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return movies;
	}
	public Movie findMovieByImdb(String id) {
		Movie movie = null;
	
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "SELECT * FROM movies WHERE imdbId = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, id);
			results = statement.executeQuery();
			if(results.next()) {
				String title = results.getString("title");
				String imdbId = results.getString("imdbId");
				String plot = results.getString("plot");
				String poster = results.getString("poster");
				movie = new Movie(imdbId, title, plot, poster);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return movie;
	}
	public int createMovie(Movie movie) {
		
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "INSERT INTO movies (imdbId, title, plot, poster) VALUES (?,?,?,?)";
			statement = connection.prepareStatement(sql);
			statement.setString(1, movie.getImdbId());
			statement.setString(2, movie.getTitle());
			statement.setString(3, movie.getPlot());
			statement.setString(4, movie.getPoster());
			result = statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public int deleteMovie(String imdbId) {
		Connection connection = null;
		PreparedStatement statement = null;
		int result = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "DELETE FROM movies WHERE imdbId=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, imdbId);
			result = statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public int updateMovie(String imdbId, Movie movie) {
		Connection connection = null;
		PreparedStatement statement = null;
		int results = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			String sql = "UPDATE movies SET imdbId=?,title=?,plot=?,poster=? WHERE imdbId=?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, movie.getImdbId());
			statement.setString(2, movie.getTitle());
			statement.setString(3, movie.getPlot());
			statement.setString(4, movie.getPoster());
			statement.setString(5, imdbId);
			results = statement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return results;
	}
}
