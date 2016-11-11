import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import java.io.*;
import org.newdawn.slick.Input.*;
import java.awt.FontFormatException;
public class PlayerNum extends BasicGameState
{
    private final int NUM1P = 0;
    private final int NUM2P = 1;
    private Image splash;
    private Image n1p;
    private Image n2p;
    private Image arrow;
    private int elapsedTime;
    private final int DELAY = 1000;
    private int position;
    private int[] colors;

    private int x = 394;
    private int y = 100;

    /**
     * Constructor
     */
    public PlayerNum(int state) 
    {
        position = 0;
        colors = new int[2];
        colors[0] = 1;
    }

    /**
     * Initializes
     */
    public void init(GameContainer gc, StateBasedGame s) throws SlickException
    {
        splash = new Image("res\\backgrounds\\selection2.png");
        n1p = new Image("res\\1p.png");
        n2p = new Image("res\\2p.png");
        arrow = new Image("res\\arrow2.png");
    }

    /**
     * Draws the images for the choices.
     */
    public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException
    {
        g.drawImage(splash, 0, 0);
        g.drawImage(n1p,294,300);
        g.drawImage(n2p,786,300);
        g.drawImage(arrow, x,y);
    }

    /**
     * Updates which position the player is currently on and determines if one is pressed.
     */
    public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException
    {
        Input input = gc.getInput();
        if(input.isKeyPressed(Input.KEY_RIGHT))
        {
            if(position != NUM2P)
            {
                position+=1;
                x = 886;
            }
            else
            {
                position = NUM1P;
                x = 394;
            }
        }
        if(input.isKeyPressed(Input.KEY_LEFT))
        {
            if(position != NUM1P)
            {
                position-=1;
                x = 394;
            }
            else
            {
                position = NUM2P;
                x = 886;
            }
        }
        if(input.isKeyPressed(Input.KEY_ENTER))
        {
            World.setPNum(position);
            s.enterState(3);
        }
    }

    /**
     * The game state's id.
     */
    public int getID()
    {
        return 2;
    }
}
