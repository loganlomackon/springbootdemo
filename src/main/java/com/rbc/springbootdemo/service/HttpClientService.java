package com.rbc.springbootdemo.service;

import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.rbc.springbootdemo.rest.dto.ContentDTO;

@Service
public class HttpClientService {
	
	public static String TEST_HASH_PATH = "http://34.80.24.39:8079/api/test/hash";

	public String sendPost(String path, String content) {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(path);
		post.addHeader("Content-type", "application/json; charset=UTF-8");
		
	    try {
	    	StringEntity entity = new StringEntity(content, Charset.forName("UTF-8"));
		    post.setEntity(entity);
	    	CloseableHttpResponse response = client.execute(post);
		    int status = response.getStatusLine().getStatusCode();
		    String res = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
		    client.close();
		    
		    if (status != 200)
		    	throw new Exception(String.valueOf(status)+":"+res);
		    
		    return res;
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	
	public String sendGet(String path) throws Exception {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(path);
		CloseableHttpResponse response = client.execute(get);
		int status = response.getStatusLine().getStatusCode();
		String content = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
		client.close();
		
		if (status != 200)
			throw new Exception(String.valueOf(status));
		return content;
	}
	
	public String sendTestHash(String input) throws Exception {
		ContentDTO dto = new ContentDTO();
		dto.setContent(input);
		
		Gson gson = new Gson();
		String result = sendPost(TEST_HASH_PATH, gson.toJson(dto));
		ContentDTO resDTO = gson.fromJson(result, ContentDTO.class);
		return resDTO.getContent();
	}
	
	
}
