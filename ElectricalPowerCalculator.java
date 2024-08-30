import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ElectricalPowerCalculator extends JPanel {
    private JTextField voltageField;
    private JTextField currentField;
    private JLabel resultLabel;

    public ElectricalPowerCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // Add a heading
        JLabel heading = new JLabel("Electrical Power Calculator");
        heading.setFont(new Font("Poppins", Font.BOLD, 24));
        add(heading, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        add(inputPanel, BorderLayout.CENTER);

        JPanel voltagePanel = new JPanel();
        voltagePanel.setLayout(new BoxLayout(voltagePanel, BoxLayout.X_AXIS));
        voltagePanel.add(new JLabel("Voltage (V):"));
        voltageField = new JTextField(10);
        voltagePanel.add(voltageField);
        inputPanel.add(voltagePanel);

        JPanel currentPanel = new JPanel();
        currentPanel.setLayout(new BoxLayout(currentPanel, BoxLayout.X_AXIS));
        currentPanel.add(new JLabel("Current (A):"));
        currentField = new JTextField(10);
        currentPanel.add(currentField);
        inputPanel.add(currentPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        add(buttonPanel, BorderLayout.SOUTH);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        resultLabel = new JLabel("Result: ");
        buttonPanel.add(resultLabel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double voltage = Double.parseDouble(voltageField.getText());
                double current = Double.parseDouble(currentField.getText());
                double result = voltage * current;
                resultLabel.setText(String.format("Electrical Power: %.2f W", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}