import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

public class Instructions extends Menu {
    private GreenfootImage animation = new GreenfootImage("InstructionsFP.png");
    private GreenfootImage instructions = new GreenfootImage("InstructionsF.png");
    public void act() 
    {
        instructions();
        animation();
    }
    private void instructions() {
        if  (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new InstructionWorld());
        }
    }

    public void animation(){
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null) {
            setImage(instructions);
            List objects = getWorld().getObjectsAt(mouse.getX(), mouse.getY(), Instructions.class);
            for(Object object : objects) {
                if (object == this) {
                    setImage(animation);
                }
            }
        }

    }
}