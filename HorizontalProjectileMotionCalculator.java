import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class HorizontalProjectileMotionCalculator extends JPanel {
    private JTextField initialVelocityField;
    private JTextField heightField;
    private JLabel resultLabel;

    public HorizontalProjectileMotionCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Horizontal Projectile Motion Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

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
        initialVelocityField = new JTextField(10);
        initialVelocityField.setFont(textFieldFont);
        initialVelocityPanel.add(initialVelocityLabel);
        initialVelocityPanel.add(initialVelocityField);
        inputPanel.add(initialVelocityPanel);

        JPanel heightPanel = new JPanel();
        heightPanel.setLayout(new BoxLayout(heightPanel, BoxLayout.X_AXIS));
        heightPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel heightLabel = new JLabel("Height (m): ");
        heightLabel.setFont(labelFont);
        heightField = new JTextField(10);
        heightField.setFont(textFieldFont);
        heightPanel.add(heightLabel);
        heightPanel.add(heightField);
        inputPanel.add(heightPanel);

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

        resultLabel = new JLabel("Horizontal Range: ");
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
                double initialVelocity = Double.parseDouble(initialVelocityField.getText());
                double height = Double.parseDouble(heightField.getText());
                double g = 9.81;
                double time = Math.sqrt(2 * height / g);
                double range = initialVelocity * time;
                double result = range;
                resultLabel.setText(String.format("Horizontal Range: %.2f m", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}