package com.qa.cdstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CD {
	
	
	@Id
	@GeneratedValue
	private long Id;
	private String Artist;
	private String title;
	private String genre;
	

	public CD(String Artist, String title, String genre) {
		
		this.Artist = Artist;
		this.title = title;
		this.genre = genre;
	}
	
	public CD(){
		
	};


	public long getId() {
		return Id;
	}


	public void setId(long id) {
		Id = id;
	}


	public String getArtist() {
		return Artist;
	}


	public void setArtist(String Artist) {
		this.Artist = Artist;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}

}
