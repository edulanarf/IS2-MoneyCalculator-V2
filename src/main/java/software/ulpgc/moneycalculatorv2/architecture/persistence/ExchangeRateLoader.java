package software.ulpgc.moneycalculatorv2.architecture.persistence;

import software.ulpgc.moneycalculatorv2.architecture.model.Currency;
import software.ulpgc.moneycalculatorv2.architecture.model.ExchangeRate;

import java.time.LocalDate;
import java.util.List;

public interface ExchangeRateLoader {
    List<ExchangeRate> loadExchanges();
}

