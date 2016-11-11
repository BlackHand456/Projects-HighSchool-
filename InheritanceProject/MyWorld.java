import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Where the many different backgrounds are made and objects placed.
 * 
 * @author Evan Brown
 * @version 2.0
 */ 
public class MyWorld extends World 
{  
    public static String[][] map = new String[MyWorld.MAX][MyWorld.MAX];
    public static Actor[][] worldObj = new Actor[600][600];
    public static ArrayList<Character> party = new ArrayList<>();
    boolean firstTime = true;  
    public static final int MAX = 4;
    public static int locationX = 0;
    public static int locationY = 3;
    public static int tempLocationX = 0;
    public static int tempLocationY = 0;
    static Player p1 = new Player(100,0,0);

    static boolean enemies20 = true;
    static boolean enemies10 = true;
    static boolean enemies01 = true;
    static boolean enemies11 = true;
    static boolean enemies21 = true;
    static boolean enemies31 = true;
    static boolean enemies02 = true;
    static boolean enemies12 = true;
    static boolean enemies22 = true;
    static boolean enemies32 = true;
    static boolean enemies03 = true;
    static boolean enemies13 = true;
    static boolean enemies23 = true;
    static boolean enemies33 = true;
    /**
     * Constructor for objects of class MyWorld. Plays music.
     */
    public MyWorld()
    {    
        super(600, 600, 1);
        GreenfootSound bgMusic = new GreenfootSound("sounds\\Morrowind_Theme.mp3");
        bgMusic.playLoop();
    }

    /**
     * Returns player 1.
     */
    public static Player getP1()
    {
        return p1;
    }

    /**
     * Fills the 2d array of the worlds with the correct background images.
     */
    public void map()
    {
        for(int i = 0; i < map.length; i++)
        {
            for(int x = 0; x < map[i].length; x++)
            {
                map[i][x] = "images\\" + i + "" + x + ".png";
                GreenfootImage temp = new GreenfootImage(map[i][x]);
                setBackground(temp);
            }
        }
    }

    /**
     * Places all objects that exist in the 2d array to set up an area.
     */
    public void obstacles()
    {
        for(int i = 0; i < 600; i++)
        {
            for(int x = 0; x < 600; x++)
            {
                if(worldObj[i][x] != null)
                {
                    addObject(worldObj[i][x],x,i);
                }
            }
        }
    }

    /**
     * Sets up the game and then checks if the player wants to check their stats and places objects.
     */
    public void act()
    {
        if(firstTime)
        {
            map();
            setBackground(map[3][0]);
            locationX = 0;
            locationY = 3;
            setObjects();
            obstacles();
            addObject(p1,100,200);
            party.add(p1);
            firstTime = false;
            System.out.println("\f");
            System.out.println("use 'wasd' to move");
            System.out.println("use 'e' to interact(hold the move button in the direction of the item before pressing 'e'");
            System.out.println("when in battle move within the square and press 'e' to end your turn");
            System.out.println("if you end your turn on an enemy you will attack them");
            System.out.println("press 'i' to see your party's stats");
        }
        obstacles();
        if(Greenfoot.isKeyDown("i"))
        {
            if(party.size() == 1)
            {
                System.out.println("\f");
                System.out.println("Player 1 HP: " + p1.getHp());
                System.out.println("Player 1 ATK: " + p1.getAtk());
                System.out.println("Player 1 DEF: " + p1.getDef());
            }
            else if(party.size() == 2)
            {
                System.out.println("\f");
                System.out.println("Player 1 HP: " + p1.getHp());
                System.out.println("Player 1 ATK: " + p1.getAtk());
                System.out.println("Player 1 DEF: " + p1.getDef());
                System.out.println();
                System.out.println("Player 2 HP: " + ((Player3)party.get(1)).getHp());
                System.out.println("Player 2 ATK: " + ((Player3)party.get(1)).getAtk());
                System.out.println("Player 2 DEF: " + ((Player3)party.get(1)).getDef());
            }
            else
            {
                System.out.println("\f");
                System.out.println("Player 1 HP: " + p1.getHp());
                System.out.println("Player 1 ATK: " + p1.getAtk());
                System.out.println("Player 1 DEF: " + p1.getDef());
                System.out.println();
                System.out.println("Player 2 HP: " + ((Player3)party.get(1)).getHp());
                System.out.println("Player 2 ATK: " + ((Player3)party.get(1)).getAtk());
                System.out.println("Player 2 DEF: " + ((Player3)party.get(1)).getDef());
                System.out.println();
                System.out.println("Player 3 HP: " + ((Player2)party.get(2)).getHp());
                System.out.println("Player 3 ATK: " + ((Player2)party.get(2)).getAtk());
                System.out.println("Player 3 DEF: " + ((Player2)party.get(2)).getDef());
            }
        }
    }

