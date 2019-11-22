package tor;

import javax.swing.*;
import java.awt.*;

public class RenderImage extends JPanel
{
    Pane3D[] renderedShapes;

    public RenderImage(Pane3D... toBeRendered)
    {
        setPreferredSize(new Dimension(Window.width, Window.height));
        renderedShapes = toBeRendered;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (Pane3D pane: renderedShapes) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(pane.getColor());
            g2.fillPolygon(pane.x, pane.y, 4);
        }
    }
}
