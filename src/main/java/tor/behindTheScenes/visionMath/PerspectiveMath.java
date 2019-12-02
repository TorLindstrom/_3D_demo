package tor.behindTheScenes.visionMath;

import tor.behindTheScenes.spaceObjects.Camera;

import static java.lang.Math.*;
import static tor.behindTheScenes.rendering.Window.*;

public class PerspectiveMath
{
    public static int[] makeRelative(double x, double y, double z, Camera camera)
    {
        double relativeX = x - camera.getX();
        double relativeY = y - camera.getY();
        double relativeZ = z - camera.getZ();
        int[] screenPos = new int[2];
        double xyDistance = calculatePaneDistance(relativeX, relativeY);
        double horizontalPlaneAngle = (Math.atan(relativeY / relativeX) * (180 / PI)) - camera.getHorizontalAngle();
        double relativeXYDepth = Math.cos(horizontalPlaneAngle * (PI / 180)) * xyDistance;
        double verticalPlaneAngle = (Math.atan(relativeZ / relativeXYDepth) * (180 / PI)) - camera.getVerticalAngle();
        double zDepthDistance = calculatePaneDistance(relativeZ, relativeXYDepth);

        double relativeDepth = cos(verticalPlaneAngle * (PI / 180)) * zDepthDistance;

        double halfWidthAtDepth = tan(camera.getHorizontalFOV() / 2 * (PI / 180)) * relativeDepth;
        double halfWidthFromLeft = halfWidthAtDepth + sin(horizontalPlaneAngle * PI / 180) * xyDistance; //width deep from left
        double percentageFromTheLeft = halfWidthFromLeft / (halfWidthAtDepth * 2);

        double halfHeightAtDepth = tan(camera.getVerticalFOV() / 2 * (PI / 180)) * relativeDepth;
        double halfHeightFromUp = halfHeightAtDepth - tan(verticalPlaneAngle * PI / 180) * relativeDepth;
        double percentageFromUp = halfHeightFromUp / (halfHeightAtDepth * 2);

        screenPos[0] = (int) ((width * percentageFromTheLeft) + 0.5);
        screenPos[1] = (int) ((height * percentageFromUp) + 0.5);
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

    /*public static int[] makeRelative(double[] pos, Camera camera)
    {
        double relativeX = pos[0] - camera.getX();
        double relativeY = pos[1] - camera.getY();
        double relativeZ = pos[2] - camera.getZ();
        int[] screenPos = new int[2];
        double xyDistance = calculatePaneDistance(relativeX, relativeY);
        double horizontalPlaneAngle = (Math.atan(relativeY / relativeX) * (180 / PI)) - camera.getHorizontalAngle();
        double relativeDepth = Math.cos(horizontalPlaneAngle * (PI / 180)) * xyDistance;
        double verticalPlaneAngle = (Math.atan(relativeZ / relativeDepth) * (180 / PI)) - camera.getVerticalAngle();
        double halfWidthAtDepth = tan(camera.getHorizontalFOV() / 2 * (PI / 180)) * relativeDepth;
        double halfWidthFromLeft = halfWidthAtDepth + sin(horizontalPlaneAngle * PI / 180) * xyDistance; //width deep from left
        double totalWidth = halfWidthAtDepth * 2;
        double percentageFromTheLeft = halfWidthFromLeft / totalWidth;

        double halfHeightAtDepth = tan(camera.getVerticalFOV() / 2 * (PI / 180)) * relativeDepth;
        double halfHeightFromUp = halfHeightAtDepth - tan(verticalPlaneAngle * PI / 180) * relativeDepth;
        double percentageFromUp = halfHeightFromUp / (halfHeightAtDepth * 2);

        screenPos[0] = (int) ((width * percentageFromTheLeft) + 0.5);
        screenPos[1] = (int) ((height * percentageFromUp) + 0.5);
        return screenPos;
    }*/

    public static int[] makeRelative(double[] pos, Camera camera)
    {
        double relativeX = pos[0] - camera.getX();
        double relativeY = pos[1] - camera.getY();
        double relativeZ = pos[2] - camera.getZ();
        int[] screenPos = new int[2];
        double xyDistance = calculatePaneDistance(relativeX, relativeY);
        double horizontalPlaneAngle = (Math.atan(relativeY / relativeX) * (180 / PI)) - camera.getHorizontalAngle();
        double relativeXYDepth = Math.cos(horizontalPlaneAngle * (PI / 180)) * xyDistance;
        double verticalPlaneAngle = (Math.atan(relativeZ / relativeXYDepth) * (180 / PI)) - camera.getVerticalAngle();
        double zDepthDistance = calculatePaneDistance(relativeZ, relativeXYDepth);

        double relativeDepth = cos(verticalPlaneAngle * (PI / 180)) * zDepthDistance;

        double halfWidthAtDepth = tan(camera.getHorizontalFOV() / 2 * (PI / 180)) * relativeDepth;
        double halfWidthFromLeft = halfWidthAtDepth + sin(horizontalPlaneAngle * PI / 180) * xyDistance; //width deep from left
        double percentageFromTheLeft = halfWidthFromLeft / (halfWidthAtDepth * 2);

        double halfHeightAtDepth = tan(camera.getVerticalFOV() / 2 * (PI / 180)) * relativeDepth;
        double halfHeightFromUp = halfHeightAtDepth - tan(verticalPlaneAngle * PI / 180) * relativeDepth;
        double percentageFromUp = halfHeightFromUp / (halfHeightAtDepth * 2);

        screenPos[0] = (int) ((width * percentageFromTheLeft) + 0.5);
        screenPos[1] = (int) ((height * percentageFromUp) + 0.5);
        return screenPos;
    }

    public static int setHorizonLevel(Camera camera)
    {
        double angleToHorizon = -((Math.atan(camera.getPos()[2] / 100000.0)) * (180 / PI)) - camera.getVerticalAngle();
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

    public static double calculateSpaceDistance(double x, double y, double z, double x2, double y2, double z2)
    {
        return sqrt(pow(x - x2, 2) + pow(y - y2, 2) + pow(z - z2, 2));
    }

    public static double calculateSpaceDistance(double[] pos1, double[] pos2)
    {
        return sqrt(pow(pos1[0] - pos2[0], 2) + pow(pos1[1] - pos2[1], 2) + pow(pos1[2] - pos2[2], 2));
    }

}
