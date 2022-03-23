package com.example.gifdemo.connector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.gifdemo.model.OpenExchangeEntity;

@FeignClient(name = "open-exchange", url = "${service.exchange}")
public interface OpenExchangeConnector {
		
    @RequestMapping(method = RequestMethod.GET, value = "/api/latest.json")
    OpenExchangeEntity getExchangeLatest(@RequestParam(name = "app_id") String appId, 
    									 @RequestParam(name = "symbols") String currency);

    @RequestMapping(method = RequestMethod.GET, value = "/api/historical/{date}.json")
    OpenExchangeEntity getExchangeHistorical(@RequestParam(name = "app_id") String appId, @PathVariable(name = "date") String date,
    										 @RequestParam(name = "symbols") String currency);

}