import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Champion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Champion extends enemy
{
    public Hitbox hitbox;
    public int speed;
    public int health;
    public int damage;
    
    public Champion() {
        this(0, 45, 0);
    }
    
    public Champion(int speed, int health, int damage) { //, String imagePath) {
        this.speed = speed;
        this.health = health;
        this.damage = damage;
        this.hitbox = new Hitbox(health, health);
        //GreenfootImage image = new GreenfootImage(imagePath);
        //setImage(imagePath);
    }
    
    public void act() 
    {
       gravity();
       counter();
       state();
       checkGround();
       if (hitbox.healthValue <= 0) {
           getWorld().removeObject(this);
       }
       if (getWorld() != null) {
           hitbox.setLocation(this.getX(), this.getY());
       }
    }    
}