package engine.objects;

import engine.Scene;
import raymarching.SDF;
import raymarching.Vec2;

import java.awt.*;

public class Camera
{
    private final Scene scene;
    private Vec2 location;
    private Vec2 size;
    private final Color color;
    private Vec2 speed;
    private float angle;

    private final Ray ray;

    public Camera(Scene scene, Vec2 location, Vec2 size, Color color)
    {
        this.scene = scene;
        this.location = location;
        this.size = size;
        this.color = color;
        speed = new Vec2(0, 0);
        ray = new Ray(scene, location, 0, Color.green);
    }

    public Vec2 getLocation()
    {
        return location;
    }

    public void setLocation(Vec2 location)
    {
        this.location = location;
    }

    public Vec2 getSize()
    {
        return size;
    }

    public void setSize(Vec2 size)
    {
        this.size = size;
    }

    public Color getColor()
    {
        return color;
    }

    public Vec2 getSpeed() {
        return speed;
    }

    public void setSpeed(Vec2 speed) {
        this.speed = speed;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle)
    {
        this.angle = angle;
        ray.setAngle(angle);
    }

    public void update()
    {
        location = new Vec2(location.getX() + speed.getX(), location.getY() + speed.getY());
    }

    private void rayMarch()
    {

    }

    public void render(Graphics2D g2d)
    {
        ray.render(g2d);

        g2d.setColor(color);
        g2d.fillOval((int) location.getX(), (int) location.getY(), (int) size.getX(), (int) size.getY());

        ray.setLocation(new Vec2(location.getX() + size.getX() / 2, location.getY() + size.getY() / 2));
    }
}