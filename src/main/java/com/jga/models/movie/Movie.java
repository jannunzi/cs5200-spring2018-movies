package com.jga.models.movie;

public class Movie {
	private String title;
	private String imdbId;
	private String plot;
	private String poster;
	public String toString() {
		return imdbId + " " + title;
	}
	public Movie() {
		super();
	}
	public Movie(String imdbId, String title, String plot, String poster) {
		super();
		this.title = title;
		this.imdbId = imdbId;
		this.plot = plot;
		this.poster = poster;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public String getPlot() {
		return plot;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
}
