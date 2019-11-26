package tor.spaceObjects.vertexObjects;

import java.awt.*;

public class Box
{
    final Vertices[][] sides = new Vertices[6][4];
    Color[] sideColors = new Color[6];
    private int length, width, height;
    private int[] pos;

    public Box(int length, int width, int height, int[] pos){
        this.length = length;
        this.width = width;
        this.height = height;

        this.pos = pos;

        sides[0][0] = new Vertices(pos[0], pos[1], pos[2]);
        sides[0][1] = new Vertices(length + pos[0], pos[1], pos[2]);
        sides[0][2] = new Vertices(length + pos[0], pos[1], height + pos[2]);
        sides[0][3] = new Vertices(pos[0], pos[1], height + pos[2]);

        sides[1][0] = sides[0][3];
        sides[1][1] = sides[0][2];
        sides[1][2] = new Vertices(pos[0], width + pos[1], height + pos[2]);
        sides[1][3] = new Vertices(length + pos[0], width + pos[1], height + pos[2]);

        sides[2][0] = sides[1][3];
        sides[2][1] = sides[1][2];
        sides[2][2] = new Vertices(length + pos[0], width + pos[1], pos[2]);
        sides[2][3] = new Vertices(pos[0], width + pos[1], pos[0]);

        sides[3][0] = sides[2][3];
        sides[3][1] = sides[2][2];
        sides[3][2] = sides[0][1];
        sides[3][3] = sides[0][0];

        sides[4][0] = sides[0][0];
        sides[4][1] = sides[1][0];
        sides[4][2] = sides[2][0];
        sides[4][3] = sides[3][0];

        sides[5][0] = sides[1][1];
        sides[5][1] = sides[2][1];
        sides[5][2] = sides[3][1];
        sides[5][3] = sides[4][1];

        Color base = Color.GREEN;

        sideColors[0] = base;
        base = base.darker();
        sideColors[1] = base;
        base = base.darker();
        sideColors[2] = base;
        base = base.darker();
        sideColors[3] = base;
        base = base.darker();
        sideColors[4] = base;
        base = base.darker();
        sideColors[5] = base;
    }

    public Box(int length, int width, int height, int[] pos, Color[] colors){
        this(length, width, height, pos);
        sideColors = colors;
    }

    public void setColor(int side, Color color){
        sideColors[side] = color;
    }

    public int getLength()
    {
        return length;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public int[] getPos()
    {
        return pos;
    }
}
