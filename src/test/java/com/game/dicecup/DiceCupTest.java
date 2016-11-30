package com.game.dicecup;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiceCupTest {

    private DiceCup diceCup;

    @Before
    public void setUp() {
        diceCup = DiceCup.getCustom(1, 1, 1);
    }

    @Test
    public void testInitialValues() {
        assertEquals(1, diceCup.getDices().size());
        assertEquals(1, diceCup.getDices().get(0).getMin());
        assertEquals(1, diceCup.getDices().get(0).getMax());
        assertEquals(0, diceCup.getDices().get(0).getValue());
    }

    @Test
    public void testOneRoll() {
        diceCup.roll();
        assertEquals(1, diceCup.getDices().get(0).getValue());
    }

}