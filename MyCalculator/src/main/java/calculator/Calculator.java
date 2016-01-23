package calculator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

public class Calculator {

//    TODO
//    Double в памяти
//    Assert JUnit - DONE
//    TestNG
//    Package private specified for getters
//    Refactor code
//    KidsBook
//    Eckel Book

    //region Initialise all Calculator Elements
    //Fonts that will be used in the calculator
    Font buttonFont = new Font("OCR A Extended", 0, 40);
    Font textFont = new Font("OCR A Extended", 0, 25);

    // Calculator elements
    JFrame frame;
    JPanel windowContent;
    JTextField displayField;
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
    //endregion

    //Getters for Calculator elements
    public JTextField getDisplayField() {
        return displayField;
    }

    public JButton[] getNumButtons() {
        return numButtons;
    }

    public JButton getButtonAC() {
        return buttonAC;
    }

    public JButton getButtonPoint() {
        return buttonPoint;
    }

    public JButton getButtonEqual() {
        return buttonEqual;
    }

    public JButton getButtonPlus() {
        return buttonPlus;
    }

    public JButton getButtonMinus() {
        return buttonMinus;
    }

    public JButton getButtonDivide() {
        return buttonDivide;
    }

    public JButton getButtonMultiply() {
        return buttonMultiply;
    }

    public JButton getButtonX2() {
        return buttonX2;
    }

    private JButton createButton(String buttonName, Color foreground, Color background, boolean bool) {
        JButton button = new JButton(buttonName);
        button.setFont(buttonFont);
        button.setForeground(foreground);
        button.setBackground(background);
        button.setOpaque(bool);
        return button;
    }

    // В конструкторе создаются все компоненты и добавляются на фрейм
    // с помощью комбинации Borderlayout и Gridlayout
    public Calculator() {

        //region Create all the panels with specified schema
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
        //endregion

        //region Create input text field
        displayField = new JTextField();
        displayField.setFont(textFont);
        displayField.setEditable(false);
        displayField.setForeground(Color.BLUE);
        displayField.setHorizontalAlignment(SwingConstants.RIGHT);
        //endregion

        //Create all the buttons
        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].setFont(buttonFont);
            numButtons[i].setBackground(Color.white);
        }

        buttonAC = createButton("AC", Color.red, null, false);


//        buttonAC = new JButton("AC");
//        buttonAC.setFont(buttonFont);
//        buttonAC.setForeground(null);
//        buttonAC.setBackground(null);
//        buttonAC.setOpaque(false);



        buttonX2 = new JButton("^2");
        buttonX2.setFont(buttonFont);
        buttonPoint = new JButton(".");
        buttonPoint.setFont(buttonFont);
        buttonPoint.setBackground(Color.red);
        buttonPoint.setOpaque(false);
        buttonEqual = new JButton("=");
        buttonEqual.setFont(buttonFont);
        buttonEqual.setBackground(Color.orange);
        buttonEqual.setOpaque(true);
        buttonPlus = new JButton("+");
        buttonPlus.setFont(buttonFont);
        buttonPlus.setBackground(Color.orange);
        buttonPlus.setOpaque(true);
        buttonMinus = new JButton("-");
        buttonMinus.setFont(buttonFont);
        buttonMinus.setBackground(Color.orange);
        buttonMinus.setOpaque(true);
        buttonDivide = new JButton("/");
        buttonDivide.setFont(buttonFont);
        buttonDivide.setBackground(Color.orange);
        buttonDivide.setOpaque(true);
        buttonMultiply = new JButton("*");
        buttonMultiply.setFont(buttonFont);
        buttonMultiply.setBackground(Color.orange);
        buttonMultiply.setOpaque(true);

        //region Add panels to panels with magic logic
        windowContent.add("North", displayField);
        windowContent.add("West", p1);
        windowContent.add("East", p2);
        p1.add("North", buttonAC);
        p1.add("Center", p3);
        p1.add("South", numButtons[0]);
        //endregion

        //region Add buttons to panels with magic logic
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
        //endregion

        //region Создаём фрейм и задаём его основную панель
        frame = new JFrame("calculator.Calculator");
        frame.setContentPane(windowContent);
        frame.setLocationRelativeTo(null);  //this will center an app
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        // делаем размер окна достаточным для того, чтобы вместить все компоненты
        frame.pack();
        // Наконец, отображаем окно
        frame.setVisible(true);
        //endregion

        CalculatorEngine calcEngine = new CalculatorEngine(this);

        for (int i = 0; i < 10; i++) {
            numButtons[i].addActionListener(calcEngine);
        }

        buttonAC.addActionListener(calcEngine);
        buttonPlus.addActionListener(calcEngine);
        buttonMinus.addActionListener(calcEngine);
        buttonDivide.addActionListener(calcEngine);
        buttonMultiply.addActionListener(calcEngine);
        buttonPoint.addActionListener(calcEngine);
        buttonEqual.addActionListener(calcEngine);
        buttonX2.addActionListener(calcEngine);
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

}