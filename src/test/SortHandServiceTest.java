package test;

import com.hilton.model.Card;
import com.hilton.model.Deck;
import com.hilton.services.game.DealCardsService;
import com.hilton.services.game.ShuffleCardService;
import com.hilton.services.game.SortHandService;
import com.hilton.services.game.impl.DealCardsServiceImpl;
import com.hilton.services.game.impl.ShuffleCardServiceImpl;
import com.hilton.services.game.impl.SortHandServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class SortHandServiceTest {

    private SortHandService sortHandService;
    private DealCardsService dealCardsService;

    @Before
    public void setUp() {
        sortHandService = new SortHandServiceImpl();
        dealCardsService = new DealCardsServiceImpl();
    }

    @Test
    public void itShouldSortAnyHandInAscendingOrder() {
        Deck deck = new Deck();
        int fourCards = 4;
        int fiveCards = 5;

        List<Card> fiveCardsInTheHand = dealCardsService.deal(deck.getCards(), fiveCards);
        List<Card> fourCardsInTheHand = dealCardsService.deal(deck.getCards(), fourCards);

        Assert.assertFalse(this.isSorted(fiveCardsInTheHand));
        Assert.assertFalse(this.isSorted(fourCardsInTheHand));

        sortHandService.sort(fiveCardsInTheHand);
        sortHandService.sort(fourCardsInTheHand);

        Assert.assertTrue(this.isSorted(fiveCardsInTheHand));
        Assert.assertTrue(this.isSorted(fourCardsInTheHand));

    }

    private boolean isSorted(List<Card> hand) {
        return hand.stream().sorted().collect(Collectors.toList()).equals(hand);
    }
}
