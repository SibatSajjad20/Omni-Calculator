import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TemperatureConverter extends JPanel {
    private JTextField field1;
    private JRadioButton celsiusRadioButton;
    private JRadioButton fahrenheitRadioButton;
    private JLabel resultLabel;

    public TemperatureConverter(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Temperature Converter**
        JLabel converterLabel = new JLabel("Temperature Converter");
        converterLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        converterLabel.setHorizontalAlignment(JLabel.CENTER);
        add(converterLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel temperaturePanel = new JPanel();
        temperaturePanel.setLayout(new BoxLayout(temperaturePanel, BoxLayout.X_AXIS));
        temperaturePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel temperatureLabel = new JLabel("Temperature: ");
        temperatureLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        temperaturePanel.add(temperatureLabel);
        temperaturePanel.add(field1);
        inputPanel.add(temperaturePanel);

        JPanel unitPanel = new JPanel();
        unitPanel.setLayout(new BoxLayout(unitPanel, BoxLayout.X_AXIS));
        unitPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        ButtonGroup unitGroup = new ButtonGroup();
        celsiusRadioButton = new JRadioButton("Celsius");
        fahrenheitRadioButton = new JRadioButton("Fahrenheit");
        unitGroup.add(celsiusRadioButton);
        unitGroup.add(fahrenheitRadioButton);
        unitPanel.add(celsiusRadioButton);
        unitPanel.add(fahrenheitRadioButton);
        inputPanel.add(unitPanel);

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
                double temperature = Double.parseDouble(field1.getText());
                boolean isCelsius = celsiusRadioButton.isSelected();
                double result = isCelsius ? (temperature * 9/5) + 32 : (temperature - 32) * 5/9;
                String unit = isCelsius ? "Fahrenheit" : "Celsius";
                resultLabel.setText(String.format("Temperature: %.2f %s", result, unit));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}