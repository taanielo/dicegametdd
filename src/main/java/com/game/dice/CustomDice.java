package com.game.dice;

public class CustomDice extends AbstractDice {

    private int min;
    private int max;

    public CustomDice(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public int getMin() {
        return min;
    }

    @Override
    public int getMax() {
        return max;
    }

    public Dice create(Dice dice) {
        if (!(dice instanceof CustomDice)) {
            throw new IllegalArgumentException("Wrong dice object!");
        }
        return new CustomDice(((CustomDice) dice).getMin(), ((CustomDice) dice).getMax());
    }
}
