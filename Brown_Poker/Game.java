import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Random;
public class Game
{
    private final int ACE = 1;
    private final int JACK = 11;
    private final int QUEEN = 12;
    private final int KING = 13;
    private final int HAND_SIZE = 5;//change this number to change the amount of cards
    Deck d;
    PokerHand h1;
    PokerHand h2;
    double straight = 0;
    double flush = 0;
    double pair = 0;
    double twoPair = 0;
    double threeOfAKind = 0;
    double straightFlush = 0;
    double royalFlush = 0;
    double fourOfAKind = 0;
    double fullHouse = 0;
    double bust = 0;
    String x;
    int chips = 10;
    String bet;
    int betInt;
    String a = "0123456789";
    boolean betBoolean = false;
    /**
     * Constructor
     */
    public Game()
    {
    }

    /**
     * Plays a game of poker.
     */
    public void play()
    {
        d = new Deck();
        h1 = new PokerHand();
        h2 = new PokerHand();
        d.shuffle();
        for(int i = 0; i < HAND_SIZE; i++)
        {
            h1.adding(d.dealCard());
        }
        for(int i = 0; i < HAND_SIZE; i++)
        {
            h2.adding(d.dealCard());
        }
        String str2 = findWinner();
        System.out.println("\f");
        while(true && chips > -1)
        {
            String options = JOptionPane.showInputDialog(null,"What would you like to do? <1>Look at cards <2>Look at opponent <3>Bet <4>Play");
            if(options != null)
            {
                if(options.equals("1"))
                {
                    System.out.println("Player's Hand:");
                    h1.printHand();
                    System.out.println("\n");
                }
                else if(options.equals("2"))
                {
                    Random rand = new Random();
                    if(str2.equals("Player"))
                    {
                        int r = rand.nextInt(50)+1;
                        if(r < 25)
                        {
                            System.out.println("Your opponent seems a bit on edge.");
                        }
                        else if(r > 90)
                        {
                            System.out.println("Your opponent seems rather confident.");
                        }
                        else
                        {
                            System.out.println("Your opponent has a poker face.");
                        }
                    }
                    else if(str2.equals("Opponent"))
                    {
                        int r = rand.nextInt(50)+1;
                        if(r < 25)
                        {
                            System.out.println("Your opponent seems rather confident.");
                        }
                        else if(r > 90)
                        {
                            System.out.println("Your opponent seems a bit on edge.");
                        }
                        else
                        {
                            System.out.println("Your opponent has a poker face.");
                        }
                    }
                    else
                    {
                        System.out.println("Your opponent has a poker face.");
                    }
                }
                else if(options.equals("3"))
                {
                    if(betBoolean == false)
                    {
                        bet = JOptionPane.showInputDialog(null,"How much would you like to bet? Current Chips: " + chips + " (1 chip = $100)");
                        if(bet != null && !bet.equals("") && a.indexOf(bet.substring(0,1)) > -1)
                        {
                            betInt = Integer.parseInt(bet);
                            if(betInt <= chips && betInt >= 0)
                            {
                                chips -= betInt;
                                System.out.println("You successfully bet " + betInt + " chips.");
                                betBoolean = true;
                            }
                            else
                            {
                                System.out.println("Not enough funds.");
                            }
                        }
                    }
                }
                else if(options.equals("4"))
                {
                    System.out.println("Player's Hand:");
                    h1.printHand();
                    printEvaluation(h1);
                    System.out.println("\n");
                    System.out.println("Opponent's Hand:");
                    h2.printHand();
                    printEvaluation(h2);
                    System.out.println("\n");
                    System.out.println("Winner: " + str2);
                    if(str2.equals("Player"))
                    {
                        chips += betInt * 2;
                    }
                    System.out.println("Chips: " + chips);
                    break;
                }
            }
        }
        if(chips == 0)
        {
            chips -= 1;
            System.out.println("You ran out of funds and can no longer play. (Restart Game to reset your chips and play again)");
        }
    }

    /**
     * Decides what to print depending on evaluation.
     */
    private void printEvaluation(PokerHand x)
    {
        if(x.evaluate() == 9)
        {
            System.out.println("Royal Flush");
        }
        else if(x.evaluate() == 8)
        {
            System.out.println("Straight Flush");
        }
        else if(x.evaluate() == 7)
        {
            System.out.println("Four of a Kind");
        }
        else if(x.evaluate() == 6)
        {
            System.out.println("Full House");
        }
        else if(x.evaluate() == 5)
        {
            System.out.println("Flush");
        }
        else if(x.evaluate() == 4)
        {
            System.out.println("Straight");
        }
        else if(x.evaluate() == 3)
        {
            System.out.println("Three of a Kind");
        }
        else if(x.evaluate() == 2)
        {
            System.out.println("Two Pair");
        }
        else if(x.evaluate() == 1)
        {
            System.out.println("Pair");
        }
        else
        {
            System.out.println("Bust");
        }
    }

