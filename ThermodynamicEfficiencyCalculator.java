import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ThermodynamicEfficiencyCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JLabel resultLabel;

    public ThermodynamicEfficiencyCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Thermodynamic Efficiency Calculator**
        JLabel calculatorLabel = new JLabel("Thermodynamic Efficiency Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel temperatureHotPanel = new JPanel();
        temperatureHotPanel.setLayout(new BoxLayout(temperatureHotPanel, BoxLayout.X_AXIS));
        temperatureHotPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel temperatureHotLabel = new JLabel("Temperature Hot (K): ");
        temperatureHotLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        temperatureHotPanel.add(temperatureHotLabel);
        temperatureHotPanel.add(field1);
        inputPanel.add(temperatureHotPanel);

        JPanel temperatureColdPanel = new JPanel();
        temperatureColdPanel.setLayout(new BoxLayout(temperatureColdPanel, BoxLayout.X_AXIS));
        temperatureColdPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel temperatureColdLabel = new JLabel("Temperature Cold (K): ");
        temperatureColdLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        temperatureColdPanel.add(temperatureColdLabel);
        temperatureColdPanel.add(field2);
        inputPanel.add(temperatureColdPanel);

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
                double temperatureHot = Double.parseDouble(field1.getText());
                double temperatureCold = Double.parseDouble(field2.getText());
                double result = (temperatureHot - temperatureCold) / temperatureHot; // Thermodynamic efficiency
                
                resultLabel.setText(String.format("Thermodynamic efficiency: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}