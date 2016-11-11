import org.newdawn.slick.*;
import java.awt.Font;
import org.newdawn.slick.state.*;
import java.io.*;
import org.newdawn.slick.Input.*;
import java.awt.FontFormatException;
/**
 * Write a description of class Selection2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Selection2 extends BasicGameState
{
    private final int FIRE = 0;
    private final int OCEAN = 1;
    private final int DESERT = 2;
    private final int GRASS = 3;
    private final int BALLMER = 4;
    private Font epic;
    private Image splash;
    private Image ballmer;
    private Image fire;
    private Image ocean;
    private Image desert;
    private Image grass;
    private Image pointer;
    private int elapsedTime;
    private final int DELAY = 1000;
    private String ballStr = "Ballmer Background";
    private String fireStr = "Fire Background";
    private String oceanStr = "Ocean Background";
    private String desertStr = "Desert Background";
    private String grassStr = "Grassland Background";
    private int position;
    private int[] colors;
    private TrueTypeFont font;
    
    /**
     * Constructor
     */
    public Selection2(int state) 
    {
        position = 0;
        colors = new int[5];
        colors[0] = 1;
    }

    /**
     * Initializes including creating the font.
     */
    public void init(GameContainer gc, StateBasedGame s) throws SlickException
    {
        try
        {
            epic =  Font.createFont(Font.TRUETYPE_FONT, new File("res\\fonts\\epic.ttf")).deriveFont(20f);
        }
        catch(java.awt.FontFormatException e)
        {
            e.printStackTrace();
        }
        catch (java.io.IOException e)
        {
            e.printStackTrace();
        }
        splash = new Image("res\\backgrounds\\selection2.png");
        grass = new Image("res\\backgrounds\\grass.png");
        desert = new Image("res\\backgrounds\\desert.png");
        pointer = new Image("res\\splash_arts\\pointer.png");
        ocean = new Image("res\\backgrounds\\ocean.png");
        fire = new Image("res\\backgrounds\\fire.png");
        ballmer = new Image("res\\backgrounds\\ballmer.jpg");
        font = new TrueTypeFont(epic, true);
    }

    /**
     * Draws the images for the choices.
     */
    public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException
    {
        g.drawImage(splash, 0, 0);
        g.drawImage(fire, 48, 300);
        g.drawImage(ocean, 294, 300);
        g.drawImage(desert, 540, 300);
        g.drawImage(grass, 786, 300);
        g.drawImage(ballmer, 1032, 300);
        font.drawString(48f, 505f, fireStr, getCol(FIRE));
        font.drawString(294f, 505f, oceanStr, getCol(OCEAN));
        font.drawString(540f, 505f, desertStr, getCol(DESERT));
        font.drawString(786f, 505f, grassStr, getCol(GRASS));
        font.drawString(1032f, 505f, ballStr, getCol(BALLMER));
    }

    /**
     * Updates which position the player is currently on and determines if one is pressed.
     */
    public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException
    {
        Input input = gc.getInput();
        if(input.isKeyPressed(Input.KEY_RIGHT))
        {
            if(position != BALLMER)
            {
                position+=1;
            }
            else
            {
                position = FIRE;
            }
        }
        if(input.isKeyPressed(Input.KEY_LEFT))
        {
            if(position != FIRE)
            {
                position-=1;
            }
            else
            {
                position = BALLMER;
            }
        }
        if(input.isKeyPressed(Input.KEY_ENTER))
        {
            World.setWorld(position);
            s.enterState(5);
        }
    }

    /**
     * Changes the color based on where the player is selecting.
     */
    private Color getCol(int num)
    {
        if(num != position)
        {
            return Color.white;
        }
        else
        {
            return Color.yellow;
        }
    }

    /**
     * The game state's id.
     */
    public int getID()
    {
        return 4;
    }
}
