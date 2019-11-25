package tor.spaceObjects.pointObjects;

public class Panes
{
    Vertices[] corners;
    double[] center;

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
