package com.example.gifdemo.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Images {
	
	private Map<String, String> original;

	public Images() {}

	public Images(Map<String, String> original) {
		this.original = original;
	}

	public Map<String, String> getOriginal() {
		return original;
	}

	public void setOriginal(Map<String, String> original) {
		this.original = original;
	}
	
}
