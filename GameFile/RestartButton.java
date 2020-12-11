import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RestartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RestartButton extends Actor {
    private GreenfootImage restart = new GreenfootImage("RestartButton.png");
    
    public RestartButton() {
       setImage(restart);
    }
    public void act() 
    {
        restartButton();
    } 
    private void restartButton() {
        if  (Greenfoot.mouseClicked(this)) {
            MainWorld.music.stop();
            Greenfoot.setWorld(new StartMenu());
        }
    }
}
