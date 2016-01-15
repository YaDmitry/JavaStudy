import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dmitry on 27/12/15.
 */

public class CalculatorPlay implements ActionListener {

    Calculator parent; //ссылка на окно калькулятора
    double firstValue;

    // Конструктор сохраняет ссылку на окно калькулятора в переменной экземпляра класса
    CalculatorPlay(Calculator parent) {
        this.parent = parent;
    }

    //method for AC button
    public void ACbutton() {
        try {
            parent.displayField.setText("");
            for (int i = 0; i < 4; i++)
                parent.function[i] = false;
            for (int i = 0; i < 2; i++)
                parent.temporary[i] = 0;
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
        parent.temporary[1] = Double.parseDouble(parent.displayField.getText());
        try {
            if (parent.function[2] == true)
                result = parent.temporary[0] * parent.temporary[1];
                else if (parent.function[3] == true)
                    result = parent.temporary[0] / parent.temporary[1];
                else if (parent.function[0] == true)
                    result = parent.temporary[0] + parent.temporary[1];
                else if (parent.function[1] == true)
                    result = parent.temporary[0] - parent.temporary[1];
                parent.displayField.setText(Double.toString(result));
            if (parent.function[3] == true && parent.temporary[1] == 0)
            parent.displayField.setText("!Can't do that");
            for (int i = 0; i < 4; i++)
                parent.function[i] = false;
        } catch (NumberFormatException e) {
        }
    }

    public void actionPerformed(ActionEvent e) {

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == parent.numButtons[i])
                parent.displayField.append(String.valueOf(i));
        }

        if (e.getSource() == parent.buttonPlus) {
            //Add function[0]
            parent.temporary[0] = Double.parseDouble(parent.displayField.getText());
            firstValue = parent.temporary[0];
            parent.function[0] = true;
            parent.displayField.setText("");
        }

        if (e.getSource() == parent.buttonMinus) {
            //Minus function[1]
            parent.temporary[0] = Double.parseDouble(parent.displayField.getText());
            parent.function[1] = true;
            parent.displayField.setText("");
        }

        if (e.getSource() == parent.buttonMultiply) {
            //Multiply function[2]
            parent.temporary[0] = Double.parseDouble(parent.displayField.getText());
            parent.function[2] = true;
            parent.displayField.setText("");
        }

        if (e.getSource() == parent.buttonDivide) {
            //Divide function[3]
            parent.temporary[0] = Double.parseDouble(parent.displayField.getText());
            parent.function[3] = true;
            parent.displayField.setText("");
        }

        if (e.getSource() == parent.buttonPoint)
            parent.displayField.append(".");

        if (e.getSource() == parent.buttonAC)
            ACbutton();

        if (e.getSource() == parent.buttonX2)
            x2button();

        if (e.getSource() == parent.buttonEqual)
            getResult();

    }

}