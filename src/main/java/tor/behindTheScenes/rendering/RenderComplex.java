package tor.behindTheScenes.rendering;

import tor.behindTheScenes.spaceObjects.Camera;
import tor.behindTheScenes.spaceObjects.complexObjects.ComplexSide;
import tor.behindTheScenes.spaceObjects.lights.LightSource;
import tor.behindTheScenes.spaceObjects.vertexObjects.Panes;
import tor.behindTheScenes.spaceObjects.vertexObjects.Vertices;
import tor.behindTheScenes.visionMath.PerspectiveMath;

import javax.swing.*;
import java.awt.*;

import static tor.behindTheScenes.visionMath.PerspectiveMath.*;

public class RenderComplex extends JPanel
{
    ComplexSide[] renderedShapes;
    Camera camera;
    LightSource lightSource;

    public RenderComplex(Camera camera, LightSource lightSource, ComplexSide...complexSide)
    {
        this.camera = camera;
        this.lightSource = lightSource;
        this.renderedShapes = complexSide;
        setPreferredSize(new Dimension(PracticeWindow.width, PracticeWindow.height));
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        g.fillRect(0, PerspectiveMath.setHorizonLevel(camera), PracticeWindow.width, PracticeWindow.height);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.PINK);
        Color lineColor = Color.BLACK;
        Color baseColor = Color.ORANGE;
        for (ComplexSide side: renderedShapes) {
            for (Panes[] paneRow : side.complexSide) {
                for (Panes pane : paneRow) {
                    int[] centerPos = makeRelative(pane.center, camera);
                    double distanceToLight = calculateSpaceDistance(pane.center, lightSource.getPos());
                    if (centerPos[1] > -30 && centerPos[1] < Window.height + 30 && centerPos[0] > -30 && centerPos[0] < Window.width + 30) {
                        int[] x = new int[4];
                        int[] y = new int[4];
                        int i = 0;
                        for (Vertices vertex : pane.corners) {
                            int[] result = PerspectiveMath.makeRelative(vertex.getX(), vertex.getY(), vertex.getZ(), camera);
                            x[i] = result[0];
                            y[i++] = result[1];
                        }
                        int red = baseColor.getRed() - distanceToLight / 3 > 20 ? (int) (baseColor.getRed() - distanceToLight / 3) : 20;
                        int green = baseColor.getGreen() - distanceToLight / 3 > 20 ? (int) (baseColor.getGreen() - distanceToLight / 3) : 20;
                        int blue = baseColor.getBlue() - distanceToLight / 3 > 20 ? (int) (baseColor.getBlue() - distanceToLight / 3) : 20;
                        Color shadedColor = new Color(red, green, blue);
                        g2.setColor(shadedColor);
                        g2.fillPolygon(x, y, x.length);
                        g2.setColor(lineColor);
                        g2.drawPolygon(x, y, x.length);
                    }
                }
            }
        }
    }
}