    /**
     * Sets the objects depending on which location you are in.
     */
    public static void setObjects()
    {
        if(locationY == 3 && locationX == 0)
        {
            obj30();
        }
        else if(locationY == 2 && locationX == 0)
        {
            obj20();
        }
        else if(locationY == 1 && locationX == 0)
        {
            obj10();
        }
        else if(locationY == 0 && locationX == 0)
        {
            obj00();
        }
        else if(locationY == 0 && locationX == 1)
        {
            obj01();
        }
        else if(locationY == 1 && locationX == 1)
        {
            obj11();
        }
        else if(locationY == 2 && locationX == 1)
        {
            obj21();
        }
        else if(locationY == 3 && locationX == 1)
        {
            obj31();
        }
        else if(locationY == 3 && locationX == 2)
        {
            obj32();
        }
        else if(locationY == 2 && locationX == 2)
        {
            obj22();
        }
        else if(locationY == 1 && locationX == 2)
        {
            obj12();
        }
        else if(locationY == 0 && locationX == 2)
        {
            obj02();
        }
        else if(locationY == 0 && locationX == 3)
        {
            obj03();
        }
        else if(locationY == 1 && locationX == 3)
        {
            obj13();
        }
        else if(locationY == 2 && locationX == 3)
        {
            obj23();
        }
        else
        {
            obj33();
        }
    }

    /**
     * Sets the objects for a specific location.
     */
    public static void obj30()
    {
        for(int x = 0; x < 360; x+=60)
        {
            worldObj[312][x] = new Wall();
        }
        for(int i = 312; i > 60; i-=60)
        {
            worldObj[i][300] = new Wall();
        }
        for(int y = 0; y < 360; y+=60)
        {
            worldObj[70][y] = new Wall();
        }
        for(int z = 312; z > 60; z-=60)
        {
            worldObj[z][0] = new Wall();
        }
        worldObj[192][300] = new Door();
        worldObj[120][120] = new Chest("Wooden Sword-atk-10");
        worldObj[120][200] = new Chest("Rusty Chainmail-def-5");
        for(int j = 0; j < 600; j+=60)
        {
            worldObj[j][599] = new Wall();
        }
        worldObj[599][599] = new Wall();
        worldObj[450][450] = new NPC("images\\Villager-Front.png");
        worldObj[200][100] = new Bed();
    }

    /**
     * Sets the objects for a specific location.
     */
    public static void obj20()
    {
        for(int j = 252; j < 600; j+=60)
        {
            worldObj[j][599] = new Wall();
        }
        worldObj[599][599] = new Wall();
        for(int y = 320; y < 600; y+=60)
        {
            worldObj[12][y] = new Wall();
        }
        worldObj[132][320] = new Door();
        for(int y = 320; y < 600; y+=60)
        {
            worldObj[252][y] = new Wall();
        }
        for(int j = 252; j > 0; j-=60)
        {
            worldObj[j][560] = new Wall();
        }
        for(int j = 72; j > 0; j-=60)
        {
            worldObj[j][320] = new Wall();
        }
        worldObj[192][320] = new Wall();
        worldObj[75][400] = new Chest("Potion-hp-50");
        if(enemies20 == true)
        {
            worldObj[360][240] = new Enemy(50,10,5);
        }
        worldObj[200][400] = new Bed();
        enemies20 = false;
    }

