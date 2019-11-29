package tor.behindTheScenes.scenes.simpleScenes;

import tor.behindTheScenes.scenes.complexScenes.ComplexScene;
import tor.behindTheScenes.spaceObjects.Camera;
import tor.behindTheScenes.spaceObjects.lights.LightSource;
import tor.behindTheScenes.spaceObjects.objects.complexObjects.ComplexObject;
import tor.behindTheScenes.spaceObjects.objects.simpleObjects.SimpleObject;

import java.util.ArrayList;
import java.util.List;

public class Scene
{
    List<SimpleObject> simpleObjects;
    List<ComplexObject> complexObjects;
    List<LightSource> lightSources;
    Camera camera;

    ComplexScene complexScene;

    public Scene(){
        simpleObjects = new ArrayList<>();
        complexObjects = new ArrayList<>();
        lightSources = new ArrayList<>();
        complexScene = new ComplexScene();
    }

    public void addSimpleObject(SimpleObject simpleObject){
        simpleObjects.add(simpleObject);
        complexScene.addComplexObject(simpleObject);
    }

}
