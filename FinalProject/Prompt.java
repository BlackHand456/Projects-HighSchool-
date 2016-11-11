import org.newdawn.slick.*;
import java.awt.Font;
import org.newdawn.slick.state.*;   
import java.io.*;
import org.newdawn.slick.Input.*;
import java.awt.FontFormatException;
import org.newdawn.slick.AppGameContainer;
/**
 * Write a description of class Prompt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Prompt extends BasicGameState
{
    private final int PLAY = 0;
    private final int EXIT = 1;
    private Font epic;
    private Image splash;
    private Image pointer;
    private Image image;
    private int elapsedTime;
    private final int DELAY = 1000;
    private String str1 = "Play Again";
    private String str2 = "Exit";
    private String tsStr = "Thunderstruck";
    private String rsStr = "Recursion Song";
    private String tttStr = "Tunak Tunak Tun";
    private int position;
    private int[] colors;
    private TrueTypeFont font;

    /**
     * Constructor
     */
    public Prompt(int state) 
    {
        position = 0;
        colors = new int[2];
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

        font = new TrueTypeFont(epic, true);
    }

    /**
     * Draws the images for the choices.
     */
    public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException
    {
        font.drawString(540f, 360f, str1, getCol(PLAY));
        font.drawString(740f, 360f, str2, getCol(EXIT));
    }

    /**
     * Updates which position the player is currently on and determines if one is pressed.
     */
    public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException
    {
        Input input = gc.getInput();
        if(input.isKeyPressed(Input.KEY_RIGHT))
        {
            if(position != PLAY)
            {
                position = PLAY;
            }
            else
            {
                position = EXIT;
            }
        }
        if(input.isKeyPressed(Input.KEY_LEFT))
        {
            if(position != PLAY)
            {
                position = PLAY;
            }
            else
            {
                position = EXIT;
            }
        }
        if(input.isKeyPressed(Input.KEY_ENTER))
        {
            if(position == PLAY)
            {
                gc.reinit();
                s.enterState(1);
            }
            else
            {
                gc.exit();
            }
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
        return 8;
    }
}
