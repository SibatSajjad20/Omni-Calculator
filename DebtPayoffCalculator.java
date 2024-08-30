import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DebtPayoffCalculator extends JPanel {
    private JTextField principalField;
    private JTextField monthlyPaymentField;
    private JTextField interestRateField;
    private JLabel resultLabel;

    public DebtPayoffCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // Add a heading
        JLabel heading = new JLabel("Debt Payoff Calculator");
        heading.setFont(new Font("Poppins", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        add(inputPanel, BorderLayout.CENTER);

        inputPanel.add(new JLabel("Principal:"));
        principalField = new JTextField(10);
        inputPanel.add(principalField);

        inputPanel.add(new JLabel("Monthly Payment:"));
        monthlyPaymentField = new JTextField(10);
        inputPanel.add(monthlyPaymentField);

        inputPanel.add(new JLabel("Interest Rate (%):"));
        interestRateField = new JTextField(10);
        inputPanel.add(interestRateField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        add(buttonPanel, BorderLayout.SOUTH);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        resultLabel = new JLabel("Result: ");
        buttonPanel.add(resultLabel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double principal = Double.parseDouble(principalField.getText());
                double monthlyPayment = Double.parseDouble(monthlyPaymentField.getText());
                double interestRate = Double.parseDouble(interestRateField.getText()) / 100 / 12;
                int months = (int) Math.ceil(principal * interestRate / (monthlyPayment - principal * interestRate)); // Result in months to pay off debt
                
                resultLabel.setText(String.format("Months to pay off debt: %d", months));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}