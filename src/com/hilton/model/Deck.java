package com.hilton.model;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    private final List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>(52);
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Value value : Card.Value.values()) {
                Card card = new Card(suit, value);
                this.cards.add(card);
            }
        }
    }

    public List<Card> getCards() {
        return cards;
    }
}
