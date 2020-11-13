import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Prisoner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Prisoner extends enemy
{
    private GreenfootImage walk1 = new GreenfootImage("WalkingAnimation1.png");
    private GreenfootImage walk2 = new GreenfootImage("WalkingAnimation2.png");
    private GreenfootImage walk3 = new GreenfootImage("WalkingAnimation3.png");
    private GreenfootImage walk4 = new GreenfootImage("WalkingAnimation4.png");
    private GreenfootImage walk5 = new GreenfootImage("WalkingAnimation5.png");
    private GreenfootImage walk6 = new GreenfootImage("WalkingAnimation6.png");
    /**
     * Act - do whatever the Prisoner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       gravity();
       counter();
       state();
       checkGround();
    }    
}
