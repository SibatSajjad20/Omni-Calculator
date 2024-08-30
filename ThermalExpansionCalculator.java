import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ThermalExpansionCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JLabel resultLabel;

    public ThermalExpansionCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Thermal Expansion Calculator**
        JLabel calculatorLabel = new JLabel("Thermal Expansion Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel initialLengthPanel = new JPanel();
        initialLengthPanel.setLayout(new BoxLayout(initialLengthPanel, BoxLayout.X_AXIS));
        initialLengthPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel initialLengthLabel = new JLabel("Initial Length (m): ");
        initialLengthLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        initialLengthPanel.add(initialLengthLabel);
        initialLengthPanel.add(field1);
        inputPanel.add(initialLengthPanel);

        JPanel temperatureChangePanel = new JPanel();
        temperatureChangePanel.setLayout(new BoxLayout(temperatureChangePanel, BoxLayout.X_AXIS));
        temperatureChangePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel temperatureChangeLabel = new JLabel("Temperature Change (°C): ");
        temperatureChangeLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        temperatureChangePanel.add(temperatureChangeLabel);
        temperatureChangePanel.add(field2);
        inputPanel.add(temperatureChangePanel);

        JPanel coefficientOfExpansionPanel = new JPanel();
        coefficientOfExpansionPanel.setLayout(new BoxLayout(coefficientOfExpansionPanel, BoxLayout.X_AXIS));
        coefficientOfExpansionPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel coefficientOfExpansionLabel = new JLabel("Coefficient of Expansion (1/°C): ");
        coefficientOfExpansionLabel.setFont(labelFont);
        field3 = new JTextField(10);
        field3.setFont(textFieldFont);
        coefficientOfExpansionPanel.add(coefficientOfExpansionLabel);
        coefficientOfExpansionPanel.add(field3);
        inputPanel.add(coefficientOfExpansionPanel);

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
                double initialLength = Double.parseDouble(field1.getText());
                double temperatureChange = Double.parseDouble(field2.getText());
                double coefficientOfExpansion = Double.parseDouble(field3.getText());
                double result = initialLength * coefficientOfExpansion * temperatureChange; // Thermal expansion
                
                resultLabel.setText(String.format("Thermal expansion: %.2f m", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}