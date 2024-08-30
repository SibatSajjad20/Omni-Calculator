import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TensionCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JLabel resultLabel;

    public TensionCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Tension Calculator**
        JLabel calculatorLabel = new JLabel("Tension Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel massPanel = new JPanel();
        massPanel.setLayout(new BoxLayout(massPanel, BoxLayout.X_AXIS));
        massPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel massLabel = new JLabel("Mass (kg): ");
        massLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        massPanel.add(massLabel);
        massPanel.add(field1);
        inputPanel.add(massPanel);

        JPanel accelerationPanel = new JPanel();
        accelerationPanel.setLayout(new BoxLayout(accelerationPanel, BoxLayout.X_AXIS));
        accelerationPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel accelerationLabel = new JLabel("Acceleration (m/s²): ");
        accelerationLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        accelerationPanel.add(accelerationLabel);
        accelerationPanel.add(field2);
        inputPanel.add(accelerationPanel);

        JPanel anglePanel = new JPanel();
        anglePanel.setLayout(new BoxLayout(anglePanel, BoxLayout.X_AXIS));
        anglePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel angleLabel = new JLabel("Angle (degrees): ");
        angleLabel.setFont(labelFont);
        field3 = new JTextField(10);
        field3.setFont(textFieldFont);
        anglePanel.add(angleLabel);
        anglePanel.add(field3);
        inputPanel.add(anglePanel);

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
                double mass = Double.parseDouble(field1.getText());
                double acceleration = Double.parseDouble(field2.getText());
                double angle = Math.toRadians(Double.parseDouble(field3.getText()));
                double g = 9.81; // acceleration due to gravity
                double result = mass * (g * Math.sin(angle) + acceleration);
                resultLabel.setText(String.format("Tension: %.2f N", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}