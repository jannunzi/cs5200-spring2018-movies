package com.jga.lectures.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Movie {
	private String imdbId;
	private String title;
	private String poster, plot;
	public String getImdbId() {
		return imdbId;
	}
	@XmlAttribute
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public String getTitle() {
		return title;
	}
	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPoster() {
		return poster;
	}
	@XmlElement
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getPlot() {
		return plot;
	}
	@XmlElement
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public Movie() {
		super();
	}
	public Movie(String imdbId, String title, String poster, String plot) {
		super();
		this.imdbId = imdbId;
		this.title = title;
		this.poster = poster;
		this.plot = plot;
	}
}
