package com.hilton;

import com.hilton.model.Card;
import com.hilton.model.Deck;
import com.hilton.services.game.*;
import com.hilton.services.game.impl.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // write your code here
        /*
         * Create a Card class with a Suite and Value enum
         * Create a Deck class and initialise with 52 cards
         * Setup a Deck: for loop of the suit enum and nest it with the value enum for loop
         * Shuffle the Cards after setting-up the deck you can use Collection.shuffle
         * Create the shuffle class
         * Create a Draw class to draw a card on the console
         * Go to CodePage437 to get the suits for the cards
         * Don't forget hearts and diamonds are red and clubs and spades are black
         * Create a Deal class
         * Setup the cards, sort them, evaluate them and display the cards and the results
         * you can use Collection.sort
         *
         * public staff at the top and private at the bottom
         *
         * */


        Deck deck = new Deck();

        ShuffleCardService shuffleCardService = new ShuffleCardServiceImpl();
        shuffleCardService.shuffleCards(deck.getCards());

        DealCardsService dealCardsService = new DealCardsServiceImpl();

        List<Card> hand = dealCardsService.deal(deck.getCards(), 5);

        SortHandService sortHandService = new SortHandServiceImpl();
        sortHandService.sort(hand);

        PrintHandService printHandService = new PrintHandServiceImpl();

        printHandService.print(hand);

        HandEvaluator handEvaluator = new HandEvaluatorImpl(hand);
        System.out.println(handEvaluator.evaluateHand());
    }
}
