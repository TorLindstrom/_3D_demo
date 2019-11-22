package tor;

import javax.swing.*;

import java.awt.*;

import static tor.visionMath.perspectiveMath.*;

public class Window extends JFrame
{

    public static final int width = 1000, height = 600;
    public static final double verticalFOV = 70, horizontalFOV = 120;

    public Window(){
        int[] corner1 = makeRelative(800, -250, 0);
        int[] corner2 = makeRelative(800, 250, 0);
        int[] corner3 = makeRelative(800, -250, 200);
        int[] corner4 = makeRelative(800, 250, 200);
        Pane3D thePane = new Pane3D(corner1, corner2, corner3, corner4, Color.BLUE);
        //setSize(width, height);
        RenderImage vision = new RenderImage(thePane);
        add(vision);
        pack();
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
