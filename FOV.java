import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * FOV (Field Of View)
 * 
 *
 * 
 */
public class FOV extends Actor
{
    /**
     * Act - do whatever the FOV wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     int width= 928,
         height=672;   
     
     World world = getWorld();
     GreenfootImage bkg;
     public Player pp;
     
    public FOV(Player p)
    {
        bkg = new GreenfootImage("fov.png");
        pp=p;
        setImage(bkg);        
    }
    public void act() 
    {
       setLocation(pp.getX(), pp.getY());
    }    
}
