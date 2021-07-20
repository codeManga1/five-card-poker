package com.hilton.services.game.impl;

import com.hilton.model.Card;
import com.hilton.services.evaluator.impl.FiveCardDrawEvaluatorImpl;
import com.hilton.services.game.HandEvaluator;

import java.util.List;

public class HandEvaluatorImpl extends FiveCardDrawEvaluatorImpl implements HandEvaluator {

    public HandEvaluatorImpl(List<Card> cards) {
        super(cards);
    }

    @Override
    public String evaluateHand() {
        StringBuilder sb = new StringBuilder();
        sb.append("You have: ");

        switch (evaluate()) {
            case STRAIGHT_FLUSH: {
                sb.append("Straight Flush");
                break;
            }
            case FOUR_OF_A_KIND: {
                sb.append("Four of a Kind");
                break;
            }
            case FULL_HOUSE: {
                sb.append("Full House");
                break;
            }
            case FLUSH: {
                sb.append("A Flush");
                break;
            }
            case STRAIGHT: {
                sb.append("A Straight");
                break;
            }
            case THREE_OF_A_KIND: {
                sb.append("Three of a Kind");
                break;
            }
            case TWO_PAIR: {
                sb.append("Two Pair");
                break;
            }
            case ONE_PAIR: {
                sb.append("One Pair");
                break;
            }
            case HIGH_CARDS: {
                sb.append("High Cards");
                break;
            }
        }
        return sb.toString();
    }
}
