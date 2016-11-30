package com.game.player;

import com.game.dicecup.DiceCup;
import com.game.dicecup.RollResult;
import com.game.stats.Stats;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private DiceCup diceCup;
    private Stats stats;
    private List<RollResult> rollResults;

    public Player(String name, DiceCup diceCup) {
        this.name = name;
        this.diceCup = diceCup;

        stats = new Stats();
        rollResults = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getColoredName() {
        return "\u001B[31m" + name + "\u001B[0m";
    }

    public int roll() {
        RollResult result = diceCup.roll();
        rollResults.add(result);
        stats.addRoll(result);
        return result.getTotalRoll();
    }

    public int getRollCount() {
        return stats.getRollCount();
    }

    public int getRollsSum() {
        return stats.getRollsSum();
    }

    public List<RollResult> getRolls() {
        return rollResults;
    }

    public int getMaxRoll() {
        return stats.getMaxRoll();
    }
}
