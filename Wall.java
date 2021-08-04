import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 */

public class Wall extends Actor
{
    GreenfootImage wall2 = new GreenfootImage("wall4.png");
    
    public void act() 
    {
        Actor under = getOneObjectAtOffset(0,getImage().getHeight() / 2,Wall.class);
        if (under == null)
        {
            setImage(wall2);
        }
    }    
}

