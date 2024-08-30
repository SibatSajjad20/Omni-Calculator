import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CarbCalculator extends JPanel {
    private JTextField caloriesField;
    private JTextField carbPercentageField;
    private JLabel resultLabel;

    public CarbCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // **Carb Calculator**
        JLabel calculatorLabel = new JLabel("Carb Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel caloriesPanel = new JPanel();
        caloriesPanel.setLayout(new BoxLayout(caloriesPanel, BoxLayout.X_AXIS));
        caloriesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel caloriesLabel = new JLabel("Calories: ");
        caloriesLabel.setFont(labelFont);
        caloriesField = new JTextField(10);
        caloriesField.setFont(textFieldFont);
        caloriesPanel.add(caloriesLabel);
        caloriesPanel.add(caloriesField);
        inputPanel.add(caloriesPanel);

        JPanel carbPercentagePanel = new JPanel();
        carbPercentagePanel.setLayout(new BoxLayout(carbPercentagePanel, BoxLayout.X_AXIS));
        carbPercentagePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel carbPercentageLabel = new JLabel("Carb Percentage: ");
        carbPercentageLabel.setFont(labelFont);
        carbPercentageField = new JTextField(10);
        carbPercentageField.setFont(textFieldFont);
        carbPercentagePanel.add(carbPercentageLabel);
        carbPercentagePanel.add(carbPercentageField);
        inputPanel.add(carbPercentagePanel);

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

        resultLabel = new JLabel("Carbs: ");
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
                double calories = Double.parseDouble(caloriesField.getText());
                double carbPercentage = Double.parseDouble(carbPercentageField.getText());
                double result = calories * (carbPercentage / 100) / 4;
                resultLabel.setText(String.format("Carbs: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}