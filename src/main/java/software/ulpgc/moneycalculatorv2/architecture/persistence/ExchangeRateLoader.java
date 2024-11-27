package software.ulpgc.moneycalculatorv2.architecture.persistence;

import software.ulpgc.moneycalculatorv2.architecture.model.Currency;
import software.ulpgc.moneycalculatorv2.architecture.model.ExchangeRate;

import java.time.LocalDate;

public interface ExchangeRateLoader {
    ExchangeRate load(Currency from, Currency to, LocalDate date);
}

