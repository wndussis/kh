package com.naver.search.model.vo;

import java.util.Date;

public class Movie {
	private String title;
	private String link;
	private String image;
	private String subtitle;
	private String pubDate;
	private String director;
	private String actor;
	private double userRating;

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(String title, String link, String image, String subtitle, String pubDate, String director, String actor,
			int userRating) {
		super();
		this.title = title;
		this.link = link;
		this.image = image;
		this.subtitle = subtitle;
		this.pubDate = pubDate;
		this.director = director;
		this.actor = actor;
		this.userRating = userRating;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public double getUserRating() {
		return userRating;
	}

	public void setUserRating(double d) {
		this.userRating = d;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", link=" + link + ", image=" + image + ", subtitle=" + subtitle + ", pubDate="
				+ pubDate + ", director=" + director + ", actor=" + actor + ", userRating=" + userRating + "]";
	}

}
