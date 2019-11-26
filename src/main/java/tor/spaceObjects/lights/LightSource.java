package tor.spaceObjects.lights;

import tor.spaceObjects.Points;

public class LightSource extends Points
{
    private double strength;

    public LightSource(int x, int y, int z){
        super(x, y, z);
    }

    public LightSource(int x, int y, int z, double strength){
        this(x, y, z);
        this.strength = strength;
    }
}
