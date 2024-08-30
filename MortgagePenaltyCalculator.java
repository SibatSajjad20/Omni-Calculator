import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MortgagePenaltyCalculator extends JPanel {
    private JTextField mortgageBalanceField;
    private JTextField interestRateField;
    private JLabel resultLabel;

    public MortgagePenaltyCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Mortgage Penalty Calculator**
        JLabel calculatorLabel = new JLabel("Mortgage Penalty Calculator");
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

        JPanel interestRatePanel = new JPanel();
        interestRatePanel.setLayout(new BoxLayout(interestRatePanel, BoxLayout.X_AXIS));
        interestRatePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel interestRateLabel = new JLabel("Interest Rate (%): ");
        interestRateLabel.setFont(labelFont);
        interestRateField = new JTextField(10);
        interestRateField.setFont(textFieldFont);
        interestRatePanel.add(interestRateLabel);
        interestRatePanel.add(interestRateField);
        inputPanel.add(interestRatePanel);

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

        resultLabel = new JLabel("Mortgage Penalty: ");
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
                double interestRate = Double.parseDouble(interestRateField.getText());
                double result = (mortgageBalance * interestRate) / 100;
                resultLabel.setText(String.format("Mortgage Penalty: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}