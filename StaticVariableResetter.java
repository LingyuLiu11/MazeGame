/**
 * StaticvariableResetter
 * 
 * 
 */
public class StaticVariableResetter  
{   
    public static void resetMenuVariables()
    {
        //resetat variabile ce tin de meniu
        Options.gamemode=-1;
        Options.isPlaying=false;    
        Options.scoreWindowShown=false;
        Options.shouldResetText=false;        
    }
    
    public static void resetMyWorldVariables()
    {   
        Player.canMove=true;   
        Options.isPlaying=false; 
        MyWorld.shouldShowVictoryWindow=false;
        MyWorld.VictoryWindowShown=false;      
        MyWorld.shouldSwitchWorld=false;
        ItemCounter.pillTimer=300;
        ItemCounter.shouldCountdownPill=false;   
        Options.gamemode=-1;
    }
}