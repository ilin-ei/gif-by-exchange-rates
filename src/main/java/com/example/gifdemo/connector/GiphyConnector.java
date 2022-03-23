package com.example.gifdemo.connector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.gifdemo.model.GiphyEntity;

@FeignClient(name = "giphy", url = "${service.giphy}")
public interface GiphyConnector {
			
	    @RequestMapping(method = RequestMethod.GET, value = "/v1/gifs/random")
	    GiphyEntity getGif(@RequestParam(name = "api_key") String apiKey, 
	    									 @RequestParam(name = "tag") String tag);

}
