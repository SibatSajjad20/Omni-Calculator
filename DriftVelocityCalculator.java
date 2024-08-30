import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DriftVelocityCalculator extends JPanel {
    private JTextField currentField;
    private JTextField areaField;
    private JTextField chargeCarrierDensityField;
    private JLabel resultLabel;

    public DriftVelocityCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // Add a heading
        JLabel heading = new JLabel("Drift Velocity Calculator");
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        add(inputPanel, BorderLayout.CENTER);

        JPanel currentPanel = new JPanel();
        currentPanel.setLayout(new BoxLayout(currentPanel, BoxLayout.X_AXIS));
        currentPanel.add(new JLabel("Current (A):"));
        currentField = new JTextField(10);
        currentPanel.add(currentField);
        inputPanel.add(currentPanel);

        JPanel areaPanel = new JPanel();
        areaPanel.setLayout(new BoxLayout(areaPanel, BoxLayout.X_AXIS));
        areaPanel.add(new JLabel("Area (m^2):"));
        areaField = new JTextField(10);
        areaPanel.add(areaField);
        inputPanel.add(areaPanel);

        JPanel chargeCarrierDensityPanel = new JPanel();
        chargeCarrierDensityPanel.setLayout(new BoxLayout(chargeCarrierDensityPanel, BoxLayout.X_AXIS));
        chargeCarrierDensityPanel.add(new JLabel("Charge Carrier Density (m^-3):"));
        chargeCarrierDensityField = new JTextField(10);
        chargeCarrierDensityPanel.add(chargeCarrierDensityField);
        inputPanel.add(chargeCarrierDensityPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        add(buttonPanel, BorderLayout.SOUTH);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        resultLabel = new JLabel("Drift Velocity: ");
        buttonPanel.add(resultLabel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double current = Double.parseDouble(currentField.getText());
                double area = Double.parseDouble(areaField.getText());
                double chargeCarrierDensity = Double.parseDouble(chargeCarrierDensityField.getText());
                double charge = 1.602e-19; 
                double result = current / (area * chargeCarrierDensity * charge);
                resultLabel.setText(String.format("Drift Velocity: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}