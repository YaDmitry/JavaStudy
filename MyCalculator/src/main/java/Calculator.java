import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Calculator {

//    TODO
//    No errors
//    Unit tests all operations
//    Smoke test ROBOT
//    TRY - CATCH
//    2 строки

    //Set default font for the buttons
    Font buttonFont = new Font("OCR A Extended", 0, 30);
    Font textFont = new Font("OCR A Extended", 0, 27);

    // Describe all calculator elements
    JPanel windowContent;
    JFormattedTextField displayField;

    JButton numButtons[] = new JButton[10];
    JButton buttonAC;
    JButton buttonPoint;
    JButton buttonEqual;
    JButton buttonPlus;
    JButton buttonMinus;
    JButton buttonDivide;
    JButton buttonMultiply;
    JButton buttonX2;

    JPanel p1;
    JPanel p2;
    JPanel p3;

    // В конструкторе создаются все компоненты и добавляются на фрейм
    // с помощью комбинации Borderlayout и Gridlayout
    Calculator() {

        //Create all the panels with specified schema
        windowContent = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();

        BorderLayout bL1 = new BorderLayout();
        BorderLayout bL2 = new BorderLayout();
        GridLayout gL1 = new GridLayout(5, 2);
        GridLayout gL2 = new GridLayout(3, 2);

        windowContent.setLayout(bL1);
        p1.setLayout(bL2);
        p2.setLayout(gL1);
        p3.setLayout(gL2);

        //Create input text field
        displayField = new JFormattedTextField();
        displayField.setFont(textFont);
        displayField.setForeground(Color.BLUE);
        displayField.setHorizontalAlignment(SwingConstants.RIGHT);

        //Create all the buttons
        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].setFont(buttonFont);
        }

        buttonAC = new JButton("AC");
        buttonAC.setFont(buttonFont);
        buttonAC.setForeground(Color.red);
        buttonX2 = new JButton("x2");
        buttonX2.setFont(buttonFont);
        buttonPoint = new JButton(".");
        buttonPoint.setFont(buttonFont);
        buttonEqual = new JButton("=");
        buttonEqual.setFont(buttonFont);
        buttonEqual.setBackground(Color.orange);
        buttonEqual.setOpaque(true);
        buttonEqual.setBorderPainted(false);

        buttonPlus = new JButton("+");
        buttonPlus.setFont(buttonFont);
        buttonPlus.setBackground(Color.orange);
        buttonPlus.setOpaque(true);
        buttonPlus.setBorderPainted(false);

        buttonMinus = new JButton("-");
        buttonMinus.setFont(buttonFont);
        buttonMinus.setBackground(Color.orange);
        buttonMinus.setOpaque(true);
        buttonMinus.setBorderPainted(false);

        buttonDivide = new JButton("/");
        buttonDivide.setFont(buttonFont);
        buttonDivide.setBackground(Color.orange);
        buttonDivide.setOpaque(true);
        buttonDivide.setBorderPainted(false);

        buttonMultiply = new JButton("*");
        buttonMultiply.setFont(buttonFont);
        buttonMultiply.setBackground(Color.orange);
        buttonMultiply.setOpaque(true);
        buttonMultiply.setBorderPainted(false);

        //Add panels to panels with magic logic
        windowContent.add("North", displayField);
        windowContent.add("West", p1);
        windowContent.add("East", p2);
        p1.add("North", buttonAC);
        p1.add("Center", p3);
        p1.add("South", numButtons[0]);

        //Add buttons to panels with magic logic
        p2.add(buttonX2);
        p2.add(buttonPlus);
        p2.add(numButtons[3]);
        p2.add(buttonMinus);
        p2.add(numButtons[6]);
        p2.add(buttonDivide);
        p2.add(numButtons[9]);
        p2.add(buttonMultiply);
        p2.add(buttonPoint);
        p2.add(buttonEqual);

        p3.add(numButtons[1]);
        p3.add(numButtons[2]);
        p3.add(numButtons[4]);
        p3.add(numButtons[5]);
        p3.add(numButtons[7]);
        p3.add(numButtons[8]);

        //Создаём фрейм и задаём его основную панель
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(windowContent);
        frame.setLocationRelativeTo(null);  //this will center an app
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        // делаем размер окна достаточным
        // для того, чтобы вместить все компоненты
        frame.pack();
        // Наконец, отображаем окно
        frame.setVisible(true);

        try {
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch (Exception e) {
            e.printStackTrace();
        }


//        CalculatorEngine calcEngine = new CalculatorEngine(this);

//        for (int i = 0; i < 10; i++) {
//            numButtons[i].addActionListener(calcEngine);
//        }
//
//        buttonAC.addActionListener(calcEngine);
//        buttonPlus.addActionListener(calcEngine);
//        buttonMinus.addActionListener(calcEngine);
//        buttonDivide.addActionListener(calcEngine);
//        buttonMultiply.addActionListener(calcEngine);
//        buttonPoint.addActionListener(calcEngine);
//        buttonEqual.addActionListener(calcEngine);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculator();
            }
        });
//        Calculator calc = new Calculator();
    }

}