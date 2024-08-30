import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SavingsGoalCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JLabel resultLabel;

    public SavingsGoalCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Savings Goal Calculator**
        JLabel calculatorLabel = new JLabel("Savings Goal Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel goalAmountPanel = new JPanel();
        goalAmountPanel.setLayout(new BoxLayout(goalAmountPanel, BoxLayout.X_AXIS));
        goalAmountPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel goalAmountLabel = new JLabel("Goal Amount: ");
        goalAmountLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        goalAmountPanel.add(goalAmountLabel);
        goalAmountPanel.add(field1);
        inputPanel.add(goalAmountPanel);

        JPanel monthlySavingsPanel = new JPanel();
        monthlySavingsPanel.setLayout(new BoxLayout(monthlySavingsPanel, BoxLayout.X_AXIS));
        monthlySavingsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel monthlySavingsLabel = new JLabel("Monthly Savings: ");
        monthlySavingsLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        monthlySavingsPanel.add(monthlySavingsLabel);
        monthlySavingsPanel.add(field2);
        inputPanel.add(monthlySavingsPanel);

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
                double goalAmount = Double.parseDouble(field1.getText());
                double monthlySavings = Double.parseDouble(field2.getText());
                int months = (int) Math.ceil(goalAmount / monthlySavings); // Result in months
                
                resultLabel.setText(String.format("Months needed to reach the goal: %d", months));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}