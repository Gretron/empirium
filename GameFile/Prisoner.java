import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Prisoner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Prisoner extends enemy
{
    public Hitbox hitbox; 
    public Prisoner() {
       this.hitbox = new Hitbox();
    }
    public void act() {
       gravity();
       counter();
       state();
       checkGround();
       if (hitbox.healthValue <= 0) {
           getWorld().removeObject(this);
           //Remove hitbox after Prisoner dies *****************************************
       }
    }        
}
