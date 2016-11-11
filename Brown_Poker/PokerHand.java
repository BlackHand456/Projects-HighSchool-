import java.util.ArrayList;
public class PokerHand extends Deck
{
    ArrayList<Card> hand = new ArrayList<Card>();
    Card highCard;
    /**
     * Constructor for hand.
     */
    public PokerHand()
    { 
    }

    /**
     * Prints cards in hand in order.
     */
    public void printHand()
    {
        insertionSortHand();
        for(int i = 0; i < hand.size(); i++)
        {
            if(i != hand.size()-1)
            {
                System.out.print(hand.get(i) + ", ");
            }
            else
            {
                System.out.print(hand.get(i));
            }
        }
        System.out.println("\n");
    }

    public Card getHighCard()
    {
        return highCard;
    }

    /**
     * Adds a card to hand.
     */
    public void adding(Card c)
    {
        hand.add(c);
    }

    /**
     * Returns a card in hand.
     */
    public Card getCard(int x)
    {
        return hand.get(x);
    }

    /**
     * Removes a card in hand.
     */
    public void removeCard(int x)
    {
        hand.remove(x);
    }

    /**
     * Returns the size of hand.
     */
    public int getSize()
    {
        return hand.size();
    }

    /**
     * Evalautes a hand and determines what it is. Ex: pair, straight, etc...
     */
    public int evaluate()
    {
        int value = 0;
        if(royalFlush())
        {
            //System.out.println("Royal Flush");
            value = 9;
            return value;
        }
        else if(straightFlush())
        {
            //System.out.println("Straight Flush");
            value = 8;
            return value;
        }
        else if(fourOfAKind())
        {
            //System.out.println("Four of a Kind");
            value = 7;
            return value;
        }
        else if(fullHouse())
        {
            //System.out.println("Full House");
            value = 6;
            return value;
        }
        else if(flush())
        {
            //System.out.println("Flush");
            value = 5;
            return value;
        }
        else if(straight())
        {
            //System.out.println("Straight");
            value = 4;
            return value;
        }
        else if(threeOfAKind())
        {
            //System.out.println("Three of a Kind");
            value = 3;
            return value;
        }
        else if(twoPair())
        {
            //System.out.println("Two Pair");
            value = 2;
            return value;
        }
        else if(pair())
        {
            //System.out.println("Pair");
            value = 1;
            return value;
        }
        else
        {
            value = 0;
            //System.out.println("Bust");
            return value;
        }
    }

    /**
     * Looks for a flush and staright of 10, jack, queen, king, and ace.
     */
    public boolean royalFlush()
    {
        insertionSortHand();
        boolean flush = false;
        if(flush() == true)
        {
            flush = true;
        }
        if(flush == true && findCardWithSequentialSearchHand(1) == true & findCardWithSequentialSearchHand(10) == true && findCardWithSequentialSearchHand(11) == true && findCardWithSequentialSearchHand(12) == true && findCardWithSequentialSearchHand(13) == true)
        {
            return true;
        }
        return false;
    }

    /**
     * Looks for a straight and a flush
     */
    public boolean straightFlush()
    {
        insertionSortHand();
        boolean straight = false;
        boolean flush = false;
        if(flush() == true)
        {
            flush = true;
        }
        if(straight() == true)
        {
            straight = true;
        }
        if(flush == true && straight == true)
        {
            return true;
        }
        return false;
    }

    /**
     * Looks for four of the same rank of card in hand.
     */
    public boolean fourOfAKind()
    {
        insertionSortHand();
        boolean four = false;
        int count = 1;
        Card temp = new Card(0,8);
        for(int x = 0; x < hand.size(); x++)
        {
            temp = hand.get(x);
            for(int i = x; i < hand.size()-1; i++)
            {
                if(hand.get(i+1).rank == temp.rank)
                {
                    count += 1;
                }
            }
            if(count >= 4)
            {
                four = true;
                break;
            }
            else
            {
                count = 1;
            }
        }
        if(four == true)
        {
            highCard = temp;
            return true;
        }
        return false;
    }

    /**
     * Looks for a pair and a three of a kind.
     */
    public boolean fullHouse()
    {
        insertionSortHand();
        boolean house = false;
        boolean pair = false;
        int count = 1;
        Card temp = new Card(0,8);
        Card temp2 = new Card(0,8);
        for(int x = 0; x < hand.size(); x++)
        {
            temp = hand.get(x);
            for(int i = x+1; i < hand.size()-1; i++)
            {
                if(hand.get(i).rank == temp.rank)
                {
                    count += 1;
                }
            }
            if(count >= 3)
            {
                house = true;
                break;
            }
            else
            {
                count = 1;
            }
        }
        for(int x = 0; x < hand.size(); x++)
        {
            temp2 = hand.get(x);
            for(int i = x; i < hand.size()-1; i++)
            {
                if(temp2.rank != temp.rank && hand.get(i+1).rank == temp2.rank)
                {
                    pair = true;
                    break;
                }
            }
            if(pair == true)
            {
                break;
            }
        }
        if(pair == true && house == true)
        {
            highCard = temp;
            return true;
        }
        return false;
    }

