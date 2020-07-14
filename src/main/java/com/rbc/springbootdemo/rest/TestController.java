package com.rbc.springbootdemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rbc.springbootdemo.rest.dto.ContentDTO;
import com.rbc.springbootdemo.service.HttpClientService;

@RestController
@RequestMapping("/api/test")
public class TestController {
	
	@Autowired
    private HttpClientService httpClientService;

	@RequestMapping(value="/hash", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> testHash(@RequestBody ContentDTO inputDTO) {
		try {
			String result = httpClientService.sendTestHash(inputDTO.getContent());
			ContentDTO dto = new ContentDTO();
			dto.setContent(result);
			return ResponseEntity.status(HttpStatus.OK).body(dto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
	
}
