package engine.objects;

import java.awt.*;
import java.util.ArrayList;

public class Handler
{
    public ArrayList<SceneObject> objects;

    public Handler()
    {
        objects = new ArrayList<>();
    }

    public void add(SceneObject object)
    {
        objects.add(object);
    }

    public void render(Graphics2D g2d)
    {
        for(SceneObject object : objects)
        {
            object.render(g2d);
        }
    }
}