package software.ulpgc.moneycalculatorv2.apps.windows.view;

import software.ulpgc.moneycalculatorv2.architecture.model.Money;
import software.ulpgc.moneycalculatorv2.architecture.view.MoneyDisplay;

import javax.swing.*;

public class SwingMoneyDisplay extends JPanel implements MoneyDisplay {
    private final JLabel label; //JLabel se usa para mostrar texto o imagenes

    public SwingMoneyDisplay() {
        this.add(label = createLabel());
    }

    private JLabel createLabel() {
        return new JLabel();
    }

    @Override
    public void show(Money money) {
        label.setText(money.amount() + " " + money.currency().code());
    }
}
