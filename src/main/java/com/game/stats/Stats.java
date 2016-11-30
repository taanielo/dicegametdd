package com.game.stats;

import com.game.dicecup.RollResult;
import lombok.Getter;

public class Stats {

    @Getter
    private int rollCount;
    @Getter
    private int maxRoll;
    @Getter
    private int rollsSum;

    public Stats() {
        rollCount = 0;
        maxRoll = 0;
        rollsSum = 0;
    }

    public void addRoll(RollResult result) {
        rollCount++;
        rollsSum += result.getTotalRoll();
        setMaxRoll(result.getTotalRoll());
    }

    private void setMaxRoll(int rollSum) {
        if (maxRoll < rollSum) {
            maxRoll = rollSum;
        }
    }

}
