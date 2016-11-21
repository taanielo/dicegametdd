package com.game.dice;

import java.util.Random;

public abstract class AbstractDice implements Dice, Cloneable {

    private int value;

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public int roll() {
        if (getMin() == getMax()) {
            value = getMin();
            return getMin();
        }
        Random random = new Random();
        value = getMin() + random.nextInt(getMax());
        return value;
    }

    @Override
    public int getMin() {
        return 1;
    }

    public abstract int getMax();
}
