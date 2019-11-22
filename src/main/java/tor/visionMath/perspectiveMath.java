package tor.visionMath;

import static java.lang.Math.*;
import static tor.Window.*;

public class perspectiveMath
{
    public static int[] makeRelative(double x, double y, double z){
        int[] screenPos = new int[2];
        double horizontalPlaneAngle = (Math.atan(Math.abs(y) / x) * (180 / PI));
        double verticalPlaneAngle = (Math.atan(Math.abs(z) / calculatePaneDistance(x, y)) * (180 / PI));
        if (y > 0){
            screenPos[0] = (int) (((horizontalFOV / 2 + horizontalPlaneAngle) / horizontalFOV) * (width)); //pixels from the left
        } else if (y < 0){
            screenPos[0] = (int) (((horizontalFOV / 2 - horizontalPlaneAngle) / horizontalFOV) * (width)); //pixels from the left
        } else {
            screenPos[0] = (int) (width / 2);
        }
        if (z > 0){
            screenPos[1] = (int) (((verticalFOV / 2 + verticalPlaneAngle) / verticalFOV) * (height));
        } else if (z < 0){
            screenPos[1] = (int) (((verticalFOV / 2 - verticalPlaneAngle) / verticalFOV) * (height));
        } else {
            screenPos[1] = (int) (height / 2);
        }
        return screenPos;
    }

    public static double calculatePaneDistance(double x, double y){
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public static double calculateSpaceDistance(double x, double y, double z){
        return sqrt(pow(x, 2) + pow(y, 2) + pow(z, 2));
    }
}
