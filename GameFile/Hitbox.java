
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hitbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hitbox extends Actor
{
    GreenfootImage hitBox = new GreenfootImage("Hitbox rect.png");      
    
    public Hitbox() {
        hitBox.scale(hitBox.getWidth() - 200, hitBox.getHeight());
    }
    /**
     * Act - do whatever the Hitbox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {  
         followBob();
         BoxOfHit();
    }    
    private void followBob() {
        Actor prisoner = (Actor)getWorld().getObjects(Prisoner.class).get(0);
        setLocation(prisoner.getX(), prisoner.getY());
    }
    public void BoxOfHit() {
            setImage(hitBox);
    }
}
