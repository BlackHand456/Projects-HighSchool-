import javax.swing.JOptionPane;
public class Game
{
    private final int ACE = 1;
    private final int JACK = 11;
    private final int QUEEN = 12;
    private final int KING = 13;
    private final int MAX = 21;
    private final int DEALER_MUST_HIT = 17;
    Deck d;
    Hand h1;
    Hand h2;
    int h1Sum;
    int h2Sum;
    /**
     * Constructor for game.
     */
    public Game()
    {
    }

    /**
     * Plays the game by setting up the deck and dealing out the hands. The player can hit, stand, or look at the dealer's upcard. 
     * Eventually the dealer goes, and finally it checks who is the winner.
     */
    public void play()
    {
        setUp();

        options();

        if(h2Sum < DEALER_MUST_HIT && h1Sum <= MAX)
        {
            dealerPlays();
        }

        checkWinner();
    }

    /**
     * Compares the sums of the two hands to determine the winner and the apporopriate system output.
     */
    private void checkWinner()
    {
        System.out.println("\n");
        System.out.println("Your hand: ");
        h1.printHand();
        System.out.println("Your Total: " + h1Sum);
        System.out.println("\n");
        System.out.println("Dealer's hand: ");
        h2.printHand();
        System.out.println("Dealer's Total: " + h2Sum);
        if(MAX - h1Sum < MAX - h2Sum && h1Sum <= MAX && h2Sum <= MAX)
        {
            System.out.println("You win!");
        }
        else if(h1Sum > MAX && h2Sum <= MAX)
        {
            System.out.println("You bust. Dealer Wins.");
        }
        else if(MAX - h1Sum > MAX - h2Sum && h1Sum <= MAX && h2Sum <= MAX)
        {
            System.out.println("Dealer wins.");
        }
        else if(h2Sum > MAX && h1Sum <= MAX)
        {
            System.out.println("Dealer busts. You win!");
        }
        else if(h1Sum == h2Sum && h1Sum <= MAX && h2Sum <= MAX)
        {
            System.out.println("It was a push. You tied.");
        }
    }

