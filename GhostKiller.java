import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GhostKiller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GhostKiller extends Item
{
    /**
     * Act - do whatever the GhostKiller wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
       if(getOneIntersectingObject(Player.class)!=null)
            {
                MyWorld.GhostKilled = true;  
                getWorld().removeObject(this);
            }
    }
}
