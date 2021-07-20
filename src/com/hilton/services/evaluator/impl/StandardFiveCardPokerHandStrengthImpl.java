package com.hilton.services.evaluator.impl;

import com.hilton.model.Card;
import com.hilton.services.evaluator.StandardFiveCardPokerHandStrength;

import java.util.List;

public class StandardFiveCardPokerHandStrengthImpl implements StandardFiveCardPokerHandStrength {

    private final List<Card> cards;

    public StandardFiveCardPokerHandStrengthImpl(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public boolean isStraightFlush() {
        // if all suits are the same AND
        // if player has 5 consecutive values
        return isFlush() && isStraight();
    }

    @Override
    public boolean isFourOfAKind() {
        // if from the first card, 4 cards are the same
        // if from the second card, 4 cards are the same
        return (cards.get(0).getValue().ordinal() == cards.get(1).getValue().ordinal() &&
                    cards.get(0).getValue().ordinal() == cards.get(2).getValue().ordinal() &&
                    cards.get(0).getValue().ordinal() == cards.get(3).getValue().ordinal()) ||
                (cards.get(1).getValue().ordinal() == cards.get(2).getValue().ordinal() &&
                    cards.get(1).getValue().ordinal() == cards.get(3).getValue().ordinal() &&
                    cards.get(1).getValue().ordinal() == cards.get(4).getValue().ordinal());

    }

    @Override
    public boolean isFullHouse() {
        // if the first three cars AND last two cards are of the same value OR
        // if the first two cards, AND last three cards are of the same value
        return isThreeOfAKind() && isPair();
    }

    @Override
    public boolean isFlush() {
        // if all suits are the same
        return cards.get(0).getSuit() == cards.get(1).getSuit()
                && cards.get(1).getSuit() == cards.get(2).getSuit()
                && cards.get(2).getSuit() == cards.get(3).getSuit()
                && cards.get(3).getSuit() == cards.get(4).getSuit();
    }

    @Override
    public boolean isStraight() {
        // if player has 5 consecutive values
        return cards.get(0).getValue().ordinal() == cards.get(1).getValue().ordinal() - 1
                && cards.get(1).getValue().ordinal() == cards.get(2).getValue().ordinal() - 1
                && cards.get(2).getValue().ordinal() == cards.get(3).getValue().ordinal() - 1
                && cards.get(3).getValue().ordinal() == cards.get(4).getValue().ordinal() - 1;
    }

    @Override
    public boolean isThreeOfAKind() {
        // if the 1,2,3 cards are the same OR
        // if the 2,3,4 cards are the same OR
        // if the 3,4,5 cards are the same
        // 3rds card will always be a part of Three of A Kind
        return ((cards.get(0).getValue().ordinal() == cards.get(1).getValue().ordinal() &&
                    cards.get(0).getValue().ordinal() == cards.get(2).getValue().ordinal()) ||
                (cards.get(1).getValue().ordinal() == cards.get(2).getValue().ordinal() &&
                    cards.get(1).getValue().ordinal() == cards.get(3).getValue().ordinal()) ||
                (cards.get(2).getValue().ordinal() == cards.get(3).getValue().ordinal() &&
                    cards.get(2).getValue().ordinal() == cards.get(4).getValue().ordinal()));
    }

    @Override
    public boolean isTwoPair() {
        // if card 1 & 2 are the same AND card 3 & 4 are the same OR
        // if card 1 & 2 are the same AND card 4 & 5 are the same OR
        // if card 2 & 3 are the same AND card 4 & 5 are the same
        // with two pairs, the 2nd card will always be a part of one pair
        // and 4th card will always be a part of second pair
        return ((cards.get(0).getValue().ordinal() == cards.get(1).getValue().ordinal() &&
                        cards.get(2).getValue().ordinal() == cards.get(3).getValue().ordinal()) ||
                (cards.get(0).getValue().ordinal() == cards.get(1).getValue().ordinal() &&
                        cards.get(3).getValue().ordinal() == cards.get(4).getValue().ordinal()) ||
                (cards.get(1).getValue().ordinal() == cards.get(2).getValue().ordinal() &&
                        cards.get(3).getValue().ordinal() == cards.get(4).getValue().ordinal()));
    }

    @Override
    public boolean isPair() {
        // if card 1 & 2 are the same OR
        // if card 2 & 3 are the same OR
        // if card 3 & 4 are the same OR
        // if card 4 & 5 are the same
        return ((cards.get(0).getValue().ordinal() == cards.get(1).getValue().ordinal()) ||
                (cards.get(1).getValue().ordinal() == cards.get(2).getValue().ordinal()) ||
                (cards.get(2).getValue().ordinal() == cards.get(3).getValue().ordinal()) ||
                (cards.get(3).getValue().ordinal() == cards.get(4).getValue().ordinal()));
    }
}
