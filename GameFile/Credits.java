import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Credits here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Credits extends Menu
{
    /**
     * Act - do whatever the Credits wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        creditButton();
    }    
     private void creditButton() {
        if  (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new CreditWorld());
        }
   }
}
