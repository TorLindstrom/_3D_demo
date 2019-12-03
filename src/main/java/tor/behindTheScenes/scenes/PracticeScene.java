package tor.behindTheScenes.scenes;

import tor.behindTheScenes.spaceObjects.complexObjects.ComplexSide;
import tor.behindTheScenes.spaceObjects.lights.LightSource;
import tor.behindTheScenes.spaceObjects.objects.simpleObjects.SimpleObject;
import tor.behindTheScenes.spaceObjects.shadows.SimpleShadow;

import java.awt.*;

public class PracticeScene
{
    public ComplexSide thePane = ComplexSide.createYZSide(200, 10000, new int[]{350,0,0});
    public ComplexSide thePane2 = ComplexSide.createYZSide(600, 300, new int[]{150,-300,0});

    public LightSource light = new LightSource(0, -300, 500, 100);
    public SimpleShadow paneShadow = new SimpleShadow(new SimpleObject(thePane2.corners), light);

    {thePane2.shadow = paneShadow;}
}
