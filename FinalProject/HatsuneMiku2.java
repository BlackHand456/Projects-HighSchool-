import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.*;
/**
 * Write a description of class HatsuneMiku here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HatsuneMiku2 extends Player2
{
    private Rectangle hitbox;
    private Image miku;
    public static final String NAME = "Hatsune Miku";
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
    private Image icon;

    private SpriteSheet idleRight;
    private SpriteSheet idleLeft;
    private SpriteSheet runRight;
    private SpriteSheet runLeft;
    private SpriteSheet jumpLeft;
    private SpriteSheet jumpRight;
    private SpriteSheet attackLeft;
    private SpriteSheet attackRight;
    private SpriteSheet attackedRight;
    private SpriteSheet attackedLeft;

    private Animation[] anims;

    private Music m;
    /**
     * Constructor for objects of class HatsuneMikuAI
     */
    public HatsuneMiku2() throws SlickException
    {
        miku = new Image("res\\miku.png");
        loadImages(miku);
        runInit();
        atkInit();
        jumpInit();
        fallInit();
        deadInit();
        animation();
        loadAnimations(anims);
        icon = new Image("res\\mikuIcon.png");
        World.loadIcons(icon,false);
        setXY(1200,468);
        hitbox = new Rectangle(50, 468, 256,  252);
        loadHitBoxes(hitbox);
        m = new Music("mikuScream.ogg");
        loadSounds(m);
    }

    public void init(GameContainer container) throws SlickException
    {
    }

    /**
     * Calls its parent's render.
     */
    public void render(GameContainer container, Graphics g) throws SlickException
    {
        super.render(container, g);
    }

    /**
     * Calls its parent's update.
     */
    public void update(GameContainer container, int delta) throws SlickException
    {
        super.update(container, delta);
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
        anims = new Animation[12];
        Image tempIdleR = new Image("res\\spritesheets\\idle.png").getScaledCopy(4f);
        idleRight = new SpriteSheet(tempIdleR,256,252);
        //idleRight = idleRight.getScaledCopy(4f);
        Image tempIdleL = new Image("res\\spritesheets\\idleLeft.png").getScaledCopy(4f);
        idleLeft = new SpriteSheet (tempIdleL, 256, 252);
        //idleLeft = new SpriteSheet("res\\spritesheets\\idleLeft.png",64,63);
        // idleLeft = idleLeft.getScaledCopy(4f);
        //runRight = new SpriteSheet("res\\spritesheets\\run.png",69,72);
        //runLeft = new SpriteSheet("res\\spritesheets\\runLeft.png",69,72);
        //jumpLeft = new SpriteSheet("res\\spritesheets\\jump.png",64,63);
        //jumpRight = new SpriteSheet("res\\spritesheets\\jumpLeft.png",64,63);
        //attackLeft = new SpriteSheet("res\\spritesheets\\mikuattack.png",64,63);
        //attackRight = new SpriteSheet("res\\spritesheets\\mikuattackLeft.png",64,63);
        //attackedRight = new SpriteSheet("res\\spritesheets\\attacked.png",64,63);
        //attackedLeft = new SpriteSheet("res\\spritesheets\\attackedLeft.png",64,63);

        idleRightAnim = new Animation(idleRight,300);
        idleLeftAnim = new Animation(idleLeft,300);
        //runRightAnim = new Animation(runRight,500);
        //runLeftAnim = new Animation(runLeft,500);
        //jumpLeftAnim = new Animation(jumpLeft,500);
        //jumpRightAnim = new Animation(jumpRight,500);
        //attackLeftAnim = new Animation(attackLeft,500);
        //attackRightAnim = new Animation(attackRight,500);
        //attackedRightAnim = new Animation(attackedRight,500);
        //attackedLeftAnim = new Animation(attackedLeft,500);
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
     * Sets the run animation.
     */
    public void runInit() throws SlickException
    {
        Image[] temp = new Image[8];
        for(int i = 1; i <=8; i++)
        {
            temp[i-1] = new Image("res\\spritesheets\\run" + i + ".png").getScaledCopy(4f);
        }
        runRightAnim = new Animation(temp, 500); 
        Image[] temp2 = new Image[8];
        for(int x = 1; x <=8; x++)
        {
            temp2[x-1] = new Image("res\\spritesheets\\run" + x + "r.png").getScaledCopy(4f);
        }
        runLeftAnim = new Animation(temp2, 500); 
    }

    /**
     * Sets the attack animation.
     */
    public void atkInit() throws SlickException
    {
        Image[] temp = new Image[8];
        for(int i = 1; i <=8; i++)
        {
            temp[i-1] = new Image("res\\spritesheets\\attack" + i + ".png").getScaledCopy(4f);
        }
        attackRightAnim = new Animation(temp, 200); 
        attackRightAnim.stopAt(7);
        Image[] temp2 = new Image[8];
        for(int x = 1; x <=8; x++)
        {
            temp2[x-1] = new Image("res\\spritesheets\\attack" + x + "r.png").getScaledCopy(4f);
        }
        attackLeftAnim = new Animation(temp2, 200); 
        attackLeftAnim.stopAt(7);
    }

    /**
     * Sets the jump animation.
     */
    public void jumpInit() throws SlickException
    {
        Image[] temp = new Image[3];
        for(int i = 1; i <=3; i++)
        {
            temp[i-1] = new Image("res\\spritesheets\\jump" + i + ".png").getScaledCopy(4f);
        }
        jumpRightAnim = new Animation(temp, 600); 
        jumpRightAnim.setDuration(0,400);
        jumpRightAnim.stopAt(2);
        Image[] temp2 = new Image[3];
        for(int x = 1; x <=3; x++)
        {
            temp2[x-1] = new Image("res\\spritesheets\\jump" + x + "r.png").getScaledCopy(4f);
        }
        jumpLeftAnim = new Animation(temp2, 600); 
        jumpLeftAnim.setDuration(0,400);
        jumpLeftAnim.stopAt(2);
    }

    /**
     * Sets the fall animation.
     */
    public void fallInit() throws SlickException
    {
        Image[] temp = new Image[6];
        for(int i = 1; i <=6; i++)
        {
            temp[i-1] = new Image("res\\spritesheets\\fall" + i + ".png").getScaledCopy(4f);
        }
        fallRightAnim = new Animation(temp, 200); 
        fallRightAnim.stopAt(5);
        Image[] temp2 = new Image[6];
        for(int x = 1; x <=6; x++)
        {
            temp2[x-1] = new Image("res\\spritesheets\\fall" + x + "r.png").getScaledCopy(4f);
        }
        fallLeftAnim = new Animation(temp2, 200); 
        fallLeftAnim.stopAt(5);
    }

    /**
     * Sets the death animation.
     */
    public void deadInit() throws SlickException
    {
        Image[] temp = new Image[3];
        for(int i = 1; i <=3; i++)
        {
            temp[i-1] = new Image("res\\spritesheets\\attacked" + i + ".png").getScaledCopy(4f);
        }
        attackedRightAnim = new Animation(temp, 400); 
        attackedRightAnim.stopAt(2);
        Image[] temp2 = new Image[3];
        for(int x = 1; x <=3; x++)
        {
            temp2[x-1] = new Image("res\\spritesheets\\attacked" + x + "r.png").getScaledCopy(4f);
        }
        attackedLeftAnim = new Animation(temp2, 400); 
        attackedLeftAnim.stopAt(2);
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
}
