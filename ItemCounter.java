import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * ItemCounter
 * 
 * 
 */
public class ItemCounter extends Actor
{
    public static int[] gems_taken = new int[4]; 
    int ok, s;
    static int pillTimer=300, 
               defaultSpeed=2; 
               
    static boolean shouldCountdownPill=false; 

    public void act() 
    {
        checkPillCountdown();
    }  
    
    private void checkPillCountdown()
    {
        if(shouldCountdownPill)
        {
            if(pillTimer>0)
                pillTimer--;
            else
                {
                    Player.speed=defaultSpeed;
                    shouldCountdownPill=false;
                }
                
        }        
    }
}