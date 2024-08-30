import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MagneticForceCalculator extends JPanel {
    private JTextField chargeField;
    private JTextField velocityField;
    private JTextField magneticFieldField;
    private JLabel resultLabel;

    public MagneticForceCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Magnetic Force Calculator**
        JLabel calculatorLabel = new JLabel("Magnetic Force Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel chargePanel = new JPanel();
        chargePanel.setLayout(new BoxLayout(chargePanel, BoxLayout.X_AXIS));
        chargePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel chargeLabel = new JLabel("Charge: ");
        chargeLabel.setFont(labelFont);
        chargeField = new JTextField(20);
        chargeField.setFont(textFieldFont);
        chargePanel.add(chargeLabel);
        chargePanel.add(chargeField);
        inputPanel.add(chargePanel);

        JPanel velocityPanel = new JPanel();
        velocityPanel.setLayout(new BoxLayout(velocityPanel, BoxLayout.X_AXIS));
        velocityPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel velocityLabel = new JLabel("Velocity: ");
        velocityLabel.setFont(labelFont);
        velocityField = new JTextField(20);
        velocityField.setFont(textFieldFont);
        velocityPanel.add(velocityLabel);
        velocityPanel.add(velocityField);
        inputPanel.add(velocityPanel);

        JPanel magneticFieldPanel = new JPanel();
        magneticFieldPanel.setLayout(new BoxLayout(magneticFieldPanel, BoxLayout.X_AXIS));
        magneticFieldPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel magneticFieldLabel = new JLabel("Magnetic Field: ");
        magneticFieldLabel.setFont(labelFont);
        magneticFieldField = new JTextField(20);
        magneticFieldField.setFont(textFieldFont);
        magneticFieldPanel.add(magneticFieldLabel);
        magneticFieldPanel.add(magneticFieldField);
        inputPanel.add(magneticFieldPanel);

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

        resultLabel = new JLabel("Magnetic Force: ");
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
                double charge = Double.parseDouble(chargeField.getText());
                double velocity = Double.parseDouble(velocityField.getText());
                double magneticField = Double.parseDouble(magneticFieldField.getText());
                double result = charge * velocity * magneticField; // Magnetic force
                
                resultLabel.setText(String.format("Magnetic Force: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}