import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CreditWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreditWorld extends World
{

    /**
     * Constructor for objects of class CreditWorld.
     * 
     */
    public CreditWorld()
    {    
        super(1280, 720, 1); 
        addObject(new Creds(), 640, 360);
        addObject(new BackButton(), 200, 600);
    }
}
