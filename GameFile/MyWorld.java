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
        setPaintOrder(Bobius.class, World.class, Ground.class);
    }
}
