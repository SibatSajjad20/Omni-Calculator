import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class KineticEnergyCalculator extends JPanel {
    private JTextField massField;
    private JTextField velocityField;
    private JLabel resultLabel;

    public KineticEnergyCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Kinetic Energy Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

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
        massField = new JTextField(10);
        massField.setFont(textFieldFont);
        massPanel.add(massLabel);
        massPanel.add(massField);
        inputPanel.add(massPanel);

        JPanel velocityPanel = new JPanel();
        velocityPanel.setLayout(new BoxLayout(velocityPanel, BoxLayout.X_AXIS));
        velocityPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel velocityLabel = new JLabel("Velocity (m/s): ");
        velocityLabel.setFont(labelFont);
        velocityField = new JTextField(10);
        velocityField.setFont(textFieldFont);
        velocityPanel.add(velocityLabel);
        velocityPanel.add(velocityField);
        inputPanel.add(velocityPanel);

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

        resultLabel = new JLabel("Kinetic Energy: ");
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
                double mass = Double.parseDouble(massField.getText());
                double velocity = Double.parseDouble(velocityField.getText());
                double result = 0.5 * mass * Math.pow(velocity, 2);
                resultLabel.setText(String.format("Kinetic Energy: %.2f J", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}