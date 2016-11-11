
public class Hand
{
    Card cardA;
    Card cardB;
    Card cardC;
    Card cardD;
    Card cardE;
    Card cardF;
    Card cardG;
    Card cardH;
    Card cardI;
    Card cardJ;
    Card cardK;
    /**
     * Constructor for hand.
     */
    public Hand(Card cardOne, Card cardTwo, Card cardThree, Card cardFour, Card cardFive, Card cardSix, Card cardSeven, Card cardEight, Card cardNine, Card cardTen, Card cardEleven)
    { 
        cardA = cardOne;
        cardB = cardTwo;
        cardC = cardThree;
        cardD = cardFour;
        cardE = cardFive;
        cardF = cardSix;
        cardG = cardSeven;
        cardH = cardEight;
        cardI = cardNine;
        cardJ = cardTen;
        cardK = cardEleven;
    }

    /**
     * Prints cards in hand that are not null.
     */
    public void printHand()
    {
        System.out.println(cardA);
        System.out.println(cardB);
        if(cardC != null)
        {
            System.out.println(cardC);
        }
        if(cardD != null)
        {
            System.out.println(cardD);
        }
        if(cardE != null)
        {
            System.out.println(cardE);
        }
        if(cardF != null)
        {
            System.out.println(cardF);
        }
        if(cardG != null)
        {
            System.out.println(cardG);
        }
        if(cardH != null)
        {
            System.out.println(cardH);
        }
        if(cardI != null)
        {
            System.out.println(cardI);
        }
        if(cardJ != null)
        {
            System.out.println(cardJ);
        }
        if(cardK != null)
        {
            System.out.println(cardK);
        }
    }

    /**
     * Returns card a.
     */
    public Card getCardA()
    {
        return cardA;
    }

    /**
     * Returns card b.
     */
    public Card getCardB()
    {
        return cardB;
    }

    /**
     * Returns card c.
     */
    public Card getCardC()
    {
        return cardC;
    }

    /**
     * Returns card d.
     */
    public Card getCardD()
    {
        return cardD;
    }

    /**
     * Returns card e.
     */
    public Card getCardE()
    {
        return cardE;
    }

    /**
     * Returns card f.
     */
    public Card getCardF()
    {
        return cardF;
    }

    /**
     * Returns card g.
     */
    public Card getCardG()
    {
        return cardG;
    }

    /**
     * Returns card h.
     */
    public Card getCardH()
    {
        return cardH;
    }

    /**
     * Returns card i.
     */
    public Card getCardI()
    {
        return cardI;
    }

    /**
     * Returns card j.
     */
    public Card getCardJ()
    {
        return cardJ;
    }

    /**
     * Returns card k.
     */
    public Card getCardK()
    {
        return cardK;
    }

    /**
     * Allows one to set card c.
     */
    public void setCardC(Card theCard)
    {
        cardC = theCard;
    }

    /**
     * Allows one to set card d.
     */
    public void setCardD(Card theCard)
    {
        cardD = theCard;
    }

    /**
     * Allows one to set card e.
     */
    public void setCardE(Card theCard)
    {
        cardE = theCard;
    }

    /**
     * Allows one to set card f.
     */
    public void setCardF(Card theCard)
    {
        cardF = theCard;
    }

    /**
     * Allows one to set card g.
     */
    public void setCardG(Card theCard)
    {
        cardG = theCard;
    }

    /**
     * Allows one to set card h.
     */
    public void setCardH(Card theCard)
    {
        cardH = theCard;
    }

    /**
     * Allows one to set card i.
     */
    public void setCardI(Card theCard)
    {
        cardI = theCard;
    }

    /**
     * Allows one to set card j.
     */
    public void setCardJ(Card theCard)
    {
        cardJ = theCard;
    }

    /**
     * Allows one to set card k.
     */
    public void setCardK(Card theCard)
    {
        cardK = theCard;
    }
}