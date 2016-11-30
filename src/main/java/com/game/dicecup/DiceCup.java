package com.game.dicecup;

import com.game.dice.ClassicDice;
import com.game.dice.CustomDice;
import com.game.dice.Dice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DiceCup {

    private final List<Dice> dices;

    private DiceCup(Dice dice, int diceCount) {
        dices = new ArrayList<>(diceCount);
        for (int i = 0; i < diceCount; i++) {
            dices.add(dice.create(dice));
        }
    }

    public RollResult roll() {
        List<Integer> rolls = dices.stream().map(Dice::roll).collect(Collectors.toList());
        return new RollResult(rolls);
    }

    public List<Dice> getDices() {
        return dices;
    }

    public static DiceCup getClassic(int diceCount) {
        return new DiceCup(new ClassicDice(), diceCount);
    }

    public static DiceCup getCustom(int min, int max, int diceCount) {
        return new DiceCup(new CustomDice(min, max), diceCount);
    }

    public static DiceCup getCustom(Dice dice, int diceCount) {
        return new DiceCup(new CustomDice(dice.getMin(), dice.getMax()), diceCount);
    }
}
