package tor;

import tor.rendering.PracticeWindow;
import tor.rendering.Window;
import tor.scenes.PracticeScene;
import tor.spaceObjects.Camera;
import tor.spaceObjects.complexObjects.ComplexSide;

import java.util.Scanner;

public class App
{
    public static void main(String[] args) throws InterruptedException
    {
        /*Camera camera = new Camera(0, 0, 0, 120, 90);
        Window window = new Window(camera);*/

        Camera camera = new Camera(-100, -50, 180, 0, 0, 200, 160);
        PracticeScene practiceScene = new PracticeScene();
        Window window = new Window(camera, practiceScene.light, practiceScene.thePane, practiceScene.thePane2);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();

            for (int i = 0; i < 400; i++) {
                camera.setY(camera.getY() + 1);
                camera.setX(camera.getX() - 1);
                window.refresh();
                Thread.sleep(30);
            }

            for (int i = 0; i < 400; i++) {
                camera.setY(camera.getY() - 1);
                camera.setX(camera.getX() + 1);
                window.refresh();
                Thread.sleep(30);
            }

            for (int i = 0; i < 100; i++) {
                camera.setX(camera.getX() - 1);
                camera.setVerticalAngle(camera.getVerticalAngle() + 1);
                window.refresh();
                Thread.sleep(30);
            }

            for (int i = 0; i < 100; i++) {
                camera.setX(camera.getX() + 1);
                camera.setVerticalAngle(camera.getVerticalAngle() - 1);
                window.refresh();
                Thread.sleep(30);
            }

            for (int i = 0; i < 100; i++) {
                camera.setHorizontalAngle(camera.getHorizontalAngle() - 1);
                window.refresh();
                Thread.sleep(30);
            }

            for (int i = 0; i < 100; i++) {
                camera.setHorizontalAngle(camera.getHorizontalAngle() + 1);
                window.refresh();
                Thread.sleep(30);
            }
        }
    }
}
