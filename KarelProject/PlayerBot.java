import java.util.Random;
import javax.swing.JOptionPane;
import java.awt.Color;
public class PlayerBot extends SmartBot
{
    private int playerHP = 0;
    private int playerStrength = 0;
    private int playerAgility = 0;
    private int playerIntelligence = 0;
    private int playerX = 0;
    private int playerY = 0;

    public PlayerBot(int street, int avenue, Direction dir, int num_beepers, Color badge)
    {
        super(street, avenue, dir, num_beepers, badge);

        playerHP = 40;
        playerStrength = 3;
        playerAgility = 10;
        playerIntelligence = 1;
        playerX = avenue;
        playerY = street;

    }
    
    /**
     * Allows one to control the player bot and move it in different directions.
     */
    public void controlPlayer()
    {
        while(true)
        {
            String numstr1 = JOptionPane.showInputDialog(null,"Input directions: ");
            if(numstr1 != null)
            {
                if(numstr1.equals("8"))
                {
                    if(frontIsClear())
                    {
                        move();
                        playerY = playerY + 1;
                    }
                    break;
                }
                else if(numstr1.equals("6"))
                {
                    turnRight();
                    if(frontIsClear())
                    {
                        move();
                        playerX = playerX + 1;
                    }
                    turnLeft();
                    break;
                }
                else if(numstr1.equals("4"))
                {
                    turnLeft();
                    if(frontIsClear())
                    {
                        move();
                        playerX = playerX - 1;
                    }
                    turnRight();
                    break;
                }
                else if(numstr1.equals("2"))
                {
                    turnAround();
                    if(frontIsClear())
                    {
                        move();
                        playerY = playerY - 1;
                    }
                    turnAround();
                    break;
                }
                else if(numstr1.equals("stop"))
                {
                    Play.inGame =  false;
                    break;
                }
                else if(numstr1.equals("skip"))
                {
                    break;
                }
                else if(numstr1.equals("stats"))
                {
                    System.out.println("HP: " + playerHP + " Strength: " + playerStrength + " Agility: " + playerAgility + " Intelligence: " + playerIntelligence);
                }
            }
        }
    }

    /**
     * Makes it so that if the player is next to a beeper then they pick it up and it affects one of their stats.
     */
    public void beepers()
    {
        while(nextToABeeper())
        {
            pickBeeper();

            Random rand = new Random();
            int num = rand.nextInt(100) + 1;
            if(num <= 40)
            {
                int randHP = rand.nextInt(11) + 5;
                System.out.println("You found an HP beeper. You gain " + randHP + " HP.");
                playerHP = playerHP + randHP;
            }
            else if(num > 40 && num < 65)
            {
                int randStrength = rand.nextInt(5) + 1;
                System.out.println("You found a strength beeper. You gain " + randStrength + " strength.");
                playerStrength = playerStrength + randStrength;
            }
            else if(num >= 65 && num < 90)
            {
                int randAgility = rand.nextInt(10) + 1;
                System.out.println("You found an agility beeper. You gain " + randAgility + " agility.");
                playerAgility = playerAgility + randAgility;
            }
            else if(num >= 90)
            {
                int randIntelligence = rand.nextInt(3) + 1;
                System.out.println("You found an intelligence beeper. You gain " + randIntelligence + " intelligence.");
                playerIntelligence = playerIntelligence + randIntelligence;
            }
        }
    }

    /**
     * Returns the player's HP.
     */
    public int getPlayerHP()
    {
        return playerHP;
    }
    
    /**
     * Allows changing the player's HP.
     */
     public void setPlayerHP(int a)
    {
        playerHP = a;
    }

    /**
     * Returns the player's strength.
     */
    public int getPlayerStrength()
    {
        return playerStrength;
    }

    /**
     * Returns the player's agility.
     */
    public int getPlayerAgility()
    {
        return playerAgility;
    }

    /**
     * Returns the player's intelligence.
     */
    public int getPlayerIntelligence()
    {
        return playerIntelligence;
    }

    /**
     * Returns the player's x coordinate.
     */
    public int getPlayerX()
    {
        return playerX;
    }

    /**
     * Returns the player's y coordinate.
     */
    public int getPlayerY()
    {
        return playerY;
    }
}

