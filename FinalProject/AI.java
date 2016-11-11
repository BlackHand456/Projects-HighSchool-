import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.SlickException;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AI extends Character
{
    float base;
    long run=0;
    /**
     * Constructor
     */
    public AI() 
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
        if(run==0){
            base= World.p1.getY();
        }
        if((World.p1.getX()-World.comp.getX())>200){
            right();
        }else if((World.p1.getX()-World.comp.getX())<-210){
            left();
        }
        /*else if((base-20)>= World.p1.getY()){
            attackp2();
        }*/else{
           attackp2(); //right();
        }

        if(run<2){
            run++;
        }
        //Add AI code here using methods like attackp2() and left(), up(), and right()
        // if(container.getInput().isKeyDown(Input.KEY_UP) || container.getInput().isKeyDown(Input.KEY_LEFT) || container.getInput().isKeyDown(Input.KEY_RIGHT) || container.getInput().isKeyDown(Input.KEY_NUMPAD0))
        // {
        // if(container.getInput().isKeyPressed(Input.KEY_UP))
        // {
        // isJumping = true;
        // up();
        // }
        // if(container.getInput().isKeyDown(Input.KEY_LEFT) && !isJumping)
        // {
        // left();
        // }
        // if(container.getInput().isKeyDown(Input.KEY_RIGHT) && !isJumping)
        // {
        // right();
        // }
        // if(container.getInput().isKeyPressed(Input.KEY_NUMPAD0))
        // {
        // attackp2();
        // }
        // }
        // else if(!isJumping)
        // {
        // idle();
        // }
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
