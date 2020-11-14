import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemy extends Actor
{
    private GreenfootImage stand2 = new GreenfootImage("Test Sprite Upscaled.png");
    private GreenfootImage stand1 = new GreenfootImage("Test Sprite UpscaledLeft.png");
    
    private GreenfootImage walk1 = new GreenfootImage("WalkingAnimation1.png");
    private GreenfootImage walk2 = new GreenfootImage("WalkingAnimation2.png");
    private GreenfootImage walk3 = new GreenfootImage("WalkingAnimation3.png");
    private GreenfootImage walk4 = new GreenfootImage("WalkingAnimation4.png");
    private GreenfootImage walk5 = new GreenfootImage("WalkingAnimation5.png");
    private GreenfootImage walk6 = new GreenfootImage("WalkingAnimation6.png");
    
    private GreenfootImage walk1L = new GreenfootImage("WalkingAnimationLeft1.png");
    private GreenfootImage walk2L = new GreenfootImage("WalkingAnimationLeft2.png");
    private GreenfootImage walk3L = new GreenfootImage("WalkingAnimationLeft3.png");
    private GreenfootImage walk4L = new GreenfootImage("WalkingAnimationLeft4.png");
    private GreenfootImage walk5L = new GreenfootImage("WalkingAnimationLeft5.png");
    private GreenfootImage walk6L = new GreenfootImage("WalkingAnimationLeft6.png");
    
    private int counter;    
        
    private boolean isStanding;
    private boolean walkedRight;
    private boolean walkedLeft;
    
    // Gravity
    private static final int GRAVITY = 4;
    private int vSpeed;
    
    private final int distance = 150;
    
    public enemy() {
        setImage(stand1);
        isStanding = true;
        walkedRight = false;
        counter = 0;
    }
    
    public void act () {
        gravity();
        counter();
        state();
        checkGround();
    }
    /**
    * To check if there is collision with the ground (this is the collision factor with the ground)
    */
    public void checkGround() {
        if (!isTouching(Ground.class)) {
               vSpeed += GRAVITY;
           }
           else {
               vSpeed = 0;
        }
    }
    /**
    * to set  up gravity so the player falls on the ground and stays there
    */
    public void gravity() {
        setLocation(getX(), getY() + vSpeed);
           
    }
    public boolean direction() {
        int enemyX = getX();
        Actor bobius = (Actor)getWorld().getObjects(Bobius.class).get(0);
        int bobiusX = bobius.getX();
        if (enemyX - bobiusX < 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public boolean closeProximity() {
        int enemyX = getX();
        Actor bobius = (Actor)getWorld().getObjects(Bobius.class).get(0);
        int bobiusX = bobius.getX();
        if (enemyX > bobiusX - distance && enemyX < bobiusX + distance) {
            return true;
        }
        else {
            return false;
        }
    }
    /**
     * 
     */
    public void counter(){
        if (counter < 25){
            counter++;
        }
        else {
            counter = 0;
        }
    }
    
    public boolean isWalkingLeft(){
        if(!direction()){
          walkedLeft = true;
          walkedRight = false;
          return true;
        }
        return false;
    }
    public boolean isWalkingRight(){
        if (direction()){
            walkedRight = true;
            walkedLeft = false;
            return true;
        }
        return false;
    }
    public void state(){
        if (isWalkingRight() && !closeProximity()){
            if (counter % 5 == 0){
                setLocation(getX() + 13,getY());
                enemyWalkAnimationR();
            }
        }
        
        else if (isWalkingLeft() && !closeProximity()){
            if (counter % 5 == 0){
                setLocation(getX() - 13,getY());
                enemyWalkAnimationL();
            }
        }
        else if(!direction()) {
            isStandingRight();
        }
        else if(direction()) {
            isStandingLeft();
        }
    }
    public void isStandingRight(){
         setImage(stand1);
    }
        
    public void isStandingLeft(){
        setImage(stand2);
        
    }
    
    public void enemyWalkAnimationR(){
        if (getImage() == stand1 || getImage() == stand2){
            setImage(walk1);
        }
        else if (getImage() == walk1){
            setImage(walk2);
        }
        else if (getImage() == walk2){
            setImage(walk3);
        }
        else if (getImage() == walk3){
            setImage(walk4);
        }
        else if (getImage() == walk4){
            setImage(walk5);
        }
        else if (getImage() == walk5) {
            setImage(walk6);
        }
        else {
            setImage(walk1);
        }
    }
    public void enemyWalkAnimationL(){
       if (getImage() == stand1 || getImage() == stand2){
            setImage(walk1L);
        }
        else if (getImage() == walk1L){
            setImage(walk2L);
        }
        else if (getImage() == walk2L){
            setImage(walk3L);
        }
        else if (getImage() == walk3L){
            setImage(walk4L);
        }
        else if (getImage() == walk4L){
            setImage(walk5L);
        }
        else if (getImage() == walk5L) {
            setImage(walk6L);
        }
        else {
            setImage(walk1L);
        }
    }
    
}

    



