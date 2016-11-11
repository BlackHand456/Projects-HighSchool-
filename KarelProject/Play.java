import kareltherobot.*;
import java.util.Random;
import javax.swing.JOptionPane;
import java.awt.Color;
/**
 * This program should run a world where beepers and walls are randomly generated and the player must control their robot and defeat the enemies. 
 * Picking up beepers increases stats and when one encounters an enemy a battle world is loaded where one can run, use magic, or use melee. 
 * If the player dies then the game over screen is loaded, but if the player finishes five levels or waves, where the enemy default health increases, then the win screen is loaded. 
 */
public class Play implements Directions
{
    PlayerBot pl;
    EnemyBot bot1;
    EnemyBot bot2;
    EnemyBot bot3;
    HPBot HPTracker;
    public static boolean inGame = true;//allows for stopping the game with the input 'stop'
    int beepers = 8;//how many beepers the world randomly places
    int NSWalls = 5;// how mnay NS walls the world randomly places
    int EWWalls = 5;//how many EW walls the world randomly places
    int z = 0;//allows for determining which bot is next to the player
    int pY;//player's y coordinate
    int pX;//player's x coordinate
    int b1Y;//bot1's y coordinate
    int b1X;//bot1's x coordinate
    int b2Y;//bot2's y coordinate
    int b2X;//bot2's x coordinate
    int b3Y;//bot3's y coordinate
    int b3X;//bot3's x coordinate
    int enemyMove = 1;//determines which enemy moves during a turn
    Direction direction1;//bot1's direction
    Direction direction2;//bot2's direction
    Direction direction3;//bot3's direction
    int escape;//determines whether you can flee from a battle
    int waveCount;//counts how many waves you have beaten
    /**
     * Sets up the game and processes turns while the player is still alive. If the player dies then it loads the game over world. If the player defeats all enemies then it allows him to go to the next level.
     */
    public Play()
    {
        setUp();

        while(inGame == true && pl.getPlayerHP() > 0)
        {
            oneTurn();
            if(pl.nextToARobot())
            {
                System.out.println("You have encountered an enemy.");
                attack();
            }
            if(bot1.getEnemyHP() <= 0 && bot2.getEnemyHP() <= 0 && bot3.getEnemyHP() <= 0)
            {
                World.removeEWWall(14,7);
                World.repaint();
            }
            if(pl.getPlayerX() == 7 && pl.getPlayerY() == 15)
            {
                World.reset();
                setUp();
                bot1.setEnemyHP(+10);
                bot2.setEnemyHP(+10);
                bot3.setEnemyHP(+10);
                waveCount += 1;
            }
            if(waveCount == 5)
            {
                pl.turnOff();
                World.reset();
                World.setVisible(true);
                World.setTrace(false);
                World.readWorld("YouWinWorld.wrld");
            }
            World.saveWorld("karel-Project2.wrld");
        }
        if(pl.getPlayerHP() <= 0)
        {
            gameOver();
        }
    }

    /**
     * Sets up the world and prints instructions and controls.
     */
    public void setUp()
    {   
        pl = new PlayerBot(1, 1, North, 0, Color.red); 
        bot1 = new EnemyBot(1, 14, West, 0, Color.black);
        bot2 = new EnemyBot(14, 14, South, 0, Color.black);
        bot3 = new EnemyBot(14, 1, South, 0, Color.black);
        HPTracker = new HPBot(1, 15, North, 1000, Color.white);
        World.setVisible(true);
        World.setTrace(false);
        World.readWorld("karel-Project.wrld");
        World.setWorldColor(java.awt.Color.lightGray);
        World.placeEWWall(14,7,1);
        World.setDelay(0);
        HPTracker.setVisible(false);
        placeBeepers();
        placeWalls();
        World.repaint();
        System.out.println("You must defeat all of the robots so that a door will open to the next room.");
        System.out.println("As you progress the robots will get stronger so you must be wary.");
        System.out.println("Also, collect beepers to raise your stats.");
        System.out.println("Oh, I forgot to tell you. In order to move use the numberpad on the right of your keyboard.");
        System.out.println("To move in a specific direction press the number with a corresponding arrow beneath it."); 
        System.out.println("Also, remember to always press 'enter' after you input something."); 
        System.out.println("Now go and defeat the evil robots!");
        System.out.println("Note: Input 'stop' to allow exiting the game, 'skip' to skip your turn, and 'stats' to see your stats");
    }

