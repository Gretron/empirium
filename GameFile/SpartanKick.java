import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpartanKick here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpartanKick extends Actor
{
    private String[] spartanKickA = {"SpartanKick1.png", "SpartanKick2.png", "SpartanKick3.png", "SpartanKick4.png", "SpartanKick5.png", "SpartanKick6.png", "SpartanKick7.png"};
    
    private int kickImg = 0;
    public static int level = 1;
    private int counter = 0;
    private static int cost = 140;
    public SpartanKick() {
        GreenfootImage initialImg = new GreenfootImage(spartanKickA[0]);
        setImage(initialImg);
    }
    public void act() {
        if (getWorld() instanceof BuyScreen) {
            getWorld().showText("Level: " + level, getX(), getY() - 150);
            getWorld().showText("Cost: " + cost, getX(), getY() + 100);
            if (Greenfoot.mouseClicked(this) && MainWorld.points > 0) {
                if (MainWorld.points - cost > 0) {
                    level++;
                    Bobius.kickDamage += 3;
                    MainWorld.points -= cost;
                    cost += 25;
                }
            }
        }
        if (getWorld() instanceof MainWorld) {
            counter++;
            cooldownAnimation();
        }
        if (counter == 135)
            counter = 0;
    } 
    
    private void cooldownAnimation() {
        if (Bobius.kickTimer < 15 || kickImg != 0) {
            if (counter % 130 == 0)
                kickImg++;
            if (kickImg >= spartanKickA.length) {
                kickImg = 0;
            }
            GreenfootImage newImage = new GreenfootImage(spartanKickA[kickImg]);
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
