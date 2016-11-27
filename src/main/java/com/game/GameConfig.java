package com.game;

public class GameConfig {

    public enum GameType {
        ELIMINATING_ROUNDS,
        FIRST_TO_100,
        CLASSIC
    }

    private boolean useTwitter;
    private String twitterUsername;
    private String twitterPassword;

    private int numberOfPlayers;
    private int numberOfDices;
    private int numberOfRounds;
    private GameType gameType;

    public GameConfig() {

    }

    public GameConfig setPlayers(int players) {
        this.numberOfPlayers = players;
        return this;
    }

    public GameConfig setDices(int dices) {
        this.numberOfDices = dices;
        return this;
    }

    public GameConfig setRounds(int rounds) {
        this.numberOfRounds = rounds;
        return this;
    }

    public GameConfig setType(GameType type) {
        this.gameType = type;
        return this;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public int getNumberOfDices() {
        return numberOfDices;
    }

    public int getNumberOfRounds() {
        return numberOfRounds;
    }

    public GameType getGameType() {
        return gameType;
    }

    public String getTwitterUsername() {
        return twitterUsername;
    }

    public GameConfig setTwitterUsername(String twitterUsername) {
        this.twitterUsername = twitterUsername;
        return this;
    }

    public String getTwitterPassword() {
        return twitterPassword;
    }

    public GameConfig setTwitterPassword(String twitterPassword) {
        this.twitterPassword = twitterPassword;
        return this;
    }

    public boolean getUseTwitter() {
        return useTwitter;
    }

    public GameConfig setUseTwitter(boolean useTwitter) {
        this.useTwitter = useTwitter;
        return this;
    }

    public static GameConfig getClassicalThree() {
        return new GameConfig()
                .setDices(3)
                .setPlayers(3)
                .setRounds(3)
                .setType(GameType.CLASSIC);
    }
}
