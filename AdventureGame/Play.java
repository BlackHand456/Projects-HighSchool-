import javax.swing.JOptionPane;
/**
 * Allows one to play the game as well as choose whether to continue playing when done.
 */
public class Play
{
    Game g = new Game();
    public Play()
    {
        while(true)
        {
            g.play();
            String question = JOptionPane.showInputDialog(null,"Would you like to play again? <1> Yes <2> No");
            if(question != null)
            {
                if(question.equals("1"))
                {
                }
                else if(question.equals("2"))
                {
                    System.out.println("\f");
                    break;
                }
                else
                {
                    JOptionPane.showInputDialog(null,"Would you like to play again? <1> Yes <2> No");
                }
            }
            else
            {
                JOptionPane.showInputDialog(null,"Would you like to play again? <1> Yes <2> No");
            }
        }
        System.exit(0);
    }
}
