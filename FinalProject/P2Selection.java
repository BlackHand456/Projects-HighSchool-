import org.newdawn.slick.*;
import java.awt.Font;
import org.newdawn.slick.state.*;
import java.io.*;
import org.newdawn.slick.Input.*;
import java.awt.FontFormatException;
public class P2Selection extends BasicGameState
{
    private final int MIKU = 0;
    private final int KAREL = 1;
    private Font epic;
    private Image splash;
    private Image karel;
    private Image miku;
    private Image pointer;
    private int elapsedTime;
    private final int DELAY = 1000;
    private String karelStr = KarelJRobot.NAME;
    private String mikuStr = HatsuneMiku.NAME;
    private int position;
    private int[] colors;
    private TrueTypeFont font;
    
    /**
     * Constructor
     */
    public P2Selection(int state) 
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
        splash = new Image("res\\backgrounds\\selection3.png");
        miku = new Image("res\\splash_arts\\mikuface.jpg");
        pointer = new Image("res\\splash_arts\\pointer.png");
        karel = new Image("res\\splash_arts\\karelface.jpg");
        font = new TrueTypeFont(epic, true);
    }

    /**
     * Draws the images for the choices.
     */
    public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException
    {

        g.drawImage(splash, 0, 0);
        g.drawImage(miku,294,300);//miku, 48, 300);
        g.drawImage(karel,786,300);//karel, 1032, 300);
        font.drawString(294f,505f,mikuStr,getCol(MIKU));//48f, 505f, mikuStr, getCol(MIKU));
        font.drawString(796f,505f,karelStr,getCol(KAREL));//1032f, 505f, karelStr, getCol(KAREL));
        //         g.drawString(mikuStr, 48, 505);
        //         g.drawString(lelouchStr, 294, 505);
        //         g.drawString(keimaStr, 540, 505);
        //         g.drawString(tohkaStr, 786, 505);
        //         g.drawString(karelStr, 1032, 505);
        //         g.drawImage(pointer, 200, 100);
    }

    /**
     * Updates which position the player is currently on and determines if one is pressed.
     */
    public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException
    {
        Input input = gc.getInput();
        if(input.isKeyPressed(Input.KEY_RIGHT))
        {
            if(position != KAREL)
            {
                position+=1;
            }
            else
            {
                position = MIKU;
            }
        }
        if(input.isKeyPressed(Input.KEY_LEFT))
        {
            if(position != MIKU)
            {
                position-=1;
            }
            else
            {
                position = KAREL;
            }
        }
        if(input.isKeyPressed(Input.KEY_ENTER))
        {
            World.setP2Character(position);
            s.enterState(4);
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
        return 7;
    }
}
