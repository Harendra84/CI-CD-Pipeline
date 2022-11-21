package com.cicd.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message/api")
public class MessageController {
	
	@GetMapping("/wish") // method path
	public ResponseEntity<String> showMessage(){
		
		// System date and time
		LocalDateTime ldt  = LocalDateTime.now();
		String msg = null;
		
		int hour = ldt.getHour();
		if(hour<12)
			msg="Good Morning.";
		else if(hour<16)
			msg="Good Afternoon.";
		else if(hour<20)
			msg="Good Evening.";
		else
			msg="Good Night.";
		
		// Create response entity object having content body and status code
		ResponseEntity<String> entity = new ResponseEntity<String>(msg, HttpStatus.OK);
		return entity;
	}
}
