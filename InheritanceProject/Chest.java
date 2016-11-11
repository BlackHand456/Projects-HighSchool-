import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * An obstacle with items in it.
 * 
 * @author  Evan Brown 
 * @version 1.0
 */
public class Chest extends Obstacle
{
    String item;
    /**
     * Constructor
     */
    public Chest(String item)
    {
        this.item = item;
    } 

    /**
     * Returns the item in the chest.
     */
    public String getItem()
    {
        return item;
    }
    
    /**
     * Sets the item in the chest.
     */
    public void setItem(String a)
    {
        item = a;
    }
}
