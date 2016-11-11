import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
public class SplashScreen extends BasicGameState
{
    private Image splash;
    private int elapsedTime;
    private final int DELAY = 1000;
    /**
     * Constructor
     */
    public SplashScreen(int state)
    {
    }

    /**
     * Initializes
     */
    public void init(GameContainer gc, StateBasedGame s) throws SlickException
    {
        splash = new Image("res\\backgrounds\\splashscreen.png");
    }

    /**
     * Draws images.
     */
    public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException
    {
        g.drawImage(splash, 0, 0);//200, 200);
    }

    /**
     * Updates factors. Creates a timer that waits a bit before going to the menu.
     */
    public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException
    {
        elapsedTime += delta;
        if(elapsedTime >= DELAY*2)
        {
            s.enterState(1);
        }
    }

    /**
     * The game state's id.
     */
    public int getID()
    {
        return 0;
    }
}
