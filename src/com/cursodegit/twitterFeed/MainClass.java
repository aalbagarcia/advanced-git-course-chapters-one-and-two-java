package com.cursodegit.twitterFeed;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;

public class MainClass {

	public static void main(String[] args) throws Exception {
		System.out.println("¡Hola, caracola!");
		
		try {
			String accessToken = getAccessToken();
			
	        System.out.println(accessToken);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}
	
	public static String getAccessToken() throws IOException, InterruptedException {
		
        String oAuthConsumerKey = "yv4UDBXKGzuRf58FDzq6O8YVd";
        String oAuthConsumerSecret = "pyWrYPTBHLleabhJ0diG8UIJNlpJDDxz56taz80kVvwvfRYlw8";
        String aux = oAuthConsumerKey + ":" + oAuthConsumerSecret;
		String consumerInfo = Base64.getEncoder().encodeToString(aux.getBytes());;
		
		System.out.println(aux);
		System.out.println(consumerInfo);
		
		HttpClient client = HttpClient.newHttpClient();

		HttpRequest request = HttpRequest.newBuilder(
		       URI.create("https://api.twitter.com/oauth2/token"))
		   .header("Authorization", "Basic " +  consumerInfo)
		   .header("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8")
		   .POST(HttpRequest.BodyPublishers.ofString("grant_type=client_credentials"))
		   .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
		System.out.println(response.statusCode());

        return response.body();
	}

}
