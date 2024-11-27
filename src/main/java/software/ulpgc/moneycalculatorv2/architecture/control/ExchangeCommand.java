package software.ulpgc.moneycalculatorv2.architecture.control;



import software.ulpgc.moneycalculatorv2.architecture.model.Currency;
import software.ulpgc.moneycalculatorv2.architecture.model.ExchangeRate;
import software.ulpgc.moneycalculatorv2.architecture.model.Money;
import software.ulpgc.moneycalculatorv2.architecture.persistence.ExchangeRateLoader;
import software.ulpgc.moneycalculatorv2.architecture.view.CurrencyDialog;
import software.ulpgc.moneycalculatorv2.architecture.view.MoneyDialog;
import software.ulpgc.moneycalculatorv2.architecture.view.MoneyDisplay;

import java.time.LocalDate;

public class ExchangeCommand implements Command{
    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final ExchangeRateLoader loader;
    private final MoneyDisplay moneyDisplay;

    public ExchangeCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, ExchangeRateLoader loader, MoneyDisplay moneyDisplay) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.loader = loader;
        this.moneyDisplay = moneyDisplay;
    }

    @Override
    public void execute() {
        Money money = moneyDialog.get();
        Currency currency = currencyDialog.get();

        ExchangeRate exchangeRate = loader.load(money.currency(),currency , LocalDate.now());
        Money result = new Money(money.amount()*exchangeRate.rate(),currency);

        moneyDisplay.show(result);
    }
}
