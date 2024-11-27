package software.ulpgc.moneycalculatorv2.apps.windows.view;

import software.ulpgc.moneycalculatorv2.architecture.model.Currency;
import software.ulpgc.moneycalculatorv2.architecture.view.CurrencyDialog;

import javax.swing.*;
import java.util.List;

public class SwingCurrencyDialog extends JPanel implements CurrencyDialog {
    private final List<Currency> currencies;
    private final JComboBox<Currency>selector;

    public SwingCurrencyDialog(List<Currency> currencies) {
        this.currencies = currencies;
        this.add(selector = createSelector());
    }

    private JComboBox<Currency> createSelector() {//Lista desplegable que mostrara todos los tipos de currencies
        JComboBox<Currency> comboBox = new JComboBox<>();
        for(Currency currency: currencies){
            comboBox.addItem(currency);
        }
        return comboBox;
    }

    @Override
    public Currency get() {
        return currencies.get(selector.getSelectedIndex()); //Devuelve la divisa seleccionada
    }
}
