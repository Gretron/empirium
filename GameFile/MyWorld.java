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
        
        Prisoner prisoner = new Prisoner();
        addObject(prisoner, 1100 , 410);
        addObject(prisoner.hitbox, 1100, 410);
        addObject(prisoner.hitbox.healthbar, 1095, 235);
        
        Champion champion = new Champion();
        addObject(champion, 400, 410);
        addObject(champion.hitbox, 400, 410);
        addObject(champion.hitbox.healthbar, 395, 235);
        
        addObject(new RestartButton(), 1220, 55);
        addObject(new SecondBackground(), 640, 360);
        addObject(new Pillar(), 1280, 360);
        Pillar pillar = new Pillar();
        pillar.getImage().mirrorHorizontally();
        addObject(pillar, 0, 360);
   
        setPaintOrder(RestartButton.class, Pillar.class, Bobius.class, HealthBar.class, Bird.class, Prisoner.class, Champion.class, SecondBackground.class,
                Hitbox.class, Ground.class, World.class);
    }
    public void act() {
        spawnRandBird();
        //spawnRandPris();
        showText("" + points, 10, 700);
    }
    
    /*
    public void spawnRandPris() {
       int randNum = Greenfoot.getRandomNumber(350); 
        int spawnNum = 10;
        if (randNum == spawnNum && getObjects(Prisoner.class).size() < 3 ) {
            if (Greenfoot.getRandomNumber(2) == 1) {
                Prisoner prisoner = new Prisoner();
                addObject(prisoner, 1255 , 410);
                addObject(prisoner.hitbox, 1255, 410);
                addObject(prisoner.hitbox.healthbar, 1250, 235);
            }
            else {
                Prisoner prisoner = new Prisoner();
                addObject(prisoner, 25 , 410);
                addObject(prisoner.hitbox, 25, 410);
                addObject(prisoner.hitbox.healthbar, 20, 235);
            }
        }
    }
    */
    public void spawnRandBird() {
        int randNum = Greenfoot.getRandomNumber(350); 
        int spawnNum = 10;
        Bird bird = new Bird();
        if (randNum == spawnNum && getObjects(Bird.class).isEmpty()) {
            if (Greenfoot.getRandomNumber(2) == 1)
                addObject(new Bird(), 1255, 115);
            else {
                addObject(new Bird(), 25, 115);
                bird.move(3);
            }
        }
    }
}
