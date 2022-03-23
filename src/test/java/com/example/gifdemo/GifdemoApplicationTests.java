package com.example.gifdemo;

import java.util.HashMap;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.gifdemo.connector.GiphyConnector;
import com.example.gifdemo.connector.OpenExchangeConnector;
import com.example.gifdemo.model.Data;
import com.example.gifdemo.model.GiphyEntity;
import com.example.gifdemo.model.Images;
import com.example.gifdemo.model.OpenExchangeEntity;
import com.example.gifdemo.service.OpenExchangeService;

@SpringBootTest
class GifdemoApplicationTests {

    @MockBean
	private GiphyConnector giphyConnector;
    
    @MockBean
    private OpenExchangeConnector openExchangeConnector;
    
    @Autowired
    private OpenExchangeService openExchangeService;
           
    @Value("${currency}")
	private String currency;
    
		@Test
		public void getRates() {

			OpenExchangeEntity openExchangeEntity = new OpenExchangeEntity();
			OpenExchangeEntity openExchangeEntity2 = new OpenExchangeEntity();
			
			Map<String, Double> rates = new HashMap<String, Double>();
			rates.put(currency, 30.56);
			openExchangeEntity.setRates(rates);
			
			Map<String, Double> rates2 = new HashMap<String, Double>();
			rates2.put(currency, 33.06);
			openExchangeEntity2.setRates(rates2);
			
			GiphyEntity gifEntity = new GiphyEntity();
			Data data = new Data();
			Images images = new Images();
			
			Map<String, String> original = new HashMap<String, String>();
			original.put("url", "some-url");
			
			gifEntity.setData(data);
			data.setImages(images);
			images.setOriginal(original);
			
			BDDMockito.given(openExchangeConnector.getExchangeLatest(ArgumentMatchers.any(), ArgumentMatchers.any()))
			.willReturn(openExchangeEntity);
	
			BDDMockito.given(openExchangeConnector.getExchangeHistorical(ArgumentMatchers.any(), ArgumentMatchers.any(),
					ArgumentMatchers.any()))
			.willReturn(openExchangeEntity2);
			
			BDDMockito.given(giphyConnector.getGif(ArgumentMatchers.any(), ArgumentMatchers.any())).willReturn(gifEntity);
			
			String url = openExchangeService.getRates();
			
			Assertions.assertThat(url).isEqualTo("some-url");
		}
}
