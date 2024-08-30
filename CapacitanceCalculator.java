import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CapacitanceCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JLabel resultLabel;

    public CapacitanceCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        JPanel headingPanel = new JPanel();
        JLabel headingLabel = new JLabel("Capacitance Calculator");
        headingLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        headingPanel.add(headingLabel);
        add(headingPanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel chargePanel = new JPanel();
        chargePanel.setLayout(new BoxLayout(chargePanel, BoxLayout.X_AXIS));
        chargePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel chargeLabel = new JLabel("Charge (C): ");
        chargeLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        chargePanel.add(chargeLabel);
        chargePanel.add(field1);
        inputPanel.add(chargePanel);

        JPanel voltagePanel = new JPanel();
        voltagePanel.setLayout(new BoxLayout(voltagePanel, BoxLayout.X_AXIS));
        voltagePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel voltageLabel = new JLabel("Voltage (V): ");
        voltageLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        voltagePanel.add(voltageLabel);
        voltagePanel.add(field2);
        inputPanel.add(voltagePanel);

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
                double charge = Double.parseDouble(field1.getText());
                double voltage = Double.parseDouble(field2.getText());
                if (voltage == 0) {
                    resultLabel.setText("Voltage cannot be zero.");
                } else {
                    double result = charge / voltage; // Capacitance
                    resultLabel.setText(String.format("Capacitance: %.2f F", result));
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}