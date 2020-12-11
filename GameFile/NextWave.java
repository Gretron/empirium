import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class NextWave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NextWave extends Actor
{
    /**
     * Act - do whatever the NextWave wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        nextWaveButton();
    }
    
    public void nextWaveButton() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new MainWorld());
            MainWorld.waveNum++;
            Prisoner.damage += 1;
            if (MainWorld.waveNum > 3) {
                Greenfoot.setWorld(new PostCycleMessage());
            }
        }
    }
}
