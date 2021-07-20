package test;

import com.hilton.model.Card;
import com.hilton.model.Deck;
import com.hilton.services.game.DealCardsService;
import com.hilton.services.game.impl.DealCardsServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DealCardsServiceTest {

    private DealCardsService dealCardsService;

    @Before
    public void setUp() {
        dealCardsService = new DealCardsServiceImpl();
    }

    @Test
    public void itShouldDealFiveCards() {
        Deck deck = new Deck();
        int numberOfCardsToDeal = 5;

        List<Card> hand = dealCardsService.deal(deck.getCards(), numberOfCardsToDeal);

        Assert.assertNotNull(hand);
        Assert.assertEquals(numberOfCardsToDeal, hand.size());
    }
}
