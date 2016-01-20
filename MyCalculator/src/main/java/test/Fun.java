package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class Fun extends JFrame {
    JLabel l;
    Robot r;
    JTextField xcord, ycord;

    public static void main(String args[]) {
        new Fun().start();
    }

    void start() {
        try {
            JFrame f = new JFrame("Fun");
            JTextField txt = new JTextField(20);
            l = new JLabel("Printing msg without touching keyboard.");
            JLabel l2 = new JLabel("Pixel color determiner.Enter x and y coordinates");
            xcord = new JTextField(6);
            ycord = new JTextField(6);
            JButton but = new JButton("Determine");
            but.setEnabled(false);
            f.add(txt);
            f.add(l);
            f.add(l2);
            f.add(xcord);
            f.add(ycord);
            f.add(but);
            f.setSize(500, 200);
            f.setVisible(true);
            f.setLayout(new FlowLayout());
            f.setDefaultCloseOperation(EXIT_ON_CLOSE);
            f.setLocation(400, 400);
            r = new Robot();
            r.setAutoDelay(900);
            r.keyPress(KeyEvent.VK_T);
            r.keyPress(KeyEvent.VK_H);
            r.keyPress(KeyEvent.VK_I);
            r.keyPress(KeyEvent.VK_S);
            r.keyPress(KeyEvent.VK_SPACE);
            r.keyPress(KeyEvent.VK_I);
            r.keyPress(KeyEvent.VK_S);
            r.keyPress(KeyEvent.VK_SPACE);
            r.keyPress(KeyEvent.VK_F);
            r.keyPress(KeyEvent.VK_U);
            r.keyPress(KeyEvent.VK_N);
            l.setText("Moving mouse without touching");
            r.mouseMove(410, 110);
            r.mouseMove(410, 210);
            r.mouseMove(410, 310);
            r.mouseMove(410, 410);
            l.setText("Performing Mouse right click");
            r.mousePress(InputEvent.BUTTON3_MASK);
            r.mouseRelease(InputEvent.BUTTON3_MASK);
            l.setText("Performing Mouse left click after moving mouse to right");
            r.mouseMove(700, 410);
            r.mousePress(InputEvent.BUTTON1_MASK);
            r.mouseRelease(InputEvent.BUTTON1_MASK);
            but.setEnabled(true);
            but.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    l.setText(r.getPixelColor(Integer.parseInt(xcord.getText()), Integer.parseInt(ycord.getText())).toString());
                }
            });
        } catch (Exception e) {
        }
    }
}
