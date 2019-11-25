package tor;

import tor.spaceObjects.Camera;
import tor.spaceObjects.Pane3D;

import javax.swing.*;

import java.awt.*;

import static tor.visionMath.PerspectiveMath.*;

public class Window extends JFrame
{

    public static final int width = 1000, height = 600;
    public static final double verticalFOV = 90, horizontalFOV = 120;
    public Camera camera;

    public Window(Camera camera)
    {
        this.camera = camera;



        int[] corner1 = makeRelative(1000, -250, 0, this.camera);
        int[] corner2 = makeRelative(1000, 250, 0, this.camera);
        int[] corner3 = makeRelative(1000, 250, 800, this.camera);
        int[] corner4 = makeRelative(1000, -250, 800, this.camera);
        Pane3D thePane = new Pane3D(corner1, corner2, corner3, corner4, Color.BLUE);
        RenderImage vision = new RenderImage(this.camera, thePane);
        add(vision);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void refresh(){
        int[] corner1 = makeRelative(1000, -250, 0, this.camera);
        int[] corner2 = makeRelative(1000, 250, 0, this.camera);
        int[] corner3 = makeRelative(1000, 250, 800, this.camera);
        int[] corner4 = makeRelative(1000, -250, 800, this.camera);
        Pane3D thePane = new Pane3D(corner1, corner2, corner3, corner4, Color.BLUE);
        RenderImage vision = new RenderImage(camera, thePane);
        add(vision);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
