import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     */
    public MyWorld()
    {
        super(1280, 720, 1);
        addObject(new Bobius(), 100, 410);
        addObject(new Ground(), 640, 650);
        addObject(new Prisoner(), 1100, 410);
        setPaintOrder(Bobius.class, Prisoner.class, World.class, Ground.class);
    }
}
