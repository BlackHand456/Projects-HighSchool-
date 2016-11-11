import java.util.Random;
public class Deck
{
    Card[] deck = new Card[52];
    /**
     * Constructor for deck. Fills deck with 52 cards, 4 of each rank per suit type.
     */
    public Deck()
    {
        for(int i = 0; i < deck.length; i++)
        {
            if(i <= 12)
            {
                deck[i] = new Card(0,0);
                deck[i].rank = i + 1;
            }
            else if(i > 12 && i <= 25)
            {
                deck[i] = new Card(0,0);
                deck[i].rank = (i - 13) + 1;
            }
            else if(i > 25 && i <= 38)
            {
                deck[i] = new Card(0,0);
                deck[i].rank = (i - 26) + 1;
            }
            else if(i > 38 && i <= 51)
            {
                deck[i] = new Card(0,0);
                deck[i].rank = (i - 39) + 1;
            }
        }
        for(int x = 0; x < deck.length; x++)
        {
            if(x <= 12)
            {
                deck[x].suit = 0;
            }
            else if(x > 12 && x <= 25)
            {
                deck[x].suit = 1;
            }
            else if(x > 25 && x <= 38)
            {
                deck[x].suit = 2;
            }
            else if(x > 38 && x <= 51)
            {
                deck[x].suit = 3;
            }
        }
    }

    /**
     * Returns a deck.
     */
    public String toString()
    {
        String a = "";
        for(int i = 0; i < deck.length; i++)
        {
            a += deck[i] + ", ";
        }
        return a;
    }

    /**
     * Checks whether the deck is empty or not.
     */
    public boolean empty()
    {
        for(int i = 0; i < deck.length; i++)
        {
            if(deck[i] != null)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * Counts how many cards remain in the deck.
     */
    public int numCards()
    {
        int cardCount = 0;
        for(int i = 0; i < deck.length; i++)
        {
            if(deck[i] != null)
            {
                cardCount += 1;
            }
        }
        return cardCount;
    }

    /**
     * Deals a card from the top of the deck.
     */
    public Card dealCard()
    {
        int x;
        Card y;
        for(x = 0; x < deck.length; x++)
        {
            if(deck[x] != null)
            {
                break;
            }
        }
        y = deck[x];
        deck[x] = null;
        return y;
    }

    /**
     * Shuffles the deck.
     */
    public void shuffle()
    {
        Random rand = new Random();
        Card temp;
        for(int i = 0; i < deck.length; i++)
        {
            int x = rand.nextInt(51);
            temp = deck[i];
            deck[i] = deck[x];
            deck[x] = deck[i];
        }
    }
}