    /**
     * Sets the objects for a specific location.
     */
    public static void obj10()
    {
        for(int y = 330; y < 600; y+=60)
        {
            worldObj[578][y] = new Wall();
        }
        for(int j = 0; j < 600; j+=60)
        {
            worldObj[j][599] = new Wall();
        }
        for(int j = 0; j < 600; j+=60)
        {
            worldObj[60][j] = new Wall();
        }
        worldObj[60][300] = new Door();
        worldObj[0][0] = new Wall();
        worldObj[360][599] = new Door();
        if(enemies10 == true)
        {
            worldObj[360][200] = new Enemy(50,10,5);
            worldObj[420][200] = new Enemy(50,10,5);
            worldObj[550][260] = new Player3(100,10,5);
            party.add((Player3)worldObj[550][260]);
        }
        enemies10 = false;
    }

    /**
     * Sets the objects for a specific location.
     */
    public static void obj00()
    {
        for(int j = 0; j < 600; j+=60)
        {
            worldObj[j][599] = new Wall();
        }
        worldObj[599][599] = new Wall();
        for(int j = 0; j < 600; j+=60)
        {
            worldObj[0][j] = new Wall();
        }
        for(int j = 0; j < 600; j+=60)
        {
            worldObj[j][0] = new Wall();
        }
        worldObj[599][0] = new Wall();
        worldObj[200][300] = new King();
        worldObj[200][200] = new NPC("images\\Guard-Front.png");
        worldObj[200][400] = new NPC("images\\Guard-Front.png");
    }

    /**
     * Sets the objects for a specific location.
     */
    public static void obj01()
    {
        for(int j = 0; j < 600; j+=60)
        {
            worldObj[j][0] = new Wall();
        }
        worldObj[599][0] = new Wall();
        for(int j = 0; j < 600; j+=60)
        {
            worldObj[j][599] = new CaveWall();
        }
        worldObj[599][599] = new CaveWall();
        worldObj[300][60] = new Tree();
        worldObj[240][60] = new Tree();
        worldObj[460][500] = new Tree();
        worldObj[34][87] = new Tree();
        worldObj[300][450] = new Tree();
        worldObj[180][420] = new Tree();
        worldObj[360][120] = new Tree();
        worldObj[110][350] = new Tree();
        worldObj[56][432] = new Tree();
        worldObj[450][300] = new Tree();
        worldObj[60][300] = new Chest("Fine Iron Armor-def-15");
        if(enemies01 == true)
        {
            worldObj[360][200] = new Enemy(50,15,8);
            worldObj[420][200] = new Enemy(50,15,8);
            worldObj[300][480] = new Bat(50,15,5);
        }
        enemies01 = false;
    }

    /**
     * Sets the objects for a specific location.
     */
    public static void obj11()
    {
        for(int j = 0; j < 600; j+=60)
        {
            worldObj[j][0] = new Wall();
        }
        worldObj[599][0] = new Wall();
        worldObj[360][0] = new Door();
        worldObj[599][0] = new Wall();
        worldObj[60][60] = new Tree();
        worldObj[240][60] = new Tree();
        worldObj[599][580] = new Tree();
        worldObj[120][120] = new Tree();
        worldObj[360][450] = new Tree();
        worldObj[180][420] = new Tree();
        worldObj[300][180] = new Tree();
        worldObj[180][300] = new Tree();
        worldObj[90][100] = new Tree();
        worldObj[300][300] = new Tree();
        worldObj[0][599] = new CaveWall();
        worldObj[60][599] = new CaveWall();
        if(enemies11 == true)
        {
            worldObj[60][240] = new Enemy(50,12,5);
            worldObj[180][300] = new Enemy(50,12,5);
        }
        enemies11 = false;
    }

    /**
     * Sets the objects for a specific location.
     */
    public static void obj21()
    {
        for(int j = 0; j < 600; j+=60)
        {
            worldObj[j][0] = new Wall();
        }
        worldObj[599][0] = new Wall();
        worldObj[499][60] = new Tree();
        worldObj[390][80] = new Tree();
        worldObj[599][499] = new Tree();
        worldObj[120][580] = new Tree();
        worldObj[360][578] = new Tree();
        worldObj[140][510] = new Tree();
        worldObj[300][130] = new Tree();
        worldObj[180][560] = new Tree();
        worldObj[90][456] = new Tree();
        worldObj[300][577] = new Tree();
        worldObj[360][60] = new Chest("Iron Sword-atk-30");
        if(enemies21 == true)
        {
            worldObj[100][130] = new Enemy(50,15,5);
            worldObj[300][200] = new Slime(50,10,10);
            worldObj[200][454] = new Slime(50,10,10);
        }
        enemies21 = false;
    }

