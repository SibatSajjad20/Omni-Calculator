import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AreaConverter extends JPanel {
    private JTextField inputField;
    private JLabel resultLabel;
    private JComboBox<String> fromUnitBox;
    private JComboBox<String> toUnitBox;

    public AreaConverter(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add heading
        JLabel heading = new JLabel("Area Converter");
        heading.setFont(new Font("Poppins", Font.BOLD, 24));
        add(heading, BorderLayout.NORTH);

        // Create input panel with grid layout
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        String[] units = {"Square Meters", "Square Kilometers", "Square Miles", "Square Yards", "Square Feet", "Square Inches", "Hectares", "Acres"};

        inputPanel.add(new JLabel("Value:"));
        inputField = new JTextField();
        inputPanel.add(inputField);

        inputPanel.add(new JLabel("From Unit:"));
        fromUnitBox = new JComboBox<>(units);
        inputPanel.add(fromUnitBox);

        inputPanel.add(new JLabel("To Unit:"));
        toUnitBox = new JComboBox<>(units);
        inputPanel.add(toUnitBox);

        add(inputPanel, BorderLayout.CENTER);

        // Create button panel with flow layout
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ConvertButtonListener());
        buttonPanel.add(convertButton);

        resultLabel = new JLabel("Converted Value: ");
        buttonPanel.add(resultLabel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Set font and style for labels and buttons
        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font buttonFont = new Font("Poppins", Font.BOLD, 18);

        for (Component component : inputPanel.getComponents()) {
            if (component instanceof JLabel) {
                ((JLabel) component).setFont(labelFont);
            }
        }

        for (Component component : buttonPanel.getComponents()) {
            if (component instanceof JButton) {
                ((JButton) component).setFont(buttonFont);
            } else if (component instanceof JLabel) {
                ((JLabel) component).setFont(labelFont);
            }
        }
    }

    private class ConvertButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double value = Double.parseDouble(inputField.getText());
                String fromUnit = (String) fromUnitBox.getSelectedItem();
                String toUnit = (String) toUnitBox.getSelectedItem();
                double convertedValue = convertArea(value, fromUnit, toUnit);
                resultLabel.setText(String.format("Converted Value: %.4f %s", convertedValue, toUnit));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number.");
            }
        }

        private double convertArea(double value, String fromUnit, String toUnit) {
            double[] factors = {1.0, 1e6, 2.59e6, 0.836127, 0.092903, 0.00064516, 10000, 4046.86};
            String[] units = {"Square Meters", "Square Kilometers", "Square Miles", "Square Yards", "Square Feet", "Square Inches", "Hectares", "Acres"};

            double fromFactor = 1.0;
            double toFactor = 1.0;

            for (int i = 0; i < units.length; i++) {
                if (units[i].equals(fromUnit)) {
                    fromFactor = factors[i];
                }
                if (units[i].equals(toUnit)) {
                    toFactor = factors[i];
                }
            }

            return (value * fromFactor) / toFactor;
        }
    }
}