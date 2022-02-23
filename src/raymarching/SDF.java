package raymarching;

public class SDF
{
    public static float sdSphere(Vec2 p, Vec2 s, float r)
    {
        return Vec2.length(Vec2.sub(p, s)) - r;
    }

    public static float sdRectangle(Vec2 p, Vec2 b, Vec2 s)
    {
        Vec2 d = Vec2.sub(Vec2.abs(Vec2.sub(p, b)), s);
        return Vec2.length(Vec2.max(d, new Vec2(0f, 0f))) + Math.min(Math.max(d.getX(), d.getY()), 0f);
    }

    float sdPlane(Vec2 p, Vec2 n, float h)
    {
        return Vec2.dot(p, Vec2.norm(n)) + h;
    }
}