    /**
     * Sets the objects for a specific location.
     */
    public static void obj31()
    {
        for(int j = 0; j < 600; j+=60)
        {
            worldObj[j][0] = new Wall();
        }
        worldObj[599][0] = new Wall();
        worldObj[50][360] = new Tree();
        worldObj[230][430] = new Tree();
        worldObj[569][580] = new Tree();
        worldObj[190][290] = new Tree();
        worldObj[360][450] = new Tree();
        worldObj[580][560] = new Tree();
        worldObj[599][230] = new Tree();
        worldObj[180][500] = new Tree();
        worldObj[78][444] = new Tree();
        worldObj[340][599] = new Tree();
        if(enemies31 == true)
        {
            worldObj[36][249] = new Enemy(50,15,5);
            worldObj[420][500] = new Enemy(50,15,5);
            worldObj[30][100] = new Bat(50,15,5);
        }
        enemies31 = false;
    }

    /**
     * Sets the objects for a specific location.
     */
    public static void obj32()
    {
        worldObj[570][150] = new Tree();
        worldObj[180][200] = new Tree();
        worldObj[90][140] = new Tree();
        if(enemies32 == true)
        {
            worldObj[260][89] = new Slime(50,10,5);
            worldObj[420][400] = new Slime(50,10,5);
            worldObj[30][40] = new Slime(50,10,5);
            worldObj[60][270] = new Slime(50,10,5);
            worldObj[49][570] = new Slime(50,10,5);
        }
        enemies32 = false;
    }

    /**
     * Sets the objects for a specific location.
     */
    public static void obj22()
    {
        worldObj[580][460] = new Tree();
        worldObj[520][120] = new Tree();
        worldObj[134][360] = new Tree();
        worldObj[599][444] = new Tree();
        worldObj[340][100] = new Tree();
        for(int j = 0; j < 600; j+=60)
        {
            worldObj[j][599] = new Tree();
        }
        worldObj[599][599] = new Tree();
        if(enemies22 == true)
        {
            worldObj[36][249] = new Enemy(50,15,5);
            worldObj[420][500] = new Slime(50,10,5);
            worldObj[30][100] = new Bat(50,15,5);
        }
        enemies22 = false;
    }

    /**
     * Sets the objects for a specific location.
     */
    public static void obj12()
    {
        for(int j = 0; j < 600; j+=60)
        {
            worldObj[60][j] = new CaveWall();
        }
        worldObj[0][0] = new CaveWall();
        worldObj[0][599] = new CaveWall();
        worldObj[60][599] = new CaveWall();
        worldObj[60][300] = null;
        worldObj[60][240] = null;
        worldObj[60][360] = null;
        worldObj[570][150] = new Tree();
        worldObj[180][200] = new Tree();
        worldObj[569][580] = new Tree();
        worldObj[190][290] = new Tree();
        worldObj[390][100] = new Tree();
        worldObj[599][499] = new Tree();
        worldObj[120][580] = new Tree();
        worldObj[360][578] = new Tree();
        worldObj[599][180] = new Tree();
        worldObj[180][500] = new Tree();
        worldObj[78][444] = new Tree();
        worldObj[340][599] = new Tree();
        worldObj[300][100] = new Tree();
        worldObj[240][100] = new Tree();
        for(int j = 599; j > 60; j-=60)
        {
            worldObj[j][599] = new Tree();
        }
        if(enemies12 == true)
        {
            worldObj[36][249] = new Enemy(50,15,5);
            worldObj[250][190] = new Bat(50,15,5);
            worldObj[90][520] = new Bat(50,15,5);
        }
        enemies12 = false;
    }

