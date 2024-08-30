import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BikeCadenceAndSpeedCalculator extends JPanel {
    private JTextField wheelCircumferenceField;
    private JTextField cadenceField;
    private JLabel resultLabel;

    public BikeCadenceAndSpeedCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Bike Cadence and Speed Calculator**
        JLabel calculatorLabel = new JLabel("Bike Cadence and Speed Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel wheelCircumferencePanel = new JPanel();
        wheelCircumferencePanel.setLayout(new BoxLayout(wheelCircumferencePanel, BoxLayout.X_AXIS));
        wheelCircumferencePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel wheelCircumferenceLabel = new JLabel("Wheel Circumference (meters): ");
        wheelCircumferenceLabel.setFont(labelFont);
        wheelCircumferenceField = new JTextField(10);
        wheelCircumferenceField.setFont(textFieldFont);
        wheelCircumferencePanel.add(wheelCircumferenceLabel);
        wheelCircumferencePanel.add(wheelCircumferenceField);
        inputPanel.add(wheelCircumferencePanel);

        JPanel cadencePanel = new JPanel();
        cadencePanel.setLayout(new BoxLayout(cadencePanel, BoxLayout.X_AXIS));
        cadencePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel cadenceLabel = new JLabel("Cadence (RPM): ");
        cadenceLabel.setFont(labelFont);
        cadenceField = new JTextField(10);
        cadenceField.setFont(textFieldFont);
        cadencePanel.add(cadenceLabel);
        cadencePanel.add(cadenceField);
        inputPanel.add(cadencePanel);

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
                double wheelCircumference = Double.parseDouble(wheelCircumferenceField.getText());
                if (wheelCircumference == 0) {
                    throw new ArithmeticException("Wheel circumference cannot be 0");
                }
                int cadence = Integer.parseInt(cadenceField.getText());
                double speed = calculateSpeed(wheelCircumference, cadence);
                updateResultLabel(speed);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            } catch (ArithmeticException ex) {
                resultLabel.setText("Wheel circumference cannot be 0.");
            }
        }
    }

    private double calculateSpeed(double wheelCircumference, int cadence) {
        return wheelCircumference * cadence * 60 / 1000; // Speed in km/h
    }

    private void updateResultLabel(double speed) {
        resultLabel.setText(String.format("Speed in km/h: %.2f", speed));
    }
}