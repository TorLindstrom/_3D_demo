package tor.behindTheScenes.rendering;

import tor.behindTheScenes.spaceObjects.Camera;
import tor.behindTheScenes.spaceObjects.Points;
import tor.behindTheScenes.spaceObjects.complexObjects.ComplexSide;
import tor.behindTheScenes.spaceObjects.lights.LightSource;
import tor.behindTheScenes.spaceObjects.shadows.SimpleShadow;
import tor.behindTheScenes.spaceObjects.vertexObjects.Panes;
import tor.behindTheScenes.spaceObjects.vertexObjects.Vertices;
import tor.behindTheScenes.visionMath.PerspectiveMath;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static tor.behindTheScenes.visionMath.PerspectiveMath.*;

public class RenderComplex extends JPanel
{
    ComplexSide[] renderedShapes;
    List<SimpleShadow> simpleShadowList;
    Camera camera;
    LightSource lightSource;

    public RenderComplex(Camera camera, LightSource lightSource, ComplexSide... complexSide)
    {
        this.camera = camera;
        this.lightSource = lightSource;
        this.renderedShapes = complexSide;
        setPreferredSize(new Dimension(PracticeWindow.width, PracticeWindow.height));
    }

    public RenderComplex(Camera camera, List<SimpleShadow> shadows, LightSource lightSource, ComplexSide... complexSide)
    {
        this.camera = camera;
        this.lightSource = lightSource;
        this.renderedShapes = complexSide;
        this.simpleShadowList = shadows;
        setPreferredSize(new Dimension(PracticeWindow.width, PracticeWindow.height));
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(new Color(128, 191, 255));
        g.fillRect(0, 0, PracticeWindow.width, PracticeWindow.height);
        g.setColor(Color.GRAY);
        g.fillRect(0, PerspectiveMath.setHorizonLevel(camera), PracticeWindow.width, PracticeWindow.height);
        Graphics2D g2 = (Graphics2D) g;
        Color lineColor = Color.BLACK;
        Color baseColor = Color.ORANGE;
        /*for (SimpleShadow shadow : simpleShadowList) {
            int[] x = new int[4];
            int[] y = new int[4];
            int i = 0;
            for (Points points : shadow.getSides()) {
                int[] result = PerspectiveMath.makeRelative(points.getX(), points.getY(), points.getZ(), camera);
                x[i] = result[0];
                y[i++] = result[1];
            }
            g2.setColor(Color.BLACK);
            g2.fillPolygon(x, y, x.length);
            g2.setColor(Color.WHITE);
            g2.drawPolygon(x, y, x.length);
        }*/
        for (ComplexSide side : renderedShapes) {
            if (side.shadow != null){
                int[] x = new int[4];
                int[] y = new int[4];
                int i = 0;
                for (Points corner: side.shadow.getCorners()){
                    int[] result = PerspectiveMath.makeRelative(corner.getX(), corner.getY(), corner.getZ(), camera);
                    x[i] = result[0];
                    y[i++] = result[1];
                }
                g2.setColor(Color.BLACK);
                g2.fillPolygon(x, y, x.length);
            }
            for (Panes[] paneRow : side.complexSide) {
                for (Panes pane : paneRow) {
                    int[] centerPos = makeRelative(pane.center, camera);
                    double distanceToLight = calculateSpaceDistance(pane.center, lightSource.getPos());
                    if (centerPos[1] > -50 && centerPos[1] < Window.height + 50 && centerPos[0] > -50 && centerPos[0] < Window.width + 50) {
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
                        //g2.drawPolygon(x, y, x.length);
                    }
                }
            }
        }
    }
}
