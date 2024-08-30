import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CarCrashCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JLabel resultLabel;

    public CarCrashCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        JPanel headingPanel = new JPanel();
        JLabel headingLabel = new JLabel("Car Crash Force Calculator");
        headingLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        headingPanel.add(headingLabel);
        add(headingPanel, BorderLayout.NORTH);

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

        JPanel velocityPanel = new JPanel();
        velocityPanel.setLayout(new BoxLayout(velocityPanel, BoxLayout.X_AXIS));
        velocityPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel velocityLabel = new JLabel("Velocity (m/s): ");
        velocityLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        velocityPanel.add(velocityLabel);
        velocityPanel.add(field2);
        inputPanel.add(velocityPanel);

        JPanel stoppingDistancePanel = new JPanel();
        stoppingDistancePanel.setLayout(new BoxLayout(stoppingDistancePanel, BoxLayout.X_AXIS));
        stoppingDistancePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel stoppingDistanceLabel = new JLabel("Stopping Distance (m): ");
        stoppingDistanceLabel.setFont(labelFont);
        field3 = new JTextField(10);
        field3.setFont(textFieldFont);
        stoppingDistancePanel.add(stoppingDistanceLabel);
        stoppingDistancePanel.add(field3);
        inputPanel.add(stoppingDistancePanel);

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
                double velocity = Double.parseDouble(field2.getText());
                double stoppingDistance = Double.parseDouble(field3.getText());
                double result = mass * Math.pow(velocity, 2) / (2 * stoppingDistance);
                resultLabel.setText(String.format("Car Crash Force: %.2f N", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}