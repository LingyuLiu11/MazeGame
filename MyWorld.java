import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.IOException;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (Lingyu Liu) 
 * @version (8/3/2021)
 * This is inspired by https://github.com/mehanix/Blackout, in particular the
 * generation algorithm of the maze. Great thanks to Mehanix!
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public final int pixelSize=32;
    Generator gen;
    int[][] b; 
    Gate gat;
    
    public int ElapsedTime=0;
    
    static boolean shouldShowVictoryWindow=false,
                   VictoryWindowShown=false,
                   shouldSwitchWorld=false,
                   shouldShowLoseWindow=false,
                   LoseWindowShown=false,
                   GhostKilled=false;
    
    Options ww;
    int[] xy = new int[2];
    int[] ty = new int[2]; 
    
    public MyWorld(Options w)
    {    
        
        super(928, 672, 1); 
        setBackground("BlackBg.png");
        setPaintOrder(FOV.class,Gate.class,Player.class,Item.class,Floor.class, Ghost.class); 
        generateMap(14,9); 
        Player player = new Player();
        ww = w;
    }
    
    
  
    public void act()
    {
        checkTimer();
        checkVictory();
        checkLose();
    }
    
    void generateMap(int row, int col)
    {
        GreenfootImage zid = new GreenfootImage("wall5.png");
        generateMaze(row,col);       
    }
    
    private void generateMaze(int row, int col)
    {  
       
       Generator gen = new Generator(row,col);
       gen.makeMaze();
       b=gen.getMaze();
       
       drawMaze(gen,row,col); 
       placeObjects(gen);
    }    
    
    
    private void drawMaze(Generator gen,int row, int col)
    {
        
        int exit_row = Greenfoot.getRandomNumber(row-1) * 2 +1;
        GhostKilled = false;
        xy=gen.getRandomEmptyPosition();        
        Player p = new Player();
        addObject(p,xy[0]*pixelSize+pixelSize/2,xy[1]*pixelSize+pixelSize/2);
        Player.speed=2;
        FOV fov = new FOV(p);
        addObject(fov,p.getX(),p.getY());   
        
        ty=gen.getRandomEmptyPosition();        
        Ghost gh = new Ghost();
        addObject(gh,ty[0]*pixelSize+pixelSize/2,ty[1]*pixelSize+pixelSize/2);
      
      
        if(!(xy[1]<=col+1))
             {
                 b[exit_row][0] = 4;
                 Gate gat = new Gate();

                 addObject(gat,exit_row*pixelSize+pixelSize/2,0*pixelSize+pixelSize/2);
                }
                    else
             {
                 b[exit_row][gen.getCols()-1] = 0;
                 Gate gat = new Gate();

                 addObject(gat,exit_row*pixelSize+pixelSize/2,(gen.getCols()-1)*pixelSize+pixelSize/2);
            }
            
        
        for(int i=0;i<=gen.getRows()-1;i++)
            for(int j=0;j<=gen.getCols()-1;j++)
            {
                if(b[i][j]==1)
                {
                    Wall wall = new Wall();
                    addObject(wall,i*pixelSize+pixelSize/2,j*pixelSize+pixelSize/2);
                }
                else
                {
                    Floor floor = new Floor();
                    addObject(floor,i*pixelSize+pixelSize/2,j*pixelSize+pixelSize/2);                    
                }                
            }        
    }
    
    private void placeObjects(Generator gen)
    {        
        Speedpill sp = new Speedpill();
        xy=gen.getRandomEmptyPosition();
        addObject(sp,xy[0]*pixelSize+pixelSize/2,xy[1]*pixelSize+pixelSize/2);   
      
        ItemCounter it = new ItemCounter();
        addObject(it,0,0); 
        ItemCounter.shouldCountdownPill=false;  
        
        GhostKiller gk = new GhostKiller();
        xy=gen.getRandomEmptyPosition();
        addObject(gk,xy[0]*pixelSize+pixelSize/2,xy[1]*pixelSize+pixelSize/2);   
      
        ItemCounter itgk = new ItemCounter();
        addObject(itgk,0,0); 
        ItemCounter.shouldCountdownPill=false; 
    }
    
    private void checkVictory()
    {
        
        if(shouldShowVictoryWindow == true && VictoryWindowShown==false)
        {
            VictoryWindow vw = new VictoryWindow();
            Player.canMove=false;
            addObject(vw, 566, 337);
            VictoryWindowShown=true;
            
            showText("Congratulations!",478,305);
            showText("You have completed Puzzle Mode!",478,325);
            showText("Your time is: " + ElapsedTime/65+"s",478,345);
            try
            {
                if (isBestTime())
                {
                    showText("New record!",478,365);
                }
            }
            catch (IOException ex) 
            {
                showText("Error reading score file!",478,305);    
            }            
        }
         if(shouldSwitchWorld==true)
        {
            StaticVariableResetter.resetMyWorldVariables();
            Greenfoot.setWorld(ww);
        }       
    }
    
    private void checkLose()
    {
        
        if(shouldShowLoseWindow == true && LoseWindowShown==false)
        {
            LoseWindow lw = new LoseWindow();
            Player.canMove=false;
            addObject(lw, 566, 337);
            LoseWindowShown=true;
            
            showText("Ghost found you!",478,305);
            showText("You Lose!",478,325);             
        }
         if(shouldSwitchWorld==true)
        {
            StaticVariableResetter.resetMyWorldVariables();
            Greenfoot.setWorld(ww);
        }       
    }
    
    boolean isBestTime() throws IOException
    {
        String line;
        ReadFile file = new ReadFile("Bestscore.txt");
        line = file.OpenFile();     
        if (Integer.valueOf(line) > ElapsedTime/65)
        {
            WriteFile data = new WriteFile("Bestscore.txt");
            data.writeToFile(String.valueOf(ElapsedTime/65));
            return true;
        }
        return false;
    }
    
    private void checkTimer()
    {
        if (Player.canMove == true)
            ElapsedTime++;
        showText(String.valueOf(ElapsedTime/65),710,640);        
    }
}
