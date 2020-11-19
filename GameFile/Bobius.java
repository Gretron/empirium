import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
* Write a description of class Bobius here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
public class Bobius extends Actor {
    // Standing Right Frame
    private GreenfootImage standR = new GreenfootImage("Stand.png");
    
    // Standing Left Frame
    private GreenfootImage standL = new GreenfootImage("StandL.png");
    
    // Walking Right Frames
    private GreenfootImage walk1 = new GreenfootImage("WalkingAnimation1.png");
    private GreenfootImage walk2 = new GreenfootImage("WalkingAnimation2.png");
    private GreenfootImage walk3 = new GreenfootImage("WalkingAnimation3.png");
    private GreenfootImage walk4 = new GreenfootImage("WalkingAnimation4.png");
    private GreenfootImage walk5 = new GreenfootImage("WalkingAnimation5.png");
    private GreenfootImage walk6 = new GreenfootImage("WalkingAnimation6.png");
    
    // Walking Left Frames
    private GreenfootImage walk1L = new GreenfootImage("WalkingAnimationL1.png");
    private GreenfootImage walk2L = new GreenfootImage("WalkingAnimationL2.png");
    private GreenfootImage walk3L = new GreenfootImage("WalkingAnimationL3.png");
    private GreenfootImage walk4L = new GreenfootImage("WalkingAnimationL4.png");
    private GreenfootImage walk5L = new GreenfootImage("WalkingAnimationL5.png");
    private GreenfootImage walk6L = new GreenfootImage("WalkingAnimationL6.png");
    
    // Rolling Right Frames
    private GreenfootImage roll1 = new GreenfootImage("RollingAnimation0.png");
    private GreenfootImage roll2 = new GreenfootImage("RollingAnimation1.png");
    private GreenfootImage roll3 = new GreenfootImage("RollingAnimation2.png");
    private GreenfootImage roll4 = new GreenfootImage("RollingAnimation3.png");
    private GreenfootImage roll5 = new GreenfootImage("RollingAnimation4.png");
    private GreenfootImage roll6 = new GreenfootImage("RollingAnimation5.png");
    private GreenfootImage roll7 = new GreenfootImage("RollingAnimation6.png");
    private GreenfootImage roll8 = new GreenfootImage("RollingAnimation7.png");
    private GreenfootImage roll9 = new GreenfootImage("RollingAnimation8.png");
    
    // Rolling Left Frames
    private GreenfootImage roll1L = new GreenfootImage("RollingAnimationL0.png");
    private GreenfootImage roll2L = new GreenfootImage("RollingAnimationL1.png");
    private GreenfootImage roll3L = new GreenfootImage("RollingAnimationL2.png");
    private GreenfootImage roll4L = new GreenfootImage("RollingAnimationL3.png");
    private GreenfootImage roll5L = new GreenfootImage("RollingAnimationL4.png");
    private GreenfootImage roll6L = new GreenfootImage("RollingAnimationL5.png");
    private GreenfootImage roll7L = new GreenfootImage("RollingAnimationL6.png");
    private GreenfootImage roll8L = new GreenfootImage("RollingAnimationL7.png");
    private GreenfootImage roll9L = new GreenfootImage("RollingAnimationL8.png");
    
    // attack left frames
    private GreenfootImage attack1L = new GreenfootImage("LightAttackL1.png"); 
    private GreenfootImage attack2L = new GreenfootImage("LightAttackL2.png"); 
    private GreenfootImage attack3L = new GreenfootImage("LightAttackL3.png"); 
    private GreenfootImage attack4L = new GreenfootImage("LightAttackL4.png"); 
    private GreenfootImage attack5L = new GreenfootImage("LightAttackL5.png"); 
    private GreenfootImage attack6L = new GreenfootImage("LightAttackL6.png"); 
    
    // attack right frames 
    private GreenfootImage attack1R = new GreenfootImage("LightAttack1.png"); 
    private GreenfootImage attack2R = new GreenfootImage("LightAttack2.png"); 
    private GreenfootImage attack3R = new GreenfootImage("LightAttack3.png"); 
    private GreenfootImage attack4R = new GreenfootImage("LightAttack4.png"); 
    private GreenfootImage attack5R = new GreenfootImage("LightAttack5.png"); 
    private GreenfootImage attack6R = new GreenfootImage("LightAttack6.png"); 
    
    // Counters
    private int counter;
    
    private int rollCounter;
    