    /**
     * Sets up the world for battle.
     */
    public void setUpBattle()
    {
        pY = pl.getPlayerY();
        pX = pl.getPlayerX();
        b1Y = bot1.getY();
        b1X = bot1.getX();
        b2Y = bot2.getY();
        b2X = bot2.getY();
        b3Y = bot3.getY();
        b3X = bot3.getX();
        direction1 = bot1.getDirection();
        direction2 = bot2.getDirection();
        direction3 = bot3.getDirection();
        World.reset();
        World.setVisible(true);
        World.setTrace(false);
        World.readWorld("BattleWorld.wrld");
        World.setWorldColor(java.awt.Color.lightGray);
        World.setDelay(10);
        World.repaint();
    }

    /**
     * Makes one turn consist of both player and enemy movements.
     */
    public void oneTurn()
    {
        playerTurn();
        enemyTurn();
    }

    /**
     * Tracks player's HP, looks for beepers and enemies next to the player, and allows you to move.
     */
    public void playerTurn()
    {
        World.setDelay(0);
        HPTracker.trackHP(pl);
        World.setDelay(10);
        if(pl.getPlayerHP() > 0)
        {
            pl.beepers();
            pl.controlPlayer();
            pl.beepers();
            trackZ();
            World.setDelay(0);
            HPTracker.trackHP(pl);
            World.setDelay(10);
        }
    }

    /**
     * Causes enemies to move in a pattern where one moves each turn to give the player a movement advantage.
     */
    public void enemyTurn()
    {
        World.setDelay(2);
        if(bot1.getEnemyHP() <= 0 && enemyMove == 1)
        {
            enemyMove = 2;
        }
        else if(bot2.getEnemyHP() <= 0 && enemyMove == 2)
        {
            enemyMove = 3;
        }
        else if(bot3.getEnemyHP() <= 0 && enemyMove == 3)
        {
            enemyMove = 1;
        }
        else if(bot1.getEnemyHP() <= 0 && bot2.getEnemyHP() <= 0)
        {
            enemyMove = 3;
        }
        else if(bot1.getEnemyHP() <= 0 && bot3.getEnemyHP() <= 0)
        {
            enemyMove = 2;
        }
        else if(bot2.getEnemyHP() <= 0 && bot3.getEnemyHP() <= 0)
        {
            enemyMove = 1;
        }

        if(enemyMove == 1)
        {
            if(bot1.getEnemyHP() > 0)
            {
                bot1.enemyMovement(pl);
                if(bot2.getEnemyHP() <= 0)
                {
                    enemyMove += 2;
                }
                else if(bot2.getEnemyHP() <= 0 && bot3.getEnemyHP() <= 0)
                {
                    enemyMove = 1;
                }
                else
                {
                    enemyMove += 1;
                }
            }
        }
        else if(enemyMove == 2)
        {
            if(bot2.getEnemyHP() > 0)
            {
                bot2.enemyMovement(pl);
                if(bot3.getEnemyHP() <= 0)
                {
                    enemyMove = 1;
                }
                else
                {
                    enemyMove += 1;
                }
            }
        }
        else if(enemyMove == 3)
        {
            if(bot3.getEnemyHP() > 0)
            {
                bot3.enemyMovement(pl);
                enemyMove = 1;
            }
        }
        trackZ();
        World.setDelay(10);
    }

