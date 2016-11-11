import java.util.Random;
import java.awt.Color;
public class EnemyBot extends SmartBot
{
    private int enemyHP;
    private int x;
    private int y;
    private int theX;
    private int theY;
    private int move;
    private Direction direction;
    public EnemyBot(int street, int avenue, Direction dir, int num_beepers, Color badge)
    {
        super(street, avenue, dir, num_beepers, badge);

        enemyHP = 10;
        x = avenue;
        y = street;
        move = 2;
    }

    /**
     * Makes the enemies move towards the player's location.
     */
    public void enemyMovement(PlayerBot pl)
    {
        moveToX(pl.getPlayerX());
        moveToY(pl.getPlayerY());
        move = move + 2;
    }

    /**
     * Causes movement to affect variables that represent coordinates.
     */
    public void moveC()
    {
        move();
        if(facingEast())
        {
            direction = East;
            x = x + 1;
        }
        else if(facingWest())
        {
            direction = West;
            x = x - 1;
        }
        else if(facingNorth())
        {
            direction = North;
            y = y + 1;
        }
        else
        {
            direction = South;
            y = y - 1;
        }
    }

    /**
     * Moves enemies towards the player's x coordinate.
     */
    public void moveToX(int theX)
    {
        while(move > 1)
        {
            if(theX > x)
            {
                while(!facingEast())
                {
                    turnLeft();
                }
                if(frontIsClear())
                {
                    moveC();
                    move = move - 1;
                }
                else
                {
                    while(!frontIsClear())
                    {
                        turnLeft();
                    }
                    moveC();
                    move = move - 1;
                }
            }

            else if(theX < x)
            {
                while(!facingWest())
                {
                    turnLeft();
                }
                if(frontIsClear())
                {
                    moveC();
                    move = move - 1;
                }
                else
                {
                    while(!frontIsClear())
                    {
                        turnLeft();
                    }
                    moveC();
                    move = move - 1;
                }
            }

            else
            {
                break;
            }
        }
    }

    /**
     * Moves enemies towards the player's y coordinate.
     */
    public void moveToY(int theY)
    {
        while(move > 0)
        {
            if(theY > y)
            {
                while(!facingNorth())
                {
                    turnLeft();
                }
                if(frontIsClear())
                {
                    moveC();
                    move = move - 1;
                }
                else
                {
                    while(!frontIsClear())
                    {
                        turnLeft();
                    }
                    moveC();
                    move = move - 1;
                }
            }

            else if(theY < y)
            {
                while(!facingSouth())
                {
                    turnLeft();
                }
                if(frontIsClear())
                {
                    moveC();
                    move = move - 1;
                }
                else
                {
                    while(!frontIsClear())
                    {
                        turnLeft();
                    }
                    moveC();
                    move = move - 1;
                }
            }

            else
            {
                break;
            }
        }
    }

    /**
     * Allows changing of an enemy's HP.
     */
    public void setEnemyHP(int a)
    {
        enemyHP = a;
    }

    /**
     * Returns an enemy's HP.
     */
    public int getEnemyHP()
    {
        return enemyHP;
    }

    /**
     * Returns an enemy's x coordinate.
     */
    public int getX()
    {
        return x;
    }

    /**
     * Returns an enemy's y coordinate.
     */
    public int getY()
    {
        return y;
    }

    /**
     * Returns an enemy's direction.
     */
    public Direction getDirection()
    {
        return direction;
    }

    /**
     * Sets x and y coordinates equal to 0.
     */
    public void setXAndY()
    {
        x = 0;
        y = 0;
    }
}
