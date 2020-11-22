
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
    public Prisoner prisoner;
    public int healthValue = 30;
    public Hitbox() {
        hitBox.scale(hitBox.getWidth() - 200, hitBox.getHeight());
    }
    
    public Hitbox(Prisoner prisoner) {
        this();
        this.prisoner = prisoner;
    }
   
    public void act() 
    {  
         followBob();
         BoxOfHit();
    }    
    private void followBob() {
        if (!getWorld().getObjects(Prisoner.class).isEmpty()) {
            Actor prisoner = (Actor)getWorld().getObjects(Prisoner.class).get(0);
            setLocation(prisoner.getX(), prisoner.getY());
        }
    }
    public void BoxOfHit() {
            setImage(hitBox);
    }
}
