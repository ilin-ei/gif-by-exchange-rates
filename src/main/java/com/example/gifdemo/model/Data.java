package com.example.gifdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Data {

	private Images images;
	
	public Data() {}

	public Data(Images images) {
		this.images = images;
	}

	public Images getImages() {
		return images;
	}

	public void setImages(Images images) {
		this.images = images;
	}
		
}
