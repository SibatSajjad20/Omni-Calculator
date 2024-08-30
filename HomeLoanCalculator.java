import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class HomeLoanCalculator extends JPanel {
    private JTextField principalField;
    private JTextField annualInterestRateField;
    private JTextField yearsField;
    private JLabel resultLabel;

    public HomeLoanCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Home Loan Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel principalPanel = new JPanel();
        principalPanel.setLayout(new BoxLayout(principalPanel, BoxLayout.X_AXIS));
        principalPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel principalLabel = new JLabel("Principal Amount ($): ");
        principalLabel.setFont(labelFont);
        principalField = new JTextField(10);
        principalField.setFont(textFieldFont);
        principalPanel.add(principalLabel);
        principalPanel.add(principalField);
        inputPanel.add(principalPanel);

        JPanel annualInterestRatePanel = new JPanel();
        annualInterestRatePanel.setLayout(new BoxLayout(annualInterestRatePanel, BoxLayout.X_AXIS));
        annualInterestRatePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel annualInterestRateLabel = new JLabel("Annual Interest Rate (%): ");
        annualInterestRateLabel.setFont(labelFont);
        annualInterestRateField = new JTextField(10);
        annualInterestRateField.setFont(textFieldFont);
        annualInterestRatePanel.add(annualInterestRateLabel);
        annualInterestRatePanel.add(annualInterestRateField);
        inputPanel.add(annualInterestRatePanel);

        JPanel yearsPanel = new JPanel();
        yearsPanel.setLayout(new BoxLayout(yearsPanel, BoxLayout.X_AXIS));
        yearsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel yearsLabel = new JLabel("Years: ");
        yearsLabel.setFont(labelFont);
        yearsField = new JTextField(10);
        yearsField.setFont(textFieldFont);
        yearsPanel.add(yearsLabel);
        yearsPanel.add(yearsField);
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

        resultLabel = new JLabel("Monthly Payment: ");
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
                double principal = Double.parseDouble(principalField.getText());
                double annualInterestRate = Double.parseDouble(annualInterestRateField.getText()) / 100;
                double years = Double.parseDouble(yearsField.getText());
                double monthlyInterestRate = annualInterestRate / 12;
                double numberOfPayments = years * 12;
                double result = principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments) / (Math.pow(1 + monthlyInterestRate, numberOfPayments) - 1);
                resultLabel.setText(String.format("Monthly Payment: $%.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}