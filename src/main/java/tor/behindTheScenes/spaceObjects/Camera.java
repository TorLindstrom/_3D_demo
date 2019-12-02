package tor.behindTheScenes.spaceObjects;

public class Camera extends Points
{
    double horizontalAngle;
    double verticalAngle;

    double horizontalFOV = 120;
    double verticalFOV = 90;

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

    public Camera(int x, int y, int z, double horizontalAngle, double verticalAngle, double horizontalFOV, double verticalFOV)
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
    }

    public double getVerticalFOV()
    {
        return verticalFOV;
    }

    public void setVerticalFOV(double verticalFOV)
    {
        this.verticalFOV = verticalFOV;
    }
}
