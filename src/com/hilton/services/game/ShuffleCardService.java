package com.hilton.services.game;

import com.hilton.model.Card;

import java.util.List;

public interface ShuffleCardService {
    List<Card> shuffleCards(List<Card> cards);
}
