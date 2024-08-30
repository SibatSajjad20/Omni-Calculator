import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CalorieDeficitCalculator extends JPanel {
    private JTextField currentWeightField;
    private JTextField targetWeightField;
    private JTextField timeframeField;
    private JLabel resultLabel;

    public CalorieDeficitCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // **Calorie Deficit Calculator**
        JLabel calculatorLabel = new JLabel("Calorie Deficit Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel currentWeightPanel = new JPanel();
        currentWeightPanel.setLayout(new BoxLayout(currentWeightPanel, BoxLayout.X_AXIS));
        currentWeightPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel currentWeightLabel = new JLabel("Current Weight (kg): ");
        currentWeightLabel.setFont(labelFont);
        currentWeightField = new JTextField(10);
        currentWeightField.setFont(textFieldFont);
        currentWeightPanel.add(currentWeightLabel);
        currentWeightPanel.add(currentWeightField);
        inputPanel.add(currentWeightPanel);

        JPanel targetWeightPanel = new JPanel();
        targetWeightPanel.setLayout(new BoxLayout(targetWeightPanel, BoxLayout.X_AXIS));
        targetWeightPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel targetWeightLabel = new JLabel("Target Weight (kg): ");
        targetWeightLabel.setFont(labelFont);
        targetWeightField = new JTextField(10);
        targetWeightField.setFont(textFieldFont);
        targetWeightPanel.add(targetWeightLabel);
        targetWeightPanel.add(targetWeightField);
        inputPanel.add(targetWeightPanel);

        JPanel timeframePanel = new JPanel();
        timeframePanel.setLayout(new BoxLayout(timeframePanel, BoxLayout.X_AXIS));
        timeframePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel timeframeLabel = new JLabel("Time Frame (weeks): ");
        timeframeLabel.setFont(labelFont);
        timeframeField = new JTextField(10);
        timeframeField.setFont(textFieldFont);
        timeframePanel.add(timeframeLabel);
        timeframePanel.add(timeframeField);
        inputPanel.add(timeframePanel);

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

        resultLabel = new JLabel("Calorie Deficit: ");
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
                double currentWeight = Double.parseDouble(currentWeightField.getText());
                double targetWeight = Double.parseDouble(targetWeightField.getText());
                int timeframe = Integer.parseInt(timeframeField.getText());
                double result = (currentWeight - targetWeight) * 7700 / timeframe;
                resultLabel.setText(String.format("Calorie Deficit: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}