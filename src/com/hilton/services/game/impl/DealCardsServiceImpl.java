package com.hilton.services.game.impl;

import com.hilton.model.Card;
import com.hilton.services.game.DealCardsService;

import java.util.ArrayList;
import java.util.List;

public class DealCardsServiceImpl implements DealCardsService {

    @Override
    public List<Card> deal(List<Card> cards, int numberOfCardsToDeal) {
        List<Card> hand = new ArrayList<>(numberOfCardsToDeal);
        int topCard = cards.size() - 1;

        for (int i = 0; i < numberOfCardsToDeal; i++) {
            hand.add(cards.get(topCard));
            cards.remove(topCard);
            topCard--;
        }

        return hand;
    }
}
