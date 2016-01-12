import javax.swing.*;
import java.awt.*;

/**
 * Created by Dmitry on 12/01/16.
 */
public class CalculatorPlay {
    JPanel windowContent = new JPanel();
    JFormattedTextField displayField = new JFormattedTextField();
    JButton buttonAC = new JButton("AC");
    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();

    BorderLayout bL = new BorderLayout();
    BorderLayout bL1 = new BorderLayout();
    BorderLayout bL2 = new BorderLayout();

    CalculatorPlay() {
        windowContent.setLayout(bL);
        p1.setLayout(bL2);
        p2.setLayout(bL1);
//        p3.setLayout(bL2);

        windowContent.add("North", displayField);
        windowContent.add("South", p1);

        //Создаём фрейм и задаём его основную панель
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(windowContent);
        frame.setLocationRelativeTo(null);  //this will center an app
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        CalculatorPlay calculatorPlay = new CalculatorPlay();
    }


}
