package com.cursodegit.twitterFeed;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Client {
	
	public Connection conn;
	
	Client(Connection conn) {
		this.conn = conn;
	}
	
	public List<Map<String, Object>> getTweets(String username, int count)throws ConnectionException, JsonMappingException, JsonProcessingException {
		String uri = String.format("https://api.twitter.com/1.1/statuses/user_timeline.json?count=%d&screen_name=%s&trim_user=1&exclude_replies=1", count, username );

		String body = this.conn.get(uri);
		System.out.println(body);
	    List<Map<String, Object>> map = new ObjectMapper().readValue(body, List.class);
	
        return map;
	}

}
