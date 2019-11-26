package tor.spaceObjects.vertexObjects;

public class Panes
{
    public Vertices[] corners;
    public double[] center;

    public Panes(Vertices...corners){
        this.corners = corners;
        double xMid = 0, yMid = 0, zMid = 0;
        for (Vertices werther: corners){
            xMid += werther.getX();
            yMid += werther.getY();
            zMid += werther.getZ();
        }
        center = new double[]{xMid/corners.length, yMid/corners.length, zMid/corners.length};
    }
}
