package tor.behindTheScenes.spaceObjects.complexObjects;

import tor.behindTheScenes.spaceObjects.vertexObjects.Panes;
import tor.behindTheScenes.spaceObjects.vertexObjects.Vertices;

public class ComplexSide
{
    public Panes[][] complexSide;

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
    }
}
