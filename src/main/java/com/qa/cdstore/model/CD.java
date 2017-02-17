package com.qa.cdstore.model;

import javax.persistence.*;

@Entity
public class CD {
	
	@Id
	@GeneratedValue
	private int cdID;
	private String artist;
	private String song;
	private String genre;
	
	public CD(){
		//Blank Constructor//
	}
	
	public CD(int cdID, String artist, String song, String genre) {
		this.cdID = cdID;
		this.artist = artist;
		this.song = song;
		this.genre = genre;
	}
	
    //Getters and Setters below//
	public int getCdID() {
		return cdID;
	}

	public void setCdID(int cdID) {
		this.cdID = cdID;
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
