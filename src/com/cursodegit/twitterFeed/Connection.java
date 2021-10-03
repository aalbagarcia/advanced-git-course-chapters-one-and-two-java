package com.cursodegit.twitterFeed;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Connection extends ConnectionA {
    private String oAuthConsumerKey = "";
    private String oAuthConsumerSecret = "";
    
	protected Map<String, String> accessTokenMap;
	
	public Connection(String oAuthConsumerKey, String oAuthConsumerSecret) throws ConnectionException {
		super();
		this.oAuthConsumerKey = oAuthConsumerKey;
		this.oAuthConsumerSecret = oAuthConsumerSecret;
		try {
			setAccessTokenMap();
		} catch(Exception e){
			String message = "Couldn't Get the Access Token from Twitter: " + e.getMessage();
			throw new ConnectionException(message);
		}
		
	}
	
	// Comentarios añadidos por nuestro compañeros (simulado como commit en Bitbucket/Github/Gitlab)
	private void setAccessTokenMap() throws IOException, InterruptedException {
		
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
        System.out.println(body);
	    this.accessTokenMap = new ObjectMapper().readValue(body, Map.class);
	}
	
	// Comentarios añadidos por nuestro compañeros (simulado como commit en Bitbucket/Github/Gitlab)
	public String get(String uri) throws ConnectionException {
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder(
		       URI.create(uri))
		   .header("Authorization", "Bearer " +  accessTokenMap.get("access_token"))
		   .GET()
		   .build();

		try {
	        HttpResponse<String> response = client.send(request,
	                HttpResponse.BodyHandlers.ofString());
			
	        return response.body();			
		} catch(Exception e) {
			String message = String.format("Couldn't get the URL %s: %s", uri, e.getMessage());
			throw new ConnectionException(message);
			
		}
	}
}