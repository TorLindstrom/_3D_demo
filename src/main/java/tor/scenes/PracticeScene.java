package tor.scenes;

import tor.spaceObjects.Pane3D;
import tor.spaceObjects.complexObjects.ComplexSide;
import tor.spaceObjects.lights.LightSource;

import java.awt.*;

import static tor.visionMath.PerspectiveMath.makeRelative;

public class PracticeScene
{
    public ComplexSide thePane = ComplexSide.createYZSide(200, 5000, new int[]{350,-100,0});
    public ComplexSide thePane2 = ComplexSide.createYZSide(400, 300, new int[]{150,-200,0});

    public LightSource light = new LightSource(0, 0, 180, 100);
}
