
public class Card
{
    private final int ACE = 1;
    private final int JACK = 11;
    private final int QUEEN = 12;
    private final int KING = 13;
    public int suit;
    public int rank; 
    private String description = "";
    /**
     * Constructor for card.
     */
    public Card(int theSuit, int theRank)
    {
        suit = theSuit;
        rank = theRank;
    }

    /**
     * Returns the description for a card by giving its rank and suit.
     */
    public String toString()
    {
        String suitString = "";
        if(suit == 0)
        {
            suitString = "Spades";
        }
        else if(suit == 1)
        {
            suitString = "Hearts";
        }
        else if(suit == 2)
        {
            suitString = "Clubs";
        }
        else if(suit == 3)
        {
            suitString = "Diamonds";
        }
        if(rank == ACE)
        {
            description = "Ace of " + suitString;
        }
        else if(rank == JACK)
        {
            description = "Jack of " + suitString;
        }
        else if(rank == QUEEN)
        {
            description = "Queen of " + suitString;
        }
        else if(rank == KING)
        {
            description = "King of " + suitString;
        }
        else
        {
            description = rank + " of " + suitString;
        }
        return description;
    }

    /**
     * Checks if a card's characteristics equal another's.
     */
    public boolean equals(Card c2)
    {
        return rank == c2.rank && suit == c2.suit;
    }

    /**
     * Returns a card's rank.
     */
    public int getRank()
    {
        return rank;
    }
}
