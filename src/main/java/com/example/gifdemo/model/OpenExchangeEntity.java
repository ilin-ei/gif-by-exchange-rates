package com.example.gifdemo.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class OpenExchangeEntity {
	
	private Map<String, Double> rates;
	
	public OpenExchangeEntity() {}
	
	public OpenExchangeEntity(Map<String, Double> rates) {
	this.rates = rates;
	}
	
	public Map<String, Double> getRates() {
		return rates;
	}

	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}

}
