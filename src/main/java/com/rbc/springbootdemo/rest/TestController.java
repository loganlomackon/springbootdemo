package com.rbc.springbootdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> test() {
		return ResponseEntity.status(HttpStatus.OK).body("Hi");
	}
}
