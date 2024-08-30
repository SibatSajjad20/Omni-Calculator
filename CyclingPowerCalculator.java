import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CyclingPowerCalculator extends JPanel {
    private static final double AIR_DENSITY = 1.225; // in kg/m³
    private static final double DRAG_COEFFICIENT = 0.9; // typical value
    private static final double FRONTAL_AREA = 0.5; // in m²

    private JTextField speedField;
    private JTextField weightField;
    private JLabel resultLabel;

    public CyclingPowerCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Cycling Power Calculator**
        JLabel calculatorLabel = new JLabel("Cycling Power Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel speedPanel = new JPanel();
        speedPanel.setLayout(new BoxLayout(speedPanel, BoxLayout.X_AXIS));
        speedPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel speedLabel = new JLabel("Speed (m/s): ");
        speedLabel.setFont(labelFont);
        speedField = new JTextField(10);
        speedField.setFont(textFieldFont);
        speedPanel.add(speedLabel);
        speedPanel.add(speedField);
        inputPanel.add(speedPanel);

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
                double speed = Double.parseDouble(speedField.getText()); // in m/s
                double weight = Double.parseDouble(weightField.getText()); // in kg
                double power = calculatePower(speed, weight);
                resultLabel.setText(String.format("Cycling Power in watts: %.2f", power));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }

    private double calculatePower(double speed, double weight) {
        return 0.5 * AIR_DENSITY * DRAG_COEFFICIENT * FRONTAL_AREA * Math.pow(speed, 3) + 9.8 * weight * speed;
    }
}