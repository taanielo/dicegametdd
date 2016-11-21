package com.game.dicebox;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiceBoxTest {

    private DiceBox diceBox;

    @Before
    public void setUp() {
        diceBox = DiceBox.getCustom(1, 1, 1);
    }

    @Test
    public void testInitialValues() {
        assertEquals(0, diceBox.getSum());
        assertEquals(1, diceBox.getDices().size());
        assertEquals(1, diceBox.getDices().get(0).getMin());
        assertEquals(1, diceBox.getDices().get(0).getMax());
        assertEquals(0, diceBox.getDices().get(0).getValue());
    }

    @Test
    public void testOneRoll() {
        diceBox.roll();
        assertEquals(1, diceBox.getSum());
        assertEquals(1, diceBox.getDices().get(0).getValue());
    }

}