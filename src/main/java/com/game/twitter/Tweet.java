package com.game.twitter;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Tweet {

    private long id;
    private String text;
    @JsonProperty("retweet_count")
    private int retweetCount;

    public Tweet(String text) {
        this.text = text;
    }

}
