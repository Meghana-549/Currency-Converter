import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Currency_Converter extends JFrame {

    private final JLabel amountLabel;
    private JLabel fromLabel, toLabel, resultLabel;
    private JTextField amountField;
    private JComboBox<String> fromComboBox, toComboBox;
    private JButton convertButton;
    private DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

    private final String[] currencies = {"USD", "EUR", "JPY", "GBP", "CAD", "AUD", "CHF", "CNY","INR"};
    private double[] exchangeRates = {1.00, 0.84, 109.65, 0.72, 1.27, 1.30, 0.92, 6.47,87.14};

    public Currency_Converter() {
        setTitle("Currency Converter");
        setLayout(new GridLayout(4, 2));

        amountLabel = new JLabel("Amount:");
        add(amountLabel);

        amountField = new JTextField();
        add(amountField);

        fromLabel = new JLabel("From:");
        add(fromLabel);

        fromComboBox = new JComboBox<>(currencies);
        add(fromComboBox);

        toLabel = new JLabel("To:");
        add(toLabel);

        toComboBox = new JComboBox<>(currencies);
        add(toComboBox);

        convertButton = new JButton("Convert");
        add(convertButton);

        resultLabel = new JLabel();
        add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double amount = Double.parseDouble(amountField.getText());
                    String fromCurrency = (String) fromComboBox.getSelectedItem();
                    String toCurrency = (String) toComboBox.getSelectedItem();
                    double exchangeRate = exchangeRates[getIndex(toCurrency)] / exchangeRates[getIndex(fromCurrency)];
                    double result = amount * exchangeRate;
                    resultLabel.setText(decimalFormat.format(result) + " " + toCurrency);
                } catch (Exception ex) {
                    resultLabel.setText("Invalid input");
                }
            }
        });

        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private int getIndex(String currency) {
        for (int i = 0; i < currencies.length; i++) {
            if (currency.equals(currencies[i])) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            new Currency_Converter();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @return
     */
    public JLabel getAmountLabel() {
        return amountLabel;
    }

    public JLabel getFromLabel() {
        return fromLabel;
    }

    public void setFromLabel(JLabel fromLabel) {
        this.fromLabel = fromLabel;
    }

    public JLabel getToLabel() {
        return toLabel;
    }

    public void setToLabel(JLabel toLabel) {
        this.toLabel = toLabel;
    }

    public JLabel getResultLabel() {
        return resultLabel;
    }

    public void setResultLabel(JLabel resultLabel) {
        this.resultLabel = resultLabel;
    }

    public JTextField getAmountField() {
        return amountField;
    }

    public void setAmountField(JTextField amountField) {
        this.amountField = amountField;
    }

    public JComboBox<String> getFromComboBox() {
        return fromComboBox;
    }

    public void setFromComboBox(JComboBox<String> fromComboBox) {
        this.fromComboBox = fromComboBox;
    }

    public JComboBox<String> getToComboBox() {
        return toComboBox;
    }

    public void setToComboBox(JComboBox<String> toComboBox) {
        this.toComboBox = toComboBox;
    }

    public JButton getConvertButton() {
        return convertButton;
    }

    public void setConvertButton(JButton convertButton) {
        this.convertButton = convertButton;
    }

    public DecimalFormat getDecimalFormat() {
        return decimalFormat;
    }

    public void setDecimalFormat(DecimalFormat decimalFormat) {
        this.decimalFormat = decimalFormat;
    }

    public String[] getCurrencies() {
        return currencies;
    }

    public double[] getExchangeRates() {
        return exchangeRates;
    }

    public void setExchangeRates(double[] exchangeRates) {
        this.exchangeRates = exchangeRates;
    }
}