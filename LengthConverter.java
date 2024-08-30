import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LengthConverter extends JPanel {
    private JTextField inputField;
    private JComboBox<String> fromUnitBox;
    private JComboBox<String> toUnitBox;
    private JLabel resultLabel;

    private final String[] UNITS = {"Meters", "Kilometers", "Centimeters", "Millimeters", "Miles", "Yards", "Feet", "Inches"};

    public LengthConverter(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Length Converter");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel valuePanel = new JPanel();
        valuePanel.setLayout(new BoxLayout(valuePanel, BoxLayout.X_AXIS));
        valuePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel valueLabel = new JLabel("Value: ");
        valueLabel.setFont(labelFont);
        inputField = new JTextField(10);
        inputField.setFont(textFieldFont);
        valuePanel.add(valueLabel);
        valuePanel.add(inputField);
        inputPanel.add(valuePanel);

        JPanel fromUnitPanel = new JPanel();
        fromUnitPanel.setLayout(new BoxLayout(fromUnitPanel, BoxLayout.X_AXIS));
        fromUnitPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel fromUnitLabel = new JLabel("From: ");
        fromUnitLabel.setFont(labelFont);
        fromUnitBox = new JComboBox<>(UNITS);
        fromUnitBox.setFont(textFieldFont);
        fromUnitPanel.add(fromUnitLabel);
        fromUnitPanel.add(fromUnitBox);
        inputPanel.add(fromUnitPanel);

        JPanel toUnitPanel = new JPanel();
        toUnitPanel.setLayout(new BoxLayout(toUnitPanel, BoxLayout.X_AXIS));
        toUnitPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel toUnitLabel = new JLabel("To: ");
        toUnitLabel.setFont(labelFont);
        toUnitBox = new JComboBox<>(UNITS);
        toUnitBox.setFont(textFieldFont);
        toUnitPanel.add(toUnitLabel);
        toUnitPanel.add(toUnitBox);
        inputPanel.add(toUnitPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(buttonPanel, BorderLayout.SOUTH);

        JButton convertButton = new JButton("Convert");
        convertButton.setFont(textFieldFont);
        convertButton.addActionListener(new ConvertButtonListener());
        buttonPanel.add(convertButton);

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

    private class ConvertButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double value = Double.parseDouble(inputField.getText());
                String fromUnit = (String) fromUnitBox.getSelectedItem();
                String toUnit = (String) toUnitBox.getSelectedItem();
                double result = convert(value, fromUnit, toUnit);
                resultLabel.setText(String.format("Result: %.4f %s", result, toUnit));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number.");
            }
        }

        private double convert(double value, String fromUnit, String toUnit) {
            // Convert to meters first
            double inMeters = toMeters(value, fromUnit);
            // Then convert from meters to the target unit
            return fromMeters(inMeters, toUnit);
        }

        private double toMeters(double value, String unit) {
            switch (unit) {
                case "Meters": return value;
                case "Kilometers": return value * 1000;
                case "Centimeters": return value / 100;
                case "Millimeters": return value / 1000;
                case "Miles": return value * 1609.344;
                case "Yards": return value * 0.9144;
                case "Feet": return value * 0.3048;
                case "Inches": return value * 0.0254;
                default: return value;
            }
        }

        private double fromMeters(double meters, String unit) {
            switch (unit) {
                case "Meters": return meters;
                case "Kilometers": return meters / 1000;
                case "Centimeters": return meters * 100;
                case "Millimeters": return meters * 1000;
                case "Miles": return meters / 1609.344;
                case "Yards": return meters / 0.9144;
                case "Feet": return meters / 0.3048;
                case "Inches": return meters / 0.0254;
                default: return meters;
            }
        }
    }
}