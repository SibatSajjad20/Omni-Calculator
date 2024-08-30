import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MortgageRateCalculator extends JPanel {
    private JTextField principalField;
    private JTextField annualInterestRateField;
    private JLabel resultLabel;

    public MortgageRateCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Mortgage Rate Calculator**
        JLabel calculatorLabel = new JLabel("Mortgage Rate Calculator");
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
        JLabel principalLabel = new JLabel("Principal Amount: ");
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

        resultLabel = new JLabel("Mortgage Rate: ");
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
                double annualInterestRate = Double.parseDouble(annualInterestRateField.getText());
                double result = annualInterestRate / 100; // assuming annualInterestRate is in percentage
                resultLabel.setText(String.format("Mortgage Rate: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}