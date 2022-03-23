package com.example.gifdemo.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.gifdemo.connector.GiphyConnector;
import com.example.gifdemo.connector.OpenExchangeConnector;
import com.example.gifdemo.model.GiphyEntity;
import com.example.gifdemo.model.OpenExchangeEntity;

@Service
public class OpenExchangeServiceImpl implements OpenExchangeService {

	@Value("${openExchange.apiKey}")
	private String apiKey;
	
	@Value("${giphy.apiKey}")
	private String appKey;
	
	@Value("${currency}")
	private String currency;
	
	@Autowired
	private OpenExchangeConnector openExchangeConnector;
	
	@Autowired
	private GiphyConnector giphyConnector;
		
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private String yesterday = formatter.format(LocalDate.now().minusDays(1));
		
	@Override
	public String getRates() {
		
		OpenExchangeEntity openExchangeEntity = openExchangeConnector.getExchangeLatest(apiKey, currency);
		Double todayRate = openExchangeEntity.getRates().get(currency);
		openExchangeEntity = openExchangeConnector.getExchangeHistorical(apiKey, yesterday, currency);
		Double yesterdayRate = openExchangeEntity.getRates().get(currency);
		
		String tag = todayRate > yesterdayRate ? "broke" : "rich";
		
		GiphyEntity gifObject = giphyConnector.getGif(appKey, tag);
		String url = gifObject.getData().getImages().getOriginal().get("url");
		
		return url;
	}
}
