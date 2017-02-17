package com.qa.cdstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CD {

	
	@Id
	@GeneratedValue
	private long cdId;
	
	@Column(name="Artist")
	private String artist;
	
	@Column(name="Song")
	private String song;
	
	@Column(name="Genre")
	private String genre;

	public CD(){
		
	}
	
	public CD(String artist, String song, String genre) {
		super();
		this.artist = artist;
		this.song = song;
		this.genre = genre;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getSong() {
		return song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
}
