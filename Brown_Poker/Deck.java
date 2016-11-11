import java.util.Random;
import java.util.ArrayList;
public class Deck
{
    private final int DECK_SIZE = 52;
    ArrayList<Card> deck = new ArrayList<Card>();
    /**
     * Constructor for deck. Fills deck with 52 cards, 4 of each rank per suit type.
     */
    public Deck()
    {
        for(int i = 0; i < DECK_SIZE; i++)
        {
            if(i <= 12)
            {
                Card temp = new Card(0,i+1);
                deck.add(i,temp);
            }
            else if(i > 12 && i <= 25)
            {
                Card temp = new Card(0,(i - 13) + 1);
                deck.add(i,temp);
            }
            else if(i > 25 && i <= 38)
            {
                Card temp = new Card(0,(i - 26) + 1);
                deck.add(i,temp);
            }
            else if(i > 38 && i <= 51)
            {
                Card temp = new Card(0,(i - 39) + 1);
                deck.add(i,temp);
            }
        }
        for(int x = 0; x < DECK_SIZE; x++)
        {
            if(x <= 12)
            {
                deck.get(x).suit = 0;
            }
            else if(x > 12 && x <= 25)
            {
                deck.get(x).suit = 1;
            }
            else if(x > 25 && x <= 38)
            {
                deck.get(x).suit = 2;
            }
            else if(x > 38 && x <= 51)
            {
                deck.get(x).suit = 3;
            }
        }
    }

    /**
     * Returns a deck.
     */
    public String toString()
    {
        String a = "";
        for(int i = 0; i < deck.size(); i++)
        {
            a += deck.get(i) + ", ";
        }
        return a;
    }

    /**
     * Checks whether the deck is empty or not.
     */
    public boolean empty()
    {
        for(int i = 0; i < deck.size(); i++)
        {
            if(deck.get(i) != null)
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
        for(int i = 0; i < deck.size(); i++)
        {
            if(deck.get(i) != null)
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
        for(x = 0; x < deck.size(); x++)
        {
            if(deck.get(x) != null)
            {
                break;
            }
        }
        y = deck.get(x);
        deck.remove(x);
        return y;
    }

    /**
     * Shuffles the deck.
     */
    public void shuffle()
    {
        Random rand = new Random();
        Card temp;
        Card temp2;
        for(int i = 0; i < deck.size(); i++)
        {
            int x = rand.nextInt(deck.size());
            temp = deck.get(i);
            temp2 = deck.get(x);
            deck.set(i, temp2);
            deck.set(x, temp);
        }
    }

    /**
     * Sorts the deck starting with the first two and then slowly increasing the amount it sorts.
     */
    public void insertionSort()
    {
        Card num;
        for(int i = 1; i < deck.size(); i++)
        {
            num = deck.get(i);
            for(int x = i-1; x >= 0; x--)
            {
                Card temp = num;
                if(deck.get(x).rank >= num.rank)
                {
                    deck.remove(num);
                    deck.add(deck.indexOf(deck.get(x)),temp);
                }
            }
        }
    }

    /**
     * Sorts the deck by finding the smallest cards and putting them where they go.
     */
    public void selectionSort()
    {
        Card min;
        for(int i = 0; i < deck.size(); i++)
        {
            min = deck.get(i);
            for(int x = i; x < deck.size(); x++)
            {
                if(deck.get(x).rank <= min.rank)
                {
                    min = deck.get(x);
                }
            }
            Card temp = min;
            deck.set(deck.indexOf(min),deck.get(i));
            deck.set(i,temp);
        }
    }

    /**
     * Searches for a card by looking through the deck from beginning to end.
     */
    public Card findCardWithSequentialSearch(int rank, int suit)
    {
        for(int i = 0; i < deck.size(); i++)
        {
            if(deck.get(i).rank == rank && deck.get(i).suit == suit)
            {
                System.out.println(deck.get(i));
                return deck.get(i);
            }
        }
        System.out.println("Not found.");
        return deck.get(0);
    }

    /**
     * Searches for a card by looking through the deck in sections by changing the high, low, and mid.
     */
    public Card findCardWithBinarySearch(int theRank, int theSuit)
    {
        insertionSort();
        int high = deck.size()-1;
        int low = 0;
        int mid = (high + low)/2;
        while(true)
        {
            if(high - low > 2)
            {
                if(deck.get(mid).rank == theRank && deck.get(mid).suit == theSuit)
                {
                    System.out.println("Index: " + mid);
                    return deck.get(mid);
                }
                else
                {
                    if(deck.get(mid).rank > theRank)
                    {
                        high = mid - 1;
                        mid = (high + low)/2;
                    }
                    else
                    {
                        low = mid + 1;
                        mid = (high + low)/2;
                    }
                }
            }
            else
            {
                if(deck.get(high).rank == theRank && deck.get(high).suit == theSuit)
                {
                    System.out.println("Index: " + high);
                    return deck.get(high);
                }
                else if(deck.get(low).rank == theRank && deck.get(low).suit == theSuit)
                {
                    System.out.println("Index: " + low);
                    return deck.get(low);
                }
                else
                {
                    System.out.println("Index: Not Found");
                    return deck.get(0);
                }
            }
        }
    }
    
    /**
     * Adds a card to deck.
     */
    public void adding(Card c)
    {
        deck.add(c);
    }
}

