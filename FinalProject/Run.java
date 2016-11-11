import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.state.*;
import org.newdawn.slick.*;
/**
 * This is a 2d fighting game. It allows one to chose the characters, world, and music.
 * The selections are limited but enjoyable. Two players fight, one using w, a, d, and r and the other using the left, right, and up arrows and 0 on the num pad.
 * When damged health decreases. The first person to lose all of their health loses, but if time runs out no one wins.
 * Stamina is used up with attacking and jumping and is needed to attack, but it does regenerate.
 * 
 * NOTE: LAG IS COMMON AND AI FEATURE IS YET TO BE IMPLEMENTED
 * 
 * @author Evan Brown & Blaise von Ohlen
 * @version 6.66 
 */
public class Run extends StateBasedGame
{
    public static final String gameName = "Evan_LeftWallBot";
    public static final int splash = 0;
    public static final int menu = 1;
    public static final int pNum = 2;
    public static final int selection = 3;
    public static final int selection2 = 4;
    public static final int selection3 = 5;
    public static final int world = 6;
    public static final int p2selection = 7;
    public static final int prompt = 8;
    /**
     * Constructor
     */
    public Run(String gameName)
    {
        super(gameName);
    }

    /**
     * Initializes all of the game states.
     */
    public void initStatesList(GameContainer gc) throws SlickException
    {
        this.addState(new SplashScreen(splash));
        this.addState(new Menu(menu));
        this.addState(new PlayerNum(pNum));
        this.addState(new Selection(selection));
        this.addState(new P2Selection(p2selection));
        this.addState(new Selection2(selection2));
        this.addState(new Selection3(selection3));
        this.addState(new World(world));
        this.addState(new Prompt(prompt));
    }
    
  

    /**
     * Runs the game.
     */
    public static void main(String args[]) throws SlickException
    {
        AppGameContainer app = new AppGameContainer(new Run(gameName));
        app.setDisplayMode(1280, 720, false);
        app.setShowFPS(false);
        app.setVSync(true);
        String[] icons = {"res\\icon32.png", "res\\icon16.png"};
        app.setIcons(icons);
        app.start();
    }
}