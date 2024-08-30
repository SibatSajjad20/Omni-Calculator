import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ElectricFieldCalculator extends JPanel {
    private JTextField chargeField;
    private JTextField distanceField;
    private JLabel resultLabel;

    public ElectricFieldCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        JPanel headingPanel = new JPanel();
        JLabel headingLabel = new JLabel("Electric Field Calculator");
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
        chargeField = new JTextField(10);
        chargeField.setFont(textFieldFont);
        chargePanel.add(chargeLabel);
        chargePanel.add(chargeField);
        inputPanel.add(chargePanel);

        JPanel distancePanel = new JPanel();
        distancePanel.setLayout(new BoxLayout(distancePanel, BoxLayout.X_AXIS));
        distancePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel distanceLabel = new JLabel("Distance (m): ");
        distanceLabel.setFont(labelFont);
        distanceField = new JTextField(10);
        distanceField.setFont(textFieldFont);
        distancePanel.add(distanceLabel);
        distancePanel.add(distanceField);
        inputPanel.add(distancePanel);

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
                double charge = Double.parseDouble(chargeField.getText());
                double distance = Double.parseDouble(distanceField.getText());
                double k = 8.99e9;
                double result = k * charge / Math.pow(distance, 2);
                resultLabel.setText(String.format("Electric Field: %.2f N/C", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}