    /**
     * Sets up the game by shuffling, dealing, and getting the sums of the first cards in the player's hand.
     */
    private void setUp()
    {
        d = new Deck();
        d.shuffle();
        System.out.println("\f");
        h1 = new Hand(d.dealCard(),d.dealCard(),null,null,null,null,null,null,null,null,null);
        h2 = new Hand(d.dealCard(),d.dealCard(),null,null,null,null,null,null,null,null,null);
        h1Sum = h1.getCardA().getRank() + h1.getCardB().getRank();
        if(h1.getCardA().getRank() == JACK || h1.getCardA().getRank() == QUEEN || h1.getCardA().getRank() == KING)
        {
            h1Sum -= h1.getCardA().getRank();
            h1Sum += 10;
        }
        if(h1.getCardB().getRank() == JACK || h1.getCardB().getRank() == QUEEN || h1.getCardB().getRank() == KING)
        {
            h1Sum -= h1.getCardB().getRank();
            h1Sum += 10;
        }
        if(h1.getCardA().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardB().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        h2Sum = h2.getCardA().getRank() + h2.getCardB().getRank(); 
        if(h2.getCardA().getRank() == JACK || h2.getCardA().getRank() == QUEEN || h2.getCardA().getRank() == KING)
        {
            h2Sum -= h2.getCardA().getRank();
            h2Sum += 10;
        }
        if(h2.getCardB().getRank() == JACK || h2.getCardB().getRank() == QUEEN || h2.getCardB().getRank() == KING)
        {
            h2Sum -= h2.getCardB().getRank();
            h2Sum += 10;
        }
        if(h2.getCardA().getRank() == ACE)
        {
            if(h2Sum + 10 <= MAX)
            {
                h2Sum += 10; 
            }
        }
        if(h2.getCardB().getRank() == ACE)
        {
            if(h2Sum + 10 <= MAX)
            {
                h2Sum += 10; 
            }
        }
        h1.printHand();
        System.out.println("Your Total: " + h1Sum);
    }

    /**
     * Makes the dealer hit until their sum is >= to 17.
     */
    private void dealerPlays()
    {
        while(h2Sum < DEALER_MUST_HIT)
        {
            if(h2.getCardC() == null)
            {
                h2.setCardC(d.dealCard());
            }
            else if(h2.getCardD() == null)
            {
                h2.setCardD(d.dealCard());
            }
            else if(h2.getCardE() == null)
            {
                h2.setCardE(d.dealCard());
            }
            else if(h2.getCardF() == null)
            {
                h2.setCardF(d.dealCard());
            }
            else if(h2.getCardG() == null)
            {
                h2.setCardG(d.dealCard());
            }
            else if(h2.getCardH() == null)
            {
                h2.setCardH(d.dealCard());
            }
            else if(h2.getCardI() == null)
            {
                h2.setCardI(d.dealCard());
            }
            else if(h2.getCardJ() == null)
            {
                h2.setCardJ(d.dealCard());
            }
            else if(h2.getCardK() == null)
            {
                h2.setCardK(d.dealCard());
            }
            if(h2.getCardC() == null)
            {
                h2Sum = h2.getCardA().getRank() + h2.getCardB().getRank();
                if(h2.getCardA().getRank() == JACK || h2.getCardA().getRank() == QUEEN || h2.getCardA().getRank() == KING)
                {
                    h2Sum -= h2.getCardA().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardB().getRank() == JACK || h2.getCardB().getRank() == QUEEN || h2.getCardB().getRank() == KING)
                {
                    h2Sum -= h2.getCardB().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardA().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardB().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
            }
            else if(h2.getCardD() == null)
            {
                h2Sum = h2.getCardA().getRank() + h2.getCardB().getRank() + h2.getCardC().getRank();
                if(h2.getCardA().getRank() == JACK || h2.getCardA().getRank() == QUEEN || h2.getCardA().getRank() == KING)
                {
                    h2Sum -= h2.getCardA().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardB().getRank() == JACK || h2.getCardB().getRank() == QUEEN || h2.getCardB().getRank() == KING)
                {
                    h2Sum -= h2.getCardB().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardC().getRank() == JACK || h2.getCardC().getRank() == QUEEN || h2.getCardC().getRank() == KING)
                {
                    h2Sum -= h2.getCardC().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardA().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardB().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardC().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
            }
            else if(h2.getCardE() == null)
            {
                h2Sum = h2.getCardA().getRank() + h2.getCardB().getRank() + h2.getCardC().getRank() + h2.getCardD().getRank();
                if(h2.getCardA().getRank() == JACK || h2.getCardA().getRank() == QUEEN || h2.getCardA().getRank() == KING)
                {
                    h2Sum -= h2.getCardA().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardB().getRank() == JACK || h2.getCardB().getRank() == QUEEN || h2.getCardB().getRank() == KING)
                {
                    h2Sum -= h2.getCardB().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardC().getRank() == JACK || h2.getCardC().getRank() == QUEEN || h2.getCardC().getRank() == KING)
                {
                    h2Sum -= h2.getCardC().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardD().getRank() == JACK || h2.getCardD().getRank() == QUEEN || h2.getCardD().getRank() == KING)
                {
                    h2Sum -= h2.getCardD().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardA().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardB().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardC().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardD().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
            }
            else if(h2.getCardF() == null)
            {
                h2Sum = h2.getCardA().getRank() + h2.getCardB().getRank() + h2.getCardC().getRank() + h2.getCardD().getRank() + h2.getCardE().getRank();
                if(h2.getCardA().getRank() == JACK || h2.getCardA().getRank() == QUEEN || h2.getCardA().getRank() == KING)
                {
                    h2Sum -= h2.getCardA().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardB().getRank() == JACK || h2.getCardB().getRank() == QUEEN || h2.getCardB().getRank() == KING)
                {
                    h2Sum -= h2.getCardB().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardC().getRank() == JACK || h2.getCardC().getRank() == QUEEN || h2.getCardC().getRank() == KING)
                {
                    h2Sum -= h2.getCardC().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardD().getRank() == JACK || h2.getCardD().getRank() == QUEEN || h2.getCardD().getRank() == KING)
                {
                    h2Sum -= h2.getCardD().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardE().getRank() == JACK || h2.getCardE().getRank() == QUEEN || h2.getCardE().getRank() == KING)
                {
                    h2Sum -= h2.getCardE().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardA().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardB().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardC().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardD().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardE().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
            }
            else if(h2.getCardG() == null)
            {
                h2Sum = h2.getCardA().getRank() + h2.getCardB().getRank() + h2.getCardC().getRank() + h2.getCardD().getRank() + h2.getCardE().getRank() + h2.getCardF().getRank();
                if(h2.getCardA().getRank() == JACK || h2.getCardA().getRank() == QUEEN || h2.getCardA().getRank() == KING)
                {
                    h2Sum -= h2.getCardA().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardB().getRank() == JACK || h2.getCardB().getRank() == QUEEN || h2.getCardB().getRank() == KING)
                {
                    h2Sum -= h2.getCardB().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardC().getRank() == JACK || h2.getCardC().getRank() == QUEEN || h2.getCardC().getRank() == KING)
                {
                    h2Sum -= h2.getCardC().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardD().getRank() == JACK || h2.getCardD().getRank() == QUEEN || h2.getCardD().getRank() == KING)
                {
                    h2Sum -= h2.getCardD().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardE().getRank() == JACK || h2.getCardE().getRank() == QUEEN || h2.getCardE().getRank() == KING)
                {
                    h2Sum -= h2.getCardE().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardF().getRank() == JACK || h2.getCardF().getRank() == QUEEN || h2.getCardF().getRank() == KING)
                {
                    h2Sum -= h2.getCardF().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardA().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardB().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardC().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardD().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardE().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardF().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
            }
            else if(h2.getCardH() == null)
            {
                h2Sum = h2.getCardA().getRank() + h2.getCardB().getRank() + h2.getCardC().getRank() + h2.getCardD().getRank() + h2.getCardE().getRank() + h2.getCardF().getRank() + h2.getCardG().getRank();
                if(h2.getCardA().getRank() == JACK || h2.getCardA().getRank() == QUEEN || h2.getCardA().getRank() == KING)
                {
                    h2Sum -= h2.getCardA().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardB().getRank() == JACK || h2.getCardB().getRank() == QUEEN || h2.getCardB().getRank() == KING)
                {
                    h2Sum -= h2.getCardB().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardC().getRank() == JACK || h2.getCardC().getRank() == QUEEN || h2.getCardC().getRank() == KING)
                {
                    h2Sum -= h2.getCardC().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardD().getRank() == JACK || h2.getCardD().getRank() == QUEEN || h2.getCardD().getRank() == KING)
                {
                    h2Sum -= h2.getCardD().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardE().getRank() == JACK || h2.getCardE().getRank() == QUEEN || h2.getCardE().getRank() == KING)
                {
                    h2Sum -= h2.getCardE().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardF().getRank() == JACK || h2.getCardF().getRank() == QUEEN || h2.getCardF().getRank() == KING)
                {
                    h2Sum -= h2.getCardF().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardG().getRank() == JACK || h2.getCardG().getRank() == QUEEN || h2.getCardG().getRank() == KING)
                {
                    h2Sum -= h2.getCardG().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardA().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardB().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardC().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardD().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardE().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardF().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardG().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
            }
            else if(h2.getCardI() == null)
            {
                h2Sum = h2.getCardA().getRank() + h2.getCardB().getRank() + h2.getCardC().getRank() + h2.getCardD().getRank() + h2.getCardE().getRank() + h2.getCardF().getRank() + h2.getCardG().getRank() + h2.getCardH().getRank();
                if(h2.getCardA().getRank() == JACK || h2.getCardA().getRank() == QUEEN || h2.getCardA().getRank() == KING)
                {
                    h2Sum -= h2.getCardA().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardB().getRank() == JACK || h2.getCardB().getRank() == QUEEN || h2.getCardB().getRank() == KING)
                {
                    h2Sum -= h2.getCardB().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardC().getRank() == JACK || h2.getCardC().getRank() == QUEEN || h2.getCardC().getRank() == KING)
                {
                    h2Sum -= h2.getCardC().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardD().getRank() == JACK || h2.getCardD().getRank() == QUEEN || h2.getCardD().getRank() == KING)
                {
                    h2Sum -= h2.getCardD().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardE().getRank() == JACK || h2.getCardE().getRank() == QUEEN || h2.getCardE().getRank() == KING)
                {
                    h2Sum -= h2.getCardE().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardF().getRank() == JACK || h2.getCardF().getRank() == QUEEN || h2.getCardF().getRank() == KING)
                {
                    h2Sum -= h2.getCardF().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardG().getRank() == JACK || h2.getCardG().getRank() == QUEEN || h2.getCardG().getRank() == KING)
                {
                    h2Sum -= h2.getCardG().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardH().getRank() == JACK || h2.getCardH().getRank() == QUEEN || h2.getCardH().getRank() == KING)
                {
                    h2Sum -= h2.getCardH().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardA().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardB().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardC().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardD().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardE().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardF().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardG().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardH().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
            }
            else if(h2.getCardJ() == null)
            {
                h2Sum = h2.getCardA().getRank() + h2.getCardB().getRank() + h2.getCardC().getRank() + h2.getCardD().getRank() + h2.getCardE().getRank() + h2.getCardF().getRank() + h2.getCardG().getRank() + h2.getCardH().getRank() + h2.getCardI().getRank();
                if(h2.getCardA().getRank() == JACK || h2.getCardA().getRank() == QUEEN || h2.getCardA().getRank() == KING)
                {
                    h2Sum -= h2.getCardA().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardB().getRank() == JACK || h2.getCardB().getRank() == QUEEN || h2.getCardB().getRank() == KING)
                {
                    h2Sum -= h2.getCardB().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardC().getRank() == JACK || h2.getCardC().getRank() == QUEEN || h2.getCardC().getRank() == KING)
                {
                    h2Sum -= h2.getCardC().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardD().getRank() == JACK || h2.getCardD().getRank() == QUEEN || h2.getCardD().getRank() == KING)
                {
                    h2Sum -= h2.getCardD().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardE().getRank() == JACK || h2.getCardE().getRank() == QUEEN || h2.getCardE().getRank() == KING)
                {
                    h2Sum -= h2.getCardE().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardF().getRank() == JACK || h2.getCardF().getRank() == QUEEN || h2.getCardF().getRank() == KING)
                {
                    h2Sum -= h2.getCardF().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardG().getRank() == JACK || h2.getCardG().getRank() == QUEEN || h2.getCardG().getRank() == KING)
                {
                    h2Sum -= h2.getCardG().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardH().getRank() == JACK || h2.getCardH().getRank() == QUEEN || h2.getCardH().getRank() == KING)
                {
                    h2Sum -= h2.getCardH().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardI().getRank() == JACK || h2.getCardI().getRank() == QUEEN || h2.getCardI().getRank() == KING)
                {
                    h2Sum -= h2.getCardI().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardA().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardB().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardC().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardD().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardE().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardF().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardG().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardH().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardI().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
            }
            else if(h2.getCardK() == null)
            {
                h2Sum = h2.getCardA().getRank() + h2.getCardB().getRank() + h2.getCardC().getRank() + h2.getCardD().getRank() + h2.getCardE().getRank() + h2.getCardF().getRank() + h2.getCardG().getRank() + h2.getCardH().getRank() + h2.getCardI().getRank() + h2.getCardJ().getRank();
                if(h2.getCardA().getRank() == JACK || h2.getCardA().getRank() == QUEEN || h2.getCardA().getRank() == KING)
                {
                    h2Sum -= h2.getCardA().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardB().getRank() == JACK || h2.getCardB().getRank() == QUEEN || h2.getCardB().getRank() == KING)
                {
                    h2Sum -= h2.getCardB().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardC().getRank() == JACK || h2.getCardC().getRank() == QUEEN || h2.getCardC().getRank() == KING)
                {
                    h2Sum -= h2.getCardC().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardD().getRank() == JACK || h2.getCardD().getRank() == QUEEN || h2.getCardD().getRank() == KING)
                {
                    h2Sum -= h2.getCardD().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardE().getRank() == JACK || h2.getCardE().getRank() == QUEEN || h2.getCardE().getRank() == KING)
                {
                    h2Sum -= h2.getCardE().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardF().getRank() == JACK || h2.getCardF().getRank() == QUEEN || h2.getCardF().getRank() == KING)
                {
                    h2Sum -= h2.getCardF().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardG().getRank() == JACK || h2.getCardG().getRank() == QUEEN || h2.getCardG().getRank() == KING)
                {
                    h2Sum -= h2.getCardG().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardH().getRank() == JACK || h2.getCardH().getRank() == QUEEN || h2.getCardH().getRank() == KING)
                {
                    h2Sum -= h2.getCardH().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardI().getRank() == JACK || h2.getCardI().getRank() == QUEEN || h2.getCardI().getRank() == KING)
                {
                    h2Sum -= h2.getCardI().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardJ().getRank() == JACK || h2.getCardJ().getRank() == QUEEN || h2.getCardJ().getRank() == KING)
                {
                    h2Sum -= h2.getCardJ().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardA().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardB().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardC().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardD().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardE().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardF().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardG().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardH().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardI().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardJ().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
            }
            else
            {
                h2Sum = h2.getCardA().getRank() + h2.getCardB().getRank() + h2.getCardC().getRank() + h2.getCardD().getRank() + h2.getCardE().getRank() + h2.getCardF().getRank() + h2.getCardG().getRank() + h2.getCardH().getRank() + h2.getCardI().getRank() + h2.getCardJ().getRank() + h2.getCardK().getRank();
                if(h2.getCardA().getRank() == JACK || h2.getCardA().getRank() == QUEEN || h2.getCardA().getRank() == KING)
                {
                    h2Sum -= h2.getCardA().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardB().getRank() == JACK || h2.getCardB().getRank() == QUEEN || h2.getCardB().getRank() == KING)
                {
                    h2Sum -= h2.getCardB().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardC().getRank() == JACK || h2.getCardC().getRank() == QUEEN || h2.getCardC().getRank() == KING)
                {
                    h2Sum -= h2.getCardC().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardD().getRank() == JACK || h2.getCardD().getRank() == QUEEN || h2.getCardD().getRank() == KING)
                {
                    h2Sum -= h2.getCardD().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardE().getRank() == JACK || h2.getCardE().getRank() == QUEEN || h2.getCardE().getRank() == KING)
                {
                    h2Sum -= h2.getCardE().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardF().getRank() == JACK || h2.getCardF().getRank() == QUEEN || h2.getCardF().getRank() == KING)
                {
                    h2Sum -= h2.getCardF().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardG().getRank() == JACK || h2.getCardG().getRank() == QUEEN || h2.getCardG().getRank() == KING)
                {
                    h2Sum -= h2.getCardG().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardH().getRank() == JACK || h2.getCardH().getRank() == QUEEN || h2.getCardH().getRank() == KING)
                {
                    h2Sum -= h2.getCardH().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardI().getRank() == JACK || h2.getCardI().getRank() == QUEEN || h2.getCardI().getRank() == KING)
                {
                    h2Sum -= h2.getCardI().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardJ().getRank() == JACK || h2.getCardJ().getRank() == QUEEN || h2.getCardJ().getRank() == KING)
                {
                    h2Sum -= h2.getCardJ().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardK().getRank() == JACK || h2.getCardK().getRank() == QUEEN || h2.getCardK().getRank() == KING)
                {
                    h2Sum -= h2.getCardK().getRank();
                    h2Sum += 10;
                }
                if(h2.getCardA().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardB().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardC().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardD().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardE().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardF().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardG().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardH().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardI().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardJ().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
                if(h2.getCardK().getRank() == ACE)
                {
                    if(h2Sum + 10 <= MAX)
                    {
                        h2Sum += 10; 
                    }
                }
            }
        }
    }

    /**
     * Allows the player to chose what to do and carries it out. They can hit, stand, or look at the dealer's upcard.
     */
    private void options()
    {
        while(h1Sum < MAX)
        {
            String options = JOptionPane.showInputDialog(null,"What would you like to do? <1>Hit <2>Stand <3>Look at dealer's upcard");
            if(options != null)
            {
                System.out.println("\n");
                if(options.equals("1"))
                {
                    dealWhichCard();
                    getSum();
                    h1.printHand();
                    System.out.println("Your Total: " + h1Sum);
                }
                else if(options.equals("2"))
                {
                    break;
                }
                else if(options.equals("3"))
                {
                    System.out.println(h2.getCardB());
                }
            }
        }
    }

    /**
     * Gets the sum of the player's cards.
     */
    private void getSum()
    {
        if(h1.getCardC() == null)
        {
            h1Sum = h1.getCardA().getRank() + h1.getCardB().getRank();
            checkABHand();
        }
        else if(h1.getCardD() == null)
        {
            h1Sum = h1.getCardA().getRank() + h1.getCardB().getRank() + h1.getCardC().getRank();
            checkACHand();
        }
        else if(h1.getCardE() == null)
        {
            h1Sum = h1.getCardA().getRank() + h1.getCardB().getRank() + h1.getCardC().getRank() + h1.getCardD().getRank();
            checkADHand();
        }
        else if(h1.getCardF() == null)
        {
            h1Sum = h1.getCardA().getRank() + h1.getCardB().getRank() + h1.getCardC().getRank() + h1.getCardD().getRank() + h1.getCardE().getRank();
            checkAEHand();
        }
        else if(h1.getCardG() == null)
        {
            h1Sum = h1.getCardA().getRank() + h1.getCardB().getRank() + h1.getCardC().getRank() + h1.getCardD().getRank() + h1.getCardE().getRank() + h1.getCardF().getRank();
            checkAFHand();
        }
        else if(h1.getCardH() == null)
        {
            h1Sum = h1.getCardA().getRank() + h1.getCardB().getRank() + h1.getCardC().getRank() + h1.getCardD().getRank() + h1.getCardE().getRank() + h1.getCardF().getRank() + h1.getCardG().getRank();
            checkAGHand();
        }
        else if(h1.getCardI() == null)
        {
            h1Sum = h1.getCardA().getRank() + h1.getCardB().getRank() + h1.getCardC().getRank() + h1.getCardD().getRank() + h1.getCardE().getRank() + h1.getCardF().getRank() + h1.getCardG().getRank() + h1.getCardH().getRank();
            checkAHHand();
        }
        else if(h1.getCardJ() == null)
        {
            h1Sum = h1.getCardA().getRank() + h1.getCardB().getRank() + h1.getCardC().getRank() + h1.getCardD().getRank() + h1.getCardE().getRank() + h1.getCardF().getRank() + h1.getCardG().getRank() + h1.getCardH().getRank() + h1.getCardI().getRank();
            checkAIHand();
        }
        else if(h1.getCardK() == null)
        {
            h1Sum = h1.getCardA().getRank() + h1.getCardB().getRank() + h1.getCardC().getRank() + h1.getCardD().getRank() + h1.getCardE().getRank() + h1.getCardF().getRank() + h1.getCardG().getRank() + h1.getCardH().getRank() + h1.getCardI().getRank() + h1.getCardJ().getRank();
            checkAJHand();
        }
        else
        {
            h1Sum = h1.getCardA().getRank() + h1.getCardB().getRank() + h1.getCardC().getRank() + h1.getCardD().getRank() + h1.getCardE().getRank() + h1.getCardF().getRank() + h1.getCardG().getRank() + h1.getCardH().getRank() + h1.getCardI().getRank() + h1.getCardJ().getRank() + h1.getCardK().getRank();
            checkFullHand();
        }
    }

    /**
     * Chooses which card to deal based on how many cards the player possesses.
     */
    private void dealWhichCard()
    {
        if(h1.getCardC() == null)
        {
            h1.setCardC(d.dealCard());
        }
        else if(h1.getCardD() == null)
        {
            h1.setCardD(d.dealCard());
        }
        else if(h1.getCardE() == null)
        {
            h1.setCardE(d.dealCard());
        }
        else if(h1.getCardF() == null)
        {
            h1.setCardF(d.dealCard());
        }
        else if(h1.getCardG() == null)
        {
            h1.setCardG(d.dealCard());
        }
        else if(h1.getCardH() == null)
        {
            h1.setCardH(d.dealCard());
        }
        else if(h1.getCardI() == null)
        {
            h1.setCardI(d.dealCard());
        }
        else if(h1.getCardJ() == null)
        {
            h1.setCardJ(d.dealCard());
        }
        else if(h1.getCardK() == null)
        {
            h1.setCardK(d.dealCard());
        }
    }

    /**
     * Checks the hand for face cards and gives them the correct value.
     */
    private void checkABHand()
    {
        if(h1.getCardA().getRank() == JACK || h1.getCardA().getRank() == QUEEN || h1.getCardA().getRank() == KING)
        {
            h1Sum -= h1.getCardA().getRank();
            h1Sum += 10;
        }
        if(h1.getCardB().getRank() == JACK || h1.getCardB().getRank() == QUEEN || h1.getCardB().getRank() == KING)
        {
            h1Sum -= h1.getCardB().getRank();
            h1Sum += 10;
        }
        if(h1.getCardA().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardB().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
    }

    /**
     * Checks the hand for face cards and gives them the correct value.
     */
    private void checkACHand()
    {
        if(h1.getCardA().getRank() == JACK || h1.getCardA().getRank() == QUEEN || h1.getCardA().getRank() == KING)
        {
            h1Sum -= h1.getCardA().getRank();
            h1Sum += 10;
        }
        if(h1.getCardB().getRank() == JACK || h1.getCardB().getRank() == QUEEN || h1.getCardB().getRank() == KING)
        {
            h1Sum -= h1.getCardB().getRank();
            h1Sum += 10;
        }
        if(h1.getCardC().getRank() == JACK || h1.getCardC().getRank() == QUEEN || h1.getCardC().getRank() == KING)
        {
            h1Sum -= h1.getCardC().getRank();
            h1Sum += 10;
        }
        if(h1.getCardA().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardB().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardC().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
    }

    /**
     * Checks the hand for face cards and gives them the correct value.
     */
    private void checkADHand()
    {
        if(h1.getCardA().getRank() == JACK || h1.getCardA().getRank() == QUEEN || h1.getCardA().getRank() == KING)
        {
            h1Sum -= h1.getCardA().getRank();
            h1Sum += 10;
        }
        if(h1.getCardB().getRank() == JACK || h1.getCardB().getRank() == QUEEN || h1.getCardB().getRank() == KING)
        {
            h1Sum -= h1.getCardB().getRank();
            h1Sum += 10;
        }
        if(h1.getCardC().getRank() == JACK || h1.getCardC().getRank() == QUEEN || h1.getCardC().getRank() == KING)
        {
            h1Sum -= h1.getCardC().getRank();
            h1Sum += 10;
        }
        if(h1.getCardD().getRank() == JACK || h1.getCardD().getRank() == QUEEN || h1.getCardD().getRank() == KING)
        {
            h1Sum -= h1.getCardD().getRank();
            h1Sum += 10;
        }
        if(h1.getCardA().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardB().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardC().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardD().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
    }

    /**
     * Checks the hand for face cards and gives them the correct value.
     */
    private void checkAEHand()
    {
        if(h1.getCardA().getRank() == JACK || h1.getCardA().getRank() == QUEEN || h1.getCardA().getRank() == KING)
        {
            h1Sum -= h1.getCardA().getRank();
            h1Sum += 10;
        }
        if(h1.getCardB().getRank() == JACK || h1.getCardB().getRank() == QUEEN || h1.getCardB().getRank() == KING)
        {
            h1Sum -= h1.getCardB().getRank();
            h1Sum += 10;
        }
        if(h1.getCardC().getRank() == JACK || h1.getCardC().getRank() == QUEEN || h1.getCardC().getRank() == KING)
        {
            h1Sum -= h1.getCardC().getRank();
            h1Sum += 10;
        }
        if(h1.getCardD().getRank() == JACK || h1.getCardD().getRank() == QUEEN || h1.getCardD().getRank() == KING)
        {
            h1Sum -= h1.getCardD().getRank();
            h1Sum += 10;
        }
        if(h1.getCardE().getRank() == JACK || h1.getCardE().getRank() == QUEEN || h1.getCardE().getRank() == KING)
        {
            h1Sum -= h1.getCardE().getRank();
            h1Sum += 10;
        }
        if(h1.getCardA().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardB().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardC().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardD().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardE().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
    }

    /**
     * Checks the hand for face cards and gives them the correct value.
     */
    private void checkAFHand()
    {
        if(h1.getCardA().getRank() == JACK || h1.getCardA().getRank() == QUEEN || h1.getCardA().getRank() == KING)
        {
            h1Sum -= h1.getCardA().getRank();
            h1Sum += 10;
        }
        if(h1.getCardB().getRank() == JACK || h1.getCardB().getRank() == QUEEN || h1.getCardB().getRank() == KING)
        {
            h1Sum -= h1.getCardB().getRank();
            h1Sum += 10;
        }
        if(h1.getCardC().getRank() == JACK || h1.getCardC().getRank() == QUEEN || h1.getCardC().getRank() == KING)
        {
            h1Sum -= h1.getCardC().getRank();
            h1Sum += 10;
        }
        if(h1.getCardD().getRank() == JACK || h1.getCardD().getRank() == QUEEN || h1.getCardD().getRank() == KING)
        {
            h1Sum -= h1.getCardD().getRank();
            h1Sum += 10;
        }
        if(h1.getCardE().getRank() == JACK || h1.getCardE().getRank() == QUEEN || h1.getCardE().getRank() == KING)
        {
            h1Sum -= h1.getCardE().getRank();
            h1Sum += 10;
        }
        if(h1.getCardF().getRank() == JACK || h1.getCardF().getRank() == QUEEN || h1.getCardF().getRank() == KING)
        {
            h1Sum -= h1.getCardF().getRank();
            h1Sum += 10;
        }
        if(h1.getCardA().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardB().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardC().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardD().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardE().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardF().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
    }

    /**
     * Checks the hand for face cards and gives them the correct value.
     */
    private void checkAGHand()
    {
        if(h1.getCardA().getRank() == JACK || h1.getCardA().getRank() == QUEEN || h1.getCardA().getRank() == KING)
        {
            h1Sum -= h1.getCardA().getRank();
            h1Sum += 10;
        }
        if(h1.getCardB().getRank() == JACK || h1.getCardB().getRank() == QUEEN || h1.getCardB().getRank() == KING)
        {
            h1Sum -= h1.getCardB().getRank();
            h1Sum += 10;
        }
        if(h1.getCardC().getRank() == JACK || h1.getCardC().getRank() == QUEEN || h1.getCardC().getRank() == KING)
        {
            h1Sum -= h1.getCardC().getRank();
            h1Sum += 10;
        }
        if(h1.getCardD().getRank() == JACK || h1.getCardD().getRank() == QUEEN || h1.getCardD().getRank() == KING)
        {
            h1Sum -= h1.getCardD().getRank();
            h1Sum += 10;
        }
        if(h1.getCardE().getRank() == JACK || h1.getCardE().getRank() == QUEEN || h1.getCardE().getRank() == KING)
        {
            h1Sum -= h1.getCardE().getRank();
            h1Sum += 10;
        }
        if(h1.getCardF().getRank() == JACK || h1.getCardF().getRank() == QUEEN || h1.getCardF().getRank() == KING)
        {
            h1Sum -= h1.getCardF().getRank();
            h1Sum += 10;
        }
        if(h1.getCardG().getRank() == JACK || h1.getCardG().getRank() == QUEEN || h1.getCardG().getRank() == KING)
        {
            h1Sum -= h1.getCardG().getRank();
            h1Sum += 10;
        }
        if(h1.getCardA().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardB().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardC().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardD().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardE().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardF().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardG().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
    }

    /**
     * Checks the hand for face cards and gives them the correct value.
     */
    private void checkAHHand()
    {
        if(h1.getCardA().getRank() == JACK || h1.getCardA().getRank() == QUEEN || h1.getCardA().getRank() == KING)
        {
            h1Sum -= h1.getCardA().getRank();
            h1Sum += 10;
        }
        if(h1.getCardB().getRank() == JACK || h1.getCardB().getRank() == QUEEN || h1.getCardB().getRank() == KING)
        {
            h1Sum -= h1.getCardB().getRank();
            h1Sum += 10;
        }
        if(h1.getCardC().getRank() == JACK || h1.getCardC().getRank() == QUEEN || h1.getCardC().getRank() == KING)
        {
            h1Sum -= h1.getCardC().getRank();
            h1Sum += 10;
        }
        if(h1.getCardD().getRank() == JACK || h1.getCardD().getRank() == QUEEN || h1.getCardD().getRank() == KING)
        {
            h1Sum -= h1.getCardD().getRank();
            h1Sum += 10;
        }
        if(h1.getCardE().getRank() == JACK || h1.getCardE().getRank() == QUEEN || h1.getCardE().getRank() == KING)
        {
            h1Sum -= h1.getCardE().getRank();
            h1Sum += 10;
        }
        if(h1.getCardF().getRank() == JACK || h1.getCardF().getRank() == QUEEN || h1.getCardF().getRank() == KING)
        {
            h1Sum -= h1.getCardF().getRank();
            h1Sum += 10;
        }
        if(h1.getCardG().getRank() == JACK || h1.getCardG().getRank() == QUEEN || h1.getCardG().getRank() == KING)
        {
            h1Sum -= h1.getCardG().getRank();
            h1Sum += 10;
        }
        if(h1.getCardH().getRank() == JACK || h1.getCardH().getRank() == QUEEN || h1.getCardH().getRank() == KING)
        {
            h1Sum -= h1.getCardH().getRank();
            h1Sum += 10;
        }
        if(h1.getCardA().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardB().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardC().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardD().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardE().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardF().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardG().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardH().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
    }

    /**
     * Checks the hand for face cards and gives them the correct value.
     */
    private void checkAIHand()
    {
        if(h1.getCardA().getRank() == JACK || h1.getCardA().getRank() == QUEEN || h1.getCardA().getRank() == KING)
        {
            h1Sum -= h1.getCardA().getRank();
            h1Sum += 10;
        }
        if(h1.getCardB().getRank() == JACK || h1.getCardB().getRank() == QUEEN || h1.getCardB().getRank() == KING)
        {
            h1Sum -= h1.getCardB().getRank();
            h1Sum += 10;
        }
        if(h1.getCardC().getRank() == JACK || h1.getCardC().getRank() == QUEEN || h1.getCardC().getRank() == KING)
        {
            h1Sum -= h1.getCardC().getRank();
            h1Sum += 10;
        }
        if(h1.getCardD().getRank() == JACK || h1.getCardD().getRank() == QUEEN || h1.getCardD().getRank() == KING)
        {
            h1Sum -= h1.getCardD().getRank();
            h1Sum += 10;
        }
        if(h1.getCardE().getRank() == JACK || h1.getCardE().getRank() == QUEEN || h1.getCardE().getRank() == KING)
        {
            h1Sum -= h1.getCardE().getRank();
            h1Sum += 10;
        }
        if(h1.getCardF().getRank() == JACK || h1.getCardF().getRank() == QUEEN || h1.getCardF().getRank() == KING)
        {
            h1Sum -= h1.getCardF().getRank();
            h1Sum += 10;
        }
        if(h1.getCardG().getRank() == JACK || h1.getCardG().getRank() == QUEEN || h1.getCardG().getRank() == KING)
        {
            h1Sum -= h1.getCardG().getRank();
            h1Sum += 10;
        }
        if(h1.getCardH().getRank() == JACK || h1.getCardH().getRank() == QUEEN || h1.getCardH().getRank() == KING)
        {
            h1Sum -= h1.getCardH().getRank();
            h1Sum += 10;
        }
        if(h1.getCardI().getRank() == JACK || h1.getCardI().getRank() == QUEEN || h1.getCardI().getRank() == KING)
        {
            h1Sum -= h1.getCardI().getRank();
            h1Sum += 10;
        }
        if(h1.getCardA().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardB().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardC().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardD().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardE().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardF().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardG().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardH().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardI().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
    }

    /**
     * Checks the hand for face cards and gives them the correct value.
     */
    private void checkAJHand()
    {
        if(h1.getCardA().getRank() == JACK || h1.getCardA().getRank() == QUEEN || h1.getCardA().getRank() == KING)
        {
            h1Sum -= h1.getCardA().getRank();
            h1Sum += 10;
        }
        if(h1.getCardB().getRank() == JACK || h1.getCardB().getRank() == QUEEN || h1.getCardB().getRank() == KING)
        {
            h1Sum -= h1.getCardB().getRank();
            h1Sum += 10;
        }
        if(h1.getCardC().getRank() == JACK || h1.getCardC().getRank() == QUEEN || h1.getCardC().getRank() == KING)
        {
            h1Sum -= h1.getCardC().getRank();
            h1Sum += 10;
        }
        if(h1.getCardD().getRank() == JACK || h1.getCardD().getRank() == QUEEN || h1.getCardD().getRank() == KING)
        {
            h1Sum -= h1.getCardD().getRank();
            h1Sum += 10;
        }
        if(h1.getCardE().getRank() == JACK || h1.getCardE().getRank() == QUEEN || h1.getCardE().getRank() == KING)
        {
            h1Sum -= h1.getCardE().getRank();
            h1Sum += 10;
        }
        if(h1.getCardF().getRank() == JACK || h1.getCardF().getRank() == QUEEN || h1.getCardF().getRank() == KING)
        {
            h1Sum -= h1.getCardF().getRank();
            h1Sum += 10;
        }
        if(h1.getCardG().getRank() == JACK || h1.getCardG().getRank() == QUEEN || h1.getCardG().getRank() == KING)
        {
            h1Sum -= h1.getCardG().getRank();
            h1Sum += 10;
        }
        if(h1.getCardH().getRank() == JACK || h1.getCardH().getRank() == QUEEN || h1.getCardH().getRank() == KING)
        {
            h1Sum -= h1.getCardH().getRank();
            h1Sum += 10;
        }
        if(h1.getCardI().getRank() == JACK || h1.getCardI().getRank() == QUEEN || h1.getCardI().getRank() == KING)
        {
            h1Sum -= h1.getCardI().getRank();
            h1Sum += 10;
        }
        if(h1.getCardJ().getRank() == JACK || h1.getCardJ().getRank() == QUEEN || h1.getCardJ().getRank() == KING)
        {
            h1Sum -= h1.getCardJ().getRank();
            h1Sum += 10;
        }
        if(h1.getCardA().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardB().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardC().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardD().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardE().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardF().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardG().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardH().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardI().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardJ().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
    }

    /**
     * Checks the hand for face cards and gives them the correct value.
     */
    private void checkFullHand()
    {
        if(h1.getCardA().getRank() == JACK || h1.getCardA().getRank() == QUEEN || h1.getCardA().getRank() == KING)
        {
            h1Sum -= h1.getCardA().getRank();
            h1Sum += 10;
        }
        if(h1.getCardB().getRank() == JACK || h1.getCardB().getRank() == QUEEN || h1.getCardB().getRank() == KING)
        {
            h1Sum -= h1.getCardB().getRank();
            h1Sum += 10;
        }
        if(h1.getCardC().getRank() == JACK || h1.getCardC().getRank() == QUEEN || h1.getCardC().getRank() == KING)
        {
            h1Sum -= h1.getCardC().getRank();
            h1Sum += 10;
        }
        if(h1.getCardD().getRank() == JACK || h1.getCardD().getRank() == QUEEN || h1.getCardD().getRank() == KING)
        {
            h1Sum -= h1.getCardD().getRank();
            h1Sum += 10;
        }
        if(h1.getCardE().getRank() == JACK || h1.getCardE().getRank() == QUEEN || h1.getCardE().getRank() == KING)
        {
            h1Sum -= h1.getCardE().getRank();
            h1Sum += 10;
        }
        if(h1.getCardF().getRank() == JACK || h1.getCardF().getRank() == QUEEN || h1.getCardF().getRank() == KING)
        {
            h1Sum -= h1.getCardF().getRank();
            h1Sum += 10;
        }
        if(h1.getCardG().getRank() == JACK || h1.getCardG().getRank() == QUEEN || h1.getCardG().getRank() == KING)
        {
            h1Sum -= h1.getCardG().getRank();
            h1Sum += 10;
        }
        if(h1.getCardH().getRank() == JACK || h1.getCardH().getRank() == QUEEN || h1.getCardH().getRank() == KING)
        {
            h1Sum -= h1.getCardH().getRank();
            h1Sum += 10;
        }
        if(h1.getCardI().getRank() == JACK || h1.getCardI().getRank() == QUEEN || h1.getCardI().getRank() == KING)
        {
            h1Sum -= h1.getCardI().getRank();
            h1Sum += 10;
        }
        if(h1.getCardJ().getRank() == JACK || h1.getCardJ().getRank() == QUEEN || h1.getCardJ().getRank() == KING)
        {
            h1Sum -= h1.getCardJ().getRank();
            h1Sum += 10;
        }
        if(h1.getCardK().getRank() == JACK || h1.getCardK().getRank() == QUEEN || h1.getCardK().getRank() == KING)
        {
            h1Sum -= h1.getCardK().getRank();
            h1Sum += 10;
        }
        if(h1.getCardA().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardB().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardC().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardD().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardE().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardF().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardG().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardH().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardI().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardJ().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
        if(h1.getCardK().getRank() == ACE)
        {
            if(h1Sum + 10 <= MAX)
            {
                h1Sum += 10; 
            }
        }
    }
}
