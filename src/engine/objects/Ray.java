package engine.objects;

import engine.Scene;
import raymarching.SDF;
import raymarching.Vec2;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class Ray
{
    private final Scene scene;
    private Vec2 location;
    private Vec2 p;
    private float angle;
    private final float phase;
    private final Color color;

    public Ray(Scene scene, Vec2 origin, float phase, Color color)
    {
        this.scene = scene;
        location = origin;
        p = location;
        this.phase = phase;
        this.color = color;
    }

    public Vec2 getLocation() {
        return location;
    }

    public void setLocation(Vec2 location)
    {
        this.location = location;
    }

    public Vec2 getP() {
        return p;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public void render(Graphics2D g2d)
    {
        g2d.setColor(color);
        g2d.drawLine((int) location.getX(), (int) location.getY(), (int) p.getX(), (int) p.getY());

        g2d.setColor(Color.yellow);

        for(int j = 0; j < 10; j++)
        {
            rayMarch(getMaxDist(), g2d);
        }
    }

    private float getMaxDist()
    {
        ArrayList<Float> dists = new ArrayList<>();

        for(int i = 0; i < scene.handler.objects.size(); i++)
        {
            SceneObject object = scene.handler.objects.get(i);
            if(object.getType() == Type.Circle)
            {
                dists.add(SDF.sdSphere(location, object.getCenter(), object.getSize().getX() / 2));
            }
            else if(object.getType() == Type.Rectangle)
            {
                dists.add(SDF.sdRectangle(location, new Vec2(object.getLocation().getX() + object.getSize().getX() / 2, object.getLocation().getY() + object.getSize().getY() / 2), Vec2.dev(object.getSize(), new Vec2(2f, 2f))));
            }
        }

        return Collections.min(dists);
    }

    private void rayMarch(float dist, Graphics2D g2d)
    {
        g2d.drawOval((int) (location.getX() - dist), (int) (location.getY() - dist), (int) dist * 2, (int) dist * 2);
        p = new Vec2((float) (location.getX() + dist * Math.cos(phase + angle)), (float) (location.getY() + dist * Math.sin(phase + angle)));
        location = p;
    }
}