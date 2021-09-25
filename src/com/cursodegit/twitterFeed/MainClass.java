package com.cursodegit.twitterFeed;

import java.util.Map;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

public class MainClass {
	
	private static final String ANSI_RESET = "\033[0m";
	private static final String ANSI_RED = "\033[31;1m";
	private static final String ANSI_GREEN = "\033[32;1m";
	
	private static String twitterHandle = "";
	
	// Comentarios añadidos por nuestro compañeros (simulado como commit en Bitbucket/Github/Gitlab)
	public static void main(String[] args) throws Exception {
	    String oAuthConsumerKey = "yv4UDBXKGzuRf58FDzq6O8YVd";
	    String oAuthConsumerSecret = "pyWrYPTBHLleabhJ0diG8UIJNlpJDDxz56taz80kVvwvfRYlw8";
	    
		if ( args.length == 0 ) {
			System.out.println(ANSI_RED+"Debes introducir el usuario de twitter."+ANSI_RESET);
			System.out.println(Usage());
			return;
		}
		twitterHandle = args[0];
		
		try {
			Connection conn = new Connection(oAuthConsumerKey, oAuthConsumerSecret);
			
			List<Map<String, Object>> tweets = getTweets(conn, twitterHandle, 10);
			for (int i=0; i < tweets.size(); i++) {
				String line = String.format("%s\t%s", tweets.get(i).get("created_at"), tweets.get(i).get("text"));
				System.out.println(line); 
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	

	// Comentarios añadidos por nuestro compañeros (simulado como commit en Bitbucket/Github/Gitlab)
	public static List<Map<String, Object>> getTweets(Connection conn, String username, int count) throws ConnectionException, JsonMappingException, JsonProcessingException {
		String uri = String.format("https://api.twitter.com/1.1/statuses/user_timeline.json?count=%d&screen_name=%s&trim_user=1&exclude_replies=1", count, username );

		String body = conn.get(uri);
		System.out.println(body);
	    List<Map<String, Object>> map = new ObjectMapper().readValue(body, List.class);
	
        return map;
	}
	
	// Comentarios añadidos por nuestro compañeros (simulado como commit en Bitbucket/Github/Gitlab)
	public static String Usage() {
	    return ANSI_GREEN+"""
	    		Muestra los tweets de un usuario.
	    		
	    		Uso:
	            	> tweets [usuario]
            	"""+ANSI_RESET;
	    }
}
