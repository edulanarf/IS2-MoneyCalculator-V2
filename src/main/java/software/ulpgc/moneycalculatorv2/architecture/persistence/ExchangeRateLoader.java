package software.ulpgc.moneycalculatorv2.architecture.persistence;

import software.ulpgc.moneycalculatorv2.architecture.model.ExchangeRate;

import java.time.LocalDate;
import java.util.Currency;
import java.util.List;

public interface ExchangeRateLoader {
    List<ExchangeRate> load(Currency from, Currency to, LocalDate date);
}
