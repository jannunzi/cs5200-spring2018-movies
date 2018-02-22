package com.jga.experiments.models;

import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Movies {
	private Collection<Movie> movies;
	public Movies() {
		super();
	}
	public Movies(Collection<Movie> movies) {
		super();
		this.movies = movies;
	}
	public Collection<Movie> getMovies() {
		return movies;
	}
	@XmlElement
	public void setMovies(Collection<Movie> movies) {
		this.movies = movies;
	}
}
