package tor;

import tor.spaceObjects.Camera;

import java.util.Calendar;
import java.util.Scanner;

public class App
{
    public static void main(String[] args) throws InterruptedException
    {
        /*Camera camera = new Camera(0, 0, 0, 120, 90);
        Window window = new Window(camera);*/

        Camera camera = new Camera(50, -50, 180, 0, 0, 120, 90);
        Window window = new Window(camera);


        while (true) {
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();

            for (int i = 0; i < 70; i++) {
                camera.setY(camera.getY() + 10);
                camera.setX(camera.getX() - 3);
                window.refresh();
                Thread.sleep(100);
            }

            for (int i = 0; i < 70; i++) {
                camera.setY(camera.getY() - 10);
                camera.setX(camera.getX() + 3);
                window.refresh();
                Thread.sleep(100);
            }

            for (int i = 0; i < 40; i++) {
                camera.setX(camera.getX() - 5);
                camera.setVerticalAngle(camera.getVerticalAngle() + 1);
                window.refresh();
                Thread.sleep(100);
            }

            for (int i = 0; i < 40; i++) {
                camera.setX(camera.getX() + 5);
                camera.setVerticalAngle(camera.getVerticalAngle() - 1);
                window.refresh();
                Thread.sleep(100);
            }

            for (int i = 0; i < 40; i++) {
                camera.setHorizontalAngle(camera.getHorizontalAngle() - 1);
                window.refresh();
                Thread.sleep(100);
            }

            for (int i = 0; i < 40; i++) {
                camera.setHorizontalAngle(camera.getHorizontalAngle() + 1);
                window.refresh();
                Thread.sleep(100);
            }
        }
    }
}
