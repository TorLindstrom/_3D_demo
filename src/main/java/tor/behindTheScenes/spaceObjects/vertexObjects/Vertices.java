package tor.behindTheScenes.spaceObjects.vertexObjects;

import tor.behindTheScenes.spaceObjects.Points;

public class Vertices extends Points
{
    Vertices[] connections;

    public Vertices(int x, int y, int z){
        super(x, y, z);
    }

    public Vertices(int x, int y, int z, Vertices...connections){
        super(x, y, z);
        this.connections = connections;
    }


}
