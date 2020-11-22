import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public int points = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(1280, 720, 1); 
        addObject(new Bobius(), 100, 410);
        addObject(new Ground(), 640, 650);
        //for (int i = 1; i <= 3; i++) {
            Prisoner prisoner = new Prisoner();
            addObject(prisoner, 1100 , 410);
            addObject(prisoner.hitbox, 1100, 400);
        //}
        addObject(new RestartButton(), 1220, 55);
        addObject(new SecondBackground(), 640, 360);
        addObject(new Pillar(), 1250, 360);
        Pillar pillar = new Pillar();
        pillar.getImage().mirrorHorizontally();
        addObject(pillar, 30, 360);
        setPaintOrder(RestartButton.class, Pillar.class, Bobius.class, Bird.class, Prisoner.class, SecondBackground.class, Hitbox.class, Ground.class, World.class);
    }
    public void act() {
        spawnRandBird();
        showText("" + points, 10, 700);
    }
    public void spawnRandBird() {
        int randNum = Greenfoot.getRandomNumber(350); 
        int spawnNum = 10;
        Bird bird = new Bird();
        if (randNum == spawnNum && getObjects(Bird.class).isEmpty()) {
            if (Greenfoot.getRandomNumber(2) == 1)
                addObject(new Bird(), 1220, 115);
            else {
                addObject(new Bird(), 60, 115);
                bird.move(3);
            }
        }
    }
}
