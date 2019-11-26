package tor.visionMath;

import tor.spaceObjects.lights.LightSource;
import tor.spaceObjects.vertexObjects.Panes;

public class LightMath
{
    public static int reduceLight(int[] posObject, LightSource light){
        return 1;
    }

    /*public static Panes createShadow(int[][] panePos, int[] lightPos){
        int xDiff = panePos[0][0] - lightPos[0], yDiff = panePos[0][1] - lightPos[1], zDiff = panePos[0][2] - lightPos[2];
        double xyPlaneAngle = AnglesMath.calculateAngle(xDiff, yDiff);
    }*/
}
