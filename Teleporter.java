import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 */
public class Teleporter extends Actor
{
    public Teleporter()
    {
        setImage(new GreenfootImage("bg.png"));
    }
    
    public void act() 
    {
        if(getOneIntersectingObject(Player.class)!=null)
        {
            MyWorld.shouldShowVictoryWindow=true;  
        }
            
    }    
}
