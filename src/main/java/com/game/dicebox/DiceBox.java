package com.game.dicebox;

import com.game.dice.ClassicDice;
import com.game.dice.CustomDice;
import com.game.dice.Dice;

import java.util.ArrayList;
import java.util.List;

public class DiceBox {

    private final List<Dice> dices;

    private DiceBox(Dice dice, int diceCount) {
        dices = new ArrayList<>(diceCount);
        for (int i = 0; i < diceCount; i++) {
            dices.add(dice.create(dice));
        }
    }

    public int roll() {
        dices.forEach(Dice::roll);
        return getSum();
    }

    public List<Dice> getDices() {
        return dices;
    }

    public int getSum() {
        return dices.stream().mapToInt(dice -> dice.getValue()).sum();
    }

    public static DiceBox getClassic(int diceCount) {
        return new DiceBox(new ClassicDice(), diceCount);
    }

    public static DiceBox getCustom(int min, int max, int diceCount) {
        return new DiceBox(new CustomDice(min, max), diceCount);
    }

    public static DiceBox getCustom(Dice dice, int diceCount) {
        return new DiceBox(new CustomDice(dice.getMin(), dice.getMax()), diceCount);
    }
}
