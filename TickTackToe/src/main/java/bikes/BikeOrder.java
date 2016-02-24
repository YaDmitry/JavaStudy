package bikes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dmitry on 26/01/16.
 */
public class BikeOrder implements ActionListener {

    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JTextField bikeModel = new JTextField();
    JTextField qty = new JTextField();
    JButton order = new JButton("Order!");
    GridLayout bl = new GridLayout();

    BikeOrder() {
        panel.setLayout(bl);
        panel.add("North", bikeModel);
        panel.add("North", qty);
        panel.add("South", order);
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);  //this will center an app
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    String selectedModel = bikeModel.getText();
    String selectedQuantity = qty.getText();
    int quantity = Integer.parseInt(selectedQuantity);

    void checkOrder(String bikeModel, int quantity) throws TooManyBikesException {
//Напишите код, который проверяет, помещается ли требуемое //количество велосипедов заданной модели в грузовик. //Если не помещается, сделать следующее:
        throw new TooManyBikesException("Невозможно доставить" + quantity + " велосипедов модели " + bikeModel +
                " за одну доставку");
    }


    public void actionPerformed(ActionEvent e) {
        try {
            order.checkOrder("FireBird", quantity);
//следующая строка не выполняется в случае исключения
            txtFieldOrderConfirmation.setText(
                    "Размещение вашего заказа завершено");
        } catch (TooManyBikesException e) {
            txtFieldOrderConfirmation.setText(e.getMessage());
        }
    }

    public static void main(String[] args) {
        BikeOrder bikeOrder = new BikeOrder();
    }
}
