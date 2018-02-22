package com.jga.lectures.xml;

import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Library {
	private Collection<Movie> movies;
	@XmlElement
	public void setMovies(Collection<Movie> movies) {
		this.movies = movies;
	}
	public Collection<Movie> getMovies() {
		return movies;
	}
	public Library(Collection<Movie> movies) {
		super();
		this.movies = movies;
	}
	public Library() {
		super();
	}

}
