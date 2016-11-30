package com.game.stats;

import com.game.dicecup.RollResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class StatsTest {

    private Stats stats;

    @Before
    public void setUp() {
        stats = new Stats();
    }

    @Test
    public void testInitialValues() {
        assertEquals(0, stats.getMaxRoll());
        assertEquals(0, stats.getRollsSum());
        assertEquals(0, stats.getRollCount());
    }

    @Test
    public void testRoll1() {
        stats.addRoll(getRoll(1));
        assertEquals(1, stats.getMaxRoll());
        assertEquals(1, stats.getRollCount());
        assertEquals(1, stats.getRollsSum());
    }

    @Test
    public void testRoll1And3() {
        stats.addRoll(getRoll(1));
        stats.addRoll(getRoll(3));
        assertEquals(3, stats.getMaxRoll());
        assertEquals(2, stats.getRollCount());
        assertEquals(4, stats.getRollsSum());
    }

    @After
    public void tearDown() {
        stats = null;
    }

    private RollResult getRoll(int roll) {
        List<Integer> rolls = new ArrayList<>();
        rolls.add(roll);
        return new RollResult(rolls);
    }

}