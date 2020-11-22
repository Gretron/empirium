import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Bird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bird extends Actor
{
    private GreenfootImage bird1L = new GreenfootImage("BirdWingUp.png");
    private GreenfootImage bird2L = new GreenfootImage("BirdWingDown.png");
    private GreenfootImage bird1R = new GreenfootImage("BirdDownR.png");
    private GreenfootImage bird2R = new GreenfootImage("BirdUpR.png");
    private static int birdXLocation = -1;
    private int kill = 0;
    private int frame = 0;
    public Bird() {
        bird1L.scale(bird1L.getWidth() * 3, bird1L.getHeight() * 3);
        setImage(bird1L);
        bird2L.scale(bird2L.getWidth() * 3, bird2L.getHeight() * 3);
        setImage(bird2L);
        bird1R.scale(bird1R.getWidth() * 3, bird1R.getHeight() * 3);
        setImage(bird1R);
        bird2R.scale(bird2R.getWidth() * 3, bird2R.getHeight() * 3);
        setImage(bird2R);
    }
    /**
     * Act - do whatever the Bird wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       removeAtEdge();
       movement();
    }   
     /**
     * bird animation
     */
    public void animateBirdR() {
        frame++;
        if (frame == 7) {
            setImage(bird2R);
        }
        else if (frame == 14) {
            setImage(bird1R);
            frame = 0;
        }
    }
    public void animateBirdL() {
        frame++;
        if (frame == 7) {
            setImage(bird2L);
        }
        else if (frame == 14) {
            setImage(bird1L);
            frame = 0;
        }
    }
    public void movement() {
        int moveSteps = 3;
        kill++;
        if (getWorld() == null) return; 
        if (birdXLocation == -1 || (birdXLocation > this.getX() - moveSteps && birdXLocation < this.getX() + moveSteps)) {
            birdXLocation = Greenfoot.getRandomNumber(1250) + 20;
            if (kill >= 2000) {
                birdXLocation = birdXLocation * 0;
            }
        }
        if (birdXLocation > this.getX()) {
            move(moveSteps);
        }
        else {
            move(moveSteps * -1);
        }
        getWorld().showText("" + kill, 1220, 700);
    }
    
    public void removeAtEdge() {
        if (isAtEdge()) {
           getWorld().removeObject(this);
        }
    }
    
    @Override
    public void move(int num) {
        super.move(num);
        if (num < 0) animateBirdL();
        else animateBirdR();
    }
}
