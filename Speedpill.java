import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Speedpill
 * 
 */
public class Speedpill extends Item
{
    static GreenfootSound sound = new GreenfootSound("speedSound.wav");
    public Speedpill()
    {
        getImage().scale(getImage().getWidth()*2/3,getImage().getHeight()*2/3);       
        sound.setVolume(80);
    }
    
    public void act() 
    {
        checkPlayerCollision();
    }
    
    private void checkPlayerCollision()
    {
       if (getOneIntersectingObject(Player.class) != null)
        {
            ItemCounter.shouldCountdownPill=true;
            ItemCounter.pillTimer=300;
            Player.speed=4;
            getWorld().removeObject(this);
        }         
    }
}

