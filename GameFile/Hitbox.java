
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class hitbox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hitbox extends Actor
{
    GreenfootImage hitbox = new GreenfootImage("Hitbox rect.png"); 
    public Prisoner prisoner;
    public Champion champion;
    public HealthBar healthbar;
    public final int maxHealthValue;
    public int healthValue;
    public int invincibility = 0;
    public Hitbox() {
        this(0, 0);
    }
    
    public Hitbox(int healthValue, int maxHealthValue) {
        hitbox.scale(hitbox.getWidth() - 200, hitbox.getHeight());
        this.healthValue = healthValue;
        this.maxHealthValue = maxHealthValue;
        this.healthbar = new HealthBar();
    }
   
    public Hitbox(Prisoner prisoner) {
        this();
        this.prisoner = prisoner;
        this.champion = null;
    }
    
    public Hitbox(Champion champion) {
        this();
        this.prisoner = null;
        this.champion = champion;
    }
   
    public void act() 
    {  
         BoxOfHit();
         Bobius bobius = getWorld().getObjects(Bobius.class).get(0);
         if (bobius.hitbox == this) {
             setLocation(bobius.getX(), bobius.getY());
         }
         if (healthValue <= 0) {
            getWorld().removeObject(this);
         } 
         if (getWorld() != null) {
           healthbar.setLocation(this.getX() - 5, this.getY() - 175);
         } 
    }
    
    public void disappear() {       
        invincibility = 1;
    }
    
    public void lowerHealth() {
        healthbar.health = (int) Math.ceil((double) healthValue / maxHealthValue * 100);
    }
    
    public void BoxOfHit() {
        setImage(hitbox);
    }
}
