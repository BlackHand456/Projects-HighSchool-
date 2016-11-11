/**
 * An interface for all enemies.
 * 
 * @author Evan Brown
 * @version 1.0
 */
public interface EnemyAI  
{
    public void battleMove();

    public void fight();

    public PlayerControls detectClosest();

    public void setHp(int a);

    public void setAtk(int a);

    public void setDef(int a);

    public int getHp();

    public int getAtk();

    public int getDef();
    
    public boolean getTurn();
    
    public void setTurn(boolean turn);
    
    public int getTheX();
    
    public int getTheY();
    
    public void setTempX(int a);
    
    public void setTempY(int a);
}
