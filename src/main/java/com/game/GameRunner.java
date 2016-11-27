package com.game;

import com.game.dicebox.DiceBox;
import com.game.player.Player;
import com.game.twitter.TwitterClient;
import com.game.twitter.TwitterClient.TwitterLogin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class GameRunner {

    private static final Logger logger = LogManager.getLogger(GameRunner.class);

    private GameConfig config;
    private List<Player> players;
    private List<GameRound> rounds;
    private GameRound currentRound;
    private TwitterClient twitterClient;


    public GameRunner(GameConfig config) {
        this.config = config;
        players = new ArrayList<>();
        if (config.getUseTwitter()) {
            twitterClient = new TwitterClient(new TwitterLogin(config.getTwitterUsername(), config.getTwitterPassword()));
        }

        for (int i = 0; i < config.getNumberOfPlayers(); i++) {
            players.add(createPlayer(i));
        }
    }

    public void start() {
        rounds = new ArrayList<>();
        do {
            currentRound = createGameRound();
            currentRound.roll();
            if (config.getUseTwitter()) {
                twitterClient.postGameRound(currentRound);
            }
            logger.debug(currentRound);
            rounds.add(currentRound);
            if (config.getGameType().equals(GameConfig.GameType.ELIMINATING_ROUNDS)) {
                Player lastPlayer = currentRound.getResults().stream().sorted().findFirst().get().getPlayer();
                players.remove(lastPlayer);
            }
        } while (!isOver());
    }

    private GameRound createGameRound() {
        GameRound gameRound = new GameRound(players);
        return gameRound;
    }

    public boolean isOver() {
        switch (config.getGameType()) {
            case CLASSIC:
                return rounds.size() >= config.getNumberOfRounds();
            case ELIMINATING_ROUNDS:
                return players.isEmpty();
            case FIRST_TO_100:
                return currentRound.getWinner().getRoll() >= 100;
        }
        return false;
    }

    private Player createPlayer(int i) {
        DiceBox diceBox = DiceBox.getClassic(config.getNumberOfDices());
        return new Player("Player " + i, diceBox);
    }

    public static void main(String[] args) {
        GameConfig config = GameConfig.getClassicalThree();
        GameRunner game = new GameRunner(config);
        game.start();
    }
}
