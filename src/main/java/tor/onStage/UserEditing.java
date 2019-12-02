package tor.onStage;

import tor.behindTheScenes.rendering.Window;
import tor.behindTheScenes.scenes.PracticeScene;
import tor.behindTheScenes.scenes.simpleScenes.Scene;
import tor.behindTheScenes.spaceObjects.Camera;
import tor.behindTheScenes.spaceObjects.Points;
import tor.behindTheScenes.spaceObjects.objects.simpleObjects.SimpleObject;

import java.util.Scanner;

public class UserEditing
{
    public static void setup() throws InterruptedException
    {
        Camera camera = new Camera(-100, 0, 100, 0, 0, 100., 80.);
        PracticeScene practiceScene = new PracticeScene();
        Window window = new Window(camera, practiceScene.light, practiceScene.thePane, practiceScene.thePane2);

        /*while (true){
            Scanner scan = new Scanner(System.in);
            scan.nextLine();

            for (int i = 0; i < 20; i++) {
                camera.setDepthOfField(camera.getDepthOfField() + 5);
                window.refresh();
                Thread.sleep(70);
            }
            for (int i = 0; i < 20; i++) {
                camera.setDepthOfField(camera.getDepthOfField() - 5);
                window.refresh();
                Thread.sleep(70);
            }
            scan.nextLine();

            for (int i = 0; i < 20; i++) {
                camera.setHorizontalFOV(camera.getHorizontalFOV() + 1);
                window.refresh();
                Thread.sleep(70);
            }
            for (int i = 0; i < 20; i++) {
                camera.setHorizontalFOV(camera.getHorizontalFOV() - 1);
                window.refresh();
                Thread.sleep(70);
            }
            scan.nextLine();

            for (int i = 0; i < 20; i++) {
                camera.setVerticalFOV(camera.getVerticalFOV() + 1);
                window.refresh();
                Thread.sleep(70);
            }
            for (int i = 0; i < 20; i++) {
                camera.setVerticalFOV(camera.getVerticalFOV() - 1);
                window.refresh();
                Thread.sleep(70);
            }
            scan.nextLine();
        }*/

        while (true) {
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();

            for (int i = 0; i < 200; i++) {
                camera.setY(camera.getY() + 1);
                camera.setX(camera.getX() - 1);
                window.refresh();
                Thread.sleep(30);
            }

            for (int i = 0; i < 200; i++) {
                camera.setY(camera.getY() - 1);
                camera.setX(camera.getX() + 1);
                window.refresh();
                Thread.sleep(30);
            }

            for (int i = 0; i < 60; i++) {
                camera.setX(camera.getX() - 1);
                camera.setVerticalAngle(camera.getVerticalAngle() + 1);
                window.refresh();
                Thread.sleep(60);
            }

            for (int i = 0; i < 60; i++) {
                camera.setX(camera.getX() + 1);
                camera.setVerticalAngle(camera.getVerticalAngle() - 1);
                window.refresh();
                Thread.sleep(60);
            }

            for (int i = 0; i < 40; i++) {
                camera.setHorizontalAngle(camera.getHorizontalAngle() - 1);
                window.refresh();
                Thread.sleep(60);
            }

            for (int i = 0; i < 40; i++) {
                camera.setHorizontalAngle(camera.getHorizontalAngle() + 1);
                window.refresh();
                Thread.sleep(60);
            }
        }

        /*Scene scene = new Scene();
        createYPane(scene, 400, 300, new int[]{300, 400, 0});
        createXPane(scene, 400, 300, new int[]{-100, -600, 0});*/
    }

    public static void createYPane(Scene scene, int width, int height, int[] pos){
        Points[] corners = new Points[]{
                new Points(pos[0] , pos[1], pos[2]),
                new Points(pos[0], pos[1] + width, pos[2]),
                new Points(pos[0], pos[1] + width,pos[2] + height),
                new Points(pos[0], pos[1], pos[2] + height)};
        scene.addSimpleObject(new SimpleObject(corners));
    }

    public static void createXPane(Scene scene, int length, int height, int[] pos){
        Points[] corners = new Points[]{
                new Points(pos[0], pos[1], pos[2]),
                new Points(pos[0] + length, pos[1], pos[2]),
                new Points(pos[0] + length, pos[1],pos[2] + height),
                new Points(pos[0], pos[1], pos[2] + height)};
        scene.addSimpleObject(new SimpleObject(corners));
    }
}
