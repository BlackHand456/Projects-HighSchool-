import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * An enemy that looks like a mummy.
 * 
 * @author Evan Brown
 * @version 1.0
 */
public class Mummy extends Character implements EnemyAI
{
    int tempX; 
    int tempY;

    int hp;
    int atk;
    int def;
    boolean turn = true;
    /**
     * Constructor
     */
    public Mummy(int hp, int atk, int def)
    {
        this.hp = hp;
        this.atk = atk;
        this.def = def;
    }

    /** 
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
    }    

    /**
     * Returns whther its the enemy's turn.
     */
    public boolean getTurn()
    {
        return turn;
    }

    /**
     * Sets the enemy's turn.
     */
    public void setTurn(boolean turn)
    {
        this.turn = turn;
    }

    /**
     * Moves the enemy toward the closest player and attacks them.
     */
    public void battleMove()
    {
        if(hp > 0)
        {
            //nearObstacle();
            Player temp3 = (Player)MyWorld.party.get(0);
            Player3 temp = null;
            Player2 temp2 = null;
            if(MyWorld.party.size() == 2)
            {
                temp = (Player3)MyWorld.party.get(1);
                if(detectClosest() == temp)
                {
                    if(Math.abs(getY() - temp.getY()) > 4)
                    {
                        if(getY() < temp.getY())
                        {
                            setImage("images\\MummyFront.png");
                            if(getY() != temp.getY() && getY() < tempY + 90)
                            {
                                turnTowards(getX(),599);
                                move(4);
                            }
                        }
                        else
                        {
                            setImage("images\\MummyBack.png");
                            if(getY() != temp.getY() && getY() > tempY - 90)
                            {
                                turnTowards(getX(),0);
                                move(4);
                            }
                        }
                    }
                    else
                    {
                        if(getX() < temp.getX())
                        {
                            setImage("images\\MummyRight.png");
                            if(getX() != temp.getX() && getX() < tempX + 90)
                            {
                                turnTowards(599,getY());
                                move(4);
                            }
                        }
                        else
                        {
                            setImage("images\\MummyLeft.png");
                            if(getX() != temp.getX() && getX() > tempX - 90)
                            {
                                turnTowards(0,getY());
                                move(4);
                            }
                        }
                    } 
                }
                else
                {
                    if(Math.abs(getY() - temp3.getY()) > 4)
                    {
                        if(getY() < temp3.getY())
                        {
                            setImage("images\\MummyFront.png");
                            if(getY() != temp3.getY() && getY() < tempY + 90)
                            {
                                turnTowards(getX(),599);
                                move(4);
                            }
                        }

                        else
                        {
                            setImage("images\\MummyBack.png");
                            if(getY() != temp3.getY() && getY() > tempY - 90)
                            {
                                turnTowards(getX(),0);
                                move(4);
                            }
                        }
                    }
                    else
                    {
                        if(getX() < temp3.getX())
                        {
                            setImage("images\\MummyRight.png");
                            if(getX() != temp3.getX() && getX() < tempX + 90)
                            {
                                turnTowards(599,getY());
                                move(4);
                            }
                        }
                        else
                        {
                            setImage("images\\MummyLeft.png");
                            if(getX() != temp3.getX() && getX() > tempX - 90)
                            {
                                turnTowards(0,getY());
                                move(4);
                            }
                        }
                    } 
                }
            }
            else if(MyWorld.party.size() == 3)
            {
                temp = (Player3)MyWorld.party.get(1);
                temp2 = (Player2)MyWorld.party.get(2);
                if(detectClosest() == temp)
                {
                    if(Math.abs(getY() - temp.getY()) > 4)
                    {
                        if(getY() < temp.getY())
                        {
                            setImage("images\\MummyFront.png");
                            if(getY() != temp.getY() && getY() < tempY + 90)
                            {
                                turnTowards(getX(),599);
                                move(4);
                            }
                        }

                        else
                        {
                            setImage("images\\MummyBack.png");
                            if(getY() != temp.getY() && getY() > tempY - 90)
                            {
                                turnTowards(getX(),0);
                                move(4);
                            }
                        }
                    }
                    else
                    {
                        if(getX() < temp.getX())
                        {
                            setImage("images\\MummyRight.png");
                            if(getX() != temp.getX() && getX() < tempX + 90)
                            {
                                turnTowards(599,getY());
                                move(4);
                            }
                        }
                        else
                        {
                            setImage("images\\MummyLeft.png");
                            if(getX() != temp.getX() && getX() > tempX - 90)
                            {
                                turnTowards(0,getY());
                                move(4);
                            }
                        }
                    } 
                }
                else if(detectClosest() == temp2)
                {
                    if(Math.abs(getY() - temp2.getY()) > 4)
                    {
                        if(getY() < temp2.getY())
                        {
                            setImage("images\\MummyFront.png");
                            if(getY() != temp2.getY() && getY() < tempY + 90)
                            {
                                turnTowards(getX(),599);
                                move(4);
                            }
                        }

                        else
                        {
                            setImage("images\\MummyBack.png");
                            if(getY() != temp2.getY() && getY() > tempY - 90)
                            {
                                turnTowards(getX(),0);
                                move(4);
                            }
                        }
                    }
                    else
                    {
                        if(getX() < temp2.getX())
                        {
                            setImage("images\\MummyRight.png");
                            if(getX() != temp2.getX() && getX() < tempX + 90)
                            {
                                turnTowards(599,getY());
                                move(4);
                            }
                        }
                        else
                        {
                            setImage("images\\MummyLeft.png");
                            if(getX() != temp2.getX() && getX() > tempX - 90)
                            {
                                turnTowards(0,getY());
                                move(4);
                            }
                        }
                    } 
                }
                else
                {
                    if(Math.abs(getY() - temp3.getY()) > 4)
                    {
                        if(getY() < temp3.getY())
                        {
                            setImage("images\\MummyFront.png");
                            if(getY() != temp3.getY() && getY() < tempY + 90)
                            {
                                turnTowards(getX(),599);
                                move(4);
                            }
                        }

                        else
                        {
                            setImage("images\\MummyBack.png");
                            if(getY() != temp3.getY() && getY() > tempY - 90)
                            {
                                turnTowards(getX(),0);
                                move(4);
                            }
                        }
                    }
                    else
                    {
                        if(getX() < temp3.getX())
                        {
                            setImage("images\\MummyRight.png");
                            if(getX() != temp3.getX() && getX() < tempX + 90)
                            {
                                turnTowards(599,getY());
                                move(4);
                            }
                        }
                        else
                        {
                            setImage("images\\MummyLeft.png");
                            if(getX() != temp3.getX() && getX() > tempX - 90)
                            {
                                turnTowards(0,getY());
                                move(4);
                            }
                        }
                    } 
                }
            }
            else
            {
                if(Math.abs(getY() - temp3.getY()) > 4)
                {
                    if(getY() < temp3.getY())
                    {
                        setImage("images\\MummyFront.png");
                        if(getY() != temp3.getY() && getY() < tempY + 90)
                        {
                            turnTowards(getX(),599);
                            move(4);
                        }
                    }

                    else
                    {
                        setImage("images\\MummyBack.png");
                        if(getY() != temp3.getY() && getY() > tempY - 90)
                        {
                            turnTowards(getX(),0);
                            move(4);
                        }
                    }
                }
                else
                {
                    if(getX() < temp3.getX())
                    {
                        setImage("images\\MummyRight.png");
                        if(getX() != temp3.getX() && getX() < tempX + 90)
                        {
                            turnTowards(599,getY());
                            move(4);
                        }
                    }
                    else
                    {
                        setImage("images\\MummyLeft.png");
                        if(getX() != temp3.getX() && getX() > tempX - 90)
                        {
                            turnTowards(0,getY());
                            move(4);
                        }
                    }
                } 
            }
            //nearObstacle();
            fight();
            if(MyWorld.party.size() == 1 && (getX() >= tempX + 90 || getX() <= tempX - 90 || getY() >= tempY + 90 || getY() <= tempY - 90 || (Math.abs(getY() - temp3.getY()) <= 4 && Math.abs(getX() - temp3.getX()) <= 4)))
            {
                if(isTouching(PlayerControls.class))
                {
                    String str;
                    PlayerControls temp4 = (PlayerControls)getOneIntersectingObject(PlayerControls.class);
                    if(temp4.getDef() <= atk)
                    {
                        temp4.setHp(temp4.getHp() - (atk -  temp4.getDef()));
                    }
                    getWorld().getBackground().setColor(Color.RED);
                    GreenfootImage slash = new GreenfootImage("images\\Slash.png");
                    getWorld().getBackground().drawImage(slash,getX()-90,getY()-90);
                    Greenfoot.delay(20);
                    if(temp4.getDef() <= atk)
                    {
                        str = ("You took " + (atk -  temp4.getDef()) + " damage.");
                    }
                    else
                    {
                        str = ("You took 0 damage.");
                    }
                    getWorld().getBackground().drawString(str,getX()-90,getY()-90);
                    Greenfoot.delay(20);
                    getWorld().getBackground().setColor(Color.WHITE);
                }
                getWorld().getBackground().fill();
                getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
                turn = false;
            }
            else if(MyWorld.party.size() == 2 && (getX() >= tempX + 90 || getX() <= tempX - 90 || getY() >= tempY + 90 || getY() <= tempY - 90 || (Math.abs(getY() - temp3.getY()) <= 4 && Math.abs(getX() - temp3.getX()) <= 4) || (Math.abs(getY() - temp.getY()) <= 4 && Math.abs(getX() - temp.getX()) <= 4)))
            {
                if(isTouching(PlayerControls.class))
                {
                    String str;
                    PlayerControls temp4 = (PlayerControls)getOneIntersectingObject(PlayerControls.class);
                    if(temp4.getDef() <= atk)
                    {
                        temp.setHp(temp4.getHp() - (atk -  temp4.getDef()));
                    }
                    getWorld().getBackground().setColor(Color.RED);
                    GreenfootImage slash = new GreenfootImage("images\\Slash.png");
                    getWorld().getBackground().drawImage(slash,getX()-90,getY()-90);
                    Greenfoot.delay(20);
                    if(temp4.getDef() <= atk)
                    {
                        str = ("You took " + (atk -  temp4.getDef()) + " damage.");
                    }
                    else
                    {
                        str = ("You took 0 damage.");
                    }
                    getWorld().getBackground().drawString(str,getX()-90,getY()-90);
                    Greenfoot.delay(20);
                    getWorld().getBackground().setColor(Color.WHITE);
                }
                getWorld().getBackground().fill();
                getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
                turn = false;
            }
            else if(MyWorld.party.size() == 3 && (getX() >= tempX + 90 || getX() <= tempX - 90 || getY() >= tempY + 90 || getY() <= tempY - 90 || (Math.abs(getY() - temp3.getY()) <= 4 && Math.abs(getX() - temp3.getX()) <= 4) || (Math.abs(getY() - temp.getY()) <= 4 && Math.abs(getX() - temp.getX()) <= 4) || (Math.abs(getY() - temp2.getY()) <= 4 && Math.abs(getX() - temp2.getX()) <= 4)))
            {
                if(isTouching(PlayerControls.class))
                {
                    String str;
                    PlayerControls temp4 = (PlayerControls)getOneIntersectingObject(PlayerControls.class);
                    if(temp4.getDef() <= atk)
                    {
                        temp.setHp(temp4.getHp() - (atk -  temp4.getDef()));
                    }
                    getWorld().getBackground().setColor(Color.RED);
                    GreenfootImage slash = new GreenfootImage("images\\Slash.png");
                    getWorld().getBackground().drawImage(slash,getX()-90,getY()-90);
                    Greenfoot.delay(20);
                    if(temp4.getDef() <= atk)
                    {
                        str = ("You took " + (atk -  temp4.getDef()) + " damage.");
                    }
                    else
                    {
                        str = ("You took 0 damage.");
                    }
                    getWorld().getBackground().drawString(str,getX()-90,getY()-90);
                    Greenfoot.delay(20);
                    getWorld().getBackground().setColor(Color.WHITE);
                }
                getWorld().getBackground().fill();
                getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
                turn = false;
            }
        }
        else
        {
            if(hp <= 0)
            {
                turn = false;
                getWorld().removeObject(this);
                for(int i = 0; i < MyWorld.worldObj.length; i++)
                {
                    for(int x = 0; x < MyWorld.worldObj[i].length; x++)
                    {
                        if(MyWorld.worldObj[i][x] instanceof Mummy)
                        {
                            Mummy e = (Mummy)MyWorld.worldObj[i][x];
                            if(e.getHp() <= 0)
                            {
                                MyWorld.worldObj[i][x] = null;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Not needed.
     */
    public void fight()
    {
        if(isTouching(PlayerControls.class))
        {
            detectClosest().setHp(detectClosest().getHp() - (atk - detectClosest().getDef()));
        }
    }

    /**
     * Finds the closest player.
     */
    public PlayerControls detectClosest()
    {
        Player temp3 = (Player)MyWorld.party.get(0);	
        if(MyWorld.party.size() == 2)
        {
            Player3 temp = (Player3)MyWorld.party.get(1);
            int p3dif = Math.abs((getX() + getY()) - (temp.getX() + temp.getY()));
            int p1dif = Math.abs((getX() + getY()) - (temp3.getX() + temp3.getY()));
            if(p3dif < p1dif && Math.abs(p1dif - p3dif) > 4)
            {
                return temp;
            }
            else
            {
                return temp3;
            }
        }
        else if(MyWorld.party.size() == 3)
        {
            Player3 temp = (Player3)MyWorld.party.get(1);
            Player2 temp2 = (Player2)MyWorld.party.get(2);
            int p3dif = Math.abs((getX() + getY()) - (temp.getX() + temp.getY()));
            int p2dif = Math.abs((getX() + getY()) - (temp2.getX() + temp2.getY()));
            int p1dif = Math.abs((getX() + getY()) - (temp3.getX() + temp3.getY()));
            if(p3dif < p2dif && p3dif < p1dif && Math.abs(p2dif - p3dif) > 4 && Math.abs(p1dif - p3dif) > 4)
            {
                return temp;
            }
            else if(p2dif < p3dif && p2dif < p1dif && Math.abs(p3dif - p2dif) > 4 && Math.abs(p1dif - p2dif) > 4)
            {
                return temp2;
            }
            else
            {
                return temp3;
            }
        }
        else
        {
            return temp3;
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
     * Returns the x coord.
     */
    public int getTheX()
    {
        return getX();
    }

    /**
     * Returns the y coord.
     */
    public int getTheY()
    {
        return getY();
    }

    /**
     * Sets the x coord.
     */
    public void setTempX(int a)
    {
        tempX = a;
    }

    /**
     * Sets the y coord.
     */
    public void setTempY(int a)
    {
        tempY = a;
    }

    /**
     * Determines if their is an obstacle.
     */
    public void nearObstacle()
    {
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
}
