import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class FrictionCalculator extends JPanel {
    private JTextField normalForceField;
    private JTextField frictionCoefficientField;
    private JLabel resultLabel;

    public FrictionCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Friction Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel normalForcePanel = new JPanel();
        normalForcePanel.setLayout(new BoxLayout(normalForcePanel, BoxLayout.X_AXIS));
        normalForcePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel normalForceLabel = new JLabel("Normal Force (N): ");
        normalForceLabel.setFont(labelFont);
        normalForceField = new JTextField(10);
        normalForceField.setFont(textFieldFont);
        normalForcePanel.add(normalForceLabel);
        normalForcePanel.add(normalForceField);
        inputPanel.add(normalForcePanel);

        JPanel frictionCoefficientPanel = new JPanel();
        frictionCoefficientPanel.setLayout(new BoxLayout(frictionCoefficientPanel, BoxLayout.X_AXIS));
        frictionCoefficientPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel frictionCoefficientLabel = new JLabel("Friction Coefficient (μ): ");
        frictionCoefficientLabel.setFont(labelFont);
        frictionCoefficientField = new JTextField(10);
        frictionCoefficientField.setFont(textFieldFont);
        frictionCoefficientPanel.add(frictionCoefficientLabel);
        frictionCoefficientPanel.add(frictionCoefficientField);
        inputPanel.add(frictionCoefficientPanel);

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
                double normalForce = Double.parseDouble(normalForceField.getText());
                double frictionCoefficient = Double.parseDouble(frictionCoefficientField.getText());
                double result = normalForce * frictionCoefficient;
                resultLabel.setText(String.format("Friction (N): %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}