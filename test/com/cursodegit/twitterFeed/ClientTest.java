package com.cursodegit.twitterFeed;


import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cursodegit.twitterFeed.*;

class ClientTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void testGetTweets() {
		try {
			ConnectionMock conn = new ConnectionMock("KEY","SECRET");
			Client client = new Client(conn);
			List<Map<String, Object>> tweets = client.getTweets("THE_HANDLE", 10);
			assertEquals(2, tweets.size());
		} catch(Exception e) {
			fail("Exception raised. We don't expect any exception here...");
		}
	}

}
