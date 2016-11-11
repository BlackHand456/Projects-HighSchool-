import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.SlickException;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Character
{
    /**
     * Constructor
     */
    public Player() 
    {
        super(100,100);
    }

    public static void main(String[] args) throws SlickException
    {

    }

    public void init(GameContainer container) throws SlickException
    {
    }

    /**
     * Checks which keys are down or pressed for controlling the character and calls the methods associated with those.
     */
    public void update(GameContainer container, int delta) throws SlickException
    {
        super.update(container,delta);
        if(container.getInput().isKeyDown(Input.KEY_W) || container.getInput().isKeyDown(Input.KEY_A) || container.getInput().isKeyDown(Input.KEY_D) || container.getInput().isKeyDown(Input.KEY_R))
        {
            if(container.getInput().isKeyPressed(Input.KEY_W))
            {
                isJumping = true;
                up();
            }
            if(container.getInput().isKeyDown(Input.KEY_A) && !isJumping)
            {
                left();
            }
            if(container.getInput().isKeyDown(Input.KEY_D) && !isJumping)
            {
                right();
            }
            if(container.getInput().isKeyPressed(Input.KEY_R))
            {
                attackp1();
            }
        }
        else if(!isJumping)
        {
            idle();
        }
    }

    /**
     * Calls its parent's render.
     */
    public void render(GameContainer container, Graphics g) throws SlickException
    {
        super.render(container, g);
    }

    /**
     * Returns this class's name.
     */
    public String getName() throws SlickException
    {
        return "";
    }
    
    public Beeper getEvan() throws SlickException
    {
        return null;
    }
}
