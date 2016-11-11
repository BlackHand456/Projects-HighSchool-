import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.*;
/**
 * Write a description of class Attack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Attack
{
    public Rectangle rect;
    private int damage;
    private Animation anim;
    /**
     * Constructor for Attack
     */
    public Attack(Rectangle r, int dmg)
    {
        rect = r;
        damage = dmg;
        //anim = a;
    }
}
