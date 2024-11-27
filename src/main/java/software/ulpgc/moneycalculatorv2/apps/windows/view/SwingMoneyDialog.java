package software.ulpgc.moneycalculatorv2.apps.windows.view;


import software.ulpgc.moneycalculatorv2.architecture.model.Currency;
import software.ulpgc.moneycalculatorv2.architecture.model.Money;
import software.ulpgc.moneycalculatorv2.architecture.view.MoneyDialog;
import software.ulpgc.moneycalculatorv2.architecture.view.MoneyDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SwingMoneyDialog extends JPanel implements MoneyDialog {
    private final List<Currency> currencies;
    private final TextField amount;                         //TextField se usa para que el usuario pueda ingresar o mostrar texto
    private final SwingCurrencyDialog currencyDialog;

    public SwingMoneyDialog(List<Currency> currencies) {
        this.currencies = currencies;
        this.setLayout(new FlowLayout());                   //Este objeto tendra un layout
        this.add(amount = createAmountInput());
        this.add(currencyDialog =  new SwingCurrencyDialog(currencies));
    }

    private TextField createAmountInput() {
        TextField textField = new TextField();
        textField.setColumns(4);                            //Se podrá escribir como mucho 4 caracteres
        return textField;
    }


    @Override
    public Money get() {
        return new Money(toDouble(amount.getText()),currencyDialog.get());
    }

    private double toDouble(String text) {
        return Double.parseDouble(text);
    }
}
