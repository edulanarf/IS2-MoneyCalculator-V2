package software.ulpgc.moneycalculatorv2.apps.windows;

import software.ulpgc.moneycalculatorv2.apps.windows.persistence.TsvCurrencyLoader;
import software.ulpgc.moneycalculatorv2.apps.windows.persistence.TsvExchangeRateLoader;
import software.ulpgc.moneycalculatorv2.architecture.control.ExchangeCommand;
import software.ulpgc.moneycalculatorv2.architecture.model.Currency;
import software.ulpgc.moneycalculatorv2.architecture.model.ExchangeRate;
import software.ulpgc.moneycalculatorv2.architecture.persistence.CurrencyLoader;
import software.ulpgc.moneycalculatorv2.architecture.persistence.ExchangeRateLoader;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ExchangeRateLoader loadExchangeRates = new TsvExchangeRateLoader(new File("./src/main/resources/ExchangeRate.tsv"));
        List<ExchangeRate> exchangeRates = loadExchangeRates.loadExchanges();
        CurrencyLoader loadCurrencies = new TsvCurrencyLoader(new File("./src/main/resources/Currencies.tsv"));
        List<Currency> currencies = loadCurrencies.load();
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



}
