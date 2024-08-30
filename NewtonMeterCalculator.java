import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NewtonMeterCalculator extends JPanel {
    private JTextField torqueField;
    private JLabel resultLabel;

    public NewtonMeterCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Newton-Meter Calculator**
        JLabel calculatorLabel = new JLabel("Newton-Meter Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel torquePanel = new JPanel();
        torquePanel.setLayout(new BoxLayout(torquePanel, BoxLayout.X_AXIS));
        torquePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel torqueLabel = new JLabel("Torque (Newton-Meters): ");
        torqueLabel.setFont(labelFont);
        torqueField = new JTextField(10);
        torqueField.setFont(textFieldFont);
        torquePanel.add(torqueLabel);
        torquePanel.add(torqueField);
        inputPanel.add(torquePanel);

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

        resultLabel = new JLabel("Torque (Pound-Force Feet): ");
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
                double torque = Double.parseDouble(torqueField.getText());
                double result = torque / 1.356;
                resultLabel.setText(String.format("Torque: %.2f Pound-Force Feet", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}