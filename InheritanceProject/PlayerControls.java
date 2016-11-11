/**
 * An interface for players.
 * 
 * @author Evan Brown
 * @version 1.0
 */
public interface PlayerControls  
{
    public void fight();

    public void battleMove();

    public void setHp(int a);

    public void setAtk(int a);

    public void setDef(int a);

    public int getHp();

    public int getAtk();

    public int getDef();
}