    /**
     * Tracks whether a robot is on the same spot as the player.
     */
    public void trackZ()
    {
        if(bot1.getX() == pl.getPlayerX() && bot1.getY() == pl.getPlayerY())
        {
            z = 1;
        }
        else if(bot2.getX() == pl.getPlayerX() && bot2.getY() == pl.getPlayerY())
        {
            z = 2;
        }
        else if(bot3.getX() == pl.getPlayerX() && bot3.getY() == pl.getPlayerY())
        {
            z = 3;
        }
        else if(bot3.getX() == pl.getPlayerX() && bot3.getY() == pl.getPlayerY() && bot2.getX() == pl.getPlayerX() && bot2.getY() == pl.getPlayerY())
        {
            Random rand = new Random();
            int num = rand.nextInt(2) + 1;
            if(num == 1)
            {
                z = 2;
            }
            else if(num == 2)
            {
                z = 3;
            }
        }
        else if(bot3.getX() == pl.getPlayerX() && bot3.getY() == pl.getPlayerY() && bot1.getX() == pl.getPlayerX() && bot1.getY() == pl.getPlayerY())
        {
            Random rand = new Random();
            int num = rand.nextInt(2) + 1;
            if(num == 1)
            {
                z = 1;
            }
            else if(num == 2)
            {
                z = 3;
            }
        }
        else if(bot1.getX() == pl.getPlayerX() && bot1.getY() == pl.getPlayerY() && bot2.getX() == pl.getPlayerX() && bot2.getY() == pl.getPlayerY())
        {
            Random rand = new Random();
            int num = rand.nextInt(2) + 1;
            if(num == 1)
            {
                z = 2;
            }
            else if(num == 2)
            {
                z = 1;
            }
        }
    }

    /**
     * Causes the game over world to load and has a robot move until it dies for visual effect.
     */
    public void gameOver()
    {
        World.reset();
        World.readWorld("GameOver.wrld");
        World.placeNSWall(2, 46, 1);
        SmartBot bot = new SmartBot(2, 1, East, 0, Color.black);
        while(bot.frontIsClear())
        {
            bot.move();
        }
        bot.move();
    }

    /**
     * Randomly places beepers throughout the map.
     */
    public void placeBeepers()
    {
        Random rand = new Random();
        while(beepers > 0)
        {
            int x = rand.nextInt(14) + 1;
            int y = rand.nextInt(14) + 1;
            World.placeBeepers(y,x,1);
            beepers = beepers - 1;
        }
        beepers = 8;
    }

    /**
     * Randomly places walls throughout the map.
     */
    public void placeWalls()
    {
        Random rand = new Random();
        while(NSWalls > 0)
        {
            int x = rand.nextInt(14) + 1;
            int y = rand.nextInt(14) + 1;
            World.placeNSWall(y,x,1);
            NSWalls = NSWalls - 1;
        }
        while(EWWalls > 0)
        {
            int x = rand.nextInt(14) + 1;
            int y = rand.nextInt(14) + 1;
            World.placeEWWall(y,x,1);
            EWWalls = EWWalls - 1;
        }
        NSWalls = 5;
        EWWalls = 5;
    }