    /**
     * Looks for five cards all of the same suit.
     */
    public boolean flush()
    {
        insertionSortHand();
        boolean flush = false;
        int count = 1;
        Card temp = new Card(0,8);
        Card temp2 = new Card(0,8);
        for(int x = 0; x < hand.size(); x++)
        {
            temp = hand.get(x);
            for(int i = x; i < hand.size()-1; i++)
            {
                if(hand.get(i+1).suit == temp.suit)
                {
                    count += 1;
                    if(count == 5)
                    {
                        temp2 = hand.get(i + 1);
                    }
                }
            }
            if(count >= 5)
            {
                flush = true;
                break;
            }
            else
            {
                count = 1;
            }
        }
        if(flush == true)
        {
            highCard = temp2;
            return true;
        }
        return false;
    }

    /**
     * Looks for cards in numerical order.
     */
    public boolean straight()
    {
        insertionSortHand();
        boolean straight = false;
        int count = 1;
        Card temp = new Card(0,8);
        Card temp2 = new Card(0,8);
        for(int x = 0; x < hand.size(); x++)
        {
            temp = hand.get(x);
            for(int i = x; i < hand.size()-1; i++)
            {
                if(hand.get(i+1).rank == temp.rank + (i + 1))
                {
                    count += 1;
                    if(count == 5)
                    {
                        temp2 = hand.get(i + 1);
                    }
                }
            }
            if(count >= 5)
            {
                straight = true;
                break;
            }
            else
            {
                count = 1;
            }
        }
        if(straight == true)
        {
            highCard = temp2;
            return true;
        }
        return false;
    }

    /**
     * Looks for three of the same rank of card in hand.
     */
    public boolean threeOfAKind()
    {
        insertionSortHand();
        boolean three = false;
        int count = 1;
        Card temp = new Card(0,8);
        for(int x = 0; x < hand.size(); x++)
        {
            temp = hand.get(x);
            for(int i = x; i < hand.size()-1; i++)
            {
                if(hand.get(i+1).rank == temp.rank)
                {
                    count += 1;
                }
            }
            if(count >= 3)
            {
                three = true;
                break;
            }
            else
            {
                count = 1;
            }
        }
        if(three == true)
        {
            highCard = temp;
            return true;
        }
        return false;
    }

    /**
     * Looks for two pairs.
     */
    public boolean twoPair()
    {
        insertionSortHand();
        boolean pair = false;
        boolean pairTwo = false;
        int count = 0;
        Card temp = new Card(0,8);
        Card temp2 = new Card(0,8);
        Card pairOne = temp;
        for(int x = 0; x < hand.size(); x++)
        {
            temp = hand.get(x);
            for(int i = x; i < hand.size()-1; i++)
            {
                if(hand.get(i+1).rank == temp.rank)
                {
                    pair = true;
                    pairOne = temp;
                    break;
                }
            }
            if(pair == true)
            {
                break;
            }
        }
        for(int x = 0; x < hand.size(); x++)
        {
            temp2 = hand.get(x);
            for(int i = x; i < hand.size()-1; i++)
            {
                if(temp2.rank != pairOne.rank && hand.get(i+1).rank == temp2.rank)
                {
                    pairTwo = true;
                    break;
                }
            }
            if(pairTwo == true)
            {
                break;
            }
        }
        if(pair == true && pairTwo == true)
        {
            if(temp.rank > temp2.rank)
            {
                highCard = temp;
            }
            else if(temp2.rank > temp.rank)
            {
                highCard = temp2;
            }
            return true;
        }
        return false;
    }

    /**
     * Looks for two same ranked cards.
     */
    public boolean pair()
    {
        insertionSortHand();
        boolean pair = false;
        int count = 0;
        Card temp = new Card(0,8);
        for(int x = 0; x < hand.size(); x++)
        {
            temp = hand.get(x);
            for(int i = x; i < hand.size()-1; i++)
            {
                if(hand.get(i+1).rank == temp.rank)
                {
                    pair = true;
                    break;
                }
            }
            if(pair == true)
            {
                break;
            }
        }
        if(pair == true)
        {
            highCard = temp;
            return true;
        }
        return false;
    }

    /**
     * Sorts the hand using an insertion sort.
     */
    public void insertionSortHand()
    {
        Card num;
        for(int i = 1; i < hand.size(); i++)
        {
            num = hand.get(i);
            for(int x = i-1; x >= 0; x--)
            {
                Card temp = num;
                if(hand.get(x).rank >= num.rank)
                {
                    hand.remove(num);
                    hand.add(hand.indexOf(hand.get(x)),temp);
                }
            }
        }
    }

    /**
     * Searches for a card by looking through the hand from beginning to end.
     */
    public boolean findCardWithSequentialSearchHand(int rank)
    {
        for(int i = 0; i < hand.size(); i++)
        {
            if(hand.get(i).rank == rank)
            {
                return true;
            }
        }
        return false;
    }
}