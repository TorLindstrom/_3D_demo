package tor.visionMath;

import tor.spaceObjects.Camera;
import tor.spaceObjects.lights.LightSource;

import static java.lang.Math.*;
import static tor.rendering.Window.*;

public class PerspectiveMath
{
    /*public static int[] makeRelative(double x, double y, double z, Camera camera)
    {
        double relativeX = x - camera.getX();
        double relativeY = y - camera.getY();
        double relativeZ = z - camera.getZ();
        int[] screenPos = new int[2];
        double horizontalPlaneAngle = (Math.atan(relativeY / relativeX) * (180 / PI)) - camera.getHorizontalAngle();
        double verticalPlaneAngle = (Math.atan(relativeZ / calculatePaneDistance(relativeX, relativeY)) * (180 / PI)) - camera.getVerticalAngle();
        screenPos[0] = (int) (((camera.getHorizontalFOV() / 2 + horizontalPlaneAngle) / camera.getHorizontalFOV()) * (width) + 0.5); //pixels from the left
        screenPos[1] = (int) (height - (((camera.getVerticalFOV() / 2 + verticalPlaneAngle) / camera.getVerticalFOV()) * (height)) + 0.5);
        return screenPos;
    }*/

    public static int[] makeRelative(double x, double y, double z, Camera camera)
    {
        double[]  pinholePos = calculatePinholePos(camera);
        double relativeX = x - pinholePos[0];
        double relativeY = y - pinholePos[1];
        double relativeZ = z - pinholePos[2];
        int[] screenPos = new int[2];
        double horizontalPlaneAngle = (Math.atan(relativeY / relativeX) * (180 / PI)) - camera.getHorizontalAngle();
        double verticalPlaneAngle = (Math.atan(relativeZ / calculatePaneDistance(relativeX, relativeY)) * (180 / PI)) - camera.getVerticalAngle();
        //double[] pinholeFOV = calculatePinholeFOV(camera);
        screenPos[0] = (int) (((camera.getPinholeHorizontalFov() / 2 + horizontalPlaneAngle) / camera.getPinholeHorizontalFov()) * (width) + 0.5); //pixels from the left
        screenPos[1] = (int) (height - (((camera.getPinholeVerticalFOV() / 2 + verticalPlaneAngle) / camera.getPinholeVerticalFOV()) * (height)) + 0.5);
        return screenPos;
    }

    public static int[] makeRelative(double[] pos, Camera camera)
    {
        double[]  pinholePos = calculatePinholePos(camera);
        double relativeX = pos[0] - pinholePos[0];
        double relativeY = pos[1] - pinholePos[1];
        double relativeZ = pos[2] - pinholePos[2];
        int[] screenPos = new int[2];
        double horizontalPlaneAngle = (Math.atan(relativeY / relativeX) * (180 / PI)) - camera.getHorizontalAngle();
        double verticalPlaneAngle = (Math.atan(relativeZ / calculatePaneDistance(relativeX, relativeY)) * (180 / PI)) - camera.getVerticalAngle();
        //camera.setPinholeHorizontalFov();
        //camera.setPinholeVerticalFOV();
        screenPos[0] = (int) (((camera.getPinholeHorizontalFov() / 2 + horizontalPlaneAngle) / camera.getPinholeHorizontalFov()) * (width) + 0.5); //pixels from the left
        screenPos[1] = (int) (height - (((camera.getPinholeVerticalFOV() / 2 + verticalPlaneAngle) / camera.getPinholeVerticalFOV()) * (height)) + 0.5);
        return screenPos;
    }

    /*public static int[] makeRelative(double[] pos, Camera camera)
    {
        double relativeX = pos[0] - camera.getX();
        double relativeY = pos[1] - camera.getY();
        double relativeZ = pos[2] - camera.getZ();
        int[] screenPos = new int[2];
        double horizontalPlaneAngle = (Math.atan(relativeY / relativeX) * (180 / PI)) - camera.getHorizontalAngle();
        double verticalPlaneAngle = (Math.atan(relativeZ / calculatePaneDistance(relativeX, relativeY)) * (180 / PI)) - camera.getVerticalAngle();
        screenPos[0] = (int) (((camera.getHorizontalFOV() / 2 + horizontalPlaneAngle) / camera.getHorizontalFOV()) * (width) + 0.5); //pixels from the left
        screenPos[1] = (int) (height - (((camera.getVerticalFOV() / 2 + verticalPlaneAngle) / camera.getVerticalFOV()) * (height)) + 0.5);
        return screenPos;
    }*/

    public static double[] calculatePinholePos(Camera camera){
        double x = camera.getDistanceToPinHole() * Math.cos((camera.getVerticalAngle() + 180) * PI / 180) + camera.getX();
        double y = camera.getDistanceToPinHole() * Math.sin((camera.getHorizontalAngle() + 180) * PI / 180) + camera.getY();
        double z = camera.getDistanceToPinHole() * Math.sin((camera.getVerticalAngle() + 180) * PI / 180) + camera.getZ();
        camera.setPinholePos(new double[]{x, y, z});
        return new double[]{x, y, z};
    }

    /*public static double[] calculatePinholeFOV(Camera camera){
        double distance = camera.getDepthOfField() + camera.getDistanceToPinHole();
        double widthOfField = Math.tan(camera.getHorizontalFOV() / 2 * PI / 180) * camera.getDepthOfField() * 2;
        double heightOfField = Math.tan(camera.getVerticalFOV() / 2 * PI / 180) * camera.getDepthOfField() * 2;
        double horizontalFOV = Math.atan(widthOfField / distance) * (180 / PI) * 2;
        double verticalFOV = Math.atan(heightOfField / distance) * (180 / PI) * 2;
        camera.setPinholeHorizontalFov();
        return new double[]{horizontalFOV, verticalFOV};
    }*/

    public static int setHorizonLevel(Camera camera){
        double angleToHorizon = -((Math.atan(camera.getPinholePos()[2] / 100000.0)) * (180 / PI)) - camera.getVerticalAngle();
        int screenPos = (int) (height - (camera.getPinholeVerticalFOV() / 2 + angleToHorizon) / camera.getPinholeVerticalFOV() * height);
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

    public static double calculateSpaceDistance(double x, double y, double z, double x2, double y2, double z2){
        return sqrt(pow(x - x2, 2) + pow(y - y2, 2) + pow(z - z2, 2));
    }

    public static double calculateSpaceDistance(double[] pos1, double[] pos2){
        return sqrt(pow(pos1[0] - pos2[0], 2) + pow(pos1[1] - pos2[1], 2) + pow(pos1[2] - pos2[2], 2));
    }

}
