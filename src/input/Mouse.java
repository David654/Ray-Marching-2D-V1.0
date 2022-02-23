package input;

import engine.Scene;
import raymarching.Vec2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter
{
    private final Scene scene;

    public Mouse(Scene scene)
    {
        this.scene = scene;
    }

    public void mouseMoved(MouseEvent e)
    {
        Vec2 camera = scene.camera.getLocation();
        float angle = (float) Math.atan2(e.getY() - camera.getY(), e.getX() - camera.getX());
        scene.camera.setAngle(angle);
    }
}