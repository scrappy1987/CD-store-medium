package com.qa.cdstore.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="cd")

	public class CD{
	
	@Id
	@GeneratedValue
	protected long cd_id;
	
	@NotNull
	@Column(name = "cd_title", length=100)
	protected String cd_title;
	
	@NotNull
	@Column(name = "artists", length=500)
	protected String artists;
	
	@Column(name = "runtime", length=5)
	protected int runtime;
	
	@Column (name="genre", length=15)
	protected String genre;

	public CD(long cd_id, String cd_title, String artists, int runtime, String genre) {
		super();
		this.cd_id = cd_id;
		this.cd_title = cd_title;
		this.artists = artists;
		this.runtime = runtime;
		this.genre = genre;
	}
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public CD(){
	
	}

	public long getCd_id() {
		return cd_id;
	}

	public void setCd_id(long cd_id) {
		this.cd_id = cd_id;
	}

	public String getCd_title() {
		return cd_title;
	}

	public void setCd_title(String cd_title) {
		this.cd_title = cd_title;
	}

	public String getArtists() {
		return artists;
	}

	public void setArtists(String artists) {
		this.artists = artists;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}
	

}