    /**
     * Sets the objects for a specific location.
     */
    public static void obj02()
    {
        for(int j = 0; j < 600; j+=60)
        {
            worldObj[j][599] = new CaveWall();
        }
        worldObj[599][599] = new CaveWall();
        for(int j = 0; j < 600; j+=60)
        {
            worldObj[0][j] = new CaveWall();
        }
        for(int j = 0; j < 600; j+=60)
        {
            worldObj[j][0] = new CaveWall();
        }
        worldObj[599][0] = new CaveWall();
        worldObj[300][200] = new Chest("Potion-hp-50");
        if(enemies02 == true)
        {
            worldObj[478][249] = new Bat(50,15,5);
            worldObj[270][460] = new Bat(50,15,5);
            worldObj[245][336] = new Bat(50,15,5);
            worldObj[100][125] = new Player2(100,20,15);
            party.add((Player2)worldObj[100][125]);
        }
        enemies02 = false;
    }

    /**
     * Sets the objects for a specific location.
     */
    public static void obj03()
    {
        for(int j = 0; j < 600; j+=60)
        {
            worldObj[j][599] = new BossWall();
        }
        worldObj[599][599] = new BossWall();
        for(int j = 0; j < 600; j+=60)
        {
            worldObj[0][j] = new BossWall();
        }
        for(int j = 0; j < 600; j+=60)
        {
            worldObj[j][0] = new BossWall();
        }
        worldObj[599][0] = new BossWall();
        if(enemies03 == true)
        {
            worldObj[300][300] = new Enemy(50,20,10);
            worldObj[200][400] = new Enemy(50,20,10);
            worldObj[200][200] = new Enemy(50,20,10);
            worldObj[200][300] = new Boss(75,40,15);
        }
        enemies03 = false;
    }

    /**
     * Sets the objects for a specific location.
     */
    public static void obj13()
    {
        for(int j = 599; j > 60; j-=60)
        {
            worldObj[j][0] = new Cactus();
        }
        for(int j = 0; j < 600; j+=60)
        {
            worldObj[60][j] = new BossWall();
        }
        worldObj[0][0] = new BossWall();
        worldObj[0][599] = new BossWall();
        worldObj[60][599] = new BossWall();
        worldObj[60][300] = null;
        worldObj[60][240] = null;
        worldObj[60][360] = null;
        worldObj[520][290] = new Cactus();
        worldObj[350][459] = new Cactus();
        worldObj[279][99] = new Cactus();
        worldObj[126][580] = new Cactus();
        worldObj[360][57] = new Cactus();
        worldObj[599][259] = new Cactus();
        worldObj[75][400] = new Chest("Potion-hp-50");
        worldObj[360][160] = new Chest("Cursed Staff-atk-30");
        if(enemies13 == true)
        {
            worldObj[346][29] = new Enemy(50,15,10);
            worldObj[179][150] = new Enemy(50,15,10);
            worldObj[230][80] = new Enemy(50,15,10);
            worldObj[450][540] = new Mummy(50,20,15);
        }
        enemies13 = false;
    }

    /**
     * Sets the objects for a specific location.
     */
    public static void obj23()
    {
        for(int j = 0; j < 600; j+=60)
        {
            worldObj[j][0] = new Cactus();
        }
        worldObj[599][0] = new Cactus();
        worldObj[190][290] = new Cactus();
        worldObj[390][488] = new Cactus();
        worldObj[59][467] = new Cactus();
        worldObj[190][234] = new Cactus();
        worldObj[456][578] = new Cactus();
        worldObj[569][80] = new Cactus();
        worldObj[60][350] = new Chest("Fine Iron Chainmail-def-15");
        if(enemies23 == true)
        {
            worldObj[566][90] = new Mummy(50,20,10);
            worldObj[260][120] = new Mummy(50,20,10);
            worldObj[450][300] = new Mummy(50,20,10);
        }
        enemies23 = false;
    }

    /**
     * Sets the objects for a specific location.
     */
    public static void obj33()
    {
        worldObj[135][267] = new Cactus();
        worldObj[334][80] = new Cactus();
        worldObj[599][459] = new Cactus();
        worldObj[567][580] = new Cactus();
        worldObj[94][578] = new Cactus();
        worldObj[599][245] = new Cactus();
        worldObj[360][180] = new Chest("Fine Bow-atk-30");
        if(enemies33 == true)
        {
            worldObj[126][249] = new Slime(50,10,5);
            worldObj[50][60] = new Mummy(50,15,10);
            worldObj[367][230] = new Mummy(50,15,10);
            worldObj[234][480] = new Mummy(50,15,10);
        }
        enemies33 = false;
    }
}