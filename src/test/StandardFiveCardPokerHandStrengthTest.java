package test;

import com.hilton.model.Card;
import com.hilton.services.evaluator.StandardFiveCardPokerHandStrength;
import com.hilton.services.evaluator.impl.StandardFiveCardPokerHandStrengthImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StandardFiveCardPokerHandStrengthTest {

    @Test
    public void itShouldPassWhenHandIsFourOfAKing() {
        List<Card> handFromFirstCard = new ArrayList<Card>() {{
            add(new Card(Card.Suit.CLUBS, Card.Value.FIVE));
            add(new Card(Card.Suit.SPADES, Card.Value.FIVE));
            add(new Card(Card.Suit.DIAMONDS, Card.Value.FIVE));
            add(new Card(Card.Suit.HEARTS, Card.Value.FIVE));
            add(new Card(Card.Suit.CLUBS, Card.Value.TEN));
        }};

        List<Card> handFromSecondCard = new ArrayList<Card>() {{
            add(new Card(Card.Suit.CLUBS, Card.Value.SEVEN));
            add(new Card(Card.Suit.SPADES, Card.Value.KING));
            add(new Card(Card.Suit.DIAMONDS, Card.Value.KING));
            add(new Card(Card.Suit.HEARTS, Card.Value.KING));
            add(new Card(Card.Suit.CLUBS, Card.Value.KING));
        }};

        StandardFiveCardPokerHandStrength pokerHandStrength = new StandardFiveCardPokerHandStrengthImpl(handFromFirstCard);
        StandardFiveCardPokerHandStrength pokerHandStrength1 = new StandardFiveCardPokerHandStrengthImpl(handFromSecondCard);

        Assert.assertTrue(pokerHandStrength.isFourOfAKind());
        Assert.assertTrue(pokerHandStrength1.isFourOfAKind());
    }

    @Test
    public void itShouldFailWhenHandIsNotFourOfAKing() {
        List<Card> handNotFourOfAKind = new ArrayList<Card>() {{
            add(new Card(Card.Suit.CLUBS, Card.Value.FIVE));
            add(new Card(Card.Suit.SPADES, Card.Value.FIVE));
            add(new Card(Card.Suit.DIAMONDS, Card.Value.FIVE));
            add(new Card(Card.Suit.HEARTS, Card.Value.KING));
            add(new Card(Card.Suit.CLUBS, Card.Value.TEN));
        }};

        StandardFiveCardPokerHandStrength pokerHandStrength = new StandardFiveCardPokerHandStrengthImpl(handNotFourOfAKind);
        Assert.assertFalse(pokerHandStrength.isFourOfAKind());
    }

    @Test
    public void itShouldPassIfHandIsFlush() {
        List<Card> handIsFlush = new ArrayList<Card>() {{
            add(new Card(Card.Suit.CLUBS, Card.Value.SEVEN));
            add(new Card(Card.Suit.CLUBS, Card.Value.KING));
            add(new Card(Card.Suit.CLUBS, Card.Value.JACK));
            add(new Card(Card.Suit.CLUBS, Card.Value.ACE));
            add(new Card(Card.Suit.CLUBS, Card.Value.SIX));
        }};

        StandardFiveCardPokerHandStrength pokerHandStrength = new StandardFiveCardPokerHandStrengthImpl(handIsFlush);
        Assert.assertTrue(pokerHandStrength.isFlush());
    }

    @Test
    public void itShouldFailIfHandIsNotFlush() {
        List<Card> handIsNotFlush = new ArrayList<Card>() {{
            add(new Card(Card.Suit.CLUBS, Card.Value.SEVEN));
            add(new Card(Card.Suit.CLUBS, Card.Value.KING));
            add(new Card(Card.Suit.HEARTS, Card.Value.JACK));
            add(new Card(Card.Suit.CLUBS, Card.Value.ACE));
            add(new Card(Card.Suit.CLUBS, Card.Value.SIX));
        }};

        StandardFiveCardPokerHandStrength pokerHandStrength = new StandardFiveCardPokerHandStrengthImpl(handIsNotFlush);
        Assert.assertFalse(pokerHandStrength.isFlush());
    }

    @Test
    public void itShouldPassIfHandIsStraight() {

        List<Card> handIsStraight = new ArrayList<Card>() {{
            add(new Card(Card.Suit.CLUBS, Card.Value.SEVEN));
            add(new Card(Card.Suit.CLUBS, Card.Value.EIGHT));
            add(new Card(Card.Suit.HEARTS, Card.Value.NINE));
            add(new Card(Card.Suit.CLUBS, Card.Value.TEN));
            add(new Card(Card.Suit.CLUBS, Card.Value.JACK));
        }};

        StandardFiveCardPokerHandStrength pokerHandStrength = new StandardFiveCardPokerHandStrengthImpl(handIsStraight);
        Assert.assertTrue(pokerHandStrength.isStraight());
    }

    @Test
    public void itShouldFailIfHandIsNotStraight() {

        List<Card> handIsNotStraight = new ArrayList<Card>() {{
            add(new Card(Card.Suit.CLUBS, Card.Value.SEVEN));
            add(new Card(Card.Suit.CLUBS, Card.Value.EIGHT));
            add(new Card(Card.Suit.HEARTS, Card.Value.NINE));
            add(new Card(Card.Suit.CLUBS, Card.Value.TEN));
            add(new Card(Card.Suit.CLUBS, Card.Value.QUEEN));
        }};

        StandardFiveCardPokerHandStrength pokerHandStrength = new StandardFiveCardPokerHandStrengthImpl(handIsNotStraight);
        Assert.assertFalse(pokerHandStrength.isStraight());
    }

    @Test
    public void itShouldPassIfHandIsThreeOfAKind() {
        List<Card> handIsThreeOfAKind1 = new ArrayList<Card>() {{
            add(new Card(Card.Suit.CLUBS, Card.Value.SEVEN));
            add(new Card(Card.Suit.DIAMONDS, Card.Value.SEVEN));
            add(new Card(Card.Suit.HEARTS, Card.Value.SEVEN));
            add(new Card(Card.Suit.CLUBS, Card.Value.TEN));
            add(new Card(Card.Suit.CLUBS, Card.Value.QUEEN));
        }};
        List<Card> handIsThreeOfAKind2 = new ArrayList<Card>() {{
            add(new Card(Card.Suit.CLUBS, Card.Value.SEVEN));
            add(new Card(Card.Suit.CLUBS, Card.Value.EIGHT));
            add(new Card(Card.Suit.HEARTS, Card.Value.EIGHT));
            add(new Card(Card.Suit.SPADES, Card.Value.EIGHT));
            add(new Card(Card.Suit.CLUBS, Card.Value.QUEEN));
        }};
        List<Card> handIsThreeOfAKind3 = new ArrayList<Card>() {{
            add(new Card(Card.Suit.CLUBS, Card.Value.SEVEN));
            add(new Card(Card.Suit.CLUBS, Card.Value.EIGHT));
            add(new Card(Card.Suit.HEARTS, Card.Value.NINE));
            add(new Card(Card.Suit.CLUBS, Card.Value.NINE));
            add(new Card(Card.Suit.DIAMONDS, Card.Value.NINE));
        }};

        StandardFiveCardPokerHandStrength pokerHandStrength1 = new StandardFiveCardPokerHandStrengthImpl(handIsThreeOfAKind1);
        StandardFiveCardPokerHandStrength pokerHandStrength2 = new StandardFiveCardPokerHandStrengthImpl(handIsThreeOfAKind2);
        StandardFiveCardPokerHandStrength pokerHandStrength3 = new StandardFiveCardPokerHandStrengthImpl(handIsThreeOfAKind3);

        Assert.assertTrue(pokerHandStrength1.isThreeOfAKind());
        Assert.assertTrue(pokerHandStrength2.isThreeOfAKind());
        Assert.assertTrue(pokerHandStrength3.isThreeOfAKind());
    }

    @Test
    public void itShouldFailIfHandIsNotThreeOfAKind() {
        List<Card> handIsNotThreeOfAKind1 = new ArrayList<Card>() {{
            add(new Card(Card.Suit.CLUBS, Card.Value.SIX));
            add(new Card(Card.Suit.DIAMONDS, Card.Value.SEVEN));
            add(new Card(Card.Suit.HEARTS, Card.Value.SEVEN));
            add(new Card(Card.Suit.CLUBS, Card.Value.TEN));
            add(new Card(Card.Suit.CLUBS, Card.Value.QUEEN));
        }};

        StandardFiveCardPokerHandStrength pokerHandStrength1 = new StandardFiveCardPokerHandStrengthImpl(handIsNotThreeOfAKind1);

        Assert.assertFalse(pokerHandStrength1.isThreeOfAKind());
    }

    @Test
    public void itShouldPassIfHandIsStraightFlush() {
        List<Card> handIsStraightFlush = new ArrayList<Card>() {{
            add(new Card(Card.Suit.CLUBS, Card.Value.SIX));
            add(new Card(Card.Suit.CLUBS, Card.Value.SEVEN));
            add(new Card(Card.Suit.CLUBS, Card.Value.EIGHT));
            add(new Card(Card.Suit.CLUBS, Card.Value.NINE));
            add(new Card(Card.Suit.CLUBS, Card.Value.TEN));
        }};

        StandardFiveCardPokerHandStrength pokerHandStrength = new StandardFiveCardPokerHandStrengthImpl(handIsStraightFlush);

        Assert.assertTrue(pokerHandStrength.isStraightFlush());
    }

    @Test
    public void itShouldFailIfHandIsNotStraightFlush() {
        List<Card> handIsNotStraightFlush = new ArrayList<Card>() {{
            add(new Card(Card.Suit.CLUBS, Card.Value.SIX));
            add(new Card(Card.Suit.CLUBS, Card.Value.SEVEN));
            add(new Card(Card.Suit.CLUBS, Card.Value.EIGHT));
            add(new Card(Card.Suit.CLUBS, Card.Value.NINE));
            add(new Card(Card.Suit.CLUBS, Card.Value.JACK));
        }};

        StandardFiveCardPokerHandStrength pokerHandStrength = new StandardFiveCardPokerHandStrengthImpl(handIsNotStraightFlush);

        Assert.assertFalse(pokerHandStrength.isStraightFlush());
    }

    @Test
    public void itShouldPassWhenHandIsFullHouse() {
        List<Card> handIsFullHouse1 = new ArrayList<Card>() {{
            add(new Card(Card.Suit.CLUBS, Card.Value.SIX));
            add(new Card(Card.Suit.SPADES, Card.Value.SIX));
            add(new Card(Card.Suit.DIAMONDS, Card.Value.SIX));
            add(new Card(Card.Suit.CLUBS, Card.Value.ACE));
            add(new Card(Card.Suit.HEARTS, Card.Value.ACE));
        }};
        List<Card> handIsFullHouse2 = new ArrayList<Card>() {{
            add(new Card(Card.Suit.CLUBS, Card.Value.KING));
            add(new Card(Card.Suit.SPADES, Card.Value.KING));
            add(new Card(Card.Suit.DIAMONDS, Card.Value.ACE));
            add(new Card(Card.Suit.CLUBS, Card.Value.ACE));
            add(new Card(Card.Suit.HEARTS, Card.Value.ACE));
        }};

        StandardFiveCardPokerHandStrength pokerHandStrength1 = new StandardFiveCardPokerHandStrengthImpl(handIsFullHouse1);
        StandardFiveCardPokerHandStrength pokerHandStrength2 = new StandardFiveCardPokerHandStrengthImpl(handIsFullHouse2);

        Assert.assertTrue(pokerHandStrength1.isFullHouse());
        Assert.assertTrue(pokerHandStrength2.isFullHouse());
    }

    @Test
    public void itShouldFailWhenHandIsNotFullHouse() {
        List<Card> handIsFullHouse1 = new ArrayList<Card>() {{
            add(new Card(Card.Suit.CLUBS, Card.Value.SIX));
            add(new Card(Card.Suit.SPADES, Card.Value.SIX));
            add(new Card(Card.Suit.DIAMONDS, Card.Value.EIGHT));
            add(new Card(Card.Suit.CLUBS, Card.Value.ACE));
            add(new Card(Card.Suit.HEARTS, Card.Value.ACE));
        }};

        StandardFiveCardPokerHandStrength pokerHandStrength1 = new StandardFiveCardPokerHandStrengthImpl(handIsFullHouse1);

        Assert.assertFalse(pokerHandStrength1.isFullHouse());
    }
}
