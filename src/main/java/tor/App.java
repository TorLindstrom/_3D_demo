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
        Camera camera = new Camera(-200, 0, 100, 140, 100, 200., 100.);
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
                Thread.sleep(50);
            }

            for (int i = 0; i < 100; i++) {
                camera.setX(camera.getX() + 1);
                camera.setVerticalAngle(camera.getVerticalAngle() - 1);
                window.refresh();
                Thread.sleep(50);
            }

            for (int i = 0; i < 100; i++) {
                camera.setHorizontalAngle(camera.getHorizontalAngle() - 1);
                window.refresh();
                Thread.sleep(50);
            }

            for (int i = 0; i < 100; i++) {
                camera.setHorizontalAngle(camera.getHorizontalAngle() + 1);
                window.refresh();
                Thread.sleep(50);
            }
        }
    }
}
