import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BurpeeCalorieCalculator extends JPanel {
    private JTextField burpeesField;
    private JTextField weightField;
    private JLabel resultLabel;

    public BurpeeCalorieCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // **Burpee Calorie Calculator**
        JLabel calculatorLabel = new JLabel("Burpee Calorie Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel burpeesPanel = new JPanel();
        burpeesPanel.setLayout(new BoxLayout(burpeesPanel, BoxLayout.X_AXIS));
        burpeesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel burpeesLabel = new JLabel("Burpees: ");
        burpeesLabel.setFont(labelFont);
        burpeesField = new JTextField(10);
        burpeesField.setFont(textFieldFont);
        burpeesPanel.add(burpeesLabel);
        burpeesPanel.add(burpeesField);
        inputPanel.add(burpeesPanel);

        JPanel weightPanel = new JPanel();
        weightPanel.setLayout(new BoxLayout(weightPanel, BoxLayout.X_AXIS));
        weightPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel weightLabel = new JLabel("Weight (lbs): ");
        weightLabel.setFont(labelFont);
        weightField = new JTextField(10);
        weightField.setFont(textFieldFont);
        weightPanel.add(weightLabel);
        weightPanel.add(weightField);
        inputPanel.add(weightPanel);

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

        resultLabel = new JLabel("Total Calories burned: ");
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
                int burpees = Integer.parseInt(burpeesField.getText());
                double weight = Double.parseDouble(weightField.getText());

                if (burpees <= 0 || weight <= 0) {
                    resultLabel.setText("Invalid input values. Please enter positive numbers.");
                    return;
                }

                double caloriesBurned = calculateCaloriesBurned(burpees, weight);
                updateResultLabel(caloriesBurned);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }

    private double calculateCaloriesBurned(int burpees, double weight) {
        return burpees * (weight / 2.2) * 0.1; // Calories burned per burpee
    }

    private void updateResultLabel(double caloriesBurned) {
        resultLabel.setText(String.format("Total Calories burned: %.2f", caloriesBurned));
    }
}