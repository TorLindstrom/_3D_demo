package tor.behindTheScenes.scenes.simpleScenes;

import tor.behindTheScenes.scenes.complexScenes.ComplexScene;
import tor.behindTheScenes.spaceObjects.Camera;
import tor.behindTheScenes.spaceObjects.lights.LightSource;
import tor.behindTheScenes.spaceObjects.objects.complexObjects.ComplexObject;
import tor.behindTheScenes.spaceObjects.objects.simpleObjects.SimpleObject;
import tor.behindTheScenes.spaceObjects.shadows.ComplexShadow;
import tor.behindTheScenes.spaceObjects.shadows.SimpleShadow;

import java.util.ArrayList;
import java.util.List;

public class Scene
{
    List<SimpleObject> simpleObjects;
    ArrayList<SimpleShadow> simpleShadows;
    List<LightSource> lightSources;
    Camera camera;

    ComplexScene complexScene;

    public Scene(LightSource light){
        lightSources = new ArrayList<>();
        lightSources.add(light);
        simpleObjects = new ArrayList<>();
        simpleShadows = new ArrayList<>();
        complexScene = new ComplexScene();
    }

    public void addSimpleObject(SimpleObject simpleObject){
        simpleObjects.add(simpleObject);
        complexScene.addComplexObject(simpleObject);
        simpleShadows.add(new SimpleShadow(simpleObject, lightSources.get(0)));
        complexScene.addComplexShadow(simpleObject);
    }

    public List<SimpleShadow> getSimpleShadows()
    {
        return simpleShadows;
    }
}
