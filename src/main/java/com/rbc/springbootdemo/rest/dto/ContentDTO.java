package com.rbc.springbootdemo.rest.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ContentDTO implements Serializable {
	
	private String content;

	public ContentDTO() {
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