    /**
     * Causes the player to fight against the enemies in the battle world until all the enemies die or the player dies. During the battle, the player has multiple options including melee, magic, and running away.
     */
    public void attack()
    {
        if(pl.nextToARobot())
        {
            setUpBattle();

            BattleBot a = new BattleBot(8, 5, South, 1, Color.black);
            BattleBot b = new BattleBot(8, 6, South, 1, Color.black);
            BattleBot c = new BattleBot(8, 7, South, 1, Color.black);
            PlayerBattleBot p = new PlayerBattleBot(2, 6, North, 1, Color.red);
            HPBot HPTracker = new HPBot(1, 6, North, 1000, Color.white);
            p.setPlayerBattleBotHP(pl.getPlayerHP());
            p.setPlayerBattleBotStrength(pl.getPlayerStrength());
            p.setPlayerBattleBotAgility(pl.getPlayerAgility());
            p.setPlayerBattleBotIntelligence(pl.getPlayerIntelligence());
            HPTracker.setVisible(false);
            World.setDelay(0);
            HPTracker.trackBattleHP(p);
            World.setDelay(10);
            while(pl.getPlayerHP() > 0)
            {
                while(p.getPlayerBattleBotHP() > 0)
                {
                    String numstr = JOptionPane.showInputDialog(null,"What would you like to do? <1> Melee, <2> Magic, or <3> Run");
                    if(numstr != null)
                    {
                        if(numstr.equals("1"))
                        {
                            String numstr2 = JOptionPane.showInputDialog(null,"Which robot would you like to attack? <1> Robot1, <2> Robot2, or <3> Robot3");
                            if(numstr2 != null)
                            {
                                if(numstr2.equals("1"))
                                {
                                    p.moveToRobot1();
                                    p.melee(a);
                                    p.returnFrom1();
                                }
                                else if(numstr2.equals("2"))
                                {
                                    p.moveToRobot2();
                                    p.melee(b);
                                    p.returnFrom2();
                                }
                                else if(numstr2.equals("3"))
                                {
                                    p.moveToRobot3();
                                    p.melee(c);
                                    p.returnFrom3();
                                }
                            }
                        }
                        else if(numstr.equals("2"))
                        {
                            magic(p, a, b, c);
                        }
                        else if(numstr.equals("3"))
                        {
                            Random rand = new Random();
                            int escapeChance = rand.nextInt(300) + 1;
                            escapeChance = escapeChance - p.getPlayerBattleBotAgility();
                            if(escapeChance <= 10)
                            {
                                escape = escapeChance;
                                System.out.println("You were able to escape.");
                                break;
                            }
                            else
                            {
                                System.out.println("You were unable to escape.");
                            }
                        }
                        else if(numstr.equals("stats"))
                        {
                            System.out.println("HP: " + p.getPlayerBattleBotHP() + " Strength: " + p.getPlayerBattleBotStrength() + " Agility: " + p.getPlayerBattleBotAgility() + " Intelligence: " + p.getPlayerBattleBotIntelligence());
                        }
                    }
                    if(a.getBattleBotHP() <= 0)
                    {
                        a.turnOff();
                    }
                    if(b.getBattleBotHP() <= 0)
                    {
                        b.turnOff();
                    }
                    if(c.getBattleBotHP() <= 0)
                    {
                        c.turnOff();
                    }
                    if(a.getBattleBotHP() <= 0 && b.getBattleBotHP() <= 0 && c.getBattleBotHP() <= 0)
                    {
                        if(z == 1)
                        {
                            bot1.setEnemyHP(0);
                            bot1.setXAndY();
                        }
                        else if(z == 2)
                        {
                            bot2.setEnemyHP(0);
                            bot2.setXAndY();
                        }
                        else if(z == 3)
                        {
                            bot3.setEnemyHP(0);
                            bot3.setXAndY();
                        }
                        break;
                    }
                    p.enemiesAttack(a, b, c, p);
                    World.setDelay(0);
                    HPTracker.trackBattleHP(p);
                    World.setDelay(10);
                }
                if(escape <= 10)
                {
                    break;
                }
                if(a.getBattleBotHP() <= 0 && b.getBattleBotHP() <= 0 && c.getBattleBotHP() <= 0)
                {
                    if(z == 1)
                    {
                        bot1.setEnemyHP(0);
                    }
                    else if(z == 2)
                    {
                        bot2.setEnemyHP(0);
                    }
                    else if(z == 3)
                    {
                        bot3.setEnemyHP(0);
                    }
                    break;
                }
                if(p.getPlayerBattleBotHP() <= 0)
                {
                    gameOver();
                }
            }
            if(p.getPlayerBattleBotHP() <= 0)
            {
                gameOver();
            }
            battleAftermath(p.getPlayerBattleBotHP());
        }
    }

    /**
     * Damages enemies and put and picks beepers for visual effect.
     */
    public void magic(PlayerBattleBot p, BattleBot a, BattleBot b, BattleBot c)
    {
        World.setDelay(0);
        SmartBot magic = new SmartBot(2, 6, North, 1000, Color.black);
        magic.setVisible(false);
        SmartBot magic2 = new SmartBot(7, 5, North, 1000, Color.black);
        magic2.setVisible(false);
        SmartBot magic3 = new SmartBot(7, 7, North, 1000, Color.black);
        magic3.setVisible(false);
        World.setDelay(2);
        putAndPickBeepers(magic, magic2, magic3);
        magic1(p, a, b, c);
        World.setDelay(10);
    }

