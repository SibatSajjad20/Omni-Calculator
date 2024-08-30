import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SavingsInterestCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JLabel resultLabel;

    public SavingsInterestCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Savings Interest Calculator**
        JLabel calculatorLabel = new JLabel("Savings Interest Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel principalPanel = new JPanel();
        principalPanel.setLayout(new BoxLayout(principalPanel, BoxLayout.X_AXIS));
        principalPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel principalLabel = new JLabel("Principal: ");
        principalLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        principalPanel.add(principalLabel);
        principalPanel.add(field1);
        inputPanel.add(principalPanel);

        JPanel annualInterestRatePanel = new JPanel();
        annualInterestRatePanel.setLayout(new BoxLayout(annualInterestRatePanel, BoxLayout.X_AXIS));
        annualInterestRatePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel annualInterestRateLabel = new JLabel("Annual Interest Rate (%): ");
        annualInterestRateLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        annualInterestRatePanel.add(annualInterestRateLabel);
        annualInterestRatePanel.add(field2);
        inputPanel.add(annualInterestRatePanel);

        JPanel yearsPanel = new JPanel();
        yearsPanel.setLayout(new BoxLayout(yearsPanel, BoxLayout.X_AXIS));
        yearsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel yearsLabel = new JLabel("Years: ");
        yearsLabel.setFont(labelFont);
        field3 = new JTextField(10);
        field3.setFont(textFieldFont);
        yearsPanel.add(yearsLabel);
        yearsPanel.add(field3);
        inputPanel.add(yearsPanel);

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
                double principal = Double.parseDouble(field1.getText());
                double annualInterestRate = Double.parseDouble(field2.getText()) / 100;
                int years = Integer.parseInt(field3.getText());
                double result = principal * Math.pow(1 + annualInterestRate, years); // Result in future value
                
                resultLabel.setText(String.format("Result: $%.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}