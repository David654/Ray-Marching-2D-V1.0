package main;

import java.awt.*;

public class Setup
{
    private static final Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int width = d.width / 2;
    public static final int height = d.height / 2;
    public static final int size = width / 40;
    public static final double tick = 64.0;

    public static final String title = "Ray Marching 2D";

    public static final Color bg = Color.black;
}