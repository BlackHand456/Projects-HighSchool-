import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.*;
import java.util.Random;
/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character
{
    private Rectangle rectAtk;
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
    private int timer;

    private Animation currentAnim;
    private Attack atk;
    private Animation[] animes;
    private boolean isMoving;
    private Image img1;
    private Animation left;
    private Animation right;
    private Animation up;
    private float THE_X;
    private float THE_Y;
    float x;
    float y;
    private final int DELAY = 100000000;
    private int elapsedTime;
    boolean isFacingLeft;
    private int jumpTimer;
    private Image miku;
    private int stami;
    private int hp;
    private final int STAMINA = 100;
    private final int HIT_POINTS = 100;

    private Rectangle hitbox;
    protected boolean isJumping = false;
    private boolean isAttacking = false;

    private Music attackSound;
    /**
     * Constructor
     */
    public Character(int hp, int stami)
    {
        this.hp = hp;
        this.stami = stami;
    }

    public static void main(String[] args) throws SlickException
    {
    }

    /**
     * Sets the hitboxes.
     */
    public void loadHitBoxes(Rectangle r)
    {
        hitbox = r;
    }

    /**
     * Sets the attack sound.
     */
    public void loadSounds(Music s)
    {
        attackSound = s;
    }

    /**
     * Sets the character image.
     */
    public void loadImages(Image image1)
    {
        img1 = image1;
    }

    /**
     * Returns the charcter's hp.
     */
    public int getHp()
    {
        return hp;
    }

    /**
     * Returns the charcter's stamina.
     */
    public int getStami()
    {
        return stami;
    }

    /**
     * Sets the charcter's hp.
     */
    public void setHp(int a)
    {
        hp = a;
    }

    /**
     * Returns the animations to a certain character's.
     */
    public void loadAnimations(Animation[] anims)
    {
        idleRightAnim = anims[0];
        idleLeftAnim = anims[1];
        runRightAnim = anims[2];
        runLeftAnim = anims[3];
        jumpLeftAnim = anims[4];
        jumpRightAnim = anims[5];
        attackLeftAnim = anims[6];
        attackRightAnim = anims[7];
        attackedRightAnim = anims[8];
        attackedLeftAnim = anims[9];
        fallRightAnim = anims[10];
        fallLeftAnim = anims[11];

        if(this instanceof Player)
        {
            isFacingLeft = false;
        }
        else
        {
            isFacingLeft = true;
        }
        if(this instanceof Player)
        {
            currentAnim = idleRightAnim;
        }
        else
        {
            currentAnim = idleLeftAnim;
        }
    }

    /**
     * Sets the x and y to work for different character's with varying sizes.
     */
    public void setXY(float x, float y)
    {
        this.x = x;
        this.y = y;
        THE_X = this.x;
        THE_Y = this.y;
    }

    public void init(GameContainer container) throws SlickException
    {
    }

    /**
     * Updates the hitbox locations, causes jumping and falling, regenerating stamina, etc...
     */
    public void update(GameContainer container, int delta) throws SlickException
    {  
        dead();

        if(atk != null)
        {
            timer += delta;
        }
        if(timer >= 1000)
        {
            timer = 0;
            atk = null;
            rectAtk = null;
        }

        jumpTimer = 0;
        if(isJumping)
        {
            while(jumpTimer < DELAY)
            {
                jumpTimer += (delta);
            }
            y -= 10f;
        }
        if(y <= (THE_Y - 250f))
        {
            isJumping = false;
        }

        elapsedTime = 0;
        if(y < THE_Y && isJumping == false)
        {
            if(isFacingLeft)
            {
                currentAnim = fallLeftAnim;
            }
            else
            {
                currentAnim = fallRightAnim;
            }

            while(elapsedTime < DELAY)
            {
                elapsedTime += (delta * 12);
            }
            y += 10f;
        }

        elapsedTime = 0;
        if(stami < STAMINA && y >= THE_Y)
        {
            while(elapsedTime < DELAY)
            {
                elapsedTime += (delta/10);
            }
            stami += 1;
        }

        currentAnim.update(delta);
        if(this instanceof HatsuneMiku || this instanceof HatsuneMikuAI)
        {
            if(isMoving)
            {
                if(!isFacingLeft)
                {
                    hitbox.setX(x-currentAnim.getWidth()/2);
                    hitbox.setY(y);
                }
                else 
                {
                    hitbox.setX(x-currentAnim.getWidth());
                    hitbox.setY(y);
                }
            }
            else if(!isMoving)
            {
                if(isAttacking)
                {
                    if(!isFacingLeft)
                    {
                        hitbox.setX(x-currentAnim.getWidth()/2);
                        hitbox.setY(y);
                    }
                    else 
                    {
                        hitbox.setX(x-currentAnim.getWidth());
                        hitbox.setY(y);
                    }
                }
                else
                {
                    hitbox.setX(x-currentAnim.getWidth());
                    hitbox.setY(y);
                }
            }
        }
        else
        {
            hitbox.setX(x-currentAnim.getWidth());
            hitbox.setY(y);
        }

        //         if(isAttacking)
        //         {
        //             // attackSound.play();
        //         }
    }

    /**
     * draws the hitboxes and the character's current animation.
     */
    public void render(GameContainer container, Graphics g) throws SlickException
    {
        g.draw(hitbox);
        if(rectAtk != null)
            g.draw(rectAtk);
        currentAnim.draw(x-currentAnim.getWidth(),y);
    }

    /**
     * Returns the character's attack.
     */
    public Attack getAttack() throws SlickException
    {
        return null;
    }

    /**
     * Damages p2 if it's hitboxes intercept p1's and set the current animation to the one for attack.
     */
    public void attackp1() throws SlickException
    {
        if(isAttacking == false && (currentAnim == idleLeftAnim || currentAnim == idleRightAnim))
        {
            isAttacking = true;
            atk = getAttack();
            rectAtk = atk.rect;
            if(stami > 0)
            {
                stami -= 10;
                if(isFacingLeft)
                {
                    currentAnim = attackLeftAnim;
                    currentAnim.restart();
                }
                else
                {
                    currentAnim = attackRightAnim;
                    currentAnim.restart();
                }

                if(this instanceof HatsuneMiku || this instanceof HatsuneMiku2 || this instanceof HatsuneMikuAI)
                {
                    if(World.p2 != null)
                    {
                        if(World.p1.getHitbox().intersects(World.p2.getHitbox()))
                        {
                            World.p2.setHp(World.p2.getHp()-10);
                        }
                    }
                    else
                    {
                        if(World.p1.getHitbox().intersects(World.comp.getHitbox()))
                        {
                            World.comp.setHp(World.comp.getHp()-10);
                        }
                    }
                }
            }
        }
    }

    /**
     * Damages p1 if it's hitboxes intercept p2's and set the current animation to the one for attack.
     */
    public void attackp2() throws SlickException
    {
        if(isAttacking == false && (currentAnim == idleLeftAnim || currentAnim == idleRightAnim))
        {
            isAttacking = true;
            atk = getAttack();
            rectAtk = atk.rect;
            if(stami > 0)
            {
                stami -= 10;
                if(isFacingLeft)
                {
                    currentAnim = attackLeftAnim;
                    currentAnim.restart();
                }
                else
                {
                    currentAnim = attackRightAnim;
                    currentAnim.restart();
                }
                if(this instanceof HatsuneMiku || this instanceof HatsuneMiku2 || this instanceof HatsuneMikuAI)
                {
                    if(World.p2 != null)
                    {
                        if(World.p2.getHitbox().intersects(World.p1.getHitbox()))
                        {
                            World.p1.setHp(World.p1.getHp()-10);
                        }
                    }
                    else
                    {
                        if(World.comp.getHitbox().intersects(World.p1.getHitbox()))
                        {
                            World.p1.setHp(World.p1.getHp()-10);
                        }
                    }
                }
            }
        }
    }

    /**
     * Sets the current animation to the one for jumping, lowers stamina, and sets isJumping to true.
     */
    public void up() throws SlickException
    {
        if(y >= THE_Y)
        {
            isJumping = true;
            stami -= 10;
            if(isFacingLeft)
            {
                currentAnim = jumpLeftAnim;
                currentAnim.restart();
                fallLeftAnim.restart();
                fallRightAnim.restart();
            }
            else
            {
                currentAnim = jumpRightAnim;
                currentAnim.restart();
                fallLeftAnim.restart();
                fallRightAnim.restart();
            }   
        }
    }

    /**
     * Does the idle animation and is called when nothing is pressed and other animations have finished.
     */
    public void idle() throws SlickException
    {
        isMoving = false;
        isAttacking = false;
        isJumping = false;
        if(currentAnim == attackLeftAnim || currentAnim == attackRightAnim || currentAnim == attackedLeftAnim || currentAnim == attackedRightAnim || currentAnim == jumpLeftAnim || currentAnim == jumpRightAnim || currentAnim == fallLeftAnim || currentAnim == fallRightAnim)
        {
            if(currentAnim.isStopped() == true)
            {
                if(isFacingLeft)
                {
                    currentAnim = idleLeftAnim;
                }
                else
                {
                    currentAnim = idleRightAnim;
                }
            }
        }
        else
        {
            if(isFacingLeft)
            {
                currentAnim = idleLeftAnim;
            }
            else
            {
                currentAnim = idleRightAnim;
            }
        }
    }

    /**
     * Moves the character left and changes their animation.
     */
    public void left() throws SlickException
    {
        if(x > 0 && y >= THE_Y)
        {
            if(!isFacingLeft)
            {
                x+= 50;
            }
            isFacingLeft = true;
            currentAnim = runLeftAnim;
            isMoving = true;
            x -= 10f;
        }
    }

    /**
     * Moves the character right and changes their animation.
     */
    public void right() throws SlickException
    {
        if(x < 1280+currentAnim.getWidth()/8 && y >= THE_Y)
        {
            if(isFacingLeft)
            {
                x-= 50;
            }
            isFacingLeft = false;
            currentAnim = runRightAnim;
            isMoving = true;
            x += 10f;
        }
    }

    /**
     * Sets the current animation to the dying one.
     */
    public void dead() throws SlickException
    {
        if(hp <= 0)
        {
            if(isFacingLeft)
            {
                currentAnim = attackedLeftAnim;
                currentAnim.restart();
            }
            else
            {
                currentAnim = attackedRightAnim;
                currentAnim.restart();
            }
        }
    }

    /**
     * Returns the hitbox.
     */
    public Rectangle getHitbox()
    {
        return hitbox;
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }
}
