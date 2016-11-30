package com.game.dicecup;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class RollResultTest {

    @Test
    public void testOneRoll() {
        RollResult rollResult = new RollResult(getRoll(1));
        assertEquals(1, rollResult.getTotalRoll());
    }

    @Test
    public void testTwoRolls() {
        List<Integer> rolls = new ArrayList<>();
        rolls.add(5);
        rolls.add(5);
        RollResult rollResult = new RollResult(rolls);
        assertEquals(10, rollResult.getTotalRoll());
        assertEquals(rolls, rollResult.getRolls());
    }

    @Test
    public void testTenRolls() {
        List<Integer> rolls = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            int roll = i + 1;
            sum += roll;
            rolls.add(roll);
        }
        RollResult rollResult = new RollResult(rolls);
        assertEquals(sum, rollResult.getTotalRoll());
        assertEquals(rolls, rollResult.getRolls());
    }

    private List<Integer> getRoll(int roll) {
        List<Integer> rolls = new ArrayList<>();
        rolls.add(roll);
        return rolls;
    }

}