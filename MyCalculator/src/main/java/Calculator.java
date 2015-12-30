import javax.swing.*;
import java.awt.*;

public class Calculator {

//    TODO
//    1. Save exit - done
//    2. Bigger Font - done
//    3. Cool operation displaying - kinda
//    4. Can't divide with 0 - done
//    5. Junit tests
//    6. Calc opens in the center or so - done

    //Set default font for the buttons
    Font font = new Font("OCR A Extended", 0, 45);
    Font textFont = new Font("OCR A Extended", 0, 25);

    // Объявление всех компонентов калькулятора.
    JPanel windowContent;
    JFormattedTextField displayField;
    JButton buttonAC;

    JButton[] numButtons = new JButton[10];

    JButton buttonPoint;
    JButton buttonEqual;
    JButton buttonPlus;
    JButton buttonMinus;
    JButton buttonDivide;
    JButton buttonMultiply;
    JPanel p1;
    JPanel p2;

    // В конструкторе создаются все компоненты
    // и добавляются на фрейм с помощью комбинации
    // Borderlayout и Gridlayout

    Calculator() {
        windowContent = new JPanel();
        buttonAC = new JButton("AC");
        buttonAC.setFont(font);
        buttonAC.setForeground(Color.RED);

        // Задаём схему для этой панели
        BorderLayout bl = new BorderLayout();
        windowContent.setLayout(bl);

        // Создаём и отображаем поле
        // Добавляем его в Северную область окна
        // Выравниваем текст по правому краю
        displayField = new JFormattedTextField();
//        displayField.setValue(0);
        displayField.setFont(textFont);
        displayField.setForeground(Color.BLUE);
        displayField.setHorizontalAlignment(SwingConstants.RIGHT);

        windowContent.add("North", displayField);
        windowContent.add(BorderLayout.BEFORE_LINE_BEGINS, buttonAC);

        // Создаём кнопки, используя конструктор
        // класса JButton, который принимает текст
        // кнопки в качестве параметра

        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].setFont(font);
        }

        buttonPoint = new JButton(".");
        buttonPoint.setFont(font);
        buttonEqual = new JButton("=");
        buttonEqual.setFont(font);
        buttonPlus = new JButton("+");
        buttonPlus.setFont(font);
        buttonMinus = new JButton("-");
        buttonMinus.setFont(font);
        buttonDivide = new JButton("/");
        buttonDivide.setFont(font);
        buttonMultiply = new JButton("*");
        buttonMultiply.setFont(font);

        // Создаём панель с GridLayout
        // которая содержит 12 кнопок - 10 кнопок с числами
        // и кнопки с точкой и знаком равно
        p1 = new JPanel();
        GridLayout gl1 = new GridLayout(4, 3);
        p1.setLayout(gl1);

        // Создаём панель с GridLayout
        // которая содержит 4 кнопоки
        p2 = new JPanel();
        GridLayout gl2 = new GridLayout(4, 1);
        p2.setLayout(gl2);

        // Добавляем кнопки на панель p1

        for (int i = 1; i < 10; i++) {
            p1.add(numButtons[i]);
        }

        p1.add(numButtons[0]);
        p1.add(buttonPoint);
        p1.add(buttonEqual);

        // Добавляем кнопки на панель p2
        p2.add(buttonPlus);
        p2.add(buttonMinus);
        p2.add(buttonDivide);
        p2.add(buttonMultiply);

        // Помещаем панель p1 в центральную область окна
        windowContent.add("Center", p1);

        // Помещаем панель p2 в Восточную область окна
        windowContent.add("East", p2);

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
    }

    public static void main(String[] args) {
        // Создаем экземпляр класса “Калькулятор”
        Calculator calc = new Calculator();
    }

}