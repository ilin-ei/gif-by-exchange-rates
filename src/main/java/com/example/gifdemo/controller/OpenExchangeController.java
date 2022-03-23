package com.example.gifdemo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gifdemo.service.OpenExchangeService;

@RequestMapping("/currencyExchanges")
@RestController
public class OpenExchangeController {
	
	@Autowired
	private OpenExchangeService openExchangeService;
	
	@GetMapping("/rates")
	public void getRates(HttpServletResponse response) throws IOException{
		
		String url = openExchangeService.getRates();
		response.sendRedirect(url);
	}
}
