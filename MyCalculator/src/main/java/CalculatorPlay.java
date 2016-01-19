import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dmitry on 27/12/15.
 */

public class CalculatorPlay implements ActionListener {

    Calculator parent; //ссылка на окно калькулятора
    double firstValue;

    //booleans for +,-,/,*
    boolean[] function = new boolean[4];
    //temporary doubles for calculations
    double[] temporary = {0, 0};

    // Конструктор сохраняет ссылку на окно калькулятора в переменной экземпляра класса
    CalculatorPlay(Calculator parent) {
        this.parent = parent;
    }

    //method for AC button
    public void ACbutton() {
        try {
            parent.displayField.setText("");
            for (int i = 0; i < 4; i++)
                function[i] = false;
            for (int i = 0; i < 2; i++)
                temporary[i] = 0;
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
            if (function[2] == true)
                result = temporary[0] * temporary[1];
                else if (function[3] == true)
                    result = temporary[0] / temporary[1];
                else if (function[0] == true)
                    result = temporary[0] + temporary[1];
                else if (function[1] == true)
                    result = temporary[0] - temporary[1];
                parent.displayField.setText(Double.toString(result));
            if (function[3] == true && temporary[1] == 0)
            parent.displayField.setText("Can't do that!");
            for (int i = 0; i < 4; i++)
                function[i] = false;
        } catch (NumberFormatException e) {
        }
    }

    public void actionPerformed(ActionEvent e) {

        // Получаем источник действия
        JButton clickedButton = (JButton) e.getSource();
        String dispFieldText = parent.displayField.getText();

        double displayValue = 0;

        // Получить число из дисплея калькулятора,
        // если он не пустой.
        if ((!"".equals(dispFieldText))) {
            displayValue = Double.parseDouble(dispFieldText);
        }

        String clickedButtonLabel = clickedButton.getText();

        for(int i = 0; i < 4; i++)
            function[i] = false;

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == parent.numButtons[i])
//                parent.displayField.setText(String.valueOf(i));
                parent.displayField.setText(dispFieldText + clickedButtonLabel);
        }

        if (e.getSource() == parent.buttonPlus) {
            //Add function[0]
            temporary[0] = Double.parseDouble(parent.displayField.getText());
            firstValue = temporary[0];
            function[0] = true;
            parent.displayField.setText("");
        }

        if (e.getSource() == parent.buttonMinus) {
            //Minus function[1]
            temporary[0] = Double.parseDouble(parent.displayField.getText());
            function[1] = true;
            parent.displayField.setText("");
        }

        if (e.getSource() == parent.buttonMultiply) {
            //Multiply function[2]
            temporary[0] = Double.parseDouble(parent.displayField.getText());
            function[2] = true;
            parent.displayField.setText("");
        }

        if (e.getSource() == parent.buttonDivide) {
            //Divide function[3]
            temporary[0] = Double.parseDouble(parent.displayField.getText());
            function[3] = true;
            parent.displayField.setText("");
        }

        if (e.getSource() == parent.buttonPoint)
            parent.displayField.setText(".");

        if (e.getSource() == parent.buttonAC)
            ACbutton();

        if (e.getSource() == parent.buttonX2)
            x2button();

        if (e.getSource() == parent.buttonEqual)
            getResult();

    }

}