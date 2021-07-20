package test;

import com.hilton.model.Deck;
import com.hilton.services.game.ShuffleCardService;
import com.hilton.services.game.impl.ShuffleCardServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShuffleCardServiceTest {

    private ShuffleCardService shuffleCardService;

    @Before
    public void setUp() {
        shuffleCardService = new ShuffleCardServiceImpl();
    }

    @Test
    public void shuffleServiceShouldShuffleDeck() {
        Deck unShuffledDeck = new Deck();
        Deck shuffledDeck = new Deck();
        int totalNumberOfCards = 52;

        // Test before we shuffle the second deck
        int expectedCardCompareResult = 0;

        this.shuffleCardService.shuffleCards(unShuffledDeck.getCards());
        for (int i = 0; i < totalNumberOfCards; i++) {
            if (unShuffledDeck.getCards().get(i).compareTo(shuffledDeck.getCards().get(i)) != 0) {
                expectedCardCompareResult++;
            }
            Assert.assertTrue(expectedCardCompareResult > 0);
        }

    }

    @Test
    public void shuffleServiceShouldNotShuffleDeckIfNotCalled() {
        Deck unShuffledDeck = new Deck();
        Deck shuffledDeck = new Deck();
        int totalNumberOfCards = 52;

        // Test before we shuffle the second deck
        int expectedCardCompareResult = 0;

        for (int i = 0; i < totalNumberOfCards; i++) {
            if (unShuffledDeck.getCards().get(i).compareTo(shuffledDeck.getCards().get(i)) != 0) {
                expectedCardCompareResult++;
            }
            Assert.assertEquals(0, expectedCardCompareResult);
        }
    }
}
