package com.game.stats;

import java.util.ArrayList;
import java.util.List;

public class Stats {

    private int rollCount;
    private int maxRoll;
    private List<Integer> rolls;

    public Stats() {
        rolls = new ArrayList<>();
        rollCount = 0;
        maxRoll = 0;
    }

    public void roll(int roll) {
        rollCount++;
        rolls.add(roll);
        setMaxRoll(roll);
    }

    private void setMaxRoll(int roll) {
        if (maxRoll < roll) {
            maxRoll = roll;
        }
    }

    public int getRollCount() {
        return rollCount;
    }

    public List<Integer> getRolls() {
        return rolls;
    }

    public int getMaxRoll() {
        return maxRoll;
    }
}
