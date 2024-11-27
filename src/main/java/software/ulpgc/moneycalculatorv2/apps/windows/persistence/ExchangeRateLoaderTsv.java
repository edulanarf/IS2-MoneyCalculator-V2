package software.ulpgc.moneycalculatorv2.apps.windows.persistence;

import software.ulpgc.moneycalculatorv2.architecture.model.Currency;
import software.ulpgc.moneycalculatorv2.architecture.model.ExchangeRate;
import software.ulpgc.moneycalculatorv2.architecture.persistence.ExchangeRateLoader;

import java.time.LocalDate;

public class ExchangeRateLoaderTsv implements ExchangeRateLoader {
    @Override
    public ExchangeRate load(Currency from, Currency to, LocalDate date) {
        return new ExchangeRate(from, to, 1.2, date);
    }
}
