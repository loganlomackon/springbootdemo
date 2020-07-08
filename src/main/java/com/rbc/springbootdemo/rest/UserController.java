package com.rbc.springbootdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rbc.springbootdemo.domain.User;
import com.rbc.springbootdemo.rest.dto.UserDTO;
import com.rbc.springbootdemo.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
    private UserService userService;

	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getAll() {
		List<UserDTO> dtos = new ArrayList<UserDTO>();
		List<User> users = userService.getAll();
		for (User u: users) {
			dtos.add(UserDTO.createDTO(u));
		}
		return ResponseEntity.status(HttpStatus.OK).body(dtos);
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> saveUser(@RequestBody UserDTO userDTO) {
		User user = new User();
		user.setUserName(userDTO.getUser_name());
		user.setPassword(userDTO.getPassword());
		user = userService.save(user);
		return ResponseEntity.status(HttpStatus.OK).body(UserDTO.createDTO(user));
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
		User user = userService.login(userDTO.getUser_name(), userDTO.getPassword());
		if (user == null) {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(UserDTO.createDTO(user));
	}
}
