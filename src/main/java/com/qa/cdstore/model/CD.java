package com.qa.cdstore.model;

import javax.persistence.*;


@Entity
public class CD {

	CD(){}
	CD(long id, String Title, String Artist, String Genre, int price){
		setId(id);
		setTitle(Title);
		setArtist(Artist);
		setGenre(Genre);
		setPrice(price);
	}
	
	@Id
	private long id;
	
	private String Title;
	private String Artist;
	private String Genre; 
	private int price;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getArtist() {
		return Artist;
	}
	public void setArtist(String musition) {
		this.Artist = musition;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
