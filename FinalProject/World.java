import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.state.*;
import org.newdawn.slick.*;
import java.awt.FontFormatException;
import java.awt.Font;
import java.io.*;
import java.util.Random;
public class World extends BasicGameState
{
    private final int ONEP = 0;
    private final int TWOP = 1;
    private final int MIKU = 0;
    private final int KAREL = 1;
    private final int FIRE = 0; 
    private final int OCEAN = 1;
    private final int DESERT = 2;
    private final int GRASS = 3;
    private final int BALLMER = 4;
    private final int HC = 0;
    private final int LK = 1;
    private final int TS = 2;
    private final int RS = 3;
    private final int TTT = 4;
    private Image background;
    private Image healthBar;
    static Image icon;
    static Image icon2;

    static Player p1;
    static Player2 p2;
    static AI comp;

    private Music m;
    private Animation a;
    private Image[] img;
    private Image one;
    private Image two;
    private Image three;
    private final int GAME_TIME = 120000;
    private static int selectedCharacter;
    private static int selectedP2Character;
    private static int selectedWorld;
    private static int selectedMusic;
    public static int selectedPNum;
    private int time = GAME_TIME;

    private boolean p2Wins = false;
    private boolean p1Wins = false;

    private Font epic;
    private TrueTypeFont font;

    private Image hp;
    private Image enemyHp;

    private HealthBar p1Hp;
    private HealthBar p2Hp;
    private StaminaBar p1Stami;
    private StaminaBar p2Stami;

    private final int DELAY = 100000000;
    private int elapsedTime = 0;
    /**
     * Constructor for objects of class World
     */
    public World(int state)
    {
    }

    /**
     * Determines the character, music, and world on entering this game state.
     */
    public void enter(GameContainer gc, StateBasedGame s) throws SlickException
    {
        decidePNum();
        decideCharacter();
        decideWorld();
        decideMusic();
    }
    
    /**
     * Initializes the p2, font and some misc. items.
     */
    public void init(GameContainer gc, StateBasedGame s) throws SlickException
    {
        healthBar = new Image("res\\HealthBar.png");
        try
        {
            epic =  Font.createFont(Font.TRUETYPE_FONT, new File("res\\fonts\\epic.ttf")).deriveFont(15f);
        }
        catch(java.awt.FontFormatException e)
        {
            e.printStackTrace();
        }
        catch (java.io.IOException e)
        {
            e.printStackTrace();
        }
        font = new TrueTypeFont(epic, true);
    }

    /**
     * Sets an icon for p1 and p2.
     */
    public static void loadIcons(Image image1, boolean p1)
    {
        if(p1 == true)
        {
            icon = image1;
        }
        else
        {
            icon2 = image1;
        }
    }

    /**
     * Sets which character was selected.
     */
    public static void setCharacter(int num)
    {
        selectedCharacter = num;
    }

    /**
     * Sets which character was selected for p2.
     */
    public static void setP2Character(int num)
    {
        selectedP2Character = num;
    }

    /**
     * Sets which world was selected.
     */
    public static void setWorld(int num)
    {
        selectedWorld = num;
    }

    /**
     * Sets which music was selected.
     */
    public static void setMusic(int num)
    {
        selectedMusic = num;
    }

    /**
     * Sets which number of players was selected.
     */
    public static void setPNum(int num)
    {
        selectedPNum = num;
    }

