import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by Dmitry on 16/01/16.
 */
public class RobotClick {
    private static Robot robot = null;

    public static void main(String[] args) {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        click(150, 250);

    }

    public static void click(int x, int y) {
        robot.mouseMove(x, y);
        robot.delay(5);
        robot.mousePress(MouseEvent.BUTTON1_MASK);
        robot.mouseRelease(MouseEvent.BUTTON1_MASK);

    }
}