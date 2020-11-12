import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
        
    /**
    * Write a description of class Bobius here.
    * 
    * @author (your name) 
    * @version (a version number or a date)
    */
    public class Bobius extends Actor
    {   
        private GreenfootImage stand1 = new GreenfootImage("Test Sprite Upscaled.png");
        private GreenfootImage stand2 = new GreenfootImage("Test Sprite UpscaledLeft.png");
        
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
        // jump
        private int jumpSpeed = 0; //vertical jump speed
        private int acceleration = 1; //gravity effect while falling  
        private int jumpStrength = -40; 
   
            /**
         * 
         */
        public Bobius(){
            setImage(stand1);
            isStanding = true;
            walkedRight = false;
            counter = 0;
        }
        
        /**
        * Act - do whatever the Bobius wants to do. This method is called whenever
        * the 'Act' or 'Run' button gets pressed in the environment.
        */
        public void act() 
       {
           checkFall();
           isJumping();
           checkGround();
           gravity();
           counter();
           state();
       }
       public void walkAnimationRight(){
            if (getImage() == walk6){
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
            else {
                setImage(walk6);
            }
        }
        public void walkAnimationLeft(){
            if (getImage() == walk6L){
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
            else {
                setImage(walk6L);
            }
        }
    
        public boolean isWalkingRight(){
            if (Greenfoot.isKeyDown("d") && !Greenfoot.isKeyDown("shift")){
                walkedRight = true;
                walkedLeft = false;
                return true;
            }
            return false;
        }
        
        public boolean isWalkingLeft(){
            if (Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("shift")){
                walkedLeft = true;
                walkedRight = false;
                return true;
            }
            return false;
        }
        
        public void isStandingRight(){
            setImage(stand1);
        }
        
        public void isStandingLeft(){
            setImage(stand2);
        }
        
        public void state(){
            if (isWalkingRight()){
                if (counter % 4 == 0){
                    setLocation(getX() + 11,getY());
                    walkAnimationRight();
                }
            }
            
            else if (isWalkingLeft()){
                if (counter % 4 == 0){
                    setLocation(getX() - 11,getY());
                    walkAnimationLeft();
                }
            }
            else if(!isWalkingRight() && walkedRight) {
                isStandingRight();
            }
            else if(!isWalkingLeft() && walkedLeft) {
                isStandingLeft();
            }
        }
        
       public void counter(){
            if (counter < 25){
                counter++;
            }
            else {
                counter = 0;
            }
        }
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
        * To make a player jump using isKeyDown("w")
        */
       private void isJumping() {
           if(Greenfoot.isKeyDown("w") && onGround()) {
               jumpSpeed = jumpStrength;
               fall();
        }
        }
       /** 
        * to call when the player jumps and starts falling
        */
       private void fall() {
           setLocation(getX(), getY() + jumpSpeed);
           jumpSpeed = jumpSpeed + acceleration; 
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