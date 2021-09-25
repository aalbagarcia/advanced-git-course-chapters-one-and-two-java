package com.cursodegit.twitterFeed;

import java.util.Map;
import java.util.List;


public class MainClass {
	
	private static final String ANSI_RESET = "\033[0m";
	private static final String ANSI_RED = "\033[31;1m";
	private static final String ANSI_GREEN = "\033[32;1m";
	private static final String ANSI_YELLOW = "\033[33;1m";
	
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
			Client client = new Client(conn);
			
			List<Map<String, Object>> tweets = client.getTweets(twitterHandle, 10);
			displayTweets(tweets);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	// Comentarios añadidos por nuestro compañeros (simulado como commit en Bitbucket/Github/Gitlab)
	public static String Usage() {
	    return ANSI_GREEN+"""
	    		Muestra los tweets de un usuario.
	    		
	    		Uso:
	            	> tweets [usuario]
            	"""+ANSI_RESET;
	    }
	
	public static void displayTweets(List<Map<String, Object>> tweets) {
		for (int i=0; i < tweets.size(); i++) {
			String line = String.format("%s%s%s\t%s%s%s", 
					ANSI_YELLOW, 
					tweets.get(i).get("created_at"), 
					ANSI_RESET, 
					ANSI_GREEN, 
					tweets.get(i).get("text"), 
					ANSI_RESET);
			System.out.println(line); 
		}
		
	}
}
