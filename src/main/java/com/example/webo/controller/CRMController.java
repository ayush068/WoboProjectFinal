package com.example.webo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CRMController {

	
	@GetMapping("/seller")
	  public String Seller() {
	    return "Seller";
	}
}
