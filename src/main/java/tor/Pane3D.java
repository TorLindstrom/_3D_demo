package tor;

import java.awt.*;

public class Pane3D extends Shapes
{

    public int[] x;
    public int[] y;

    public Pane3D(int[][] corners){
        this.corners = corners;
    }
    public Pane3D(int[][] corners, int[] colorValues){
        this(corners);
        this.colorValues = colorValues;
    }

    public Pane3D(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4){
        x = new int[]{x1,x2,x3,x4};
        y = new int[]{y1,y2,y3,y4};
    }

    public Pane3D(int[] corner1, int[] corner2, int[] corner3, int[] corner4, Color color){
        x = new int[]{corner1[0], corner2[0], corner3[0], corner4[0]};
        y = new int[]{corner1[1], corner2[1], corner3[1], corner4[1]};
        this.color = color;
    }

    public Color getColor(){
        return color;
    }

     public Color getColorValues(){
        return new Color(colorValues[0], colorValues[1],colorValues[2]);
     }
}
