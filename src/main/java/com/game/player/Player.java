package com.game.player;

import com.game.dicebox.DiceBox;
import com.game.stats.Stats;

import java.util.List;

public class Player {

    private String name;
    private DiceBox diceBox;
    private Stats stats;

    public Player(String name, DiceBox diceBox) {
        this.name = name;
        this.diceBox = diceBox;
        stats = new Stats();
    }

    public String getName() {
        return name;
    }

    public int roll() {
        int sum = diceBox.roll();
        stats.roll(sum);
        return sum;
    }

    public int getRollCount() {
        return stats.getRollCount();
    }

    public List<Integer> getRolls() {
        return stats.getRolls();
    }

    public int getMaxRoll() {
        return stats.getMaxRoll();
    }
}
