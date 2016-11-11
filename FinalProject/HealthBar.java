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
public class HealthBar
{
    Character p = new Character(100,100);
    float x;
    float y;
    private final float MAX_HP = 100f;
    /**
     * Constructor for objects of class HealthBar
     */
    public HealthBar(Character p, float x, float y)
    {
        this.p = p;
        this.x = x;
        this.y = y;
    }

    public void init(GameContainer container) throws SlickException
    {
    }

    /**
     * Draws a health bar that changes based on the health of a character but also
     * changes in a mirrored image depending on whether the character is p1 or p2.
     */
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
        float temp = 375.0f - ((float)(p.getHp()/MAX_HP)* 375.0f); 
        if(p instanceof Player)
        {
            g.setColor(Color.white);
            g.fillRect(x, y, 375.0f, 40.0f);
            g.setColor(Color.red);
            g.fillRect(x, y, (float)(p.getHp()/MAX_HP)* 375.0f, 40.0f);
            g.setColor(Color.transparent);

        }
        else
        {
            g.setColor(Color.white);
            g.fillRect(x, y, 375.0f, 40.0f);
            g.setColor(Color.red);
            g.fillRect(x + temp, y, (float)(p.getHp()/MAX_HP)* 375.0f, 40.0f);
            g.setColor(Color.transparent);

        }
    }
}
