package com.hilton.services.game.impl;

import com.hilton.model.Card;
import com.hilton.services.game.PrintHandService;
import com.hilton.utility.SuitIcons;

import java.util.List;

public class PrintHandServiceImpl implements PrintHandService {
    @Override
    public void print(List<Card> cards) {

        // Changing the color to red for diamonds and hearts, and resetting it to black for spades and clubs
        for (Card card : cards) {
            switch (card.getSuit()) {
                case CLUBS: {
                    System.out.print(this.getValue(card) + SuitIcons.CLUB + " ");
                    break;
                }
                case HEARTS: {
                    System.out.print(this.getValue(card) + SuitIcons.HEART + " ");
                    break;
                }
                case SPADES: {
                    System.out.print(this.getValue(card) + SuitIcons.SPADE + " ");
                    break;
                }
                case DIAMONDS: {
                    System.out.print(this.getValue(card) + SuitIcons.DIAMOND + " ");
                    break;
                }
            }
        }
        System.out.println();
    }

    private String getValue(Card card) {
        StringBuilder sb = new StringBuilder();
        // for extract the first later of an ace, jack, queen and king and returning it to be printed in the console
        if (card.getValue() == Card.Value.ACE || card.getValue() == Card.Value.JACK ||
                card.getValue() == Card.Value.QUEEN || card.getValue() == Card.Value.KING) {
            sb.append(card.getValue().toString().charAt(0));
        } else { // with cards two up to card ten, extracting the ordinal value from the enum and adding two since
            // Card.Value.TWO is at the zero index
            sb.append((card.getValue().ordinal() + 2));
        }
        return sb.toString();
    }
}
