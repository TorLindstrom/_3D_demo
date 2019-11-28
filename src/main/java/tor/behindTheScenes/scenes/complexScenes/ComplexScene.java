package tor.behindTheScenes.scenes.complexScenes;

import tor.behindTheScenes.spaceObjects.objects.complexObjects.ComplexObject;
import tor.behindTheScenes.spaceObjects.objects.simpleObjects.SimpleObject;

import java.util.ArrayList;
import java.util.List;

public class ComplexScene
{
    List<ComplexObject> complexObjects;

    public ComplexScene(){
        complexObjects = new ArrayList<>();
    }

    public void addComplexObject(SimpleObject simpleObject){
        complexObjects.add(new ComplexObject(simpleObject));
    }
}
