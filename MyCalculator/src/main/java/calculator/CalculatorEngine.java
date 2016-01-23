package calculator;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dmitry on 27/12/15.
 */

public class CalculatorEngine implements ActionListener {

    Calculator parent; //ссылка на окно калькулятора

    public static final String emptyTextField = "";
    public static final String divideByZeroMessage = "Can't do that!";
    public static final int numberButtonsCount = 10;
    boolean[] operationFlags = new boolean[4];
    boolean isOperationClicked;
    double[] userNumberInput = {0, 0};

    //region Constructor
    // Конструктор сохраняет ссылку на окно калькулятора в переменной экземпляра класса
    CalculatorEngine(Calculator parent) {
        this.parent = parent;
    }
    //endregion

    //region Reset Flags and User Inputs
    private void resetUserInputs() {
        for (int i = 0; i < 2; i++)
            userNumberInput[i] = 0;
    }

    private void resetFlags() {
        for (int i = 0; i < 4; i++)
            operationFlags[i] = false;
        isOperationClicked = false;
    }
    //endregion

    //region Methods to GetResult
    public double calculateResult() {
        double result = 0;
        userNumberInput[1] = Double.parseDouble(parent.displayField.getText());
        try {
            if (operationFlags[0] == true)
                result = (userNumberInput[0] + userNumberInput[1]);
            else if (operationFlags[1] == true)
                result = userNumberInput[0] - userNumberInput[1];
            else if (operationFlags[2] == true)
                result = userNumberInput[0] * userNumberInput[1];
            else if (operationFlags[3] == true)
                result = userNumberInput[0] / userNumberInput[1];
        } catch (NumberFormatException e) {

        }
        return result;
    }

    private void setResultTextField(double result) {
        parent.displayField.setText(Double.toString(result));
        if (operationFlags[3] == true && userNumberInput[1] == 0)
            parent.displayField.setText("Can't do that!");
    }
    //endregion

    //Checks whether dispFieldText empty or contains divideByZeroMessage
    private boolean isTextFieldEmptyOrDividedByZero(String dispFieldText) {
        return !emptyTextField.equals(dispFieldText) && !divideByZeroMessage.equals(dispFieldText);
    }

    //region Event handlers
    //Numeric buttons method
    private void numericButtonClicked(String dispFieldText, String clickedButtonLabel) {
        parent.displayField.setText(dispFieldText + clickedButtonLabel);
        isOperationClicked = false;
    }

    //Plus button method
    private void plusButtonClicked(String dispFieldText) {
        //operationFlag[0] = Addition
        userNumberInput[0] = Double.parseDouble(dispFieldText);
        operationFlags[0] = true;
        isOperationClicked = true;
        parent.displayField.setText(dispFieldText);
    }

    //Minus button method
    private void minusButtonClicked(String dispFieldText) {
        //operationFlag[1] = Subtraction
        userNumberInput[0] = Double.parseDouble(dispFieldText);
        operationFlags[1] = true;
        isOperationClicked = true;
        parent.displayField.setText(dispFieldText);
    }

    //Multiply button method
    private void multiplyButtonClicked(String dispFieldText) {
        //operationFlag[2] = Multiplication
        userNumberInput[0] = Double.parseDouble(dispFieldText);
        operationFlags[2] = true;
        isOperationClicked = true;
        parent.displayField.setText(dispFieldText);
    }

    //Divide button method
    private void divideButtonClicked(String dispFieldText) {
        //operationFlag[3] = Division
        userNumberInput[0] = Double.parseDouble(dispFieldText);
        operationFlags[3] = true;
        isOperationClicked = true;
        parent.displayField.setText(dispFieldText);
    }

    //AC button method
    public void resetButtonClicked() {
        try {
            parent.displayField.setText("");
            resetFlags();
            resetUserInputs();
        } catch (NullPointerException e) {
        }
    }

    //^2 button method
    public void squareButtonClicked() {
        try {
            double value = Math.pow(Double.parseDouble(parent.displayField.getText()), 2);
            parent.displayField.setText(Double.toString(value));
        } catch (NumberFormatException e) {
        }
    }

    //Equal button method
    public void getResultClicked() {
        setResultTextField(calculateResult());
        resetFlags();
    }
    //endregion

    public void actionPerformed(ActionEvent e) {

        JButton clickedButton = (JButton) e.getSource(); //Получаем источник действия
        String dispFieldText = parent.displayField.getText();
        String clickedButtonLabel = clickedButton.getText();
        boolean isTextFieldContainsPoint = dispFieldText.contains(".");

        if (isOperationClicked)
            dispFieldText = emptyTextField;

        for (int i = 0; i < numberButtonsCount; i++) {
            if (e.getSource() == parent.numButtons[i] && !divideByZeroMessage.equals(dispFieldText)) {
                numericButtonClicked(dispFieldText, clickedButtonLabel);
            }
        }

        if (clickedButton == parent.buttonPlus && isTextFieldEmptyOrDividedByZero(dispFieldText)) {
            plusButtonClicked(dispFieldText);
        }

        if (clickedButton == parent.buttonMinus && isTextFieldEmptyOrDividedByZero(dispFieldText)) {
            minusButtonClicked(dispFieldText);
        }

        if (clickedButton == parent.buttonMultiply && isTextFieldEmptyOrDividedByZero(dispFieldText)) {
            multiplyButtonClicked(dispFieldText);
        }

        if (clickedButton == parent.buttonDivide && isTextFieldEmptyOrDividedByZero(dispFieldText)) {
            divideButtonClicked(dispFieldText);
        }

        if (clickedButton == parent.buttonPoint && !isTextFieldContainsPoint && !divideByZeroMessage.equals(dispFieldText)) {
            numericButtonClicked(dispFieldText, clickedButtonLabel);
        }

        if (clickedButton == parent.buttonAC)
            resetButtonClicked();

        if (clickedButton == parent.buttonX2 && isTextFieldEmptyOrDividedByZero(dispFieldText))
            squareButtonClicked();

        if (clickedButton == parent.buttonEqual && isTextFieldEmptyOrDividedByZero(dispFieldText))
            getResultClicked();
    }
}