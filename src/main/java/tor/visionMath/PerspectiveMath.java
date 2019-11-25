package tor.visionMath;

import tor.spaceObjects.Camera;

import static java.lang.Math.*;
import static tor.rendering.Window.*;

public class PerspectiveMath
{
    public static int[] makeRelative(double x, double y, double z)
    {
        int[] screenPos = new int[2];
        double horizontalPlaneAngle = (Math.atan(Math.abs(y) / x) * (180 / PI));
        double verticalPlaneAngle = (Math.atan(Math.abs(z) / calculatePaneDistance(x, y)) * (180 / PI));
        if (y > 0) {
            screenPos[0] = (int) (((horizontalFOV / 2 + horizontalPlaneAngle) / horizontalFOV) * (width)); //pixels from the left
        } else if (y < 0) {
            screenPos[0] = (int) (((horizontalFOV / 2 - horizontalPlaneAngle) / horizontalFOV) * (width)); //pixels from the left
        } else {
            screenPos[0] = (int) (width / 2);
        }
        if (z > 0) {
            screenPos[1] = (int) (height - (((verticalFOV / 2 + verticalPlaneAngle) / verticalFOV) * (height)));
        } else if (z < 0) {
            screenPos[1] = (int) (height - (((verticalFOV / 2 - verticalPlaneAngle) / verticalFOV) * (height)));
        } else {
            screenPos[1] = (int) (height / 2);
        }
        return screenPos;
    }

    public static int[] makeRelative(double x, double y, double z, Camera camera)
    {
        double relativeX = x - camera.getX();
        double relativeY = y - camera.getY();
        double relativeZ = z - camera.getZ();
        int[] screenPos = new int[2];
        double horizontalPlaneAngle = (Math.atan(relativeY / relativeX) * (180 / PI)) - camera.getHorizontalAngle();
        double verticalPlaneAngle = (Math.atan(relativeZ / calculatePaneDistance(relativeX, relativeY)) * (180 / PI)) - camera.getVerticalAngle();
        screenPos[0] = (int) (((camera.getHorizontalFOV() / 2 + horizontalPlaneAngle) / camera.getHorizontalFOV()) * (width)); //pixels from the left
        screenPos[1] = (int) (height - (((camera.getVerticalFOV() / 2 + verticalPlaneAngle) / camera.getVerticalFOV()) * (height)));
        return screenPos;
    }

    public static int setHorizonLevel(Camera camera){
        double angleToHorizon = -((Math.atan(camera.getZ() / 100000.0)) * (180 / PI)) - camera.getVerticalAngle();
        int screenPos = (int) (height - (camera.getVerticalFOV() / 2 + angleToHorizon) / camera.getVerticalFOV() * height);
        return screenPos;
    }

    public static double calculatePaneDistance(double x, double y)
    {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }

    public static double calculateSpaceDistance(double x, double y, double z)
    {
        return sqrt(pow(x, 2) + pow(y, 2) + pow(z, 2));
    }
}
