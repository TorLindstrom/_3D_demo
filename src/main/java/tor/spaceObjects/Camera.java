package tor.spaceObjects;

import tor.visionMath.PerspectiveMath;

import static java.lang.Math.PI;

public class Camera extends Points
{
    double horizontalAngle;
    double verticalAngle;

    double horizontalFOV = 120;
    double verticalFOV = 90;

    double depthOfField = 200;
    double distanceToPinHole = 400;
    double pinholeHorizontalFov;
    double pinholeVerticalFOV;
    double[] pinholePos;

    public Camera(int x, int y, int z)
    {
        super(x, y, z);
    }

    public Camera(int x, int y, int z, double horizontalAngle, double verticalAngle)
    {
        this(x, y, z);
        this.horizontalAngle = horizontalAngle;
        this.verticalAngle = verticalAngle;
    }

    public Camera(int x, int y, int z, double horizontalAngle, double verticalAngle, int horizontalFOV, int verticalFOV)
    {
        this(x, y, z, horizontalAngle, verticalAngle);
        this.horizontalFOV = horizontalFOV;
        this.verticalFOV = verticalFOV;
    }

    public Camera(int x, int y, int z, int horizontalFOV, int verticalFOV)
    {
        this(x, y, z);
        this.horizontalFOV = horizontalFOV;
        this.verticalFOV = verticalFOV;
    }

    public Camera(int x, int y, int z, double horizontalFOV, double verticalFOV, double depthOfField, double distanceToPinHole)
    {
        this(x, y, z, (int) horizontalFOV, (int) verticalFOV);
        this.depthOfField = depthOfField;
        this.distanceToPinHole = distanceToPinHole;
        setPinholeHorizontalFov();
        setPinholeVerticalFOV();
    }

    public void setDepthOfField(double depthOfField)
    {
        this.depthOfField = depthOfField;
        setPinholeVerticalFOV();
        setPinholeHorizontalFov();
    }

    public void setDistanceToPinHole(double distanceToPinHole)
    {
        this.distanceToPinHole = distanceToPinHole;
        setPinholeHorizontalFov();
        setPinholeVerticalFOV();
    }

    public double getDepthOfField()
    {
        return depthOfField;
    }

    public double getDistanceToPinHole()
    {
        return distanceToPinHole;
    }

    public double getPinholeHorizontalFov()
    {
        return pinholeHorizontalFov;
    }

    public double getPinholeVerticalFOV()
    {
        return pinholeVerticalFOV;
    }

    public void setPinholeHorizontalFov()
    {
        double widthAtDOF = Math.tan(horizontalFOV / 2 * PI / 180) * depthOfField;
        pinholeHorizontalFov = Math.atan(widthAtDOF / (depthOfField + distanceToPinHole)) * (180 / PI) * 2;
    }

    public void setPinholeVerticalFOV()
    {
        double heightAtDOF = Math.tan(verticalFOV / 2 * PI / 180) * depthOfField;
        pinholeVerticalFOV = Math.atan(heightAtDOF / (depthOfField + distanceToPinHole)) * (180 / PI) * 2;
    }

    public double[] getPinholePos()
    {
        return pinholePos;
    }

    public void setPinholePos(double[] pinholePos)
    {
        this.pinholePos = pinholePos;
    }

    public double getHorizontalAngle()
    {
        return horizontalAngle;
    }

    public void setHorizontalAngle(double horizontalAngle)
    {
        this.horizontalAngle = horizontalAngle;
    }

    public double getVerticalAngle()
    {
        return verticalAngle;
    }

    public void setVerticalAngle(double verticalAngle)
    {
        this.verticalAngle = verticalAngle;
    }

    public double getHorizontalFOV()
    {
        return horizontalFOV;
    }

    public void setHorizontalFOV(double horizontalFOV)
    {
        this.horizontalFOV = horizontalFOV;
        //PerspectiveMath.calculatePinholeFOV(this);
        setPinholeHorizontalFov();
    }

    public double getVerticalFOV()
    {
        return verticalFOV;
    }

    public void setVerticalFOV(double verticalFOV)
    {
        this.verticalFOV = verticalFOV;
        //PerspectiveMath.calculatePinholeFOV(this);
        setPinholeVerticalFOV();
    }
}
