import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.io.IOException;
import java.awt.Color;
/**
 * Write a description of class Options here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Options extends World
{

    /**
     * Constructor for objects of class Options.
     * 
     */
    
    Player p;
    public static int gamemode=-1;
    public static boolean isPlaying=false,scoreWindowShown=false,shouldResetText=false;
    public int psize=32;
    Generator gen;
    int[][] b;
    static Button[] bt = new Button[3];
    GreenfootImage img;
    public Options()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(928, 672, 1, false);
        resetStaticVariables();
    }
    
    public void act()
    {
        addMenu(); 
        checkGamemode(); 
    }
    
    void addMenu()
    {
        MenuLogo ml = new MenuLogo();
        addObject(ml,473,115);
        for(int i=0;i<3;i++)
            {
               bt[i] = new Button(i);
               addObject(bt[i],473,200+100*i);
            }
    }
    
    int getScore() throws IOException 
    {
        String line;
        ReadFile file = new ReadFile("Bestscore.txt");
        line = file.OpenFile();
        if(Integer.valueOf(line) == 999999)
            return -1;
        return Integer.valueOf(line);
    }
    
    private void checkGamemode()
    {
        //functia care se ocupa de trecerea din meniu in modurile diferite de joc sau in tutorial/pagina de scoruri
        switch (gamemode)
        {
            //modul contra timp
            case 1:
            {
                if (isPlaying == false)
                {
                    isPlaying=true;
                    MyWorld w = new MyWorld(this);
                    Greenfoot.setWorld(w);                    
                }
                break;
            }
            //modul puzzle
            case 2:
            {
                if (isPlaying == false)
                {
                    isPlaying=true;
                    MyWorld w = new MyWorld(this);
                    w.GhostKilled = true;
                    Greenfoot.setWorld(w);
                }
                break;
            }
            //afisarea tutorialului
            
            //afisarea paginii de scoruri
            case 3:
            {
                if (scoreWindowShown==false)
                {
                    ScoreWindow sw = new ScoreWindow();
                    addObject(sw,546,359);
                    try
                    {
                        int score = getScore();
                        
                        if(score!=-1)
                            showText("Best time: "+ score +"s",getWidth()/2,getHeight()/2-50);
                        else
                            showText("You have never played",getWidth()/2,getHeight()/2-50);
                        scoreWindowShown=true;
                    } catch (IOException ex) 
                    {
                        showText("A aparut o eroare la citirea scorurilor din fisiere",getWidth()/2,getHeight()/2-50);
                    }
                }
            }
        }
        //stergerea textului la inchiderea ferestrei de scor
        if (shouldResetText==true)
        {
            showText(" ",getWidth()/2,getHeight()/2-50);   
            showText(" ",getWidth()/2,getHeight()/2);
            shouldResetText=false;
        }         
    }
    
    private void resetStaticVariables()
    {       
        //resetarea variabilelor statice folosite in proiect
        StaticVariableResetter.resetMenuVariables();
        StaticVariableResetter.resetMyWorldVariables();
    }
}
