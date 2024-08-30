import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AccelerationCalculator extends JPanel {
    private JTextField initialVelocityField;
    private JTextField finalVelocityField;
    private JTextField timeField;
    private JLabel resultLabel;

    public AccelerationCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add heading
        JLabel heading = new JLabel("Acceleration Calculator");
        heading.setFont(new Font("Poppins", Font.BOLD, 24));
        add(heading, BorderLayout.NORTH);

        // Create input panel with grid layout
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        inputPanel.add(new JLabel("Initial Velocity (m/s):"));
        initialVelocityField = new JTextField();
        inputPanel.add(initialVelocityField);

        inputPanel.add(new JLabel("Final Velocity (m/s):"));
        finalVelocityField = new JTextField();
        inputPanel.add(finalVelocityField);

        inputPanel.add(new JLabel("Time (s):"));
        timeField = new JTextField();
        inputPanel.add(timeField);

        add(inputPanel, BorderLayout.CENTER);

        // Create button panel with flow layout
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        resultLabel = new JLabel("Result: ");
        buttonPanel.add(resultLabel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Set font and style for labels and buttons
        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font buttonFont = new Font("Poppins", Font.BOLD, 18);

        for (Component component : inputPanel.getComponents()) {
            if (component instanceof JTextField) {
                ((JTextField) component).setFont(labelFont);
            }
        }

        for (Component component : buttonPanel.getComponents()) {
            if (component instanceof JButton) {
                ((JButton) component).setFont(buttonFont);
            } else if (component instanceof JLabel) {
                ((JLabel) component).setFont(labelFont);
            }
        }
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double initialVelocity = Double.parseDouble(initialVelocityField.getText());
                double finalVelocity = Double.parseDouble(finalVelocityField.getText());
                double time = Double.parseDouble(timeField.getText());
                double result = (finalVelocity - initialVelocity) / time;
                resultLabel.setText(String.format("Acceleration: %.2f m/s²", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}