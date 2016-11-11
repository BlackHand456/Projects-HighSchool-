import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.state.*;
import org.newdawn.slick.*;
import java.awt.FontFormatException;
import java.awt.Font;
import java.io.*;
/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StaminaBar
{
    Character p = new Character(100,100);
    float x;
    float y;
    private final float MAX_STAMI = 100f;
    /**
     * Constructor for objects of class HealthBar
     */
    public StaminaBar(Character p, float x, float y)
    {
        this.p = p;
        this.x = x;
        this.y = y;
    }

    public void init(GameContainer container) throws SlickException
    {
    }

    /**
     * Draws a stamina bar that changes based on the stamina of a character but also
     * changes in a mirrored image depending on whether the character is p1 or p2.
     */
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
        float temp = 310.0f - ((float)(p.getStami()/MAX_STAMI)* 310.0f); 
        if(p instanceof Player)
        {
            g.setColor(Color.white);
            g.fillRect(x, y, 310.0f, 35.0f);
            g.setColor(Color.green);
            g.fillRect(x, y, (float)(p.getStami()/MAX_STAMI)* 310.0f, 35.0f);
            g.setColor(Color.transparent);
            
        }
        else
        {
            g.setColor(Color.white);
            g.fillRect(x, y, 310.0f, 35.0f);
            g.setColor(Color.green);
            g.fillRect(x + temp, y, (float)(p.getStami()/MAX_STAMI)* 310.0f, 35.0f);
            g.setColor(Color.transparent);
            
        }
    }
}
