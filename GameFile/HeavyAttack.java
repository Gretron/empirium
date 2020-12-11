import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HeavyAttack here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HeavyAttack extends Actor
{
    private String[] heavyAttackA = {"HeavyWidget1.png", "HeavyWidget2.png", "HeavyWidget3.png", "HeavyWidget4.png", "HeavyWidget5.png", "HeavyWidget6.png", "HeavyWidget7.png"};
    public static int level = 1;
    private int heavyAttackImg = 0;
    private static int cost = 60;
    public HeavyAttack() {
        GreenfootImage initialImg = new GreenfootImage(heavyAttackA[0]);     
        setImage(initialImg);
    }
    public void act() {
        if (getWorld() instanceof BuyScreen) {
            getWorld().showText("Level: " + level, getX(), getY() - 150);
            getWorld().showText("Cost: " + cost, getX(), getY() + 100);
            if (Greenfoot.mouseClicked(this) && MainWorld.points > 0) {
                if (MainWorld.points - cost > 0) {
                    level++;
                    Bobius.heavyDamage += 2;
                    MainWorld.points -= cost;
                    cost += 15;
                }
            }
        }
        if (getWorld() instanceof MainWorld) {
            cooldownAnimation();
        }
    }
    
    private void cooldownAnimation() {
        if (Bobius.heavyAttackTimer < 3 || heavyAttackImg != 0) {
            if (Bobius.counter % 26 == 0)
                heavyAttackImg++;
            if (heavyAttackImg >= heavyAttackA.length) {
                heavyAttackImg = 0;
            }
            GreenfootImage newImage = new GreenfootImage(heavyAttackA[heavyAttackImg]);
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
