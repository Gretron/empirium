import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dodge here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dodge extends Actor
{
    private String[] dodgeA = {"DodgeWidget1.png", "DodgeWidget2.png", "DodgeWidget3.png", "DodgeWidget4.png", "DodgeWidget5.png", "DodgeWidget6.png", "DodgeWidget7.png"};
    private int rollImg = 0;
    private int counter = 0;
    
    public Dodge() {
        GreenfootImage initialImg = new GreenfootImage(dodgeA[0]);
        setImage(initialImg);
    }
    public void act() 
    {   
        if (getWorld() instanceof MainWorld) {
            counter++;
            cooldownAnimation();
        }
        else if (getWorld() instanceof BuyScreen) {
            getWorld().showText("Not Upgradeable", getX(), getY() - 150);
            getWorld().showText("Not Upgradeable", getX(), getY() + 100);
        }
        if (counter >= 35) {
            counter = 0;
        }
    } 
    
    private void cooldownAnimation() {
        if (Bobius.rollTimer < 4 ||rollImg != 0) {
            if (counter % 20  == 0)
                rollImg++;
            if (rollImg >= dodgeA.length) {
                rollImg = 0;
            }
            GreenfootImage newImage = new GreenfootImage(dodgeA[rollImg]);
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