    /**
     * Causes magic to takes damage plus player's intelligence from the HP of all enemies.
     */
    public void magic1(PlayerBattleBot p, BattleBot a, BattleBot b, BattleBot c)
    {
        Random rand = new Random();
        int playerDamage = rand.nextInt(2) + 1;
        playerDamage = playerDamage + p.getPlayerBattleBotIntelligence();
        a.setBattleBotHP(a.getBattleBotHP() - playerDamage);
        b.setBattleBotHP(b.getBattleBotHP() - playerDamage);
        c.setBattleBotHP(c.getBattleBotHP() - playerDamage);
        System.out.println("Your magic did " + playerDamage + " damage. The enemys' HP is now " + a.getBattleBotHP() +", " + b.getBattleBotHP() +", and " + c.getBattleBotHP() + " respectively.");
    }

    /**
     * Puts and picks beepers for magic's visual effect.
     */
    public void putAndPickBeepers(SmartBot magic, SmartBot magic2, SmartBot magic3)
    {
        putBeepers(magic, magic2, magic3);
        pickBeepers(magic, magic2, magic3);
    }

    /**
     * Put beepers for magic.
     */
    public void putBeepers(SmartBot magic, SmartBot magic2, SmartBot magic3)
    {
        magic.moveAndBeeper();
        magic.moveAndBeeper();
        magic.moveAndBeeper();
        magic.moveAndBeeper();
        magic2.putBeeper();
        magic2.moveAndBeeper();
        magic.moveAndBeeper();
        magic3.putBeeper();
        magic3.moveAndBeeper();
        magic.moveAndBeeper();
    }

    /**
     * Picks beepers for magic.
     */
    public void pickBeepers(SmartBot magic, SmartBot magic2, SmartBot magic3)
    {
        magic.turnAround();
        magic2.turnAround();
        magic3.turnAround();
        magic2.move();
        magic2.turnAround();
        magic3.move();
        magic3.turnAround();
        magic.move();
        magic.move();
        magic.move();
        magic.move();
        magic.move();
        magic.move();
        magic.turnAround();
        magic.moveAndPickBeeper();
        magic.moveAndPickBeeper();
        magic.moveAndPickBeeper();
        magic.moveAndPickBeeper();
        magic2.pickBeeper();
        magic2.moveAndPickBeeper();
        magic.moveAndPickBeeper();
        magic3.pickBeeper();
        magic3.moveAndPickBeeper();
        magic.moveAndPickBeeper();
    }

    /**
     * Causes the normal world to reload after a battle in the way it was before while only spawning the bots that are still alive.
     */
    public void battleAftermath(int a)
    {
        pl.turnOff();
        bot1.turnOff();
        bot2.turnOff();
        bot3.turnOff();
        World.reset();
        World.setVisible(true);
        World.setTrace(false);
        World.readWorld("karel-Project2.wrld");
        if(pl.getPlayerHP() > 0)
        {
            pl = new PlayerBot(pY, pX, North, 0, Color.red);
        }
        if(bot1.getEnemyHP() > 0)
        {
            bot1 = new EnemyBot(b1Y, b1X, direction1, 0, Color.black);
        }
        if(bot2.getEnemyHP() > 0)
        {
            bot2 = new EnemyBot(b2Y, b2X, direction2, 0, Color.black);
        }
        if(bot3.getEnemyHP() > 0)
        {
            bot3 = new EnemyBot(b3Y, b3X, direction3, 0, Color.black);
        }
        pl.setPlayerHP(a);
        HPTracker = new HPBot(1, 15, North, 1000, Color.white);
        HPTracker.setVisible(false);
        while(HPTracker.nextToABeeper())
        {
            World.setDelay(0);
            HPTracker.pickBeeper();
        }
        World.placeEWWall(14,7,1);
        World.setDelay(10);
    }
}
