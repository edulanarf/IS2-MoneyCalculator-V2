package software.ulpgc.moneycalculatorv2.architecture.model;

import java.time.LocalDate;

public record ExchangeRate(Currency from, Currency to, double rate, LocalDate date) {
}
