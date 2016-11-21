package com.game.stats;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StatsTest {

    private Stats stats;

    @Before
    public void setUp() {
        stats = new Stats();
    }

    @Test
    public void testInitialValues() {
        assertEquals(0, stats.getMaxRoll());
        assertEquals(0, stats.getRolls().size());
        assertEquals(0, stats.getRollCount());
    }

    @Test
    public void testRoll1() {
        stats.roll(1);
        assertEquals(1, stats.getMaxRoll());
        assertEquals(1, stats.getRolls().size());
        assertEquals(1, stats.getRolls().get(0).intValue());
    }

    @Test
    public void testRoll1And3() {
        stats.roll(1);
        stats.roll(3);
        assertEquals(3, stats.getMaxRoll());
        assertEquals(2, stats.getRolls().size());
        assertEquals(1, stats.getRolls().get(0).intValue());
        assertEquals(3, stats.getRolls().get(1).intValue());
    }

    @After
    public void tearDown() {
        stats = null;
    }

}