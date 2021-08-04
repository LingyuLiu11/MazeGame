import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ghost extends Actor
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Ghost()
    {
        getImage().scale(getImage().getWidth() / 2, getImage().getHeight() / 2);
    }
    public void act()
    {
        moveAround();
        checkAlive();
    }
    
    public void moveAround()
    {
        move(2);
        if (Greenfoot.getRandomNumber(100) < 10)
        {
            turn(Greenfoot.getRandomNumber(90) - 45);
        }
        if (getX() <= 50 || getX() >= getWorld().getWidth() - 50)
        {
            turn(180);
        }
        
        if (getY() <= 20 || getY() >= getWorld().getHeight() - 100) 
        {
            turn(180);
        }
    }
    
    public void checkAlive() 
    {
        if (MyWorld.GhostKilled == true)
        {
            getWorld().removeObject(this); 
        }
    }
}
