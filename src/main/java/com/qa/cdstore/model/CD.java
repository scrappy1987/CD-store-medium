package com.qa.cdstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CD {
	@Id
	@GeneratedValue
	private long id;

	@Column(name = "title", length = 50)
	protected String title;

	@Column(name = "artist", length = 50)
	protected String artist;

	@Column(name = "genre", length = 50)
	protected String genre;

	public CD(String title, String artist, String genre) {

		this.title = title;
		this.artist = artist;
		this.genre = genre;

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
