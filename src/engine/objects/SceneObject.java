package engine.objects;

import raymarching.Vec2;

import java.awt.*;

public class SceneObject
{
    private Vec2 location;
    private Vec2 size;
    private final Type type;
    private final Color color;

    public SceneObject(Vec2 location, Vec2 size, Type type, Color color)
    {
        this.location = location;
        this.size = size;
        this.type = type;
        this.color = color;
    }

    public Vec2 getLocation()
    {
        return location;
    }

    public void setLocation(Vec2 location)
    {
        this.location = location;
    }

    public Vec2 getCenter()
    {
        return new Vec2(location.getX() + size.getX() / 2, location.getY() + size.getY() / 2);
    }

    public Vec2 getSize()
    {
        return size;
    }

    public void setSize(Vec2 size)
    {
        this.size = size;
    }

    public Type getType()
    {
        return type;
    }

    public Color getColor()
    {
        return color;
    }

    public void render(Graphics2D g2d)
    {
        g2d.setColor(color);
        if(type == Type.Circle)
        {
            g2d.drawOval((int) location.getX(), (int) location.getY(), (int) size.getX(), (int) size.getY());
        }
        else if(type == Type.Rectangle)
        {
            g2d.drawRect((int) location.getX(), (int) location.getY(), (int) size.getX(), (int) size.getY());
        }
    }
}