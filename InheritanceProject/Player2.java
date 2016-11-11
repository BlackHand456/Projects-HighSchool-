import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * A player.
 * 
 * @author Evan Brown
 * @version 2.0
 */
public class Player2 extends Character implements PlayerControls
{
    int tempX;
    int tempY;
    static boolean p3Turn = true;
    static boolean startTurn = true;

    int hp;
    int atk;
    int def;
    /**
     * Act - do whatever the Player3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Player2(int hp, int atk, int def) 
    {
        this.hp = hp;
        this.atk = atk;
        this.def = def;
    }   

    /**
     * Moves when not in battle.
     */
    public void act()
    {
        if(Player.inBattle == false)
        {
            move();
        }
    }

    /**
     * Allows the ending of a turn and attacking if near an enemy.
     */
    public void fight()
    {
        battleMove();
        if(Greenfoot.isKeyDown("e") && (getX() != tempX || getY() != tempY))
        {
            if(isTouching(EnemyAI.class))
            {
                String str;
                EnemyAI temp = (EnemyAI)getOneIntersectingObject(EnemyAI.class);
                if(temp.getDef() <= atk)
                {
                    temp.setHp(temp.getHp() - (atk -  temp.getDef()));
                }
                getWorld().getBackground().setColor(Color.RED);
                GreenfootImage pierce = new GreenfootImage("images\\Magic.png");
                getWorld().getBackground().drawImage(pierce,getX()-90,getY()-90);
                Greenfoot.delay(20);
                if(temp.getDef() <= atk)
                {
                    str = ("You did " + (atk -  temp.getDef()) + " damage.");
                }
                else
                {
                    str = ("You did 0 damage.");
                }
                getWorld().getBackground().drawString(str,getX()-90,getY()-90);
                Greenfoot.delay(20);
                getWorld().getBackground().setColor(Color.WHITE);
            }
            p3Turn = false;
            getWorld().getBackground().fill();
            getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
            Greenfoot.delay(50);
        }
    }

    /**
     * Movement when in battle, restricted to a square.
     */
    public void battleMove()
    {
        if(!isAtEdge())
        {
            if(getY() > tempY - 90)
            {
                if(Greenfoot.isKeyDown("w"))
                {
                    setImage("images\\Player1Back.png");
                    turnTowards(getX(),0);
                    move(4);
                }
            }
            if(getX() > tempX - 90)
            {
                if(Greenfoot.isKeyDown("a"))
                {
                    setImage("images\\Player1Left.png");
                    turnTowards(0,getY());
                    move(4);
                }
            }
            if(getX() < tempX + 90)
            {
                if(Greenfoot.isKeyDown("d"))
                {
                    setImage("images\\Player1Right.png");
                    turnTowards(599,getY());
                    move(4);
                }
            }
            if(getY() < tempY + 90)
            {
                if(Greenfoot.isKeyDown("s"))
                {
                    setImage("images\\Player1(new).png");
                    turnTowards(getX(),599);
                    move(4);
                }
            }
        }
        else
        {
            if(getRotation() == 0)
            {
                setLocation(getX()-1,getY());
            }
            else if(getRotation() == 90)
            {
                setLocation(getX(),getY()-1);
            }
            else if(getRotation() == 180)
            {
                setLocation(getX()+1,getY());
            }
            else
            {
                setLocation(getX(),getY()+1);
            }
        }
    }

    /**
     * Sets the hp.
     */
    public void setHp(int a)
    {
        hp = a;
    }

    /**
     * Sets the attack.
     */
    public void setAtk(int a)
    {
        atk = a;
    }

    /**
     * Sets the defense.
     */
    public void setDef(int a)
    {
        def = a;
    }

    /**
     * Returns the hp.
     */
    public int getHp()
    {
        return hp;
    }

    /**
     * Returns the atk.
     */
    public int getAtk()
    {
        return atk;
    }

    /**
     * Returns the def.
     */
    public int getDef()
    {
        return def;
    }

    /**
     * Determines if their is an obstacle.
     */
    public void nearObstacle()
    {
        nearDoor();
        if(!isAtEdge())
        {
            int tempX = getX();
            int tempY = getY();
            if(isTouching(Obstacle.class))
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
            }
        }
    }

    /**
     * Follows player 1.
     */
    public void move()
    {
        int tempX = getX();
        int tempY = getY();
        if(!isAtEdge())
        {
            if(Greenfoot.isKeyDown("w"))
            {
                setImage("images\\Player1Back.png");
                turnTowards(getX(),0);
                move(4);
            }
            else if(Greenfoot.isKeyDown("a"))
            {
                setImage("images\\Player1Left.png");
                turnTowards(0,getY());
                move(4);
            }
            else if(Greenfoot.isKeyDown("d"))
            {
                setImage("images\\Player1Right.png");
                turnTowards(599,getY());
                move(4);
            }
            else if(Greenfoot.isKeyDown("s"))
            {
                setImage("images\\Player1(new).png");
                turnTowards(getX(),599);
                move(4);
            }
        }
        else
        {
            if(getRotation() == 0)
            {
                setLocation(tempX-1,tempY);
            }
            else if(getRotation() == 90)
            {
                setLocation(tempX,tempY-1);
            }
            else if(getRotation() == 180)
            {
                setLocation(tempX+1,tempY);
            }
            else
            {
                setLocation(tempX,tempY+1);
            }
        }
    }

    /**
     * Determines if a door is nearby.
     */
    public void nearDoor()
    {
        if(!isAtEdge())
        {
            if(Greenfoot.isKeyDown("e"))
            {
                int tempX = getX();
                int tempY = getY();
                if(isTouching(Door.class))
                {
                    if(getRotation() == 0)
                    {
                        setLocation(tempX+20,tempY);
                    }
                    else if(getRotation() == 90)
                    {
                        setLocation(tempX,tempY+20);
                    }
                    else if(getRotation() == 180)
                    {
                        setLocation(tempX-20,tempY);
                    }
                    else
                    {
                        setLocation(tempX,tempY-20);
                    }
                }
            }
        }
    }
}
