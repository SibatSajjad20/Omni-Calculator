import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PaybackPeriodCalculator extends JPanel {
    private JTextField initialInvestmentField;
    private JTextField annualCashFlowField;
    private JLabel resultLabel;

    public PaybackPeriodCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Payback Period Calculator**
        JLabel calculatorLabel = new JLabel("Payback Period Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel initialInvestmentPanel = new JPanel();
        initialInvestmentPanel.setLayout(new BoxLayout(initialInvestmentPanel, BoxLayout.X_AXIS));
        initialInvestmentPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel initialInvestmentLabel = new JLabel("Initial Investment: ");
        initialInvestmentLabel.setFont(labelFont);
        initialInvestmentField = new JTextField(10);
        initialInvestmentField.setFont(textFieldFont);
        initialInvestmentPanel.add(initialInvestmentLabel);
        initialInvestmentPanel.add(initialInvestmentField);
        inputPanel.add(initialInvestmentPanel);

        JPanel annualCashFlowPanel = new JPanel();
        annualCashFlowPanel.setLayout(new BoxLayout(annualCashFlowPanel, BoxLayout.X_AXIS));
        annualCashFlowPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel annualCashFlowLabel = new JLabel("Annual Cash Flow: ");
        annualCashFlowLabel.setFont(labelFont);
        annualCashFlowField = new JTextField(10);
        annualCashFlowField.setFont(textFieldFont);
        annualCashFlowPanel.add(annualCashFlowLabel);
        annualCashFlowPanel.add(annualCashFlowField);
        inputPanel.add(annualCashFlowPanel);

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

        resultLabel = new JLabel("Result: ");
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
                double initialInvestment = Double.parseDouble(initialInvestmentField.getText());
                double annualCashFlow = Double.parseDouble(annualCashFlowField.getText());
                double result = initialInvestment / annualCashFlow; // Result in years

                resultLabel.setText(String.format("Payback Period in years: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}