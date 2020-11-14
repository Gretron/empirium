import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
        
/**
* Write a description of class Bobius here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
public class Bobius extends Actor {
   // Standing Right Frame
   private GreenfootImage stand1 = new GreenfootImage("Stand.png");

   // Standing Left Frame
   private GreenfootImage stand2 = new GreenfootImage("StandL.png");

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
   private GreenfootImage[] rollingR = new GreenfootImage[9];
   private int rollingImgs;
   
   private int rollDelay = 0;

   // Rolling Left Frames
   private GreenfootImage[] rollingL = new GreenfootImage[9];
   private int rollingImgsL;

   // Counters
   private int counter;

   // Memory Variables
   private boolean isStanding;
   private boolean walkedR;
   private boolean walkedL;

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
       for (int i = 0; i < rollingR.length; i++){
           rollingR[i] = new GreenfootImage("RollingAnimation" + i + ".png");
       }
       for (int i = 0; i < rollingL.length; i++){
           rollingL[i] = new GreenfootImage("RollingAnimationL" + i + ".png");
       }
       setImage(stand1);
       isStanding = true;
       walkedR = false;
       walkedL = false;
       counter = 0;
   }
    
    /**
    * Act - do whatever the Bobius wants to do. This method is called whenever
    * the 'Act' or 'Run' button gets pressed in the environment.
    */
    public void act(){
       // State
       state();

       // Animation Counter
       counter();
       checkFall();
       isJumping();
       checkGround();
       gravity();
   }

    // MAIN STATE

   public void state(){
       if (isWalkingR()){
           if (counter % 4 == 0){
               setLocation(getX() + 20,getY());
               walkAnimationR();
           }
       }
       else if (isWalkingL()){
           if (counter % 4 == 0){
               setLocation(getX() - 20,getY());
               walkAnimationL();
           }
       }
       else if(isRollingR()){
           if (counter % 4 == 0){
               setLocation(getX() + 60,getY());
               rollingAnimationR();
           }
       }
       else if(isRollingL()){
           if (counter % 4 == 0){
               setLocation(getX() - 60,getY());
               rollingAnimationL();
           }
       }
       else if(!isWalkingR() && walkedR) {
           isStandingR();
       }
       else if(!isWalkingL() && walkedL) {
           isStandingL();
       }
   }

    // ANIMATION METHODS

   public void rollingAnimationR(){
       rollingImgs = (rollingImgs + 1) % rollingR.length;
       setImage(rollingR[rollingImgs]);
   }
   
   public void rollingAnimationL(){
       rollingImgsL = (rollingImgsL + 1) % rollingL.length;
       setImage(rollingL[rollingImgsL]);
   }
   
   public void walkAnimationR(){
       if (getImage() == stand1){
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

   public void walkAnimationL(){
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

   // STATE METHODS

   public boolean isWalkingR(){
       if (Greenfoot.isKeyDown("d") && !Greenfoot.isKeyDown("shift")){
           walkedR = true;
           walkedL = false;
           return true;
       }
       return false;
   }
    
   public boolean isWalkingL(){
       if (Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("shift")){
           walkedL = true;
           walkedR = false;
           return true;
       }
       return false;
   }
    
   public boolean isRollingR(){
       rollDelay++;
       if (Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("shift")){
           return true;
       }
       return false;
   }
   
   public boolean isRollingL(){
       if (Greenfoot.isKeyDown("a") && Greenfoot.isKeyDown("shift")){
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
       setImage(stand1);
   }
    
   public void isStandingL() {
       setImage(stand2);
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