    /**
     * Finds which person is the winner.
     */
    private String findWinner()
    {
        String str = "";
        if(h1.evaluate() > h2.evaluate())
        {
            str = "Player";
        }
        else if(h2.evaluate() > h1.evaluate())
        {
            str = "Opponent";
        }
        else
        {
            highCard();
            str = x;
        }
        return str;
    }

    /**
     * Looks for highest card in a bust.
     */
    private void highCardByRank()
    {
        for(int i = 1; i < h1.getSize(); i++)
        {
            if(h1.getCard(h1.getSize()-i).rank > h2.getCard(h2.getSize()-i).rank)
            {
                x = "Player";
                break;
            }
            else if(h2.getCard(h2.getSize()-i).rank > h1.getCard(h1.getSize()-i).rank)
            {
                x = "Opponent";
                break;
            }
        }
    }

    /**
     * Determines the winner if there is a tie.
     */
    private String highCard()
    {
        x = "None";
        if(h1.evaluate() == 0 && h2.evaluate() == 0)
        {
            highCardByRank();
        }
        else if(h1.evaluate() == 1 && h2.evaluate() == 1)
        {
            if(h1.getHighCard().rank > h2.getHighCard().rank)
            {
                x = "Player";
            }
            else if(h2.getHighCard().rank > h1.getHighCard().rank)
            {
                x = "Opponent";
            }
            else
            {
                highCardByRank();
            }
        }
        else if(h1.evaluate() == 2 && h2.evaluate() == 2)
        {
            if(h1.getHighCard().rank > h2.getHighCard().rank)
            {
                x = "Player";
            }
            else if(h2.getHighCard().rank > h1.getHighCard().rank)
            {
                x = "Opponent";
            }
            else
            {
                highCardByRank();
            }
        }
        else if(h1.evaluate() == 3 && h2.evaluate() == 3)
        {
            if(h1.getHighCard().rank > h2.getHighCard().rank)
            {
                x = "Player";
            }
            else if(h2.getHighCard().rank > h1.getHighCard().rank)
            {
                x = "Opponent";
            }
            else
            {
                highCardByRank();
            }
        }
        else if(h1.evaluate() == 4 && h2.evaluate() == 4)
        {
            if(h1.getHighCard().rank > h2.getHighCard().rank)
            {
                x = "Player";
            }
            else if(h2.getHighCard().rank > h1.getHighCard().rank)
            {
                x = "Opponent";
            }
            else
            {
                highCardByRank();
            }
        }
        else if(h1.evaluate() == 5 && h2.evaluate() == 5)
        {
            if(h1.getHighCard().rank > h2.getHighCard().rank)
            {
                x = "Player";
            }
            else if(h2.getHighCard().rank > h1.getHighCard().rank)
            {
                x = "Opponent";
            }
            else
            {
                highCardByRank();
            }
        }
        else if(h1.evaluate() == 6 && h2.evaluate() == 6)
        {
            if(h1.getHighCard().rank > h2.getHighCard().rank)
            {
                x = "Player";
            }
            else if(h2.getHighCard().rank > h1.getHighCard().rank)
            {
                x = "Opponent";
            }
            else
            {
                highCardByRank();
            }
        }
        else if(h1.evaluate() == 7 && h2.evaluate() == 7)
        {
            if(h1.getHighCard().rank > h2.getHighCard().rank)
            {
                x = "Player";
            }
            else if(h2.getHighCard().rank > h1.getHighCard().rank)
            {
                x = "Opponent";
            }
            else
            {
                highCardByRank();
            }
        }
        else if(h1.evaluate() == 8 && h2.evaluate() == 8)
        {
            if(h1.getHighCard().rank > h2.getHighCard().rank)
            {
                x = "Player";
            }
            else if(h2.getHighCard().rank > h1.getHighCard().rank)
            {
                x = "Opponent";
            }
            else
            {
                highCardByRank();
            }
        }
        else
        {
            highCardByRank();
        }
        return x;
    }

    /**
     * Checks hands 1000000 times and gives the amounts of each evaluation.
     */
    public void pokerStats()
    {
        d = new Deck();
        h1 = new PokerHand();
        for(int x = 0; x < 1000000; x++)
        {
            d.shuffle();
            for(int i = 0; i < HAND_SIZE; i++)
            {
                h1.adding(d.dealCard());
            }
            evaluateCounter();
            for(int y = HAND_SIZE-1; y >= 0; y--)
            {
                Card temp = h1.getCard(y);
                d.adding(temp);
                h1.removeCard(y);
            }
        }
        System.out.println("\f");
        System.out.println(royalFlush/1000000 + "\n" + straightFlush/1000000 + "\n" + fourOfAKind/1000000 + "\n" + fullHouse/1000000 + "\n" + flush/1000000 + "\n" + straight/1000000 + "\n" + threeOfAKind/1000000 + "\n" + twoPair/1000000 + "\n" + pair/1000000 + "\n" + bust/1000000);
    }

