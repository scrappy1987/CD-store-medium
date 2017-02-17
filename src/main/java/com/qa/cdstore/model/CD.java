package com.qa.cdstore.model;

public class CD {


	protected Long id;
	protected String cdName;
	protected String song;
	protected String genre;
	protected String artist;
	protected String price;

	public CD (Long id, String cdName, String song, String genre, String artist, String price){
		this.id = id;
		this.cdName = cdName;
		this.song = song;
		this.genre = genre;
		this.artist = artist;
		this.price = price;
				
	}
	//Getters and Setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getcdName() {
		return cdName;
	}

	public void setcdName(String cdName) {
		this.cdName = cdName;
	}
	
	public String genre() {
		return genre;
	}

	public void genre(String genre) {
		this.genre = genre;
	}

	public String song() {
		return song;
	}

	public void song(String song) {
		this.song = song;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
