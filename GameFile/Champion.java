import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Champion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Champion extends Enemy
{
    public Hitbox hitbox;
    public static int speed;
    public static int health;
    public static int damage;
    public final static int ATTACK_SPEED = 1;
    
    private String stand;
    private String walkArray[];
    private String attackArray[];
    
    public Champion(int speed, int health, int damage, String stand, String walkArray[], String attackArray[]) {
        this.speed = speed;
        this.health = health;
        this.damage = damage;
        this.hitbox = new Hitbox(health, health);
        this.stand = stand;
        this.walkArray = walkArray;
        this.attackArray = attackArray;
    }
    
    public void act() 
    {
       walk(this.speed, this.walkArray, stand);
       frames++;
       attackTimer = cooldownTimer(attackTimer);
       enemyAttack(this.speed, ATTACK_SPEED, walkArray, this.attackArray, stand);
       attackCollision();
       gravity();
       counter();
       checkGround();
       if (hitbox.healthValue <= 0) {
           getWorld().removeObject(this);
       }
       if (getWorld() != null) {
           hitbox.setLocation(this.getX(), this.getY());
       }
    }
    
    public boolean attackCollision() {
        List bobius = getIntersectingObjects(Bobius.class);
        for (int i = 0; i < bobius.size(); i++) {
           Hitbox hitbox = ((Bobius)bobius.get(i)).hitbox;
           if (hitbox == this.hitbox) continue;
           if (enemyAttack(this.speed, ATTACK_SPEED, walkArray, this.attackArray, stand) && hitbox != null && Bobius.invincibilityFrame != 1) {
               hitbox.healthValue -= damage;
               hitbox.lowerHealth();
           }
        }
        return false;
    }
}
