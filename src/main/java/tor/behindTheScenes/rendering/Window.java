package tor.behindTheScenes.rendering;

import tor.behindTheScenes.spaceObjects.Camera;
import tor.behindTheScenes.spaceObjects.complexObjects.ComplexSide;
import tor.behindTheScenes.spaceObjects.lights.LightSource;

import javax.swing.*;

public class Window extends JFrame
{
    public static final int width = 1500, height = 900;
    public static final double verticalFOV = 100, horizontalFOV = 140;
    public Camera camera;
    public ComplexSide[] sides;
    public ComplexSide complexSide;
    public LightSource lightSource;

    public Window(Camera camera, LightSource lightSource, ComplexSide...complexSide)
    {
        this.sides = complexSide;
        this.complexSide = complexSide[0];
        this.camera = camera;
        this.lightSource = lightSource;

        RenderComplex vision = new RenderComplex(this.camera, lightSource, sides);
        add(vision);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void refresh(){
        RenderComplex vision = new RenderComplex(camera, lightSource, sides);
        add(vision);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
