import java.util.Random;
import java.awt.Color;
public class BattleBot extends SmartBot
{
    private int battleBotHP;
    private int battleBotStrength;
    public BattleBot(int street, int avenue, Direction dir, int num_beepers, Color badge)
    {
        super(street, avenue, dir, num_beepers, badge);

        battleBotHP = 10;
        battleBotStrength = 1;
    }

    /**
     * Allows changing of a battle bot's HP.
     */
    public void setBattleBotHP(int a)
    {
        battleBotHP = a;
    }

    /**
     * Returns a battle bot's HP.
     */
    public int getBattleBotHP()
    {
        return battleBotHP;
    }

    /**
     * Allows changing of a battle bot's strength.
     */
    public void setBattleBotStrength(int b)
    {
        battleBotStrength = b;
    }

    /**
     * Returns a battle bot's strength.
     */
    public int getBattleBotStrength()
    {
        return battleBotStrength;
    }

    /**
     * Moves a battle bot on the left to the player.
     */
    public void battleBotMoveToPlayer1()
    {
        move();
        move();
        turnLeft();
        move();
        turnRight();
        move();
        move();
        move();
        move();
    }

    /**
     * Returns a battle bot from the player to the left position.
     */
    public void battleBotReturn1()
    {
        turnAround();
        move();
        move();
        move();
        turnLeft();
        move();
        turnRight();
        move();
        move();
        move();
        turnAround();
    }

    /**
     * Moves a battle bot in the middle to the player.
     */
    public void battleBotMoveToPlayer2()
    {
        move();
        move();
        move();
        move();
        move();
        move();
    }

    /**
     * Returns a battle bot from the player to the middle position.
     */
    public void battleBotReturn2()
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
     * Moves a battle bot on the right to the player.
     */
    public void battleBotMoveToPlayer3()
    {
        move();
        move();
        turnRight();
        move();
        turnLeft();
        move();
        move();
        move();
        move();
    }

    /**
     * Returns a battle bot from the player to the right position.
     */
    public void battleBotReturn3()
    {
        turnAround();
        move();
        move();
        move();
        turnRight();
        move();
        turnLeft();
        move();
        move();
        move();
        turnAround();
    }

    /**
     * Gives attack damage for enemies and subtracts it from player health if the attack does not miss.
     */
    public void battleBotFight(PlayerBattleBot a)
    {
        Random rand = new Random();
        int enemyDamage = rand.nextInt(5) + 1;
        enemyDamage = enemyDamage + battleBotStrength;
        int hitChance = rand.nextInt(100) + 1;
        if(hitChance > 40)
        {
            a.setPlayerBattleBotHP(a.getPlayerBattleBotHP() - enemyDamage);
            System.out.println("The enemy attacked and did " + enemyDamage + " damage. Your HP is now " + a.getPlayerBattleBotHP() + ".");
        }
        else
        { 
            System.out.println("The enemy missed.");
        }
    }
}
