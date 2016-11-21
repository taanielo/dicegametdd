package com.game.dice;

public interface Dice {
    int getValue();
    int roll();
    int getMin();
    int getMax();
    Dice create(Dice fromDice);
}
