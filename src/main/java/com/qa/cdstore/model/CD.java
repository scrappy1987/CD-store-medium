package com.qa.cdstore.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CD {

	@Id
	private Long id;
	
	private String genre;
	private String artist;
	private String song;
	
	public CD(){
		
	}
	
	public CD(String artist, String song, String genre){
		this.genre = genre;
		this.artist = artist;
		this.song = song;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
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
	
}
