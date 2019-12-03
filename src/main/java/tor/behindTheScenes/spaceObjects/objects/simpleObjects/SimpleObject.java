package tor.behindTheScenes.spaceObjects.objects.simpleObjects;

import tor.behindTheScenes.spaceObjects.Points;

import java.awt.*;

public class SimpleObject
{
    Points[][] sides;
    Color color;

    public SimpleObject(Points[]...sides){
        this.sides = sides;
        this.color = Color.YELLOW;
    }

    public SimpleObject(Color color, Points[]...sides){
        this.sides = sides;
        this.color = color;
    }

    public Points[][] getSides()
    {
        return sides;
    }

    public Color getColor()
    {
        return color;
    }
}
