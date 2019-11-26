package tor.rendering;

import tor.spaceObjects.Camera;
import tor.spaceObjects.Pane3D;

import javax.swing.*;

import java.awt.*;

import static tor.visionMath.PerspectiveMath.*;

public class PracticeWindow extends JFrame
{

    public static final int width = 1500, height = 900;
    public static final double verticalFOV = 90, horizontalFOV = 120;
    public Camera camera;

    public PracticeWindow(Camera camera)
    {
        this.camera = camera;



        int[] corner1 = makeRelative(1000, -250, 0, this.camera);
        int[] corner2 = makeRelative(1000, 250, 0, this.camera);
        int[] corner3 = makeRelative(1000, 250, 800, this.camera);
        int[] corner4 = makeRelative(1000, -250, 800, this.camera);
        Pane3D thePane = new Pane3D(corner1, corner2, corner3, corner4, Color.BLUE);

        int[] corner21 = makeRelative(2000, -1000, 0, this.camera);
        int[] corner22 = makeRelative(2000, -300, 0, this.camera);
        int[] corner23 = makeRelative(2000, -300, 8000, this.camera);
        int[] corner24 = makeRelative(2000, -1000, 8000, this.camera);
        Pane3D thePane2 = new Pane3D(corner21, corner22, corner23, corner24, Color.CYAN);

        RenderImage vision = new RenderImage(this.camera, thePane2, thePane);
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

        int[] corner21 = makeRelative(2000, -1000, 0, this.camera);
        int[] corner22 = makeRelative(2000, -300, 0, this.camera);
        int[] corner23 = makeRelative(2000, -300, 8000, this.camera);
        int[] corner24 = makeRelative(2000, -1000, 8000, this.camera);
        Pane3D thePane2 = new Pane3D(corner21, corner22, corner23, corner24, Color.CYAN);

        Pane3D thePane = new Pane3D(corner1, corner2, corner3, corner4, Color.BLUE);

        RenderImage vision = new RenderImage(camera, thePane2, thePane);
        add(vision);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
