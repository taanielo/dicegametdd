package com.game.player;

import com.game.dice.CustomDice;
import com.game.dicecup.DiceCup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    private Player player;

    @Before
    public void setUp() {
        CustomDice dice = new CustomDice(1,1);
        DiceCup diceCup = DiceCup.getCustom(dice, 1);
        player = new Player("p", diceCup);
    }

    @Test
    public void testStatsInitialValues() {
        assertEquals(0, player.getMaxRoll());
        assertEquals(0, player.getRollCount());
        assertEquals(0, player.getRolls().size());
        assertEquals("p", player.getName());
    }

    @Test
    public void testOneRoll() {
        player.roll();
        assertEquals(1, player.getRollCount());
        assertEquals(1, player.getRolls().size());
        assertEquals(1, player.getRolls().get(0).getRolls().get(0).intValue());
    }

    @After
    public void tearDown() {
        player = null;
    }

}