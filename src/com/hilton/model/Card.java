package com.hilton.model;

public class Card implements Comparable<Card> {

    public enum Suit {
        HEARTS, DIAMONDS, SPADES, CLUBS
    }

    // ACE has the highest rank hence placed last in the enum
    public enum Value {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }

    private final Suit suit;
    private final Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Card(Card card) {
        this.suit = card.suit;
        this.value = card.value;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public int compareTo(Card o) {
        return this.value.ordinal() - o.value.ordinal();
    }
}
