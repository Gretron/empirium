import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Credits extends Menu
{
    private GreenfootImage animation = new GreenfootImage("CreditsFP.png");
    private GreenfootImage credits = new GreenfootImage("CreditsF.png");
    
   public void act() {
        if (getWorld() instanceof StartMenu) {
            creditButton();
            animation();
        }
        else
            getWorld().removeObject(this);
   }
   private void creditButton() {
        if  (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new CreditWorld());
        }
   }

   public void animation(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            setImage(credits);
            List objects = getWorld().getObjectsAt(mouse.getX(), mouse.getY(), Credits.class);
            for(Object object : objects) {
                if (object == this) {
                    setImage(animation);
                }
            }
        }
   }
}