import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class StoppingDistanceCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JLabel resultLabel;

    public StoppingDistanceCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Stopping Distance Calculator**
        JLabel calculatorLabel = new JLabel("Stopping Distance Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel initialVelocityPanel = new JPanel();
        initialVelocityPanel.setLayout(new BoxLayout(initialVelocityPanel, BoxLayout.X_AXIS));
        initialVelocityPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel initialVelocityLabel = new JLabel("Initial Velocity (m/s): ");
        initialVelocityLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        initialVelocityPanel.add(initialVelocityLabel);
        initialVelocityPanel.add(field1);
        inputPanel.add(initialVelocityPanel);

        JPanel decelerationPanel = new JPanel();
        decelerationPanel.setLayout(new BoxLayout(decelerationPanel, BoxLayout.X_AXIS));
        decelerationPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel decelerationLabel = new JLabel("Deceleration (m/s²): ");
        decelerationLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        decelerationPanel.add(decelerationLabel);
        decelerationPanel.add(field2);
        inputPanel.add(decelerationPanel);

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

        resultLabel = new JLabel("Stopping Distance: ");
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
                double initialVelocity = Double.parseDouble(field1.getText());
                double deceleration = Double.parseDouble(field2.getText());
                double result = Math.pow(initialVelocity, 2) / (2 * deceleration);
                
                resultLabel.setText(String.format("Stopping Distance: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}