package com.game;

import com.game.dicecup.DiceCup;
import com.game.player.Player;
import com.game.twitter.TwitterClient;
import com.game.twitter.TwitterClient.TwitterLogin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GameRunner {

    private static final Logger logger = LogManager.getLogger(GameRunner.class);

    private GameConfig config;
    private List<Player> players;
    private List<GameRound> rounds;
    private GameRound currentRound;
    private TwitterClient twitterClient;

    public GameRunner(GameConfig config) {
        if (!validConfig(config)) {
            throw new IllegalArgumentException("Invalid configuration");
        }
        this.config = config;
        players = new ArrayList<>();
        if (config.getUseTwitter()) {
            twitterClient = new TwitterClient(new TwitterLogin(config.getTwitterUsername(), config.getTwitterPassword()));
        }

        for (int i = 0; i < config.getNumberOfPlayers(); i++) {
            players.add(createPlayer(i));
        }
    }

    private static boolean validConfig(GameConfig config) {
        if (config.getNumberOfPlayers() <= 0) {
            return false;
        }
        if (config.getNumberOfRounds() <= 0) {
            return false;
        }
        if (config.getNumberOfDices() <= 0) {
            return false;
        }
        if (config.getGameType() == null) {
            return false;
        }
        return true;
    }

    public void start() {
        displayGameInfo();

        rounds = new ArrayList<>();
        do {
            currentRound = createGameRound();
            if (currentRound.getRoundNumber() > 1) {
                logger.info("");
            }
            logger.info("++ Starting round nr " + currentRound.getRoundNumber() + " ++");
            currentRound.roll();
            if (config.getUseTwitter()) {
                twitterClient.postGameRound(currentRound);
            }
            logger.info(currentRound);
            rounds.add(currentRound);
            if (config.getGameType().equals(GameConfig.GameType.ELIMINATING_ROUNDS)) {
                Player lastPlayer = currentRound.getResults().stream().sorted().findFirst().get().getPlayer();
                players.remove(lastPlayer);
            }
        } while (!isOver());

        displayWinners();
    }

    private void displayWinners() {
        logger.info("");
        Player winner = rounds.get(rounds.size() - 1).getWinner().getPlayer();
        logger.info("Game is over! Winner is " + winner.getColoredName() + " with:");
        logger.info("\tsum of rolls: \u001B[34;1m" + winner.getRollsSum() + "\u001B[0m");
        logger.info("\tmax addRoll: \u001B[34;1m" + winner.getMaxRoll() + "\u001B[0m");
        logger.info("");
    }

    private void displayGameInfo() {
        logger.info("");
        logger.info("\u001B[37m### \u001B[32;1mStarting new game\u001B[37m ###  \u001B[0m");
        logger.info("\ttype - " + config.getGameType());
        logger.info("\trounds - " + config.getNumberOfRounds());
        logger.info("\tdices - " + config.getNumberOfDices());
        logger.info("");
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
        DiceCup diceCup = DiceCup.getClassic(config.getNumberOfDices());
        return new Player("Player " + (i + 1), diceCup);
    }

    public static void main(String[] args) {
        GameConfig config = GameConfig.getClassicalThree();
        GameRunner game = new GameRunner(config);
        game.start();
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}