    /**
     * Draws the world, health and stamina bars and finally the characters.
     */
    public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException
    {
        if(a != null)
        {
            a.draw();
        }
        else
        {
            g.drawImage(background, 0, 0);
        }

        g.drawImage(healthBar, 0, 0);
        font.drawString(0,0,p1.getName());
        g.drawImage(icon, 0, 50);
        g.drawImage(icon2, 1280-icon.getWidth(), 50);

        if(p2 != null)
        {
            font.drawString(1280-icon.getWidth(),0,p2.getName());
        }
        else
        {
            font.drawString(1280-icon.getWidth(),0,comp.getName());
        }

        p1.render(gc,g);
        if(p2 != null)
        {
            p2.render(gc, g);
        }
        else
        {
            comp.render(gc, g);
        }
        g.drawString("" + time/1000, 630, 50);

        p1Hp.render(gc,g);
        p2Hp.render(gc,g);
        p1Stami.render(gc,g);
        p2Stami.render(gc,g);

        if(p2Wins == true)
        {
            g.drawString("P2 Wins!!!!!!!!", 630, 500);
        }
        if(p1Wins == true)
        {
            g.drawString("P1 Wins!!!!!!!!", 630, 500);
        }
    }

   
    /**
     * Plays the music and determines if the game is over or not.
     */
    public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException
    {
        if(p1Wins == true || p2Wins == true || time <= 0)
        {
            s.enterState(8);
        }
        p1.update(gc, delta);
        if(p2 != null)
        {
            p2.update(gc, delta);
        }
        else
        {
            comp.update(gc, delta);
        }
        time -= delta;

        if(m.playing() == false && m != null)
        {
            m.play();
        }
        if(p1.getHp() <= 0)
        {
            p2Wins = true;
            //             a = null;
            //             m.stop();
            //             m = null;
            //             p1.setHp(100);
            //             if(p2 != null)
            //             {
            //                 p2.setHp(100);
            //             }
            //             else
            //             {
            //                 comp.setHp(100);
            //             }
            //             p2 = null;
            //             s.enterState(1);
        }
        else
        {
            if(p2 != null)
            {
                if(p2.getHp() <= 0)
                {
                    p1Wins = true;
                    //                     a = null;
                    //                     m.stop();
                    //                     m = null;
                    //                     p1.setHp(100);
                    //                     if(p2 != null)
                    //                     {
                    //                         p2.setHp(100);
                    //                     }
                    //                     else
                    //                     {
                    //                         comp.setHp(100);
                    //                     }
                    //                     p2 = null;
                    //                     s.enterState(1);
                }
            }
            else
            {
                if(comp.getHp() <= 0)
                {
                    p1Wins = true;
                    //                     a = null;
                    //                     m.stop();
                    //                     m = null;
                    //                     p1.setHp(100);
                    //                     if(p2 != null)
                    //                     {
                    //                         p2.setHp(100);
                    //                     }
                    //                     else
                    //                     {
                    //                         comp.setHp(100);
                    //                     }
                    //                     p2 = null;
                    //                     s.enterState(1);
                }
            }
        }

    }

    /**
     * Sets p1 to whatever was selected.
     */
    public void decideCharacter() throws SlickException
    {
        if(selectedCharacter == MIKU)
        {
            p1 = new HatsuneMiku(); 
        }
        else
        {
            p1 = new KarelJRobot();
        }
        p1Hp = new HealthBar(p1,120f,0f);
        p1Stami = new StaminaBar(p1,115f,50f);
    }

    /**
     * Sets the world to whatever was selected.
     */
    public void decideWorld() throws SlickException
    {
        if(selectedWorld == FIRE)
        {
            one = new Image("res\\backgrounds\\FireBackground1.png");
            two = new Image("res\\backgrounds\\FireBackground2.png");
            three = new Image("res\\backgrounds\\FireBackground3.png");
            img = new Image[3];
            img[0] = one;
            img[1] = two;
            img[2] = three;
            a = new Animation(img, 500); 
        }
        else if(selectedWorld == OCEAN)
        {
            one = new Image("res\\backgrounds\\OceanBackground1.png");
            two = new Image("res\\backgrounds\\OceanBackground2.png");
            three = new Image("res\\backgrounds\\OceanBackground3.png");
            img = new Image[3];
            img[0] = one;
            img[1] = two;
            img[2] = three;
            a = new Animation(img, 500);
        }
        else if(selectedWorld == DESERT)
        {
            background = new Image("res\\backgrounds\\DesertBackground.png");
        }
        else if(selectedWorld == GRASS)
        {
            background = new Image("res\\backgrounds\\GrassBackground.png");
        }
        else
        {
            background = new Image("res\\backgrounds\\BallmerBackground.jpg");
        }
    }

    /**
     * Sets the music to whatever was selected.
     */
    public void decideMusic() throws SlickException
    {
        if(selectedMusic == HC)
        {
            m = new Music("hc.ogg");
        }
        else if(selectedMusic == LK)
        {
            m = new Music("lk.ogg"); 
        }
        else if(selectedMusic == TS)
        {
            m = new Music("ts.ogg");
        }
        else if(selectedMusic == RS)
        {
            m = new Music("rs.ogg");
        }
        else
        {
            m = new Music("ttt.ogg");
        }
    }

    /**
     * Sets the number of players to whatever was selected.
     */
    public void decidePNum() throws SlickException
    {
        if(selectedPNum == ONEP)
        {
            Random rand = new Random();
            int a = rand.nextInt(2)+1;
            if(a == 1)
            {
                comp = new KarelJRobotAI();
            }
            else
            {
                comp = new HatsuneMikuAI();
            }
            p2Hp = new HealthBar(comp,785f,0f);
            p2Stami = new StaminaBar(comp,855f,50f);
        }
        else
        {
            if(selectedP2Character == KAREL)
            {
                p2 = new KarelJRobot2();
            }
            else
            {
                p2 = new HatsuneMiku2();
            }
            p2Hp = new HealthBar(p2,785f,0f);
            p2Stami = new StaminaBar(p2,855f,50f);
        }
    }

    /**
     * The game state's id.
     */
    public int getID()
    {
        return 6;
    }
}