    // Reload Values
    private final int rollReload = 120;
    private final int rollDelay = 40;
    
    // Memory Variables
    private boolean isStanding;
    private boolean walkedR;
    private boolean walkedL;
    
    public boolean rolled;
    public boolean isRollingR;
    public boolean isRollingL;
    
    private boolean isAttackingL;
    private boolean isAttackingR;
    private boolean attacked;
    
    // Gravity Variables
    private static final int GRAVITY = 4;
    private int vSpeed;
    
    // Jump
    private int jumpSpeed = 0; // Vertical Jump Speed 
    private int jumpStrength = -40;
    private int jumpDelay = 0;
    
    // CONSTRUCTOR
    
    /**
    * 
    */
    public Bobius(){
        setImage(standR);
        isStanding = true;
        walkedR = false;
        walkedL = false;
        rolled = false;
        isRollingR = false;
        isRollingL = false;
        isAttackingL = false;
        isAttackingR = false;
        attacked = false;
        rollCounter = rollReload;
        counter = 0;
    }
    
    /**
    * Act - do whatever the Bobius wants to do. This method is called whenever
    * the 'Act' or 'Run' button gets pressed in the environment.
    */
    public void act(){
        // State
        state();
        attackCollision();
        // Animation Counter
        counter();
        
        // Delay Counter
        rollCounter++;
        
        
        // Gravity
        checkFall();
        isJumping();
        checkGround();
        gravity();
    }
    
    // MAIN STATE
    
    public void state(){ 
        // Rolling Right State
        if(isRollingR() || isRollingR){
           if (rollCounter < rollDelay){
               rollingAnimationR();
           }
           else {
               rolled = false;
               isRollingR = false;
           }
        }
        
        // Rolling Left State
        else if(isRollingL() || isRollingL){
           if (rollCounter < rollDelay){
               rollingAnimationL();
           }
           else {
               rolled = false;
               isRollingL = false;
           }
        }
        if (isAttackingL() || isAttackingL) {
            attackAnimationL();
        }
        if (isAttackingR() || isAttackingR) {
            attackAnimationR();
        }
        
        // Walking Right State
        else if (isWalkingR() && !isRollingR && !isRollingL){
           walkAnimationR();
        }
        
        // Walking Left State
        else if (isWalkingL() && !isRollingR && !isRollingL){
            walkAnimationL();
        }
        
        // Standing Right State
        else if(!isWalkingR() && walkedR) {
           isStandingR();
        }
        
        // Standing Left State
        else if(!isWalkingL() && walkedL) {
           isStandingL();
        }
    }
    
    // ANIMATION METHODS
    
    public void rollingAnimationR(){
        if (counter % 4 == 0){
           setLocation(getX() + 50, getY());
           if (getImage() == standR){
               setImage(roll1);
           }
           else if (getImage() == roll1){
               setImage(roll2);
           }
           else if (getImage() == roll2){
               setImage(roll3);
           }
           else if (getImage() == roll3){
               setImage(roll4);
           }
           else if (getImage() == roll4){
               setImage(roll5);
           }
           else if (getImage() == roll5) {
               setImage(roll6);
           }
           else if (getImage() == roll6) {
               setImage(roll7);
           }
           else if (getImage() == roll7) {
               setImage(roll8);
           }
           else if (getImage() == roll8) {
               setImage(roll9);
           }
           else {
               setImage(roll1);
           }
        }
    }
    
    public void rollingAnimationL(){
        if (counter % 4 == 0){
           setLocation(getX() - 50, getY());
           if (getImage() == standL){
               setImage(roll1L);
           }
           else if (getImage() == roll1L){
               setImage(roll2L);
           }
           else if (getImage() == roll2L){
               setImage(roll3L);
           }
           else if (getImage() == roll3L){
               setImage(roll4L);
           }
           else if (getImage() == roll4L){
               setImage(roll5L);
           }
           else if (getImage() == roll5L) {
               setImage(roll6L);
           }
           else if (getImage() == roll6L) {
               setImage(roll7L);
           }
           else if (getImage() == roll7L) {
               setImage(roll8L);
           }
           else if (getImage() == roll8L) {
               setImage(roll9L);
           }
           else {
               setImage(roll1L);
           }
        }   
    }
    
