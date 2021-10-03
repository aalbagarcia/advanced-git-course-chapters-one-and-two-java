package com.cursodegit.twitterFeed;

public abstract class ConnectionA {
	public ConnectionA() {
		
	}
	
	public abstract String get(String uri) throws ConnectionException;

}
