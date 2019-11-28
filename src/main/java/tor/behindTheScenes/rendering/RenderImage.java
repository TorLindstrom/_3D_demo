package tor.behindTheScenes.rendering;

import tor.behindTheScenes.spaceObjects.Camera;
import tor.behindTheScenes.spaceObjects.Pane3D;
import tor.behindTheScenes.visionMath.PerspectiveMath;

import javax.swing.*;
import java.awt.*;

public class RenderImage extends JPanel
{
    Pane3D[] renderedShapes;
    Camera camera;

    public RenderImage(Camera camera, Pane3D... toBeRendered)
    {
        this.camera = camera;
        setPreferredSize(new Dimension(PracticeWindow.width, PracticeWindow.height));
        renderedShapes = toBeRendered;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        g.fillRect(0, PerspectiveMath.setHorizonLevel(camera), PracticeWindow.width, PracticeWindow.height);
        for (Pane3D pane: renderedShapes) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(pane.getColor());
            g2.fillPolygon(pane.x, pane.y, pane.x.length);
            g2.setColor(pane.getColor().darker());
            g2.drawPolygon(pane.x, pane.y, pane.x.length);
        }
    }
}
