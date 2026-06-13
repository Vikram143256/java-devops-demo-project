package com.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        assertTrue(true);
    }

    @Test
    void testStatusEndpoint() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/status", String.class);
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().contains("running"));
    }

    @Test
    void testHealthEndpoint() {
        ResponseEntity<String> response = restTemplate.getForEntity("/api/health", String.class);
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().contains("UP"));
    }
}
