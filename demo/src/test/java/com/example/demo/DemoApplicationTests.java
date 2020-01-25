package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class DemoApplicationTests {

	private static final Logger LOG = LoggerFactory.getLogger(DemoApplicationTests.class);

	// @Test
	public void contextLoads() {
		LOG.error("ERROR");
		LOG.warn("WARN");
		LOG.info("INFO");
		LOG.debug("DEBUG");
		LOG.trace("TRACE");
	}
}
