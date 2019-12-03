package tor.behindTheScenes.rendering;

import tor.behindTheScenes.spaceObjects.Camera;
import tor.behindTheScenes.spaceObjects.complexObjects.ComplexSide;
import tor.behindTheScenes.spaceObjects.lights.LightSource;
import tor.behindTheScenes.spaceObjects.objects.complexObjects.ComplexObject;
import tor.behindTheScenes.spaceObjects.shadows.SimpleShadow;

import javax.swing.*;
import java.util.List;

public class NewWindow extends JFrame
{
    public static final int width = 1500, height = 900;
    //public static final double verticalFOV = 100, horizontalFOV = 140;
    public Camera camera;
    public ComplexSide[] sides;
    public ComplexSide complexSide;
    public LightSource lightSource;
    public List<SimpleShadow> shadows;

    public NewWindow(Camera camera, LightSource lightSource, List<SimpleShadow> shadows, ComplexSide...complexSides)
    {
        this.sides = complexSides;
        this.complexSide = complexSides[0];
        this.shadows = shadows;
        this.camera = camera;
        this.lightSource = lightSource;

        RenderComplex vision = new RenderComplex(this.camera, shadows, lightSource, sides);
        add(vision);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void refresh()
    {
        RenderComplex vision = new RenderComplex(camera, shadows, lightSource, sides);
        add(vision);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

