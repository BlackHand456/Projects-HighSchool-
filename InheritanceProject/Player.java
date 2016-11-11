import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * The class where everything is carried out from battle order to changing backgrounds in new worlds.
 *  
 * @author Evan Brown
 * @version 3.9
 */
public class Player extends Character implements PlayerControls
{
    static boolean inBattle = false;
    boolean firstOpen = false;
    boolean secondOpen = false;
    boolean p1Turn = true;
    boolean startTurn = true;
    boolean startEnemyTurn = true;
    public static boolean start = false;
    boolean begin = true;
    boolean p2 = true;
    boolean king = true;
    boolean p3 = true;

    int hp;
    int atk;
    int def;

    int wCount = 0;
    int aCount = 0;
    int sCount = 0;
    int dCount = 0;

    int tempX;
    int tempY;

    int i = 0;
    EnemyAI temp;
    /**
     * Constructor
     */
    public Player(int hp, int atk, int def)
    {
        this.hp = hp;
        this.atk = atk;
        this.def = def;
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
     * Checks for specific events and then determines whether in battle or not.
     * If not in battle the player moves and when near an obstacle is puched back and if next to the edge of the world is brought to the next background.
     * If in battle players go and then enemies and then it resets.
     */
    public void act() 
    {
        if(hp <= 0 || (MyWorld.party.size() > 1 && ((Player3)MyWorld.party.get(1)).getHp() <= 0) || (MyWorld.party.size() > 2 && ((Player2)MyWorld.party.get(2)).getHp() <= 0))
        {
            getWorld().getBackground().setColor(Color.RED);
            getWorld().getBackground().drawString("GAME OVER! A PARTY MEMBER DIED!",0,599);
            Greenfoot.stop();
        }
        if(getWorld().getObjects(EnemyAI.class).size() > 0 && MyWorld.locationY == 1 && MyWorld.locationX == 0 && p2 == true)
        {
            getWorld().getBackground().setColor(Color.WHITE);
            getWorld().getBackground().drawString("Hey you! Either get out of here or help me out!",260,490);
            Greenfoot.delay(50);
            getWorld().getBackground().fill();
            getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
            getWorld().getBackground().setColor(Color.WHITE);
            getWorld().getBackground().drawString("A new member has joined your party!",0,599);
            Greenfoot.delay(50);
            getWorld().getBackground().fill();
            getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
            p2 = false;
        }
        if(MyWorld.locationY == 0 && MyWorld.locationX == 0 && king == true)
        {
            getWorld().getBackground().setColor(Color.WHITE);
            getWorld().getBackground().drawString("Help! Those villans stole the kingdoms great treasure.",300,260);
            Greenfoot.delay(50);
            getWorld().getBackground().fill();
            getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
            getWorld().getBackground().setColor(Color.WHITE);
            getWorld().getBackground().drawString("The holy sword could kill thousands in the wrong hands you must get it back.",300,260);
            Greenfoot.delay(80);
            getWorld().getBackground().fill();
            getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
            getWorld().getBackground().setColor(Color.WHITE);
            getWorld().getBackground().drawString("Quest Updated: Defeat the evil boss and retrieve the holy sword.",0,599);
            Greenfoot.delay(80);
            getWorld().getBackground().fill();
            getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
            king = false;
        }
        if(getWorld().getObjects(EnemyAI.class).size() > 0 && MyWorld.locationY == 0 && MyWorld.locationX == 2 && p3 == true)
        {
            getWorld().getBackground().setColor(Color.WHITE);
            getWorld().getBackground().drawString("Please help me! If you kill these bats I'll definitely help you guys out!",125,160);
            Greenfoot.delay(80);
            getWorld().getBackground().fill();
            getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
            getWorld().getBackground().setColor(Color.WHITE);
            getWorld().getBackground().drawString("A new member has joined your party!",0,599);
            Greenfoot.delay(80);
            getWorld().getBackground().fill();
            getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
            p3 = false;
        }
        if(getWorld().getObjects(EnemyAI.class).size() > 0 && MyWorld.locationY == 0 && MyWorld.locationX == 3)
        {
            getWorld().getBackground().setColor(Color.WHITE);
            getWorld().getBackground().drawString("Ha ha ha! Don't tell me you people came to retrive the holy sword!",300,140);
            Greenfoot.delay(80);
            getWorld().getBackground().fill();
            getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
            getWorld().getBackground().setColor(Color.WHITE);
            getWorld().getBackground().drawString("Come and get it! If you can that is!!!!!!!!",300,140);
            Greenfoot.delay(80);
            getWorld().getBackground().fill();
            getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
        }
        if(getWorld().getObjects(EnemyAI.class).size() == 0 && MyWorld.locationY == 0 && MyWorld.locationX == 3)
        {
            getWorld().getBackground().setColor(Color.WHITE);
            getWorld().getBackground().drawString("CONGRATUALTIONS! YOU SAVED THE KINGDOM BY RETRIEVING THE HOLY SWORD!",0,599);
            Greenfoot.delay(80);
            getWorld().getBackground().fill();
            getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
            getWorld().getBackground().setColor(Color.WHITE);
            getWorld().getBackground().drawString("THANK YOU FOR PLAYING!",0,599);
            Greenfoot.delay(80);
            getWorld().getBackground().fill();
            getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
            Greenfoot.stop();
        }
        if(getWorld().getObjects(EnemyAI.class).size() > 0)
        {
            inBattle = true;
            EnemyAI temp = getWorld().getObjects(EnemyAI.class).get(0);
        }
        else
        {
            getWorld().getBackground().fill();
            getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
            inBattle = false;
        }
        if(!inBattle)
        {
            worldBoundaries();
            nearObstacle();
            if(MyWorld.party.size() == 2)
            {
                if(getRotation() == 0)
                {
                    MyWorld.party.get(1).setLocation(getX()-60,getY());
                }
                else if(getRotation() == 90)
                {
                    MyWorld.party.get(1).setLocation(getX(),getY()-60);
                }
                else if(getRotation() == 180)
                {
                    MyWorld.party.get(1).setLocation(getX()+60,getY());
                }
                else
                {
                    MyWorld.party.get(1).setLocation(getX(),getY()+60);
                }
            }
            if(MyWorld.party.size() == 3)
            {
                if(getRotation() == 0)
                {
                    MyWorld.party.get(1).setLocation(getX()-60,getY());
                }
                else if(getRotation() == 90)
                {
                    MyWorld.party.get(1).setLocation(getX(),getY()-60);
                }
                else if(getRotation() == 180)
                {
                    MyWorld.party.get(1).setLocation(getX()+60,getY());
                }
                else
                {
                    MyWorld.party.get(1).setLocation(getX(),getY()+60);
                }
                if(getRotation() == 0)
                {
                    MyWorld.party.get(2).setLocation(getX()-120,getY());
                }
                else if(getRotation() == 90)
                {
                    MyWorld.party.get(2).setLocation(getX(),getY()-120);
                }
                else if(getRotation() == 180)
                {
                    MyWorld.party.get(2).setLocation(getX()+120,getY());
                }
                else
                {
                    MyWorld.party.get(2).setLocation(getX(),getY()+120);
                }
            }
            move();
            nearObstacle();
            worldBoundaries();
            nearChest();
        }
        else
        {
            if(p1Turn == true)
            {
                if(startTurn == true)
                {
                    tempX = getX();
                    tempY = getY();
                    GreenfootImage square = new GreenfootImage("images\\Square.png");
                    getWorld().getBackground().drawImage(square,getX()-90,getY()-90);
                    startTurn = false;
                }
                this.fight();
            }
            if(MyWorld.party.size() > 1 && MyWorld.party.get(1) != null && Player3.p2Turn == true && p1Turn == false)
            {
                Player3 temp = (Player3)MyWorld.party.get(1);
                for(int i = 0; i < MyWorld.worldObj.length; i++)
                {
                    for(int x = 0; x < MyWorld.worldObj[i].length; x++)
                    {
                        if(MyWorld.worldObj[i][x] instanceof Player3)
                        {
                            temp = (Player3)MyWorld.worldObj[i][x];
                        }
                    }
                }
                if(Player3.startTurn == true)
                {
                    temp.tempX = temp.getX();
                    temp.tempY = temp.getY();
                    GreenfootImage square = new GreenfootImage("images\\Square.png");
                    getWorld().getBackground().drawImage(square,temp.getX()-90,temp.getY()-90);
                    Player3.startTurn = false;
                }
                temp.fight();
            }
            if(MyWorld.party.size() > 2 && MyWorld.party.get(2) != null && Player2.p3Turn == true && Player3.p2Turn == false)
            {
                Player2 temp = (Player2)MyWorld.party.get(2);
                for(int i = 0; i < MyWorld.worldObj.length; i++)
                {
                    for(int x = 0; x < MyWorld.worldObj[i].length; x++)
                    {
                        if(MyWorld.worldObj[i][x] instanceof Player2)
                        {
                            temp = (Player2)MyWorld.worldObj[i][x];
                        }
                    }
                }
                if(Player2.startTurn == true)
                {
                    temp.tempX = temp.getX();
                    temp.tempY = temp.getY();
                    GreenfootImage square = new GreenfootImage("images\\Square.png");
                    getWorld().getBackground().drawImage(square,temp.getX()-90,temp.getY()-90);
                    Player2.startTurn = false;
                }
                temp.fight();
            }
            if(getWorld().getObjects(EnemyAI.class).size() > 0)
            {
                if(MyWorld.party.size() == 1)
                {
                    if(p1Turn == false)
                    {
                        if(startEnemyTurn == true)
                        {
                            if(getWorld().getObjects(EnemyAI.class).get(i) instanceof Enemy)
                            {
                                temp = (Enemy) getWorld().getObjects(EnemyAI.class).get(i);
                            }
                            else if(getWorld().getObjects(EnemyAI.class).get(i) instanceof Slime)
                            {
                                temp = (Slime) getWorld().getObjects(EnemyAI.class).get(i);
                            }
                            else if(getWorld().getObjects(EnemyAI.class).get(i) instanceof Boss)
                            {
                                temp = (Boss) getWorld().getObjects(EnemyAI.class).get(i);
                            }
                            else if(getWorld().getObjects(EnemyAI.class).get(i) instanceof Mummy)
                            {
                                temp = (Mummy) getWorld().getObjects(EnemyAI.class).get(i);
                            }
                            else
                            {
                                temp = (Bat) getWorld().getObjects(EnemyAI.class).get(i);
                            }
                            temp.setTempX(temp.getTheX());
                            temp.setTempY(temp.getTheY());
                            GreenfootImage square = new GreenfootImage("images\\Square.png");
                            getWorld().getBackground().drawImage(square,temp.getTheX()-90,temp.getTheY()-90);
                            startEnemyTurn = false;
                        }
                        if(temp.getTurn() == true)
                        {
                            temp.battleMove();
                        }
                        if(temp.getTurn() == false)
                        {
                            getWorld().getBackground().fill();
                            getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
                        }
                        if(temp.getTurn() == false && i+1 < getWorld().getObjects(EnemyAI.class).size())
                        {
                            i++;
                            startEnemyTurn = true;
                            getWorld().getBackground().fill();
                            getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
                        }
                    }
                }
                else if(MyWorld.party.size() == 2)
                {
                    if(Player3.p2Turn == false)
                    {
                        if(startEnemyTurn == true)
                        {
                            if(getWorld().getObjects(EnemyAI.class).get(i) instanceof Enemy)
                            {
                                temp = (Enemy) getWorld().getObjects(EnemyAI.class).get(i);
                            }
                            else if(getWorld().getObjects(EnemyAI.class).get(i) instanceof Slime)
                            {
                                temp = (Slime) getWorld().getObjects(EnemyAI.class).get(i);
                            }
                            else if(getWorld().getObjects(EnemyAI.class).get(i) instanceof Boss)
                            {
                                temp = (Boss) getWorld().getObjects(EnemyAI.class).get(i);
                            }
                            else if(getWorld().getObjects(EnemyAI.class).get(i) instanceof Mummy)
                            {
                                temp = (Mummy) getWorld().getObjects(EnemyAI.class).get(i);
                            }
                            else
                            {
                                temp = (Bat) getWorld().getObjects(EnemyAI.class).get(i);
                            }
                            temp.setTempX(temp.getTheX());
                            temp.setTempY(temp.getTheY());
                            GreenfootImage square = new GreenfootImage("images\\Square.png");
                            getWorld().getBackground().drawImage(square,temp.getTheX()-90,temp.getTheY()-90);
                            startEnemyTurn = false;
                        }
                        if(temp.getTurn() == true)
                        {
                            temp.battleMove();
                        }
                        if(temp.getTurn() == false)
                        {
                            getWorld().getBackground().fill();
                            getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
                        }
                        if(temp.getTurn() == false && i+1 < getWorld().getObjects(EnemyAI.class).size())
                        {
                            i++;
                            getWorld().getBackground().fill();
                            getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
                            startEnemyTurn = true;
                        }
                    }
                }
                else
                {
                    if(Player2.p3Turn == false)
                    {
                        if(startEnemyTurn == true)
                        {
                            if(getWorld().getObjects(EnemyAI.class).get(i) instanceof Enemy)
                            {
                                temp = (Enemy) getWorld().getObjects(EnemyAI.class).get(i);
                            }
                            else if(getWorld().getObjects(EnemyAI.class).get(i) instanceof Slime)
                            {
                                temp = (Slime) getWorld().getObjects(EnemyAI.class).get(i);
                            }
                            else if(getWorld().getObjects(EnemyAI.class).get(i) instanceof Boss)
                            {
                                temp = (Boss) getWorld().getObjects(EnemyAI.class).get(i);
                            }
                            else if(getWorld().getObjects(EnemyAI.class).get(i) instanceof Mummy)
                            {
                                temp = (Mummy) getWorld().getObjects(EnemyAI.class).get(i);
                            }
                            else
                            {
                                temp = (Bat) getWorld().getObjects(EnemyAI.class).get(i);
                            }
                            temp.setTempX(temp.getTheX());
                            temp.setTempY(temp.getTheY());
                            GreenfootImage square = new GreenfootImage("images\\Square.png");
                            getWorld().getBackground().drawImage(square,temp.getTheX()-90,temp.getTheY()-90);
                            startEnemyTurn = false;
                        }
                        if(temp.getTurn() == true)
                        {
                            temp.battleMove();
                        }
                        if(temp.getTurn() == false)
                        {
                            getWorld().getBackground().fill();
                            getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
                        }
                        if(temp.getTurn() == false && i+1 < getWorld().getObjects(EnemyAI.class).size())
                        {
                            i++;
                            getWorld().getBackground().fill();
                            getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
                            startEnemyTurn = true;
                        }
                    }
                }
            }
            if(getWorld().getObjects(EnemyAI.class).size() == 0 || getWorld().getObjects(EnemyAI.class).get(getWorld().getObjects(EnemyAI.class).size()-1).getTurn() == false)
            {
                p1Turn = true;
                startTurn = true;
                Player2.startTurn = true;
                Player3.startTurn = true;
                startEnemyTurn = true;
                i = 0;
                if(MyWorld.party.size() > 1 && MyWorld.party.get(1) != null)
                {
                    Player3.p2Turn = true;
                } 
                if(MyWorld.party.size() > 2 && MyWorld.party.get(2) != null)
                {
                    Player2.p3Turn = true;
                } 
                for(int i = 0; i < getWorld().getObjects(EnemyAI.class).size(); i++)
                {
                    getWorld().getObjects(EnemyAI.class).get(i).setTurn(true);
                }
            }
        }
    } 

    /**
     * Aloows for ending a turn and attacking an enemy.
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
                GreenfootImage slash = new GreenfootImage("images\\Slash.png");
                getWorld().getBackground().drawImage(slash,getX()-90,getY()-90);
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
            p1Turn = false;
            getWorld().getBackground().fill();
            getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
            Greenfoot.delay(5);
        }
    }

    /**
     * Allows one to move in battle but requires them to stay in a small square.
     */
    public void battleMove()
    {
        if(!isAtEdge())
        {
            if(getY() > tempY - 90)
            {
                if(Greenfoot.isKeyDown("w"))
                {
                    setImage("images\\Player2Back.png");
                    turnTowards(getX(),0);
                    move(4);
                }
            }
            if(getX() > tempX - 90)
            {
                if(Greenfoot.isKeyDown("a"))
                {
                    setImage("images\\Player2Left.png");
                    turnTowards(0,getY());
                    move(4);
                }
            }
            if(getX() < tempX + 90)
            {
                if(Greenfoot.isKeyDown("d"))
                {
                    setImage("images\\Player2Right.png");
                    turnTowards(599,getY());
                    move(4);
                }
            }
            if(getY() < tempY + 90)
            {
                if(Greenfoot.isKeyDown("s"))
                {
                    setImage("images\\Player2Front.png");
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
     * Allows the player to move around the world.
     */
    public void move()
    {
        int tempX = getX();
        int tempY = getY();
        if(!isAtEdge())
        {
            if(Greenfoot.isKeyDown("w"))
            {
                setImage("images\\Player2Back.png");
                turnTowards(getX(),0);
                move(4);
            }
            else if(Greenfoot.isKeyDown("a"))
            {
                setImage("images\\Player2Left.png");
                turnTowards(0,getY());
                move(4);
            }
            else if(Greenfoot.isKeyDown("d"))
            {
                setImage("images\\Player2Right.png");
                turnTowards(599,getY());
                move(4);
            }
            else if(Greenfoot.isKeyDown("s"))
            {
                setImage("images\\Player2Front.png");
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
     * Clears the array of objects.
     */
    public void clear()
    {
        for(int i = 0; i < 600; i++)
        {
            for(int x = 0; x < 600; x++)
            {
                MyWorld.worldObj[i][x] = null;
            }
        }
    }

    /**
     * Checks if the player is near the edge of the world and then resets objects and stuff and changes the background and places new objects.
     */
    public void worldBoundaries()
    {
        if(isAtEdge())
        {
            if(getX() == 0)
            {
                if(MyWorld.locationX-1 >= 0 && MyWorld.locationX-1 < MyWorld.MAX)
                {
                    getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX-1]);
                    setLocation(598,getY());
                    MyWorld.locationX -= 1;
                    remove();
                    clear();
                    MyWorld.setObjects();
                }
            }
            else if(getX() == 599)
            {
                if(MyWorld.locationX+1 >= 0 && MyWorld.locationX+1 < MyWorld.MAX)
                {
                    getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX+1]);
                    setLocation(1,getY());
                    MyWorld.locationX += 1;
                    remove();
                    clear();
                    MyWorld.setObjects();
                }
            }
            else if(getY() == 0)
            {
                if(MyWorld.locationY-1 >= 0 && MyWorld.locationY-1 < MyWorld.MAX)
                {
                    getWorld().setBackground(MyWorld.map[MyWorld.locationY-1][MyWorld.locationX]);
                    setLocation(getX(),598);
                    MyWorld.locationY -= 1;
                    remove();
                    clear();
                    MyWorld.setObjects();
                }
            }
            else
            {
                if(MyWorld.locationY+1 >= 0 && MyWorld.locationY+1 < MyWorld.MAX)
                {
                    getWorld().setBackground(MyWorld.map[MyWorld.locationY+1][MyWorld.locationX]);
                    setLocation(getX(),1);
                    MyWorld.locationY += 1;
                    remove();
                    clear();
                    MyWorld.setObjects();
                }
            }
            if(!inBattle)
            {
                if(MyWorld.party.size() == 2)
                {
                    if(getRotation() == 0)
                    {
                        MyWorld.party.get(1).setLocation(getX()+60,getY());
                    }
                    else if(getRotation() == 90)
                    {
                        MyWorld.party.get(1).setLocation(getX(),getY()+60);
                    }
                    else if(getRotation() == 180)
                    {
                        MyWorld.party.get(1).setLocation(getX()-60,getY());
                    }
                    else
                    {
                        MyWorld.party.get(1).setLocation(getX(),getY()-60);
                    }
                }
                if(MyWorld.party.size() == 3)
                {
                    if(getRotation() == 0)
                    {
                        MyWorld.party.get(1).setLocation(getX()+60,getY());
                    }
                    else if(getRotation() == 90)
                    {
                        MyWorld.party.get(1).setLocation(getX(),getY()+60);
                    }
                    else if(getRotation() == 180)
                    {
                        MyWorld.party.get(1).setLocation(getX()-60,getY());
                    }
                    else
                    {
                        MyWorld.party.get(1).setLocation(getX(),getY()-60);
                    }
                    if(getRotation() == 0)
                    {
                        MyWorld.party.get(2).setLocation(getX()+120,getY());
                    }
                    else if(getRotation() == 90)
                    {
                        MyWorld.party.get(2).setLocation(getX(),getY()+120);
                    }
                    else if(getRotation() == 180)
                    {
                        MyWorld.party.get(2).setLocation(getX()-120,getY());
                    }
                    else
                    {
                        MyWorld.party.get(2).setLocation(getX(),getY()-120);
                    }
                }
            }
            p1Turn = true;
            if(MyWorld.party.size() > 1 && MyWorld.party.get(1) != null)
            {
                Player3.p2Turn = true;
            } 
            if(MyWorld.party.size() > 2 && MyWorld.party.get(2) != null)
            {
                Player2.p3Turn = true;
            } 
        }
    }

    /**
     * Checks if the player is near an obstacle and prevents them from going through it.
     */
    public void nearObstacle()
    {
        if(MyWorld.locationY == 3 && MyWorld.locationX == 0 && begin == true)
        {
            if(firstOpen == true && secondOpen == true)
            {
                nearDoor();
                if(getX() > 365)
                {
                    start = true;
                    begin = false;
                }
            }
        }
        else
        {
            nearDoor();
        }
        nearChest();
        if(!isAtEdge())
        {
            int tempX = getX();
            int tempY = getY();
            if(isTouching(Obstacle.class))
            {
                if(isTouching(Cactus.class))
                {
                    hp = getHp() - 1;
                    getWorld().getBackground().setColor(Color.RED);
                    String str = ("You took 1 damage.");
                    getWorld().getBackground().drawString(str,getX()-90,getY()-90);
                    Greenfoot.delay(20);
                    getWorld().getBackground().setColor(Color.WHITE);
                    getWorld().getBackground().fill();
                    getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
                }
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
     * Checks if the player is near a door and allows them to interact with it.
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

    /**
     * Checks if the player is near a chest and allows them to interact with it by giving them the item and changing their stats.
     */
    public void nearChest()
    {
        if(getOneIntersectingObject(Chest.class) != null)
        {
            Chest c = (Chest)getOneIntersectingObject(Chest.class);
            String temp = c.getItem();
            if(Greenfoot.isKeyDown("e"))
            {
                if(!temp.equals(""))
                {
                    if(temp.substring(temp.indexOf("-")+1,temp.lastIndexOf("-")).equals("atk"))
                    {
                        if(temp.indexOf("Sword") > -1)
                        {
                            setAtk(Integer.parseInt(temp.substring(temp.lastIndexOf("-")+1,temp.length())));
                        }
                        else if(MyWorld.party.size() > 1 && temp.indexOf("Bow") > -1)
                        {
                            ((Player3)MyWorld.party.get(1)).setAtk(Integer.parseInt(temp.substring(temp.lastIndexOf("-")+1,temp.length())));
                        }
                        else if(MyWorld.party.size() > 2 && temp.indexOf("Staff") > -1)
                        {
                            ((Player2)MyWorld.party.get(2)).setAtk(Integer.parseInt(temp.substring(temp.lastIndexOf("-")+1,temp.length())));
                        }
                    }
                    else if(temp.substring(temp.indexOf("-")+1,temp.lastIndexOf("-")).equals("def"))
                    {
                        if(temp.indexOf("Chainmail") > -1)
                        {
                            setDef(Integer.parseInt(temp.substring(temp.lastIndexOf("-")+1,temp.length())));
                        }
                        else if(MyWorld.party.size() > 1 && temp.indexOf("Armor") > -1)
                        {
                            ((Player3)MyWorld.party.get(1)).setDef(Integer.parseInt(temp.substring(temp.lastIndexOf("-")+1,temp.length())));
                        }
                        else if(MyWorld.party.size() > 2 && temp.indexOf("Robe") > -1)
                        {
                            ((Player2)MyWorld.party.get(2)).setDef(Integer.parseInt(temp.substring(temp.lastIndexOf("-")+1,temp.length())));
                        }
                    }
                    else
                    {
                        if(MyWorld.party.size() == 1)
                        {
                            setHp(getHp() + Integer.parseInt(temp.substring(temp.lastIndexOf("-")+1,temp.length())));
                        }
                        else if(MyWorld.party.size() > 1)
                        {
                            if(((Player3)MyWorld.party.get(1)).getHp() < getHp())
                            {
                                ((Player3)MyWorld.party.get(1)).setHp(((Player3)MyWorld.party.get(1)).getHp() + Integer.parseInt(temp.substring(temp.lastIndexOf("-")+1,temp.length())));
                            }
                            else
                            {
                                setHp(getHp() + Integer.parseInt(temp.substring(temp.lastIndexOf("-")+1,temp.length())));
                            }
                        }
                        else if(MyWorld.party.size() > 2)
                        {
                            if(((Player3)MyWorld.party.get(1)).getHp() < getHp() && ((Player3)MyWorld.party.get(1)).getHp() < ((Player2)MyWorld.party.get(2)).getHp())
                            {
                                ((Player3)MyWorld.party.get(1)).setHp(((Player3)MyWorld.party.get(1)).getHp() + Integer.parseInt(temp.substring(temp.lastIndexOf("-")+1,temp.length())));
                            }
                            else if(((Player2)MyWorld.party.get(2)).getHp() < getHp() && ((Player2)MyWorld.party.get(2)).getHp() < ((Player3)MyWorld.party.get(1)).getHp())
                            {
                                ((Player2)MyWorld.party.get(2)).setHp(((Player2)MyWorld.party.get(2)).getHp() + Integer.parseInt(temp.substring(temp.lastIndexOf("-")+1,temp.length())));
                            }
                            else
                            {
                                setHp(getHp() + Integer.parseInt(temp.substring(temp.lastIndexOf("-")+1,temp.length())));
                            }
                        }
                    }
                    if(temp.substring(0,temp.indexOf("-")).equals("Wooden Sword"))
                    {
                        firstOpen = true;
                    }
                    if(temp.substring(0,temp.indexOf("-")).equals("Rusty Chainmail"))
                    {
                        secondOpen = true;
                    }
                    getWorld().getBackground().setColor(Color.WHITE);
                    String str = ("You recieved a " + temp.substring(0,temp.indexOf("-")));
                    getWorld().getBackground().drawString(str,0,599);
                    c.setItem("");
                    Greenfoot.delay(30);
                    getWorld().getBackground().fill();
                    getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
                }
                else
                {
                    getWorld().getBackground().setColor(Color.WHITE);
                    String str = ("The chest was empty.");
                    getWorld().getBackground().drawString(str,0,599);
                    Greenfoot.delay(30); 
                    getWorld().getBackground().fill();
                    getWorld().setBackground(MyWorld.map[MyWorld.locationY][MyWorld.locationX]);
                }
            }
        }
    }

    /**
     * Removes all actors other than players for when the player moves to a new world.
     */
    public void remove()
    {
        getWorld().removeObjects(getWorld().getObjects(Obstacle.class));
        getWorld().removeObjects(getWorld().getObjects(Enemy.class));
        getWorld().removeObjects(getWorld().getObjects(NPC.class));
        getWorld().removeObjects(getWorld().getObjects(Bed.class));
        getWorld().removeObjects(getWorld().getObjects(Slime.class));
        getWorld().removeObjects(getWorld().getObjects(King.class));
        getWorld().removeObjects(getWorld().getObjects(Boss.class));
        getWorld().removeObjects(getWorld().getObjects(Mummy.class));
        getWorld().removeObjects(getWorld().getObjects(Bat.class));
    }
}
