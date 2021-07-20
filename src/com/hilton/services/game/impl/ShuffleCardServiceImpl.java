package com.hilton.services.game.impl;

import com.hilton.model.Card;
import com.hilton.services.game.ShuffleCardService;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShuffleCardServiceImpl implements ShuffleCardService {

    @Override
    public List<Card> shuffleCards(List<Card> cards) {
        int numberOfTimesCardsShuffled = 100;

        for (int i = 0; i < numberOfTimesCardsShuffled; i++) {
            Collections.shuffle(cards);
        }
        try {
            System.out.print("Shuffling... ");
            TimeUnit.SECONDS.sleep(1);
            System.out.print("Shuffling... ");
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Shuffling... ");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return cards;
    }
}
