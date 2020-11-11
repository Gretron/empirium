import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemy extends Actor
{
    int timer = 20;
    int speed = 1;
    public void act () {
        move();
    }
    public void move()
       {
       timer--;
       if (timer > 0) move(speed);
       speed = 3 ;
       {
            timer = 2+Greenfoot.getRandomNumber(30); 
        }
    }

    private int setRandomNumber(){
         int num = Greenfoot.getRandomNumber(2);
         int initNum=0;
         if(num==1){
              num=1;
           }
         if(num==2){
              initNum=-1;
           }
           return initNum;
    }
    public void flipLeft() {
         if (getRotation() == 0){
                turn(180);
                getImage().mirrorVertically();
         }
    }
    
    public void flipRight() {
         if (getRotation() == 180) {
                turn(180);
                getImage().mirrorVertically();
         }
     }
}
    



