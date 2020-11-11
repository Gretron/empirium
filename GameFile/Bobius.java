import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
/**
* Write a description of class Bobius here.
* 
* @author (your name) 
* @version (a version number or a date)
*/
public class Bobius extends Actor
{   
    /**
    * Act - do whatever the Bobius wants to do. This method is called whenever
    * the 'Act' or 'Run' button gets pressed in the environment.
    */
   public void act() 
   {
       checkKeyPressed();
   }
   /**
    * To check if a key is held down to move a character with extra animations
    */
   public void checkKeyPressed() {
       int speed = 0;
       if (Greenfoot.isKeyDown("d") && Greenfoot.isKeyDown("a")) {
               move(speed);
       }
       if (Greenfoot.isKeyDown("d")) {
           move(speed + 3);
           flipRight();
       }
       if (Greenfoot.isKeyDown("a")) {
           move(speed + 3);
           flipLeft();
       }
       if (Greenfoot.isKeyDown("shift") && Greenfoot.isKeyDown("d")) {
            move(speed + 6);
            flipRight();
       }
       if (Greenfoot.isKeyDown("shift") && Greenfoot.isKeyDown("a")) {
           move(speed + 6);
           flipLeft();
       }
   }
   /**
    * Flips the characters model to the left
    */
   public void flipLeft() {
        if (getRotation() == 0){
            turn(180);
            getImage().mirrorVertically();
        }
   }
   /**
    * Flips the characters model to the right
    */
   public void flipRight() {
        if (getRotation() == 180) {
            turn(180);
            getImage().mirrorVertically();
        } 
   }
}
