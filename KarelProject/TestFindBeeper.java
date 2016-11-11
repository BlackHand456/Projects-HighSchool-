import kareltherobot.*;
import java.util.Random;
import java.awt.Color;
public class TestFindBeeper extends KJRTest implements Directions
{

    public TestFindBeeper(String name)
    {   super(name);
    }

    public void setUp()
    {   
        World.setVisible(true);
        World.setTrace(false);

        World.setDelay(10);
    }

    public void test1_attack()
    {
        World.reset();
        World.readWorld("karel-Project.wrld");
        PlayerBot karel = new PlayerBot(1, 1, North, 0, Color.red);  
        EnemyBot e = new EnemyBot(1, 1, North, 0, Color.black);

        //karel.attack(e);
    }

    public void test2_beepers()
    {
        World.reset();
        World.readWorld("karel-Project.wrld");
        PlayerBot karel = new PlayerBot(1, 1, North, 0, Color.red);  
        World.placeBeepers(1,1,1);

        karel.beepers();
    }

    public void test3_enemyMovement()
    {
        World.reset();
        World.readWorld("karel-Project.wrld");
        PlayerBot karel = new PlayerBot(1, 1, North, 0, Color.red);  
        EnemyBot bot1 = new EnemyBot(1, 14, West, 0, Color.black);
        EnemyBot bot2 = new EnemyBot(14, 14, South, 0, Color.black);
        EnemyBot bot3 = new EnemyBot(14, 1, South, 0, Color.black);

        bot1.enemyMovement(karel);
        bot2.enemyMovement(karel);
        bot3.enemyMovement(karel);
    }

    public void test4_trackHP()
    {
        World.reset();
        World.readWorld("karel-Project.wrld");
        PlayerBot karel = new PlayerBot(1, 1, North, 0, Color.red);  
        HPBot HPTracker = new HPBot(1, 15, North, 100, Color.white);
        HPTracker.setVisible(false);
        World.setDelay(0);

        //EnemyBot e = new EnemyBot(1, 1, North, 0);
        //karel.attack(e);

        //World.placeBeepers(1,1,1);
        //karel.beepers();

        HPTracker.trackHP(karel);
    }

    public void test5_controlPlayer()
    {
        World.reset();
        World.readWorld("karel-Project.wrld");
        PlayerBot karel = new PlayerBot(1, 1, North, 0, Color.red); 
        //  World.setDelay(5);
        karel.controlPlayer();
        //  World.setDelay(10);
    }

    public void test6_controlPlayerWhileEnemiesMove()
    {
        World.reset();
        World.readWorld("karel-Project.wrld");
        PlayerBot karel = new PlayerBot(1, 1, North, 0, Color.red); 
        EnemyBot bot1 = new EnemyBot(1, 14, West, 0, Color.black);
        EnemyBot bot2 = new EnemyBot(14, 14, South, 0, Color.black);
        EnemyBot bot3 = new EnemyBot(14, 1, South, 0, Color.black);

        while(karel.getPlayerHP() > 0)
        {
            World.setDelay(5);
            karel.controlPlayer();
            World.setDelay(10);

            bot1.enemyMovement(karel);
            bot2.enemyMovement(karel);
            bot3.enemyMovement(karel);
        }
    }

    //World.readWorld("GameOver.wrld")

    public static void main(String[] args)
    {
        junit.textui.TestRunner.run(TestFindBeeper.class);
    }
}