import kareltherobot.*;
import java.awt.Color;
public class SmartBot  extends Robot
{
    public SmartBot(int street, int avenue, Direction dir, int num_beepers, Color badge)
    {
        super(street, avenue, dir, num_beepers, badge);
        
    }

    /**
     * Turns the robot left until it has turned right from its original position.
     */
    public void turnRight()
    {
        turnLeft();
        turnLeft();
        turnLeft();
    }
    
    /**
     * Turns the robot until it is facing the opposite direction when comapered to its original position.
     */
    public void turnAround()
    {
        turnLeft();
        turnLeft();
    }
    
    /**
     * Moves and puts a beeper.
     */
    public void moveAndBeeper()
    {
        move();
        putBeeper();
    }
    
    /**
     * Moves and picks a beeper.
     */
    public void moveAndPickBeeper()
    {
        move();
        pickBeeper();
    }
}

