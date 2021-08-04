import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * ScoreWindow
 * 
 * Creeaza fereastra pe care se vor afisa scorurile cele mai bune obtinute de jucator.
 * 
 */
public class ScoreWindow extends Actor
{
    
    public ScoreWindow()
    {
        {
            GreenfootImage tut1 = new GreenfootImage("EnScoreWindow.png");
            setImage(tut1);
        }
    }  
    public void act()
    {
        if (Greenfoot.mouseClicked(this))
            {
                Options.gamemode=-1;
                Options.scoreWindowShown=false;
                Options.shouldResetText=true;
                getWorld().removeObject(this);
            }        
    }
}
