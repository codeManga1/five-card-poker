package com.hilton.services.game.impl;

import com.hilton.model.Card;
import com.hilton.services.game.SortHandService;

import java.util.Collections;
import java.util.List;

public class SortHandServiceImpl implements SortHandService {
    @Override
    public List<Card> sort(List<Card> cards) {
        Collections.sort(cards);
        return cards;
    }
}
