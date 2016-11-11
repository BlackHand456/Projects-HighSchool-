import java.awt.Color;
public class HPBot extends SmartBot
{
    private int HPCount;
    public HPBot(int street, int avenue, Direction dir, int num_beepers, Color badge)
    {
        super(street, avenue, dir, num_beepers, badge);

        HPCount = 0;

    }

    /**
     * Tracks player's HP and represents it with beepers.
     */
    public void trackHP(PlayerBot p)
    {
        if(HPCount < p.getPlayerHP())
        {
            while(HPCount != p.getPlayerHP())
            {
                putBeeper();
                HPCount = HPCount + 1;
            }
        }

        if(HPCount > p.getPlayerHP())
        {
            while(HPCount != p.getPlayerHP())
            {
                pickBeeper();
                HPCount = HPCount - 1;
            }
        }
    }

    /**
     * Tracks player's HP while in a battle and represents it with beepers.
     */
    public void trackBattleHP(PlayerBattleBot p)
    {
        if(HPCount < p.getPlayerBattleBotHP())
        {
            while(HPCount != p.getPlayerBattleBotHP())
            {
                putBeeper();
                HPCount = HPCount + 1;
            }
        }

        if(HPCount > p.getPlayerBattleBotHP())
        {
            while(HPCount != p.getPlayerBattleBotHP())
            {
                pickBeeper();
                HPCount = HPCount - 1;
            }
        }
    }
}

