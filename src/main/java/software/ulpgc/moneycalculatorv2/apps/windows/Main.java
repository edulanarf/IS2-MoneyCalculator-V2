package software.ulpgc.moneycalculatorv2.apps.windows;

import software.ulpgc.moneycalculatorv2.apps.windows.persistence.TsvExchangeRateLoader;
import software.ulpgc.moneycalculatorv2.architecture.control.ExchangeCommand;
import software.ulpgc.moneycalculatorv2.architecture.model.Currency;
import software.ulpgc.moneycalculatorv2.architecture.model.ExchangeRate;
import software.ulpgc.moneycalculatorv2.architecture.persistence.ExchangeRateLoader;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Currency> currencies = ListOfCurrencies();

        ExchangeRateLoader loadExchangeRates = new TsvExchangeRateLoader(new File("./src/main/resources/ExchangeRate.tsv"));
        List<ExchangeRate> exchangeRates = loadExchangeRates.loadExchanges();
        System.out.println(exchangeRates);
        MainFrame mainFrame = new MainFrame(currencies);

        ExchangeCommand exchangeCommand = new ExchangeCommand(
                mainFrame.getMoneyDialog(),
                mainFrame.getCurrencyDialog(),
                mainFrame.getMoneyDisplay(),
                exchangeRates
        );


        mainFrame.add("exchange", exchangeCommand);
        mainFrame.setVisible(true);


    }

    public static List<Currency> ListOfCurrencies(){
        return List.of(
                new Currency("USD", "Dolar", "$"),
                new Currency("EUR", "Euro", "€")
        );
    }

}
