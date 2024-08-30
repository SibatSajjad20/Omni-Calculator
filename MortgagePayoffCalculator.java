import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MortgagePayoffCalculator extends JPanel {
    private JTextField mortgageBalanceField;
    private JTextField monthlyPaymentField;
    private JLabel resultLabel;

    public MortgagePayoffCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Mortgage Payoff Calculator**
        JLabel calculatorLabel = new JLabel("Mortgage Payoff Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel mortgageBalancePanel = new JPanel();
        mortgageBalancePanel.setLayout(new BoxLayout(mortgageBalancePanel, BoxLayout.X_AXIS));
        mortgageBalancePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel mortgageBalanceLabel = new JLabel("Mortgage Balance: ");
        mortgageBalanceLabel.setFont(labelFont);
        mortgageBalanceField = new JTextField(10);
        mortgageBalanceField.setFont(textFieldFont);
        mortgageBalancePanel.add(mortgageBalanceLabel);
        mortgageBalancePanel.add(mortgageBalanceField);
        inputPanel.add(mortgageBalancePanel);

        JPanel monthlyPaymentPanel = new JPanel();
        monthlyPaymentPanel.setLayout(new BoxLayout(monthlyPaymentPanel, BoxLayout.X_AXIS));
        monthlyPaymentPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel monthlyPaymentLabel = new JLabel("Monthly Payment: ");
        monthlyPaymentLabel.setFont(labelFont);
        monthlyPaymentField = new JTextField(10);
        monthlyPaymentField.setFont(textFieldFont);
        monthlyPaymentPanel.add(monthlyPaymentLabel);
        monthlyPaymentPanel.add(monthlyPaymentField);
        inputPanel.add(monthlyPaymentPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(buttonPanel, BorderLayout.SOUTH);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setFont(textFieldFont);
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        buttonPanel.add(Box.createHorizontalGlue());

        resultLabel = new JLabel("Mortgage Payoff: ");
        resultLabel.setFont(labelFont);
        buttonPanel.add(resultLabel);

        buttonPanel.add(Box.createHorizontalGlue());

        JButton backButton = new JButton("Back");
        backButton.setFont(textFieldFont);
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double mortgageBalance = Double.parseDouble(mortgageBalanceField.getText());
                double monthlyPayment = Double.parseDouble(monthlyPaymentField.getText());
                // Calculate the number of months to payoff the mortgage
                double monthsToPayoff = mortgageBalance / monthlyPayment;
                resultLabel.setText(String.format("Mortgage Payoff: %.2f months", monthsToPayoff));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}