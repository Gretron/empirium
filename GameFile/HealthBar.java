
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class HealthBar extends Actor
{
    int health = 100;
    int barWidth = 100;
    int barHeight = 10;
    public Hitbox hitbox;
    public HealthBar() {
        update();
    }

    public void act() 
    {
        update();
        if (health <= 0) {
            getWorld().removeObject(this);
        }
    }

    public void update() {
        setImage(new GreenfootImage(barWidth + 2, barHeight + 2));
        getImage().setColor(Color.BLACK);
        getImage().drawRect(0, 0, barWidth + 1, barHeight + 1);
        getImage().setColor(Color.GREEN);
        getImage().fillRect(1, 1, health, barHeight);
    }
}
