package tor.visionMath;

import static java.lang.Math.PI;

public class AnglesMath
{
    public static double calculateAngle(double xDiff, double yDiff){
        return Math.atan(yDiff / xDiff) * (180 / PI);
    }
}
