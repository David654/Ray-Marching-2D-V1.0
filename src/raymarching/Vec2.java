package raymarching;

public class Vec2
{
    private final float x;
    private final float y;

    public Vec2(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public static Vec2 add(Vec2 a, Vec2 b)
    {
        return new Vec2(a.getX() + b.getX(), a.getY() + b.getY());
    }

    public static Vec2 sub(Vec2 a, Vec2 b)
    {
        return new Vec2(a.getX() - b.getX(), a.getY() - b.getY());
    }

    public static Vec2 subS(Vec2 a, float value)
    {
        return new Vec2(a.getX() - value, a.getY() - value);
    }

    public static Vec2 mul(Vec2 a, Vec2 b)
    {
        return new Vec2(a.getX() * b.getX(), a.getY() * b.getY());
    }

    public static Vec2 mulS(Vec2 a, float value)
    {
        return new Vec2(a.getX() * value, a.getY() * value);
    }

    public static Vec2 dev(Vec2 a, Vec2 b)
    {
        return new Vec2(a.getX() / b.getX(), a.getY() / b.getY());
    }

    public static float length(Vec2 a)
    {
        return (float) Math.sqrt(Math.pow(a.getX(), 2) + Math.pow(a.getY(), 2));
    }

    public static Vec2 norm(Vec2 a)
    {
        return mulS(a, 1 / length(a));
    }

    public static float dot(Vec2 a, Vec2 b)
    {
        return a.getX() * b.getX() + a.getY() * b.getY();
    }

    public static Vec2 reflect(Vec2 rd, Vec2 n)
    {
        return sub(rd, mulS(n, 2 * dot(n, rd)));
    }

    public static Vec2 abs(Vec2 a)
    {
        return new Vec2(Math.abs(a.getX()), Math.abs(a.getY()));
    }

    public static Vec2 max(Vec2 a, Vec2 b)
    {
        float x = Math.max(a.getX(), b.getX());
        float y = Math.max(a.getY(), b.getY());
        return new Vec2(x, y);
    }

    public static Vec2 min(Vec2 a, Vec2 b)
    {
        float x = Math.min(a.getX(), b.getX());
        float y = Math.min(a.getY(), b.getY());
        return new Vec2(x, y);
    }

    public static float dist(Vec2 a, Vec2 b)
    {
        return (float) Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }
}