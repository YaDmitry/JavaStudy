import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dmitry on 27/12/15.
 */

public class CalculatorEngine implements ActionListener {

    Calculator parent; //ссылка на окно калькулятора

    char selectedAction = ' '; // +, -, /, или *
    char secondAction = ' '; // +, -, /, или *
    double currentResult = 0;

    // Конструктор сохраняет ссылку на окно калькулятора
    // в переменной экземпляра класса

    CalculatorEngine(Calculator parent) {
        this.parent = parent;
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

        Object src = e.getSource();

        // Для каждой кнопки арифметического действия
        // запомнить его: +, -, /, или *, сохранить текущее число
        // в переменной currentResult, и очистить дисплей
        // для ввода нового числа

        if (src == parent.buttonAC) {
            selectedAction = ' ';
            parent.displayField.setText("");
        } else if (src == parent.buttonPlus) {
            selectedAction = '+';
            secondAction = '+';
            currentResult = displayValue;
            parent.displayField.setValue(displayValue);
        } else if (src == parent.buttonMinus) {
            selectedAction = '-';
            secondAction = '-';
            currentResult = displayValue;
            parent.displayField.setValue(displayValue);
        } else if (src == parent.buttonDivide) {
            selectedAction = '/';
            secondAction = '/';
            currentResult = displayValue;
            parent.displayField.setValue(displayValue);
        } else if (src == parent.buttonMultiply) {
            selectedAction = '*';
            secondAction = '*';
            currentResult = displayValue;
            parent.displayField.setValue(displayValue);
        } else if (src == parent.buttonEqual) {

            // Совершить арифметическое действие, в зависимости
            // от selectedAction, обновить переменную currentResult
            // и показать результат на дисплее

            if (secondAction == '+') {
                currentResult += displayValue;

                // Сконвертировать результат в строку, добавляя его
                // к пустой строке и показать его

                parent.displayField.setText("" + currentResult);
            }

            if (secondAction == '-') {
                currentResult -= displayValue;

                parent.displayField.setText("" + currentResult);
            }

            if (secondAction == '/') {
                if (displayValue == 0) {
                    parent.displayField.setText("Cannot divide by zero!");
                } else {
                    currentResult /= displayValue;
                    parent.displayField.setText("" + currentResult);
                }
            }

            if (secondAction == '*') {
                currentResult *= displayValue;

                parent.displayField.setText("" + currentResult);
            }

        } else {
            // Для всех цифровых кнопок присоединить надпись на
            // кнопке к надписи в дисплее
            String clickedButtonLabel = clickedButton.getText();
//            System.out.println("clickedButton = " + clickedButtonLabel);
            if (selectedAction == '+' || selectedAction == '-' || selectedAction == '*' || selectedAction == '/') {
                selectedAction = ' ';
                parent.displayField.setText(clickedButtonLabel);
            } else {
                parent.displayField.setText(dispFieldText + clickedButtonLabel);
            }

        }

    }

}
