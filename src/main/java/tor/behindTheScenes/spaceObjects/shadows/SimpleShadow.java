package tor.behindTheScenes.spaceObjects.shadows;

import tor.behindTheScenes.spaceObjects.Points;
import tor.behindTheScenes.spaceObjects.lights.LightSource;
import tor.behindTheScenes.spaceObjects.objects.simpleObjects.SimpleObject;
import tor.behindTheScenes.visionMath.LightMath;

public class SimpleShadow
{
    Points[] corners;

    public SimpleShadow(SimpleObject simpleObject, LightSource lightSource){
        Points corner1 = LightMath.createShadowCorners(simpleObject.getSides()[0][0], lightSource);
        Points corner2 = LightMath.createShadowCorners(simpleObject.getSides()[0][1], lightSource);
        Points corner3 = LightMath.createShadowCorners(simpleObject.getSides()[0][2], lightSource);
        Points corner4 = LightMath.createShadowCorners(simpleObject.getSides()[0][3], lightSource);
        corners = new Points[]{corner1, corner2, corner3, corner4};
    }

    public Points[] getCorners()
    {
        return corners;
    }
}
