package tor.behindTheScenes.visionMath;

import tor.behindTheScenes.spaceObjects.Points;
import tor.behindTheScenes.spaceObjects.lights.LightSource;
import tor.behindTheScenes.spaceObjects.objects.simpleObjects.SimpleObject;

import static java.lang.Math.*;

public class LightMath
{
    public static int reduceLight(int[] posObject, LightSource light){
        return 1;
    }

    /*public static Panes createShadow(int[][] panePos, int[] lightPos){
        int xDiff = panePos[0][0] - lightPos[0], yDiff = panePos[0][1] - lightPos[1], zDiff = panePos[0][2] - lightPos[2];
        double xyPlaneAngle = AnglesMath.calculateAngle(xDiff, yDiff);
    }*/

    public static Points createShadowCorners(Points cornerPos, LightSource lightPos){
        double zDiff = lightPos.getZ() - cornerPos.getZ();
        double xyDistance = PerspectiveMath.calculatePaneDistance(lightPos.getX(), lightPos.getY(), cornerPos.getX(), cornerPos.getY());
        double verticalAngle = atan(zDiff / xyDistance) * (180 / PI);
        double shadowCornerDistance = tan((90 - verticalAngle) * (PI / 180)) * cornerPos.getZ();
        double horizontalAngleToLight = atan(((double)lightPos.getY() - cornerPos.getY()) / (lightPos.getX() - cornerPos.getX())) * (180 / PI);

        double x = cos((horizontalAngleToLight + 180) * (PI / 180)) * shadowCornerDistance;
        double y = sin((horizontalAngleToLight + 180) * (PI / 180)) * shadowCornerDistance;
        return new Points(cornerPos.getX() - x, cornerPos.getY() - y, 0);
    }
}
