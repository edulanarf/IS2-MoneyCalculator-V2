package software.ulpgc.moneycalculatorv2.architecture.persistence;

import software.ulpgc.moneycalculatorv2.architecture.model.Currency;

import java.util.List;

public interface CurrencyLoader {
    List<Currency> load();
}
