import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
        
    /**
    * Write a description of class Bobius here.
    * 
    * @author (your name) 
    * @version (a version number or a date)
    */
    public class Bobius extends Actor
    {   
        // Right Images
        private GreenfootImage imageR1 = new GreenfootImage("WalkingAnimation1.png");
        private GreenfootImage imageR2 = new GreenfootImage("WalkingAnimation2.png");
        private GreenfootImage imageR3 = new GreenfootImage("WalkingAnimation3.png");
        private GreenfootImage imageR4 = new GreenfootImage("WalkingAnimation4.png");
        private GreenfootImage imageR5 = new GreenfootImage("WalkingAnimation5.png");
        private GreenfootImage imageR6 = new GreenfootImage("WalkingAnimation6.png");
        // Left images
        private GreenfootImage imageL1 = new GreenfootImage("WalkingAnimationLeft1.png");
        private GreenfootImage imageL2 = new GreenfootImage("WalkingAnimationLeft2.png");
        private GreenfootImage imageL3 = new GreenfootImage("WalkingAnimationLeft3.png");
        private GreenfootImage imageL4 = new GreenfootImage("WalkingAnimationLeft4.png");
        private GreenfootImage imageL5 = new GreenfootImage("WalkingAnimationLeft5.png");
        private GreenfootImage imageL6 = new GreenfootImage("WalkingAnimationLeft6.png");
        // animating
        private int frame = 5;
        private int animationCount = 0;
        // Gravity
        private static final int GRAVITY = 4;
        private int vSpeed;
   
        
        
        /**
        * Act - do whatever the Bobius wants to do. This method is called whenever
        * the 'Act' or 'Run' button gets pressed in the environment.
        */
        public void act() 
       {
           checkKeyPressed();
           checkGround();
           gravity();
           animationCount++;
       }
       /**
        * To check if a key is held down to move a character with extra animations
        */
       private void checkKeyPressed() {
           int speed = 0;
           
           if (Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("a")) {
                   move(speed);
           }
           if (Greenfoot.isKeyDown("w")) {
               
           }
           if (Greenfoot.isKeyDown("d")) {
               move(speed + 3);
              walkingR();
               counter();
           }
           if (Greenfoot.isKeyDown("a")) {
               move(speed - 3);
               walkingL();
               counter();
           }
           if (Greenfoot.isKeyDown("shift") && Greenfoot.isKeyDown("d")) {
                move(speed + 6);
                
           }
           if (Greenfoot.isKeyDown("shift") && Greenfoot.isKeyDown("a")) {
               move(speed - 6);
               
           }
       }
       /**
       * 
       */
       private void walkingR() {
           if (frame == 5) {
               setImage(imageR1);
            }
            else if (frame == 10) {
                setImage(imageR2);
            }
             else if (frame == 15) {
                setImage(imageR3);
            }
             else if (frame == 20) {
                setImage(imageR4);
            }
             else if (frame == 25) {
                setImage(imageR5);
            }
             else if (frame == 30) {
                setImage(imageR6);
                frame = 5;
                return;
            }
            frame++;
       }
       private void walkingL() {
           if (frame == 5) {
                    setImage(imageL1);

            }
            else if (frame == 10) {
                    setImage(imageL2);

            }
             else if (frame == 15) {
                    setImage(imageL3);

            }
             else if (frame == 20) {
                    setImage(imageL4);
                   
            }
            else if (frame == 25) {
                    setImage(imageL5);

            }
            else if (frame == 30) {
                setImage(imageL6);
                frame = 5;
                return;
           }
           frame++;
            
       }
        /**
         * A counter to help the animation be smoother
         */
       private void counter() {
              if(animationCount % 4 == 0) {
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
       
 }