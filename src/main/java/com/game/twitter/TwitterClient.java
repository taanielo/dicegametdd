package com.game.twitter;

import org.springframework.web.client.RestTemplate;

public class TwitterClient {

    private final RestTemplate restTemplate;

    public TwitterClient(TwitterLogin login, RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public static class TwitterLogin {

        private String username;
        private String password;

        public TwitterLogin(String username, String password) {
            this.username = username;
            this.password = password;
        }

    }
}
