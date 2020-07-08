package com.rbc.springbootdemo.rest.dto;

import com.rbc.springbootdemo.domain.User;

public class UserDTO  {

	private String id;
	private String user_name;
	private String password;
	
	public UserDTO() {
	}
	
	public static UserDTO createDTO(User user) {
		UserDTO dto = new UserDTO();
		dto.setId(user.getId().toString());
		dto.setUser_name(user.getUserName());
		return dto;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
