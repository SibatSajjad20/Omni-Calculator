import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BodyTemperatureConverter extends JPanel {
    private JTextField temperatureField;
    private JRadioButton celsiusRadioButton;
    private JRadioButton fahrenheitRadioButton;
    private ButtonGroup radioGroup;
    private JLabel resultLabel;

    public BodyTemperatureConverter(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // **Body Temperature Converter**
        JLabel calculatorLabel = new JLabel("Body Temperature Converter");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

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
        temperatureField = new JTextField(10);
        temperatureField.setFont(textFieldFont);
        temperaturePanel.add(temperatureLabel);
        temperaturePanel.add(temperatureField);
        inputPanel.add(temperaturePanel);

        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.X_AXIS));
        radioPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        celsiusRadioButton = new JRadioButton("Celsius");
        fahrenheitRadioButton = new JRadioButton("Fahrenheit");
        radioGroup = new ButtonGroup();
        radioGroup.add(celsiusRadioButton);
        radioGroup.add(fahrenheitRadioButton);
        radioPanel.add(celsiusRadioButton);
        radioPanel.add(fahrenheitRadioButton);
        inputPanel.add(radioPanel);

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

        resultLabel = new JLabel("Body Temperature: ");
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
                double temperature = Double.parseDouble(temperatureField.getText());
                boolean isCelsius = celsiusRadioButton.isSelected();
                double result = isCelsius ? (temperature * 9/5) + 32 : (temperature - 32) * 5/9;
                resultLabel.setText(String.format("Body Temperature: %.2f", isCelsius ? result : temperature));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}