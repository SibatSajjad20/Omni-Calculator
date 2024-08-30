import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DebttoIncomeRatioCalculator extends JPanel {
    private JTextField monthlyDebtField;
    private JTextField monthlyIncomeField;
    private JLabel resultLabel;

    public DebttoIncomeRatioCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // Add a heading
        JLabel heading = new JLabel("Debt to Income Ratio Calculator");
        heading.setFont(new Font("Poppins", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        add(inputPanel, BorderLayout.CENTER);

        inputPanel.add(new JLabel("Monthly Debt:"));
        monthlyDebtField = new JTextField(10);
        inputPanel.add(monthlyDebtField);

        inputPanel.add(new JLabel("Monthly Income:"));
        monthlyIncomeField = new JTextField(10);
        inputPanel.add(monthlyIncomeField);

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
                double monthlyDebt = Double.parseDouble(monthlyDebtField.getText());
                double monthlyIncome = Double.parseDouble(monthlyIncomeField.getText());
                double result = (monthlyDebt / monthlyIncome) * 100;
                resultLabel.setText(String.format("Income Ratio: %.2f%%", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}