import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Start extends Menu
{
    private GreenfootImage animation = new GreenfootImage("StartFP.png");
    private GreenfootImage startButton = new GreenfootImage("StartF.png");
    public void act() 
    {
        startButton();
        animation();
    }
    private void startButton() {
        if  (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new MainWorld());
        }
    }

    public void animation(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            setImage(startButton);
            List objects = getWorld().getObjectsAt(mouse.getX(), mouse.getY(), Start.class);
            for(Object object : objects) {
                if (object == this) {
                    setImage(animation);
                }
            }
        }

    }
}