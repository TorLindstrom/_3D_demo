package tor.behindTheScenes.spaceObjects.complexObjects;

import tor.behindTheScenes.spaceObjects.Points;
import tor.behindTheScenes.spaceObjects.shadows.SimpleShadow;
import tor.behindTheScenes.spaceObjects.vertexObjects.Panes;
import tor.behindTheScenes.spaceObjects.vertexObjects.Vertices;

public class ComplexSide
{
    public Panes[][] complexSide;
    public Points[] corners;
    public SimpleShadow shadow;

    public ComplexSide(int length, int width, int height, int[] pos)
    {
    }

    public ComplexSide()
    {
    }

    /*public static ComplexSide createXYSide(int length, int width, int[] pos)
    {
        ComplexSide side = new ComplexSide();
        side.complexSide = new Panes[width / 10][length / 10];
        for (Panes[] paneRow: side.complexSide) { //for every row of panes
            for (int i = 0; i <paneRow.length; i++) {
                paneRow[i] = new Panes(pos[0], pos[1], pos[2])
            }
        }
    }

    public static ComplexSide createXZSide(int length, int height, int[] pos)
    {

    }*/

    public static ComplexSide createYZSide(int width, int height, int[] pos)
    {
        ComplexSide side = new ComplexSide();
        side.complexSide = new Panes[height / 10][width / 10];
        side.corners = new Points[]{
                new Points(pos[0], pos[1], pos[2]),
                new Points(pos[0], pos[1] + width, pos[2]),
                new Points(pos[0], pos[1] + width, pos[2] + height),
                new Points(pos[0], pos[1], pos[2] + height)};

        int xPos = pos[0], yPos = pos[1], zPos = pos[2];
        int oldYPos = yPos, oldZPos = zPos;

        for (int j = 0; j < side.complexSide.length; j++) {
            for (int i = 0; i < side.complexSide[j].length; i++) {
                yPos = oldYPos + 10;
                zPos = oldZPos + 10;
                Vertices corner1 = new Vertices(xPos, oldYPos, oldZPos);
                Vertices corner2 = new Vertices(xPos, yPos, oldZPos);
                Vertices corner3 = new Vertices(xPos, yPos, zPos);
                Vertices corner4 = new Vertices(xPos, oldYPos, zPos);

                side.complexSide[j][i] = new Panes(corner1, corner2, corner3, corner4);
                oldYPos += 10;
            }
            oldYPos = pos[1];
            oldZPos += 10;
        }
        return side;
    }

    public static ComplexSide createFloor(int width, int length, int[] pos)
    {
        int squareSide = 50;
        ComplexSide side = new ComplexSide();
        side.complexSide = new Panes[length / squareSide][width / squareSide];

        int xPos = pos[0], yPos = pos[1], zPos = pos[2];
        int oldYPos = yPos, oldXPos = xPos;

        for (int j = 0; j < side.complexSide.length; j++) {
            for (int i = 0; i < side.complexSide[j].length; i++) {
                yPos = oldYPos + squareSide;
                xPos = oldXPos + squareSide;
                Vertices corner1 = new Vertices(oldXPos, oldYPos, zPos);
                Vertices corner2 = new Vertices(oldXPos, yPos, zPos);
                Vertices corner3 = new Vertices(xPos, yPos, zPos);
                Vertices corner4 = new Vertices(xPos, oldYPos, zPos);

                side.complexSide[j][i] = new Panes(corner1, corner2, corner3, corner4);
                oldXPos += squareSide;
            }
            oldYPos = pos[1];
            oldXPos += squareSide;
        }
        return side;
    }

    /*public static ComplexSide createSide(Points[][] corners)
    {
        ComplexSide side = new ComplexSide();
        side.complexSide = new Panes[][];

        int xPos = pos[0], yPos = pos[1], zPos = pos[2];
        int oldYPos = yPos, oldZPos = zPos;

        for (int j = 0; j < side.complexSide.length; j++) {
            for (int i = 0; i < side.complexSide[j].length; i++){
                yPos = oldYPos + 10;
                zPos = oldZPos + 10;
                Vertices corner1 = new Vertices(xPos, oldYPos, oldZPos);
                Vertices corner2 = new Vertices(xPos, yPos, oldZPos);
                Vertices corner3 = new Vertices(xPos, yPos, zPos);
                Vertices corner4 = new Vertices(xPos, oldYPos, zPos);

                side.complexSide[j][i] = new Panes(corner1, corner2, corner3, corner4);
                oldYPos += 10;
            }
            oldYPos = pos[1];
            oldZPos += 10;
        }
        return side;
    }*/

    public void setShadow(SimpleShadow shadow)
    {
        this.shadow = shadow;
    }
}
