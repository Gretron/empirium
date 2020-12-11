import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LightAttack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LightAttack extends Actor
{
    public String[] lightAttackA = {"LightWidget1.png", "LightWidget2.png", "LightWidget3.png", "LightWidget4.png", "LightWidget5.png", "LightWidget6.png", "LightWidget7.png"};
    int lightAttackImg = 0;
    public static int level = 1;
    public static int cost = 40;
    public LightAttack() {
        GreenfootImage initialImg = new GreenfootImage(lightAttackA[0]); 
        setImage(initialImg);
    }
    public void act() {
        if (getWorld() instanceof BuyScreen) {
            getWorld().showText("Level: " + level, getX(), getY() - 150);
            getWorld().showText("Cost: " + cost, getX(), getY() + 100);
            if (Greenfoot.mouseClicked(this) && MainWorld.points > 0) {
                if (MainWorld.points - cost > 0) {
                    level++;
                    Bobius.lightDamage += 1;
                    MainWorld.points -= cost;
                    cost += 20;
                }
            }
        }
        if (getWorld() instanceof MainWorld) {
            cooldownAnimation();
        }
    }
    
    private void cooldownAnimation() {
        if (Bobius.counter < 60 && Bobius.lightAttackTimer == 0 || lightAttackImg != 0) {
            if (Bobius.counter % 9 == 0)
                lightAttackImg++;
            if (lightAttackImg >= lightAttackA.length) {
                lightAttackImg = 0;
            }
            GreenfootImage newImage = new GreenfootImage(lightAttackA[lightAttackImg]);
            newImage.scale(newImage.getWidth() / 2, newImage.getHeight() / 2);
            setImage(newImage);
        }
    }
    
    @Override
    protected void addedToWorld(World world) {
        if (world instanceof MainWorld)
            getImage().scale(getImage().getWidth() / 2, getImage().getHeight() / 2);
    }
}
