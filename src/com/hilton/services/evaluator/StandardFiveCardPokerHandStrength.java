package com.hilton.services.evaluator;

public interface StandardFiveCardPokerHandStrength {
    boolean isStraightFlush();

    boolean isFourOfAKind();

    boolean isFullHouse();

    boolean isFlush();

    boolean isStraight();

    boolean isThreeOfAKind();

    boolean isTwoPair();

    boolean isPair();
}
