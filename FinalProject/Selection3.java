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
public class Selection3 extends BasicGameState
{
    private final int HC = 0;
    private final int LK = 1;
    private final int TS = 2;
    private final int RS = 3;
    private final int TTT = 4;
    private Font epic;
    private Image splash;
    private Image pointer;
    private Image image;
    private int elapsedTime;
    private final int DELAY = 1000;
    private String hcStr = "Happy Crescent";
    private String lkStr = "Love Kanon";
    private String tsStr = "Thunderstruck";
    private String rsStr = "Recursion Song";
    private String tttStr = "Tunak Tunak Tun";
    private int position;
    private int[] colors;
    private TrueTypeFont font;
    
    /**
     * Constructor
     */
    public Selection3(int state) 
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
        image = new Image("res\\note.png");
        pointer = new Image("res\\splash_arts\\pointer.png");
        font = new TrueTypeFont(epic, true);
    }

    /**
     * Draws the images for the choices.
     */
    public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException
    {
        g.drawImage(splash, 0, 0);
        g.drawImage(image, 48, 300);
        g.drawImage(image, 294, 300);
        g.drawImage(image, 540, 300);
        g.drawImage(image, 786, 300);
        g.drawImage(image, 1032, 300);
        font.drawString(48f, 505f, hcStr, getCol(HC));
        font.drawString(294f, 505f, lkStr, getCol(LK));
        font.drawString(540f, 505f, tsStr, getCol(TS));
        font.drawString(786f, 505f, rsStr, getCol(RS));
        font.drawString(1032f, 505f, tttStr, getCol(TTT));
    }

    /**
     * Updates which position the player is currently on and determines if one is pressed.
     */
    public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException
    {
        Input input = gc.getInput();
        if(input.isKeyPressed(Input.KEY_RIGHT))
        {
            if(position != TTT)
            {
                position+=1;
            }
            else
            {
                position = HC;
            }
        }
        if(input.isKeyPressed(Input.KEY_LEFT))
        {
            if(position != HC)
            {
                position-=1;
            }
            else
            {
                position = TTT;
            }
        }
        if(input.isKeyPressed(Input.KEY_ENTER))
        {
            World.setMusic(position);
            s.enterState(6);
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
        return 5;
    }
}
