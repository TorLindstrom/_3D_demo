package tor.behindTheScenes.scenes;

import tor.behindTheScenes.spaceObjects.Pane3D;
import tor.behindTheScenes.spaceObjects.complexObjects.ComplexSide;
import tor.behindTheScenes.spaceObjects.lights.LightSource;

public class PracticeScene
{
    public ComplexSide thePane = ComplexSide.createYZSide(200, 10000, new int[]{350,0,0});
    public ComplexSide thePane2 = ComplexSide.createYZSide(600, 300, new int[]{150,-300,0});

    public LightSource light = new LightSource(0, 0, 180, 100);
}
