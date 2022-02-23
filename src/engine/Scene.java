package engine;

import engine.objects.Camera;
import engine.objects.Handler;
import engine.objects.SceneObject;
import engine.objects.Type;
import input.Keyboard;
import input.Mouse;
import main.Setup;
import raymarching.Vec2;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Scene extends Canvas implements Runnable
{
    private final Window window;
    private Thread thread;
    private boolean running = false;

    public Handler handler;
    public Camera camera;
    public Keyboard keyboard;
    public Mouse mouse;

    public Scene()
    {
        handler = new Handler();
        handler.add(new SceneObject(new Vec2(Setup.width / 2f, Setup.height / 2f), new Vec2(Setup.size * 5, Setup.size * 5), Type.Circle, Color.white));
        handler.add(new SceneObject(new Vec2(Setup.width / 1.2f, Setup.height / 5f), new Vec2(Setup.size * 5, Setup.size * 3), Type.Rectangle, Color.white));

        camera = new Camera(this, new Vec2(10, 10), new Vec2(Setup.size / 2f, Setup.size / 2f), Color.cyan);

        keyboard = new Keyboard(this);
        mouse = new Mouse(this);

        this.addKeyListener(keyboard);
        this.addMouseMotionListener(mouse);
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(Setup.width, Setup.height));
        window = new Window(Setup.width, Setup.height, Setup.title, this);
    }

    public synchronized void start()
    {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop()
    {
        try
        {
            thread.join();
            running = false;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void run()
    {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = Setup.tick;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while(delta >= 1)
            {
                update();
                delta--;
            }
            if(running)
            {
                render();
            }
            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                long end = System.nanoTime();
                float diff = (end - now) / 1000000f;
                window.setTitle(Setup.title + " | " + frames + " fps, " + diff + " ms");
                frames = 0;
            }
        }
        stop();
    }

    private void update()
    {
        camera.update();
    }

    private void render()
    {
        BufferStrategy bs = this.getBufferStrategy();

        if(bs == null)
        {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Setup.bg);
        g2d.fillRect(0, 0, Setup.width, Setup.height);

        handler.render(g2d);
        camera.render(g2d);

        g2d.dispose();
        bs.show();
    }

    public static double clamp(double var, double min, double max)
    {
        if(var >= max) return var = max;
        else if(var <= min) return var = min;
        else return var;
    }
}