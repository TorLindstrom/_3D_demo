package tor.behindTheScenes.spaceObjects;

public abstract class Points
{
    int x;
    int y;
    int z;

    public Points(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double[] getPos(){
        return new double[]{x, y, z};
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getZ()
    {
        return z;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void setZ(int z)
    {
        this.z = z;
    }
}
