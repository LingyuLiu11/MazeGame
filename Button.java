import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    World world = getWorld();
    GreenfootImage btn = new GreenfootImage("btn.png");
    GreenfootImage btn_pressed = new GreenfootImage("btn_pressed.png");
    GreenfootImage btn_hovered = new GreenfootImage("btn_hovered.png");
    GreenfootImage btn1 = new GreenfootImage("btn.png");
    GreenfootImage btn1_pressed = new GreenfootImage("btn_pressed.png");    
    GreenfootImage btn1_hovered = new GreenfootImage("btn_hovered.png");     
    private int cr=5;
    private double aux=0.1;
    String[] text = new String [3];
    int type,btnPosY,lg,typ,mvp;
    private boolean onThis=false;

    String txt;
    int fontSize = 26;
    public Button(int type)
    {
        text[0]="Hard Mode";
        text[1]="Easy Mode";
        text[2]="Best Score";
        
        txt = text[type];
        GreenfootImage t = new GreenfootImage(fontSize*txt.length()+fontSize, fontSize);
        //t.setFont(new Font("Serif", Font.PLAIN, fontSize));
        //t.setColor(Color.WHITE);
        t.drawString(txt, 22, 20);
        
        btnPosY=240+type*90;
        mvp=335+100*type;
        btn1.drawImage(t,(btn1_pressed.getWidth()-((fontSize/2)*txt.length()+fontSize))/2-25, btn1.getHeight()/2-fontSize/2);
        btn1_hovered.drawImage(t,(btn1_pressed.getWidth()-((fontSize/2)*txt.length()+fontSize))/2-2, btn1.getHeight()/2-fontSize/2);        
        btn1_pressed.drawImage(t,(btn1_pressed.getWidth()-((fontSize/2)*txt.length()+fontSize))/2, btn1_pressed.getHeight()/2-fontSize/2+4);
        setImage(btn1);
        typ = type;
    }
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.mouseMoved(null))
            onThis = Greenfoot.mouseMoved(this);
            
         if(onThis)
            {
                setImage(btn1_hovered); 
                showButtonTooltip();
            }
            else
           {                        
               setImage(btn1);
           }
        
        if (Greenfoot.mouseClicked(this))
            {
                
                setImage(btn1_pressed);
                Greenfoot.delay(5);
                getWorld().showText(" ", 473,640);
                Options.gamemode = typ + 1;
            }
      
      if(getY()>btnPosY)
                moveUp(mvp);
    }
    
    void moveUp(int zone)
    {
        setLocation(this.getX(),this.getY()-(int)cr);
        if(getY()<zone && cr>3)
            cr-=aux;
    }
    
    void showButtonTooltip()
    {
        if(getY()<=btnPosY)
            switch (typ)
            {
                case 0:
                {
                    getWorld().showText("A Ghost is haunting!", 473,540);
                    break;
                }
                case 1:
                {
                    getWorld().showText("No Ghost. You are safe!", 473,540);
                    break;
                }
                case 2:
                {
                    getWorld().showText("See Best Score", 473,540);
                    break;
                }                
        }
    }
}
