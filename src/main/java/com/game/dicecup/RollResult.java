package com.game.dicecup;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class RollResult {
    @Getter
    private List<Integer> rolls;
    @Getter
    private int totalRoll;

    public RollResult(List<Integer> rolls) {
        this.rolls = new ArrayList<>(rolls);
        this.totalRoll = this.rolls.stream().mapToInt(Integer::intValue).sum();
    }
}
