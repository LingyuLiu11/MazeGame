import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class VictoryWindow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LoseWindow extends Actor
{
    /**
     * Act - do whatever the VictoryWindow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public LoseWindow()
    {
        GreenfootImage logo = new GreenfootImage("LoseWindow.png");
        setImage(logo);                
    }
               
    
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
            {
                MyWorld.shouldSwitchWorld=true;
            }        
    }    
}
