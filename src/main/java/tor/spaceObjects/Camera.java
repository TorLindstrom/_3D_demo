package tor.spaceObjects;

public class Camera extends Points
{
    double horizontalAngle;
    double verticalAngle;

    int horizontalFOV = 120;
    int verticalFOV = 90;

    public Camera(int x, int y, int z){
        super(x, y, z);
    }
    public Camera(int x, int y, int z, double horizontalAngle, double verticalAngle){
        this(x, y, z);
        this.horizontalAngle = horizontalAngle;
        this.verticalAngle = verticalAngle;
    }
    public Camera(int x, int y, int z, double horizontalAngle, double verticalAngle, int horizontalFOV, int verticalFOV){
        this(x, y, z, horizontalAngle, verticalAngle);
        this.horizontalFOV = horizontalFOV;
        this.verticalFOV = verticalFOV;
    }
    public Camera(int x, int y, int z, int horizontalFOV, int verticalFOV){
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

    public int getHorizontalFOV()
    {
        return horizontalFOV;
    }

    public void setHorizontalFOV(int horizontalFOV)
    {
        this.horizontalFOV = horizontalFOV;
    }

    public int getVerticalFOV()
    {
        return verticalFOV;
    }

    public void setVerticalFOV(int verticalFOV)
    {
        this.verticalFOV = verticalFOV;
    }
}
