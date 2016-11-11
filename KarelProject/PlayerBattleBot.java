import javax.swing.JOptionPane;
import java.util.Random;
import java.awt.Color;
public class PlayerBattleBot extends SmartBot
{
    private int playerBattleBotHP;
    private int playerBattleBotStrength;
    private int playerBattleBotAgility;
    private int playerBattleBotIntelligence;

    public PlayerBattleBot(int street, int avenue, Direction dir, int num_beepers, Color badge)
    {
        super(street, avenue, dir, num_beepers, badge);

    }

    /**
     * Makes player battle bot's HP equal player's HP.
     */
    public void PlayerBattleBotHP(PlayerBot pl)
    {
        playerBattleBotHP = pl.getPlayerHP();
    }

    /**
     * Makes player battle bot's strength equal player's strength.
     */
    public void PlayerBattleBotStrength(PlayerBot pl)
    {
        playerBattleBotStrength = pl.getPlayerStrength();
    }

    /**
     * Makes player battle bot's agility equal player's agility.
     */
    public void PlayerBattleBotAgility(PlayerBot pl)
    {
        playerBattleBotAgility = pl.getPlayerAgility();
    }

    /**
     * Makes player battle bot's intelligence equal player's intelligence.
     */
    public void PlayerBattleBotIntelligence(PlayerBot pl)
    {
        playerBattleBotIntelligence = pl.getPlayerIntelligence();
    }

    /**
     * Moves the player battle bot to the battle bot on the left.
     */
    public void moveToRobot1()
    {
        move();
        move();
        move();
        turnLeft();
        move();
        turnRight();
        move();
        move();
        move();
    }

    /**
     * Moves the player battle bot to the battle bot in the middle.
     */
    public void moveToRobot2()
    {
        move();
        move();
        move();
        move();
        move();
        move();
    }

    /**
     * Moves the player battle bot to the battle bot on the right.
     */
    public void moveToRobot3()
    {
        move();
        move();
        move();
        turnRight();
        move();
        turnLeft();
        move();
        move();
        move();
    }

    /**
     * Causes player battle bot's attack damage plus strength to be taken from the HP of the enemy it attacks.
     */
    public void melee(BattleBot a)
    {
        if(nextToARobot())
        {
            Random rand = new Random();
            int playerDamage = rand.nextInt(5) + 1;
            playerDamage = playerDamage + playerBattleBotStrength;
            a.setBattleBotHP(a.getBattleBotHP() - playerDamage);
            System.out.println("You attacked and did " + playerDamage + " damage. The enemy's HP is now " + a.getBattleBotHP() + ".");
        }
    }

    /**
     * Returns player battle bot from the robot on the left.
     */
    public void returnFrom1()
    {
        turnAround();
        move();
        move();
        turnLeft();
        move();
        turnRight();
        move();
        move();
        move();
        move();
        turnAround();
    }

    /**
     * Returns player battle bot from the robot in the middle.
     */
    public void returnFrom2()
    {
        turnAround();
        move();
        move();
        move();
        move();
        move();
        move();
        turnAround();
    }

    /**
     * Returns player battle bot from the robot on the right.
     */
    public void returnFrom3()
    {
        turnAround();
        move();
        move();
        turnRight();
        move();
        turnLeft();
        move();
        move();
        move();
        move();
        turnAround();
    }

    /**
     * Allows changing of player battle bot's HP.
     */
    public void setPlayerBattleBotHP(int a)
    {
        playerBattleBotHP = a;
    }

    /**
     * Returns player battle bot's HP.
     */
    public int getPlayerBattleBotHP()
    {
        return playerBattleBotHP;
    }

    /**
     * Makes all three battle bots move to the player, attack it, and return to their previous positions.
     */
    public void enemiesAttack(BattleBot a, BattleBot b, BattleBot c, PlayerBattleBot p)
    {
        if(a.getBattleBotHP() > 0)
        {
            a.battleBotMoveToPlayer1();
            a.battleBotFight(p);
            a.battleBotReturn1();
        }
        if(b.getBattleBotHP() > 0)
        {
            b.battleBotMoveToPlayer2();
            b.battleBotFight(p);
            b.battleBotReturn2();
        }
        if(c.getBattleBotHP() > 0)
        {
            c.battleBotMoveToPlayer3();
            c.battleBotFight(p);
            c.battleBotReturn3();
        }
    }

    /**
     * Returns player battle bot's agility.
     */
    public int getPlayerBattleBotAgility()
    {
        return playerBattleBotAgility;
    }

    /**
     * Returns player battle bot's strength.
     */
    public int getPlayerBattleBotStrength()
    {
        return playerBattleBotStrength;
    }

    /**
     * Returns player battle bot's intelligence.
     */
    public int getPlayerBattleBotIntelligence()
    {
        return playerBattleBotIntelligence;
    }

    /**
     * Allows changing of player battle bot's strength.
     */
    public void setPlayerBattleBotStrength(int a)
    {
        playerBattleBotStrength = a;
    }

    /**
     * Allows changing of player battle bot's agility.
     */
    public void setPlayerBattleBotAgility(int a)
    {
        playerBattleBotAgility = a;
    }

    /**
     * Allows changing of player battle bot's intelligence.
     */
    public void setPlayerBattleBotIntelligence(int a)
    {
        playerBattleBotIntelligence = a;
    }
}

