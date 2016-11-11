import org.newdawn.slick.*;
import org.newdawn.slick.geom.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.SlickException;
public class Beeper
{
    private int user;
    private Rectangle rect;
    private float x; 
    private float y;
    private boolean isLeft;
    private Image picture;
    private boolean boole;
    /**
     * Constructor
     */
    public Beeper(float theX, float theY, boolean directionLeft, int theUser) throws SlickException
    {
        user = theUser;
        isLeft = directionLeft;
        x = theX;
        y = theY;
        picture = new Image("res\\beeper.png");
        rect = new Rectangle(x, y, picture.getWidth(), picture.getHeight());
    }

    public void init(GameContainer container) throws SlickException
    {

    }

    public boolean getBoole()
    {
        return boole;
    }

    /**
     * Draws a hitbox for the beeper.
     */
    public void render(GameContainer container, Graphics g) throws SlickException
    {
        g.draw(rect);
        if(isLeft)
        {
            g.drawImage(picture, x-150, y+50);
        }
        else
        {
            g.drawImage(picture,x+70,y+50);
        }
    }

    /**
     * Return the beeper's x coord.
     */
    public float getX()
    {
        return x;
    }

    /**
     * Moves the beeper.
     */
    public void update(GameContainer container, int delta) throws SlickException
    {
        if(!boole)
        {
            if(user == 0 && World.selectedPNum == 0 )
            {
                if(rect.intersects(World.comp.getHitbox()))
                {
                    World.comp.setHp(World.comp.getHp()-10);
                    boole = true;
                }
            }
            else if(user == 0 && World.selectedPNum == 1)
            {
                if(rect.intersects(World.p2.getHitbox()))
                {
                    World.p2.setHp(World.p2.getHp()-10);
                    boole = true;
                }
            }
            else if(user == 1)
            {
                if(rect.intersects(World.p1.getHitbox()))
                {
                    World.p1.setHp(World.p1.getHp()-10);
                    boole = true;
                }
            }
            else if(user == 2)
            {
                if(rect.intersects(World.p1.getHitbox()))
                {
                    World.p1.setHp(World.p1.getHp()-10);
                    boole = true;
                }
            }
        }
        if(isLeft)
        {
            rect.setX(x-10);
        }
        else
        {
            rect.setX(x+10);
        }
        rect.setY(y+50);
        if(isLeft == true)
        {
            x-=10;
        }
        else
        {
            x+=10;
        }
    }

    public Rectangle getBeeper() throws SlickException
    {
        return rect;
    }

    public float getBX() throws SlickException
    {
        return x;
    }
}
