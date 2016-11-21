package com.game.dice;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DiceTest {

    @Test
    public void testCustomDiceMinAndMaxWith1And1() {
        CustomDice dice = new CustomDice(1,1);
        assertEquals(1, dice.getMin());
        assertEquals(1, dice.getMax());
    }

    @Test
    public void testCustomDice1And1AllRollsEqualNumber1() {
        CustomDice dice = new CustomDice(1,1);
        for(int i = 0; i < 10; i++) {
            dice.roll();
            assertEquals(1, dice.getValue());
        }
    }

    @Test
    public void testCustomDice5And5AllRollsEqualNumber5() {
        CustomDice dice = new CustomDice(5,5);
        for(int i = 0; i < 10; i++) {
            dice.roll();
            assertEquals(5, dice.getValue());
        }
    }

    @Test
    public void testClassicDiceMinAndMax() {
        ClassicDice dice = new ClassicDice();
        assertEquals(1, dice.getMin());
        assertEquals(6, dice.getMax());
    }

    @Test
    public void testClassicDice1000RollsIsOver1000() {
        ClassicDice dice = new ClassicDice();
        int sum = 0;
        for (int i = 0; i < 1000; i++) {
            sum += dice.roll();
        }
        assertTrue(sum > 1000);
    }

}