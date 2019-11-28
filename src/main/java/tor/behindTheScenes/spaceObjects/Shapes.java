package tor.behindTheScenes.spaceObjects;

import java.awt.*;

public abstract class Shapes
{
    int[][] corners;
    int[] colorValues;
    Color color;

    abstract Color getColor();
}
