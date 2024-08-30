import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ForceCalculator extends JPanel {
    private JTextField massField;
    private JTextField accelerationField;
    private JLabel resultLabel;

    public ForceCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add the heading
        JLabel headingLabel = new JLabel("Force Calculator", SwingConstants.CENTER);
        headingLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        add(headingLabel, BorderLayout.NORTH);

        // Create a panel for the existing components
        JPanel contentPanel = new JPanel(new GridLayout(4, 2));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        contentPanel.add(new JLabel("Mass (kg):"));
        massField = new JTextField();
        contentPanel.add(massField);

        contentPanel.add(new JLabel("Acceleration (m/s^2):"));
        accelerationField = new JTextField();
        contentPanel.add(accelerationField);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        contentPanel.add(calculateButton);

        resultLabel = new JLabel("Force (N): ");
        contentPanel.add(resultLabel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        contentPanel.add(backButton);

        // Add the content panel to the center of the main panel
        add(contentPanel, BorderLayout.CENTER);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double mass = Double.parseDouble(massField.getText());
                double acceleration = Double.parseDouble(accelerationField.getText());

                if (mass <= 0 || acceleration <= 0) {
                    resultLabel.setText("Invalid input values. Please enter positive numbers.");
                    return;
                }

                double force = mass * acceleration;
                resultLabel.setText(String.format("Force (N): %.2f", force));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}