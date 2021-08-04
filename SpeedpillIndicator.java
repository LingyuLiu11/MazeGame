import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 */
public class SpeedpillIndicator extends Actor
{
    public SpeedpillIndicator()
    {
        setImage(new GreenfootImage("speedpill.png"));

        getImage().setTransparency(120);        
    }
    public void act() 
    {
        if (ItemCounter.shouldCountdownPill == true)
            {
                getImage().setTransparency(255);
            }
            else
            {
                getImage().setTransparency(120);    
            }
    }    
}
