import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * 
 */
public class Player extends Actor
{
    static int speed=2; 
    int frame,
        delay=14; 
        
    GreenfootImage r1 = new GreenfootImage("right1.png");
    GreenfootImage r2 = new GreenfootImage("right2.png");
    GreenfootImage r3 = new GreenfootImage("right3.png");
    GreenfootImage l1 = new GreenfootImage("left1.png");
    GreenfootImage l2 = new GreenfootImage("left2.png");
    GreenfootImage l3 = new GreenfootImage("left3.png");
    GreenfootImage f1 = new GreenfootImage("front1.png");
    GreenfootImage f2 = new GreenfootImage("front2.png");
    GreenfootImage f3 = new GreenfootImage("front3.png");
    GreenfootImage b1 = new GreenfootImage("back1.png");
    GreenfootImage b2 = new GreenfootImage("back2.png");
    GreenfootImage b3 = new GreenfootImage("back3.png");
    
    static boolean canMove = true;
    int playerLives = 2;

    public void act() 
    {
        checkKeys();
        PlayerHit();
        YouWin();
        YouLose();
    }    
    void checkKeys()
    {
        if (canMove==true)
        {
            if (Greenfoot.isKeyDown("left"))
                moveLeft();
            if (Greenfoot.isKeyDown("right"))
                moveRight();     
            if (Greenfoot.isKeyDown("up"))
                moveUp();
            if (Greenfoot.isKeyDown("down"))
                moveDown();     
        }
    }
    void moveLeft()
    {
        move(-speed);
        if (getOneIntersectingObject(Wall.class) != null) 
            move(speed);
         frame++;
        if(frame < 1 * delay)
        {
            setImage(l1);
        }
        else if(frame < 2 * delay)
        {
            setImage(l2);
        }
        else if (frame < 3 * delay)
        {
            setImage(l3);
        }
        else {frame = 1; return;}
    }
        void moveRight()
    {
        move(speed);    
        if (getOneIntersectingObject(Wall.class) != null) 
            move(-speed);
                     frame ++;                 
        if(frame < 1 * delay)
        {
            setImage(r1);
        }
        else if(frame < 2 * delay)
        {
            setImage(r2);
        }
        else if (frame < 3 * delay)
        {
            setImage(r3);

        }
        else {frame = 1; return;}
    }
    void moveUp()
    {
        setLocation(getX(),getY()-speed);
        if (getOneIntersectingObject(Wall.class) != null) 
          setLocation(getX(),getY()+speed);
         frame ++;
         
        if(frame < 1 * delay)
        {
            setImage(b1);
        }
        else if(frame < 2 * delay)
        {
            setImage(b2);
        }
        else if (frame < 3 * delay)
        {
            setImage(b3);

        }
        else {frame = 1; return;}        
    }
    void moveDown()
    {
        setLocation(getX(),getY()+speed);
        if (getOneIntersectingObject(Wall.class) != null) 
          setLocation(getX(),getY()-speed); 
         frame ++;
         
        if(frame < 1 * delay)
        {
            setImage(f1);
        }
        else if(frame < 2 * delay)
        {
            setImage(f2);
        }
        else if (frame < 3 * delay)
        {
            setImage(f3);

        }
        else {frame = 1; return;}        
    }    
    
    public void YouWin()
    {
        if (getOneIntersectingObject(Wall.class) != null)
        {
            getWorld().addObject(new VictoryWindow(), getWorld().getWidth() / 2, getWorld().getHeight() / 2);
            canMove = false;
            Greenfoot.stop();
        }
    }
    
    public void PlayerHit() 
    {
        if (hitEnemy())
        {
            playerLives--;
        }
    }
    
    public boolean hitEnemy()
    {
        if (isTouching(Ghost.class)) 
        {
            return true;    
        }
        
        return false;
    }
    
    public void YouLose()
    {
        if (playerLives == 0)
        {
            MyWorld.shouldShowLoseWindow=true;
        }
    }

    }
