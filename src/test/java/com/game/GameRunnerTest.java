package com.game;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GameRunnerTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private GameConfig classicConfigWith1Dice1Player1Round;

    @Before
    public void setUp() {
        classicConfigWith1Dice1Player1Round = new GameConfig();
        classicConfigWith1Dice1Player1Round
                .setRounds(1)
                .setPlayers(1)
                .setDices(1)
                .setType(GameConfig.GameType.CLASSIC);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionWithEmptyConfig() {
        GameConfig config = new GameConfig();
        GameRunner runner = new GameRunner(config);
    }

    @Test
    public void testShouldThrowExceptionWith0GameRoundsConfig() {
        classicConfigWith1Dice1Player1Round.setRounds(0);
        checkWrongConfig();
    }

    @Test
    public void testShouldThrowExceptionWith0DicesConfig() {
        classicConfigWith1Dice1Player1Round.setDices(0);
        checkWrongConfig();
    }

    @Test
    public void testShouldThrowExceptionWith0PlayersConfig() {
        classicConfigWith1Dice1Player1Round.setPlayers(0);
        checkWrongConfig();
    }

    private void checkWrongConfig() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Invalid configuration");
        GameRunner runner = new GameRunner(classicConfigWith1Dice1Player1Round);
    }

}