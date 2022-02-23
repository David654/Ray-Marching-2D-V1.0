package input;

import engine.Scene;
import raymarching.Vec2;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keyboard extends KeyAdapter
{
    private final Scene scene;
    private final float speed = 5;
    private final float angleSpeed = (float) (5 * Math.sqrt(2) / 2);
    private boolean isW;
    private boolean isA;
    private boolean isS;
    private boolean isD;

    public Keyboard(Scene scene)
    {
        this.scene = scene;
    }

    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W)
        {
            isW = true;

        }

        if(key == KeyEvent.VK_A)
        {
            isA = true;

        }

        if(key == KeyEvent.VK_S)
        {
            isS = true;

        }

        if(key == KeyEvent.VK_D)
        {
            isD = true;

        }

        if(isW && !isA && !isS && !isD) scene.camera.setSpeed(new Vec2(0, -speed));
        if(!isW && isA && !isS && !isD) scene.camera.setSpeed(new Vec2(-speed, 0));
        if(!isW && !isA && isS && !isD) scene.camera.setSpeed(new Vec2(0, speed));
        if(!isW && !isA && !isS && isD) scene.camera.setSpeed(new Vec2(speed, 0));
        if(isW && isA && !isS && !isD)
        {
            scene.camera.setSpeed(new Vec2(-angleSpeed, -angleSpeed));
        }
        if(isW && isD && !isA && !isS)
        {
            scene.camera.setSpeed(new Vec2(angleSpeed, -angleSpeed));
        }
        if(isS && isA && !isW && !isD)
        {
            scene.camera.setSpeed(new Vec2(-angleSpeed, angleSpeed));
        }
        if(isS && isD && !isW && !isA)
        {
            scene.camera.setSpeed(new Vec2(angleSpeed, angleSpeed));
        }
        if(isW && isS && !isA && !isD)
        {
            scene.camera.setSpeed(new Vec2(0, 0));
        }
        if(isA&& isD && !isW && !isS)
        {
            scene.camera.setSpeed(new Vec2(0, 0));
        }
    }

    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_W || key == KeyEvent.VK_A || key == KeyEvent.VK_S || key == KeyEvent.VK_D)
        {
            scene.camera.setSpeed(new Vec2(0, 0));
            if(key == KeyEvent.VK_W)
            {
                isW = false;
            }
            if(key == KeyEvent.VK_A)
            {
                isA = false;
            }
            if(key == KeyEvent.VK_S)
            {
                isS = false;
            }
            if(key == KeyEvent.VK_D)
            {
                isD = false;
            }
        }
    }
}