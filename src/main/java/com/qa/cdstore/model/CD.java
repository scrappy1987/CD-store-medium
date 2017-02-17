package com.qa.cdstore.model;


import javax.persistence.Entity;

import javax.persistence.Id;


@Entity
public class CD {
	
	@Id
	private int CD_ID;
	
	private String CD_Title;

	private String Artist;
	
	public CD () {}

	public CD(int cD_ID, String cD_Title, String artist) {
		super();
		CD_ID = cD_ID;
		CD_Title = cD_Title;
		Artist = artist;
	}

	public int getCD_ID() {
		return CD_ID;
	}

	public void setCD_ID(int cD_ID) {
		CD_ID = cD_ID;
	}

	public String getCD_Title() {
		return CD_Title;
	}

	public void setCD_Title(String cD_Title) {
		CD_Title = cD_Title;
	}

	public String getArtist() {
		return Artist;
	}

	public void setArtist(String artist) {
		Artist = artist;
	}

	@Override
	public String toString() {
		return "CD [CD_ID=" + CD_ID + ", CD_Title=" + CD_Title + ", Artist="
				+ Artist + ", getCD_ID()=" + getCD_ID() + ", getCD_Title()="
				+ getCD_Title() + ", getArtist()=" + getArtist() + "]";
	}



}
