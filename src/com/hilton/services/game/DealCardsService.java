package com.hilton.services.game;

import com.hilton.model.Card;

import java.util.List;

public interface DealCardsService {
    List<Card> deal(List<Card> cards, int numberOfCardsToDeal);
}
