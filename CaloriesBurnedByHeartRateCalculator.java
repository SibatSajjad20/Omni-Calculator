import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CaloriesBurnedByHeartRateCalculator extends JPanel {
    private JTextField ageField;
    private JTextField weightField;
    private JTextField heartRateField;
    private JLabel resultLabel;

    public CaloriesBurnedByHeartRateCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // **Calories Burned By Heart Rate Calculator**
        JLabel calculatorLabel = new JLabel("Calories Burned By Heart Rate Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel agePanel = new JPanel();
        agePanel.setLayout(new BoxLayout(agePanel, BoxLayout.X_AXIS));
        agePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel ageLabel = new JLabel("Age (years): ");
        ageLabel.setFont(labelFont);
        ageField = new JTextField(10);
        ageField.setFont(textFieldFont);
        agePanel.add(ageLabel);
        agePanel.add(ageField);
        inputPanel.add(agePanel);

        JPanel weightPanel = new JPanel();
        weightPanel.setLayout(new BoxLayout(weightPanel, BoxLayout.X_AXIS));
        weightPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel weightLabel = new JLabel("Weight (kg): ");
        weightLabel.setFont(labelFont);
        weightField = new JTextField(10);
        weightField.setFont(textFieldFont);
        weightPanel.add(weightLabel);
        weightPanel.add(weightField);
        inputPanel.add(weightPanel);

        JPanel heartRatePanel = new JPanel();
        heartRatePanel.setLayout(new BoxLayout(heartRatePanel, BoxLayout.X_AXIS));
        heartRatePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel heartRateLabel = new JLabel("Heart Rate (bpm): ");
        heartRateLabel.setFont(labelFont);
        heartRateField = new JTextField(10);
        heartRateField.setFont(textFieldFont);
        heartRatePanel.add(heartRateLabel);
        heartRatePanel.add(heartRateField);
        inputPanel.add(heartRatePanel);

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

        resultLabel = new JLabel("Calories Burned By Heart Rate: ");
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
                int age = Integer.parseInt(ageField.getText());
                double weight = Double.parseDouble(weightField.getText());
                int heartRate = Integer.parseInt(heartRateField.getText());

                if (age <= 0 || weight <= 0 || heartRate <= 0) {
                    resultLabel.setText("Invalid input values. Please enter positive numbers.");
                    return;
                }

                double caloriesBurned = calculateCaloriesBurned(age, weight, heartRate);
                updateResultLabel(caloriesBurned);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }

    private double calculateCaloriesBurned(int age, double weight, int heartRate) {
        return ((age * 0.2017) - (weight * 0.09036) + (heartRate * 0.6309) - 55.0969) * 4.184; // Calories burned
    }

    private void updateResultLabel(double caloriesBurned) {
        resultLabel.setText(String.format("Calories Burned By Heart Rate: %.2f", caloriesBurned));
    }
}