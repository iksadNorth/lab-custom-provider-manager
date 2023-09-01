package com.iksad.template.auth;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AuthenticationTest {
    @LocalServerPort
    private int port;

    private final TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    void authTest() {
        String path = String.format("http://localhost:%s/api/v1/login", port);

        HttpHeaders headers = new HttpHeaders();
        headers.add("username", "mock user");
        headers.add("password", "mock pw");

        ResponseEntity<UserDetails> response = restTemplate.exchange(path, HttpMethod.GET, new HttpEntity<>(headers), UserDetails.class);

        log.info(response.toString());
    }
}
