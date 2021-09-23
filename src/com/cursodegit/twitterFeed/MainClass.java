package com.cursodegit.twitterFeed;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.Map;
import java.util.List;
import com.fasterxml.jackson.databind.*;

public class MainClass {
	
	private static final String ANSI_RESET = "\033[0m";
	private static final String ANSI_RED = "\033[31;1m";
	private static final String ANSI_GREEN = "\033[32;1m";
	
	private static Map<String, String> accessTokenMap;
	private static String twitterHandle = "";
	public static void main(String[] args) throws Exception {
		if ( args.length == 0 ) {
			System.out.println(ANSI_RED+"Debes introducir el usuario de twitter."+ANSI_RESET);
			System.out.println(Usage());
			return;
		}
		twitterHandle = args[0];
		
		try {
			accessTokenMap = getAccessToken();
			List<Map<String, Object>> tweets = getTweets(twitterHandle, 10);
			for (int i=0; i < tweets.size(); i++) {
				String line = String.format("%s\t%s", tweets.get(i).get("created_at"), tweets.get(i).get("text"));
				System.out.println(line); 
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	public static Map<String, String> getAccessToken() throws IOException, InterruptedException {
		
        String oAuthConsumerKey = "yv4UDBXKGzuRf58FDzq6O8YVd";
        String oAuthConsumerSecret = "pyWrYPTBHLleabhJ0diG8UIJNlpJDDxz56taz80kVvwvfRYlw8";
        String aux = oAuthConsumerKey + ":" + oAuthConsumerSecret;
		String consumerInfo = Base64.getEncoder().encodeToString(aux.getBytes());;
		
		System.out.println(aux);
		System.out.println(consumerInfo);
		
		// Get the token
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(
		       URI.create("https://api.twitter.com/oauth2/token"))
		   .header("Authorization", "Basic " +  consumerInfo)
		   .header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
		   .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials"))
		   .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        String body = response.body();
	    Map<String, String> map = new ObjectMapper().readValue(body, Map.class);

		
        return map;
	}

	public static List<Map<String, Object>> getTweets(String username, int count) throws IOException, InterruptedException {
		String uri = String.format("https://api.twitter.com/1.1/statuses/user_timeline.json?count=%d&screen_name=%s&trim_user=1&exclude_replies=1", count, username );
		// Get the token
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(
		       URI.create(uri))
		   .header("Authorization", "Bearer " +  accessTokenMap.get("access_token"))
		   .GET()
		   .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

		String body = response.body();
		System.out.println(body);
	    List<Map<String, Object>> map = new ObjectMapper().readValue(body, List.class);

		
        return map;
	}

	public static String Usage() {
	    return ANSI_GREEN+"""
	    		Muestra los tweets de un usuario.
	    		
	    		Uso:
	            	> tweets [usuario]
            	"""+ANSI_RESET;
	    }
}
