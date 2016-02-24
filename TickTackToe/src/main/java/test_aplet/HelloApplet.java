package test_aplet;

import java.applet.Applet;
import java.awt.*;

/**
 * Created by Dmitry on 25/01/16.
 */
public class HelloApplet extends Applet {
    public void paint(Graphics graphics) {
        graphics.drawString("Sup, nigga!", 70, 40);
    }
}
