import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class OperatingMarginCalculator extends JPanel {
    private JTextField operatingIncomeField;
    private JTextField revenueField;
    private JLabel resultLabel;

    public OperatingMarginCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Operating Margin Calculator**
        JLabel calculatorLabel = new JLabel("Operating Margin Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel operatingIncomePanel = new JPanel();
        operatingIncomePanel.setLayout(new BoxLayout(operatingIncomePanel, BoxLayout.X_AXIS));
        operatingIncomePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel operatingIncomeLabel = new JLabel("Operating Income: ");
        operatingIncomeLabel.setFont(labelFont);
        operatingIncomeField = new JTextField(10);
        operatingIncomeField.setFont(textFieldFont);
        operatingIncomePanel.add(operatingIncomeLabel);
        operatingIncomePanel.add(operatingIncomeField);
        inputPanel.add(operatingIncomePanel);

        JPanel revenuePanel = new JPanel();
        revenuePanel.setLayout(new BoxLayout(revenuePanel, BoxLayout.X_AXIS));
        revenuePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel revenueLabel = new JLabel("Revenue: ");
        revenueLabel.setFont(labelFont);
        revenueField = new JTextField(10);
        revenueField.setFont(textFieldFont);
        revenuePanel.add(revenueLabel);
        revenuePanel.add(revenueField);
        inputPanel.add(revenuePanel);

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
                double operatingIncome = Double.parseDouble(operatingIncomeField.getText());
                double revenue = Double.parseDouble(revenueField.getText());
                double result = (operatingIncome / revenue) * 100; // Result in percentage
                resultLabel.setText(String.format("Operating Margin (%): %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}