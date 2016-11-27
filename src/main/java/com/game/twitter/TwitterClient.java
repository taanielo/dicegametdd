package com.game.twitter;

import com.game.GameRound;

public class TwitterClient {

    public TwitterClient(TwitterLogin login) {
    }

    public void postGameRound(GameRound gameRound) {

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
