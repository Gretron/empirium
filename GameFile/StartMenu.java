import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartMenu extends World
{

    /**
     * Constructor for objects of class StartMenu.
     * 
     */
    public StartMenu()
    {    
        super(1280, 720, 1); 
        addObject(new Menu(), 640, 360);
        addObject(new Start(), 640, 240);
        addObject(new Instructions(), 640, 350);
        addObject(new Credits(), 640, 465);
    }
}