    /**
     * Adds to the correct evaluation counters depending on what they are.
     */
    private void evaluateCounter()
    {
        if(h1.evaluate() == 9)
        {
            royalFlush += 1;
        }
        else if(h1.evaluate() == 8)
        {
            straightFlush += 1;
        }
        else if(h1.evaluate() == 7)
        {
            fourOfAKind += 1;
        }
        else if(h1.evaluate() == 6)
        {
            fullHouse += 1;
        }
        else if(h1.evaluate() == 5)
        {
            flush += 1;
        }
        else if(h1.evaluate() == 4)
        {
            straight += 1;
        }
        else if(h1.evaluate() == 3)
        {
            threeOfAKind += 1;
        }
        else if(h1.evaluate() == 2)
        {
            twoPair += 1;
        }
        else if(h1.evaluate() == 1)
        {
            pair += 1;
        }
        else
        {
            bust += 1;
        }
    }

    /**
     * Tests specific hands to to see if they evalaute correctly.
     */
    public void pokerHandTester()
    {
        d = new Deck();
        Card a = new Card(0,1);
        Card b = new Card(0,2);
        Card c = new Card(0,3);
        Card d = new Card(0,4);
        Card e = new Card(0,5);
        Card f = new Card(0,6);
        Card g = new Card(0,7);
        Card h = new Card(0,8);
        Card i = new Card(0,9);
        Card j = new Card(0,10);
        Card k = new Card(0,11);
        Card l = new Card(0,12);
        Card m = new Card(0,13);
        Card n = new Card(1,1);
        Card o = new Card(1,2);
        Card p = new Card(1,3);
        Card q = new Card(1,4);
        Card r = new Card(1,5);
        Card s = new Card(1,6);
        Card t = new Card(1,7);
        Card u = new Card(1,8);
        Card v = new Card(1,9);
        Card w = new Card(1,10);
        Card x = new Card(1,11);
        Card y = new Card(1,12);
        Card z = new Card(1,13);
        Card ab = new Card(2,1);
        Card bc = new Card(3,1);
        PokerHand pair = new PokerHand();
        pair.adding(a);
        pair.adding(n);
        pair.evaluate();
        printEvaluation(pair);
        PokerHand twoPair = new PokerHand();
        twoPair.adding(a);
        twoPair.adding(n);
        twoPair.adding(b);
        twoPair.adding(o);
        twoPair.evaluate();
        printEvaluation(twoPair);
        PokerHand threeOfAKind = new PokerHand();
        threeOfAKind.adding(a);
        threeOfAKind.adding(n);
        threeOfAKind.adding(ab);
        threeOfAKind.evaluate();
        printEvaluation(threeOfAKind);
        PokerHand straight = new PokerHand();
        straight.adding(a);
        straight.adding(b);
        straight.adding(p);
        straight.adding(q);
        straight.adding(r);
        straight.evaluate();
        printEvaluation(straight);
        PokerHand flush = new PokerHand();
        flush.adding(a);
        flush.adding(b);
        flush.adding(j);
        flush.adding(k);
        flush.adding(g);
        flush.evaluate();
        printEvaluation(flush);
        PokerHand fourOfAKind = new PokerHand();
        fourOfAKind.adding(a);
        fourOfAKind.adding(n);
        fourOfAKind.adding(ab);
        fourOfAKind.adding(bc);
        fourOfAKind.evaluate();
        printEvaluation(fourOfAKind);
        PokerHand fullHouse = new PokerHand();
        fullHouse.adding(a);
        fullHouse.adding(n);
        fullHouse.adding(ab);
        fullHouse.adding(h);
        fullHouse.adding(u);
        fullHouse.evaluate();
        printEvaluation(fullHouse);
        PokerHand straightFlush = new PokerHand();
        straightFlush.adding(a);
        straightFlush.adding(b);
        straightFlush.adding(c);
        straightFlush.adding(d);
        straightFlush.adding(e);
        straightFlush.evaluate();
        printEvaluation(straightFlush);
        PokerHand bust = new PokerHand();
        bust.adding(a);
        bust.evaluate();
        printEvaluation(bust);
        PokerHand royalFlush = new PokerHand();
        royalFlush.adding(j);
        royalFlush.adding(k);
        royalFlush.adding(l);
        royalFlush.adding(m);
        royalFlush.adding(a);
        royalFlush.evaluate();
        printEvaluation(royalFlush);
    }
}
