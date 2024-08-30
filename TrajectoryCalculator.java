import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TrajectoryCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JLabel resultLabel;

    public TrajectoryCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Trajectory Calculator**
        JLabel calculatorLabel = new JLabel("Trajectory Calculator");
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
        JLabel initialVelocityLabel = new JLabel("Initial Velocity: ");
        initialVelocityLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        initialVelocityPanel.add(initialVelocityLabel);
        initialVelocityPanel.add(field1);
        inputPanel.add(initialVelocityPanel);

        JPanel anglePanel = new JPanel();
        anglePanel.setLayout(new BoxLayout(anglePanel, BoxLayout.X_AXIS));
        anglePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel angleLabel = new JLabel("Angle (degrees): ");
        angleLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        anglePanel.add(angleLabel);
        anglePanel.add(field2);
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
                double initialVelocity = Double.parseDouble(field1.getText());
                double angle = Math.toRadians(Double.parseDouble(field2.getText()));
                double g = 9.81;
                double range = (Math.pow(initialVelocity, 2) * Math.sin(2 * angle)) / g;
                double maxHeight = Math.pow(initialVelocity * Math.sin(angle), 2) / (2 * g);
                resultLabel.setText(String.format("Result: Range = %.2f, Max Height = %.2f", range, maxHeight));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}