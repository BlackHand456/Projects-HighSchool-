import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.SlickException;
/**
 * Write a description of class Menu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends BasicGameState
{
    private boolean isOnExit;
    private int button = 0;
    private  int B1X = 600;
    private  int B1Y = 300;
    private  int B2X = 630;
    private  int B2Y = 450;
    private int B3X = 850;
    private  int B3Y = 325;
    private Image play;
    private Image arrow;
    private Image exit;
    private Image background;
    
    /**
     * Constructor
     */
    public Menu(int state)
    {
        
    }
    
    /**
     * Main
     */
    public static void main(String[] args) throws SlickException
    {

    }

    /**
     * Initializes
     */
    public void init(GameContainer gc, StateBasedGame s) throws SlickException
    {
        play = new Image("res\\play.png");
        exit = new Image("res\\exit.png");
        arrow = new Image("res\\arrow.png");
        background = new Image("res\\backgrounds\\shiori.jpg");
    }

    /**
     * draws images.
     */
    public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException
    {
        g.drawImage(background, 0, 0);
        g.drawImage(play, B1X, B1Y);
        g.drawImage(exit, B2X, B2Y);
        g.drawImage(arrow, B3X, B3Y);
    }

    /**
     * Updates allowing for choices on the menu.
     */
    public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException
    {
        buttonChoose(gc, s);
    }

    /**
     * Moves the cursor image and changes which button on is on and determines if one is selected.
     */
    public void buttonChoose(GameContainer gc, StateBasedGame s) throws SlickException
    {
        Input input = gc.getInput();
        if(input.isKeyPressed(Input.KEY_DOWN))
        {
            if(!isOnExit) //on the play button
            {
                B3Y = B3Y + 150;
                isOnExit = true;
            }
            else
            {
                B3Y = B3Y - 150;
                isOnExit = false;
            }
        }
        if(input.isKeyPressed(Input.KEY_UP))
        {
            if(isOnExit)
            {
                B3Y = B3Y - 150;
                isOnExit = false;
            }
            else
            {
                B3Y = B3Y + 150;
                isOnExit = true;
            }
        }
        if(input.isKeyPressed(Input.KEY_ENTER))
        {
            if(isOnExit)
            {
                gc.exit();
            }
            else
            {
                s.enterState(2);//2);
            }
        }
    }

    /**
     * The game state's id.
     */
    public int getID()
    {
        return 1;
    }
}

