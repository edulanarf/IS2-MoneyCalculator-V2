package software.ulpgc.moneycalculatorv2.apps.windows;

import software.ulpgc.moneycalculatorv2.apps.windows.view.SwingCurrencyDialog;
import software.ulpgc.moneycalculatorv2.apps.windows.view.SwingMoneyDialog;
import software.ulpgc.moneycalculatorv2.apps.windows.view.SwingMoneyDisplay;
import software.ulpgc.moneycalculatorv2.architecture.control.Command;
import software.ulpgc.moneycalculatorv2.architecture.model.Currency;
import software.ulpgc.moneycalculatorv2.architecture.view.CurrencyDialog;
import software.ulpgc.moneycalculatorv2.architecture.view.MoneyDialog;
import software.ulpgc.moneycalculatorv2.architecture.view.MoneyDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainFrame extends JFrame {
    private final List<Currency> currencies;
    private final SwingMoneyDialog moneyDialog;
    private final SwingCurrencyDialog currencyDialog;
    private final SwingMoneyDisplay moneyDisplay;
    private final Map<String, Command> commands;

    public MainFrame(List<Currency>currencies){
        this.currencies = currencies;
        this.setTitle("Money Calculator");
        this.setSize(800,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);                       //En el centro de la pantalla

        this.setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();                     // Creo un panel para agrupar los componentes
        contentPanel.setBackground(new Color(25, 180, 225));

        contentPanel.add(moneyDialog = createMoneyDialog());
        contentPanel.add(currencyDialog = createCurrencyDialog());
        contentPanel.add(moneyDisplay = createMoneyDisplay());

        moneyDialog.setPreferredSize(new Dimension(150, 35));
        currencyDialog.setPreferredSize(new Dimension(150, 35));
        moneyDisplay.setPreferredSize(new Dimension(150, 35));
        contentPanel.add(createCalculateButton());
        this.add(contentPanel, BorderLayout.CENTER);

        JLabel titleLabel = new JLabel("Money Calculator", JLabel.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        titleLabel.setForeground(new Color(50, 50, 50));
        this.add(titleLabel, BorderLayout.NORTH);

        this.commands = new HashMap<>();
    }

    private Component createCalculateButton() {

        JButton button = new JButton("Convert");
        button.setFont(new Font("Times New Roman", Font.BOLD, 14));
        button.setBackground(new Color(0, 123, 255));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(200, 40));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get("exchange").execute();
            }
        });
        return button;
    }

    private SwingMoneyDisplay createMoneyDisplay() {
        return new SwingMoneyDisplay();
    }

    private SwingCurrencyDialog createCurrencyDialog() {
        return new SwingCurrencyDialog(currencies);
    }

    private SwingMoneyDialog createMoneyDialog() {
        return new SwingMoneyDialog(currencies);
    }

    public void add(String operation, Command command){ //Añadir comandos
        commands.put(operation,command);
    }

    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public CurrencyDialog getCurrencyDialog() {
        return currencyDialog;
    }

    public MoneyDisplay getMoneyDisplay() {
        return moneyDisplay;
    }
}
