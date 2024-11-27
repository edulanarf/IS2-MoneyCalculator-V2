package software.ulpgc.moneycalculatorv2.apps.windows;

import software.ulpgc.moneycalculatorv2.apps.windows.persistence.ExchangeRateLoaderTsv;
import software.ulpgc.moneycalculatorv2.architecture.control.ExchangeCommand;
import software.ulpgc.moneycalculatorv2.architecture.model.Currency;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Currency> currencies = ListOfCurrencies();
        MainFrame mainFrame = new MainFrame(currencies);
        ExchangeCommand exchangeCommand = new ExchangeCommand(
                mainFrame.getMoneyDialog(),
                mainFrame.getCurrencyDialog(),
                new ExchangeRateLoaderTsv(),
                mainFrame.getMoneyDisplay()
        );
        mainFrame.add("exchange", exchangeCommand);
        mainFrame.setVisible(true);
    }

    public static List<Currency> ListOfCurrencies(){
        return List.of(
                new Currency("USD", "Dólar americano", "$"),
                new Currency("EUR", "Euro", "€")
        );
    }

}
