import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.*;
/**
 * Write a description of class KarelJRobot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KarelJRobot extends Player
{
    private Rectangle hitbox;
    private Image karel;
    private Image beeper;
    public static final String NAME = "Karel J. Robot";
    private Image icon;
    private Beeper evan;
    private boolean isAmmo;

    private Animation idleRightAnim;
    private Animation idleLeftAnim;
    private Animation runRightAnim;
    private Animation runLeftAnim;
    private Animation jumpLeftAnim;
    private Animation jumpRightAnim;
    private Animation attackLeftAnim;
    private Animation attackRightAnim;
    private Animation attackedRightAnim;
    private Animation attackedLeftAnim;
    private Animation fallRightAnim;
    private Animation fallLeftAnim;

    private Image[] idleRight;
    private Image[] idleLeft;
    private Image[] runRight;
    private Image[] runLeft;
    private Image[] jumpLeft;
    private Image[] jumpRight;
    private Image[] attackLeft;
    private Image[] attackRight;
    private Image[] attackedRight;
    private Image[] attackedLeft;
    private Image[] fallRight;
    private Image[] fallLeft;

    private Animation[] anims;
    private Music m;
    /**
     * Constructor for objects of class KarelJRobot
     */
    public KarelJRobot() throws SlickException
    {
        karel = new Image("res\\karel2.png");
        loadImages(karel);
        animation();
        loadAnimations(anims);
        icon = new Image("res\\karelIcon.png");
        World.loadIcons(icon,true);
        isAmmo = true;
        setXY(300,550);
        hitbox = new Rectangle(50, 550, karel.getWidth(), karel.getHeight());
        loadHitBoxes(hitbox);
        m = new Music("beep.ogg");
        loadSounds(m);
    }

    public void init(GameContainer container) throws SlickException
    {
    }

    /**
     * Checks for beepers in the beeper bag and none of this class's other kinds of bags.
     */
    public boolean anyBeepersInBeeperBag()
    {
        return isAmmo;
    }

    /**
     * Draws the beeper if it was shot and initialized.
     */
    public void render(GameContainer container, Graphics g) throws SlickException
    {
        if(evan != null)
        {
            evan.render(container, g);
        }
        super.render(container, g);
    }

    /**
     * Calls Character's attack and initializes the beeper to be shot.
     */
    public void attackp1() throws SlickException
    {
        super.attackp1();
        if(anyBeepersInBeeperBag())
        {
            if(isFacingLeft)
            {
                evan = new Beeper(x-100, y, isFacingLeft, 0);
            }
            else
            {  
                evan = new Beeper(x+60, y, isFacingLeft, 0);
            }
            isAmmo = false;
        }
    }

    /**
     * Determines whether a beeper still exists and sets the beeper to null if its gone.
     */
    public void update(GameContainer container, int delta) throws SlickException
    {
        super.update(container, delta);
        if(evan != null)
        {
            if(evan.getX() <= 1280f && evan.getX() > 0f)
            {
                evan.update(container, delta);
            }
            else if(evan.getX() > 1280f || evan.getX() <= 0f || evan.getBoole())
            {
                evan = null;
                isAmmo = true;
            }        
        }
    }

    /**
     * Returns this class's name.
     */
    public String getName() throws SlickException
    {
        return NAME;
    }

    /**
     * Sets all of this class's animations.
     */
    public void animation() throws SlickException
    { 
        Image one = new Image("res\\karel.png");//up
        Image two = new Image("res\\karel2.png");//left
        Image three = new Image("res\\karel3.png");//down
        Image four = new Image("res\\karel4.png");//right
        anims = new Animation[12];

        idleRight = new Image[1];
        idleRight[0] = four;
        idleLeft = new Image[1];
        idleLeft[0] = two;
        runRight = new Image[1];
        runRight[0] = four;
        runLeft = new Image[1];
        runLeft[0] = two;
        jumpLeft = new Image[1];
        jumpLeft[0] = one;
        jumpRight = new Image[1];
        jumpRight[0] = one;
        attackLeft = new Image[1];
        attackLeft[0] = two;
        attackRight = new Image[1];
        attackRight[0] = four;
        attackedRight = new Image[4];
        attackedRight[0] = four;
        attackedRight[1] = one;
        attackedRight[2] = two;
        attackedRight[3] = three;
        attackedLeft = new Image[4];
        attackedLeft[0] = two;
        attackedLeft[1] = three;
        attackedLeft[2] = four;
        attackedLeft[3] = one;
        fallRight = new Image[1];
        fallRight[0] = three;
        fallLeft = new Image[1];
        fallLeft[0] = three;

        idleRightAnim = new Animation(idleRight,500);
        idleLeftAnim = new Animation(idleLeft,500);
        runRightAnim = new Animation(runRight,500);
        runLeftAnim = new Animation(runLeft,500);
        jumpLeftAnim = new Animation(jumpLeft,500);
        jumpRightAnim = new Animation(jumpRight,500);
        attackLeftAnim = new Animation(attackLeft,500);
        attackRightAnim = new Animation(attackRight,500);
        attackedRightAnim = new Animation(attackedRight,500);
        attackedLeftAnim = new Animation(attackedLeft,500);
        fallRightAnim = new Animation(fallRight,500);
        fallLeftAnim = new Animation(fallLeft,500);

        anims[0] = idleRightAnim;
        anims[1] = idleLeftAnim;
        anims[2] = runRightAnim;
        anims[3] = runLeftAnim;
        anims[4] = jumpLeftAnim;
        anims[5] = jumpRightAnim;
        anims[6] = attackLeftAnim;
        anims[7] = attackRightAnim;
        anims[8] = attackedRightAnim;
        anims[9] = attackedLeftAnim;
        anims[10] = fallRightAnim;
        anims[11] = fallLeftAnim;
    }

    /**
     * Returns the attack of this character.
     */
    public Attack getAttack()
    {
        Rectangle tangle = new Rectangle(x, y, 50, 50);
        Attack a = new Attack(tangle, 20);
        return a;
    }

    public Beeper getEvan() throws SlickException
    {
        return evan;
    }
}
