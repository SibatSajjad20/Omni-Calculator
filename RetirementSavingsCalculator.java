import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class RetirementSavingsCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JTextField field4;
    private JLabel resultLabel;

    public RetirementSavingsCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Retirement Savings Calculator**
        JLabel calculatorLabel = new JLabel("Retirement Savings Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel currentAgePanel = new JPanel();
        currentAgePanel.setLayout(new BoxLayout(currentAgePanel, BoxLayout.X_AXIS));
        currentAgePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel currentAgeLabel = new JLabel("Current Age: ");
        currentAgeLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        currentAgePanel.add(currentAgeLabel);
        currentAgePanel.add(field1);
        inputPanel.add(currentAgePanel);

        JPanel retirementAgePanel = new JPanel();
        retirementAgePanel.setLayout(new BoxLayout(retirementAgePanel, BoxLayout.X_AXIS));
        retirementAgePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel retirementAgeLabel = new JLabel("Retirement Age: ");
        retirementAgeLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        retirementAgePanel.add(retirementAgeLabel);
        retirementAgePanel.add(field2);
        inputPanel.add(retirementAgePanel);

        JPanel annualSavingsPanel = new JPanel();
        annualSavingsPanel.setLayout(new BoxLayout(annualSavingsPanel, BoxLayout.X_AXIS));
        annualSavingsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel annualSavingsLabel = new JLabel("Annual Savings: ");
        annualSavingsLabel.setFont(labelFont);
        field3 = new JTextField(10);
        field3.setFont(textFieldFont);
        annualSavingsPanel.add(annualSavingsLabel);
        annualSavingsPanel.add(field3);
        inputPanel.add(annualSavingsPanel);

        JPanel interestRatePanel = new JPanel();
        interestRatePanel.setLayout(new BoxLayout(interestRatePanel, BoxLayout.X_AXIS));
        interestRatePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel interestRateLabel = new JLabel("Interest Rate (%): ");
        interestRateLabel.setFont(labelFont);
        field4 = new JTextField(10);
        field4.setFont(textFieldFont);
        interestRatePanel.add(interestRateLabel);
        interestRatePanel.add(field4);
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
                double currentAge = Double.parseDouble(field1.getText());
                double retirementAge = Double.parseDouble(field2.getText());
                double annualSavings = Double.parseDouble(field3.getText());
                double interestRate = Double.parseDouble(field4.getText()) / 100;
                double result = annualSavings * ((Math.pow(1 + interestRate, retirementAge - currentAge) - 1) / interestRate);
                resultLabel.setText(String.format("Retirement Savings: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}