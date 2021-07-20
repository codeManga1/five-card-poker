package com.hilton.services.evaluator.impl;

import com.hilton.model.Card;
import com.hilton.model.HandRank;
import com.hilton.services.evaluator.FiveCardDrawEvaluator;

import java.util.List;

public class FiveCardDrawEvaluatorImpl extends StandardFiveCardPokerHandStrengthImpl implements FiveCardDrawEvaluator {

    public FiveCardDrawEvaluatorImpl(List<Card> cards) {
        super(cards);
    }

    @Override
    public HandRank evaluate() {
        if (isStraightFlush()) {
            return HandRank.STRAIGHT_FLUSH;
        }
        if (isFourOfAKind()) {
            return HandRank.FOUR_OF_A_KIND;
        }
        if (isFullHouse()) {
            return HandRank.FULL_HOUSE;
        }
        if (isFlush()) {
            return HandRank.FLUSH;
        }
        if (isStraight()) {
            return HandRank.STRAIGHT;
        }
        if (isThreeOfAKind()) {
            return HandRank.THREE_OF_A_KIND;
        }
        if (isTwoPair()) {
            return HandRank.TWO_PAIR;
        }
        if (isPair()) {
            return HandRank.ONE_PAIR;
        }
        return HandRank.HIGH_CARDS;
    }
}
