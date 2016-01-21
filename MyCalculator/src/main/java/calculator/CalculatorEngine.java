package calculator;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dmitry on 27/12/15.
 */

public class CalculatorEngine implements ActionListener {

    Calculator parent; //ссылка на окно калькулятора

    //booleans for +,-,/,*
    boolean[] function = new boolean[4];
    boolean function2;
    //temporary doubles for calculations
    double[] temporary = {0, 0};

    // Конструктор сохраняет ссылку на окно калькулятора в переменной экземпляра класса
    CalculatorEngine(Calculator parent) {
        this.parent = parent;
        for (int i = 0; i < 4; i++) {
            function[i] = false;
            function2 = false;
        }
    }

    //method for AC button
    public void ACbutton() {
        try {
            parent.displayField.setText("");
            for (int i = 0; i < 4; i++)
                function[i] = false;
            for (int i = 0; i < 2; i++)
                temporary[i] = 0;
            function2 = false;
        } catch (NullPointerException e) {
        }
    }

    //method for x2 button
    public void x2button() {
        try {
            double value = Math.pow(Double.parseDouble(parent.displayField.getText()), 2);
            parent.displayField.setText(Double.toString(value));
        } catch (NumberFormatException e) {
        }
    }

    //method to get Result
    public void getResult() {
        double result = 0;
        temporary[1] = Double.parseDouble(parent.displayField.getText());
        try {
            if (function[0] == true)
                result = (temporary[0] + temporary[1]);
            else if (function[1] == true)
                result = temporary[0] - temporary[1];
            else if (function[2] == true)
                result = temporary[0] * temporary[1];
            else if (function[3] == true)
                result = temporary[0] / temporary[1];
            parent.displayField.setText(Double.toString(result));
            if (function[3] == true && temporary[1] == 0)
                parent.displayField.setText("Can't do that!");
            for (int i = 0; i < 4; i++)
                function[i] = false;
            function2 = false;
        } catch (NumberFormatException e) {
        }
    }

    public void actionPerformed(ActionEvent e) {

        // Получаем источник действия
        JButton clickedButton = (JButton) e.getSource();
        String dispFieldText = parent.displayField.getText();
        String clickedButtonLabel = clickedButton.getText();
        int count = dispFieldText.length() - dispFieldText.replaceAll("\\.", "").length();

        if (function2 == true)
            dispFieldText = "";

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == parent.numButtons[i] && !"Can't do that!".equals(dispFieldText)) {
                parent.displayField.setText(dispFieldText + clickedButtonLabel);
                function2 = false;
            }
        }

        if (e.getSource() == parent.buttonPlus && !"".equals(dispFieldText) && !"Can't do that!".equals(dispFieldText)) {
            //Add function[0]
            temporary[0] = Double.parseDouble(dispFieldText);
            function[0] = true;
            function2 = true;
            parent.displayField.setText(dispFieldText);
        }

        if (e.getSource() == parent.buttonMinus && !"".equals(dispFieldText) && !"Can't do that!".equals(dispFieldText)) {
            //Minus function[1]
            temporary[0] = Double.parseDouble(dispFieldText);
            function[1] = true;
            function2 = true;
            parent.displayField.setText(dispFieldText);
        }

        if (e.getSource() == parent.buttonMultiply && !"".equals(dispFieldText) && !"Can't do that!".equals(dispFieldText)) {
            //Multiply function[2]
            temporary[0] = Double.parseDouble(dispFieldText);
            function[2] = true;
            function2 = true;
            parent.displayField.setText(dispFieldText);
        }

        if (e.getSource() == parent.buttonDivide && !"".equals(dispFieldText) && !"Can't do that!".equals(dispFieldText)) {
            //Divide function[3]
            temporary[0] = Double.parseDouble(dispFieldText);
            function[3] = true;
            function2 = true;
            parent.displayField.setText(dispFieldText);
        }

        if (e.getSource() == parent.buttonPoint && count == 0 && !"Can't do that!".equals(dispFieldText)) {
            parent.displayField.setText(dispFieldText + clickedButtonLabel);
            function2 = false;
        }

        if (e.getSource() == parent.buttonAC)
            ACbutton();

        if (e.getSource() == parent.buttonX2 && !"".equals(dispFieldText) && !"Can't do that!".equals(dispFieldText))
            x2button();

        if (e.getSource() == parent.buttonEqual && !"".equals(dispFieldText) && !"Can't do that!".equals(dispFieldText))
            getResult();
    }

}