    public void walkAnimationR(){
        if (counter % 4 == 0){
           setLocation(getX() + 15,getY());
           if (getImage() == standR){
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
    }
    
    public void walkAnimationL(){
        if (counter % 4 == 0){
           setLocation(getX() - 15,getY());
           if (getImage() == standR || getImage() == standL){
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
    
    // STATE METHODS
    
    public boolean isWalkingR(){
        if (Greenfoot.isKeyDown("d")){
           walkedR = true;
           walkedL = false;
           return true;
        }
        return false;
    }
    
    public boolean isWalkingL(){
        if (Greenfoot.isKeyDown("a")){
           walkedL = true;
           walkedR = false;
           return true;
        }
        return false;
    }
    
    public boolean isRollingR(){
        if (Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("shift") && !isRollingL && canRoll() && !rolled){
           rolled = true;
           rollCounter = 0;
           isRollingR = true;
           return true;
        }
        return false;
    }
    
    public boolean isRollingL(){
        if (Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("shift") && !isRollingR && canRoll() && !rolled){
           rolled = true; 
           rollCounter = 0;
           isRollingL = true;
           return true;
        }
        return false;
    }
    
    public boolean canRoll(){
        if (rollCounter < rollDelay || rollCounter > rollReload){
           return true;
        }
        return false;
    }
    
    /**
    * To make a player jump using isKeyDown("w")
    */
    private void isJumping() {
        jumpDelay++;
        if(Greenfoot.isKeyDown("w") && onGround() && jumpDelay == 2) {
           jumpSpeed = jumpStrength;
           Greenfoot.playSound("jump.wav");
           fall();
        }
        if (jumpDelay == 3) {
           jumpDelay = 0;
        }
    }
    
    public void isStandingR(){
        setImage(standR);
    }
    
    public void isStandingL() {
        setImage(standL);
    }
    private void attackAnimationL() {
        if (counter % 4 == 0){
            
           if (getImage() == standL){
               setImage(attack1L);
           }
           else if (getImage() == attack1L){
               setImage(attack2L);
           }
           else if (getImage() == attack2L){
               setImage(attack3L);
           }
           else if (getImage() == attack3L){
               setImage(attack4L);
           }
           else if (getImage() == attack4L){
               setImage(attack5L);
           }
           else if (getImage() == attack5L) {
               setImage(attack6L);
           }
           else {
               setImage(attack1L);
               isAttackingL = false;
           }
        }   
    }
    private void attackAnimationR() {
        if (counter % 4 == 0){
            
           if (getImage() == standR){
               setImage(attack1R);
           }
           else if (getImage() == attack1R){
               setImage(attack2R);
           }
           else if (getImage() == attack2R){
               setImage(attack3R);
           }
           else if (getImage() == attack3R){
               setImage(attack4R);
           }
           else if (getImage() == attack4R){
               setImage(attack5R);
           }
           else if (getImage() == attack5R) {
               setImage(attack6R);
           }
           else {
               setImage(attack1R);
               isAttackingR = false;
           }
        }   
    }
    public boolean isAttackingL() {
        if (Greenfoot.isKeyDown("o") && !isRollingL() && !isRollingR()) {
           isAttackingL = true;
           attacked = true;
        }
        return false;
    }
    public boolean isAttackingR() {
        if (Greenfoot.isKeyDown("o") && !isRollingL() && !isRollingR()) {
            isAttackingR = true;
            attacked = true;
        }
        return false;
    }
    public boolean attackCollision() {
        if (isAttackingR() || isAttackingR && isTouching(Hitbox.class) && getImage() == attack6R ) {
            Greenfoot.stop();
        }
        return false;
    }

    // COUNTER INCREMENT METHODS

   public void counter(){
       if (counter < 25){
           counter++;
       }
       else {
            counter = 0;
       }
   }

   // GRAVITY METHODS

   /**
   * to set  up gravity so the player falls on the ground and stays there
   */
   private void gravity() {
       setLocation(getX(), getY() + vSpeed);
   }
       
   private void checkGround() {
      if (!isTouching(Ground.class)) {
           vSpeed += GRAVITY;
       }
       else {
           vSpeed = 0;
       }
   }
    
   /** 
    * to call when the player jumps and starts falling
    */
   private void fall() {
      setLocation(getX(), getY() + jumpSpeed);
   }
    
   /**
    * To see if is onGround when you fall
    */
    private boolean onGround() {
       Actor under = getOneObjectAtOffset(0, getImage().getHeight()/2, Ground.class);
       return under != null;
    }
    
   /**
    * To check if the actor is falling
    */
    private void checkFall() {
       if (onGround()) {
           jumpSpeed = 0;
       }
       else {
           fall();
       }
    }
}