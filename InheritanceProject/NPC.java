import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.awt.Color;

/**
 * A character that moves randomly.
 * 
 * @author Evan Brown
 * @version 1.0
 */
public class NPC extends Character
{
    String img;
    boolean once = false;
    public NPC(String img)
    {
        setImage(img);
        this.img = img;
    }

    /**
     * Act - do whatever the NPC wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        nearObstacle();
        move(2);
        nearObstacle();
        if(once == false && Player.start == true)
        {
            setLocation(MyWorld.getP1().getX(),MyWorld.getP1().getY());
            getWorld().getBackground().setColor(Color.WHITE);
            getWorld().getBackground().drawString("Did you hear? The city is under attack.",getX()-5,getY()+30);
            Greenfoot.delay(100);
            getWorld().getBackground().fill();
            getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
            getWorld().getBackground().setColor(Color.WHITE);
            getWorld().getBackground().drawString("New Quest: Find out about the city's attackers.",0,599);
            Greenfoot.delay(100);
            getWorld().getBackground().fill();
            getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
            Player.start = false;
            once = true;
        }
    }  

    public void nearObstacle()
    {
        int temp = getRotation();
        int tempX = getX();
        int tempY = getY();
        if(isTouching(Obstacle.class) || getX() < 50 || getX() > 500 || getY() < 50 || getY() > 500)
        {
            if(getRotation() == 0)
            {
                setLocation(tempX-2,tempY);
            }
            else if(getRotation() == 90)
            {
                setLocation(tempX,tempY-2);
            }
            else if(getRotation() == 180)
            {
                setLocation(tempX+2,tempY);
            }
            else
            {
                setLocation(tempX,tempY+2);
            }

            randDir();

            if(getRotation() == temp)
            {
                randDir();
            }
        }
    }

    public void randDir()
    {
        Random rand = new Random();
        int num = rand.nextInt(4)+1;
        if(num == 1)
        {
            turnTowards(getX(),0);
            setImage(img.substring(0,img.indexOf("-")+1) + "Back.png");
        }
        else if(num == 2)
        {
            turnTowards(0,getY());
            setImage(img.substring(0,img.indexOf("-")+1) + "Left.png");
        }
        else if(num == 3)
        {
            turnTowards(599,getY());
            setImage(img.substring(0,img.indexOf("-")+1) + "Right.png");
        }
        else
        {
            turnTowards(getX(),599);
            setImage(img.substring(0,img.indexOf("-")+1) + "Front.png");
        }
    }
}
