package com.game.dice;

public class ClassicDice extends AbstractDice {
    @Override
    public int getMax() {
        return 6;
    }

    public Dice create(Dice dice) {
        return new ClassicDice();
    }
}
