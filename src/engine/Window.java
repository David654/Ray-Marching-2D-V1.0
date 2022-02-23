package engine;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas
{
    private final JFrame frame;

    public Window(int width, int height, String title, Scene scene)
    {
        this.frame = new JFrame(title);

        frame.setSize(new Dimension(width, height));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(scene);
        frame.pack();
        frame.setVisible(true);

        scene.start();
    }

    public void setTitle(String title)
    {
        frame.setTitle(title);
    }
}