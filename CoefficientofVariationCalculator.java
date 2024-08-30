import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

class CoefficientofVariationCalculator extends JPanel {
    private JTextField numbersField;
    private JLabel resultLabel;

    public CoefficientofVariationCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // **Coefficient of Variation Calculator**
        JLabel calculatorLabel = new JLabel("Coefficient of Variation Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel numbersPanel = new JPanel();
        numbersPanel.setLayout(new BoxLayout(numbersPanel, BoxLayout.X_AXIS));
        numbersPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel numbersLabel = new JLabel("Numbers (comma separated): ");
        numbersLabel.setFont(labelFont);
        numbersField = new JTextField(20);
        numbersField.setFont(textFieldFont);
        numbersPanel.add(numbersLabel);
        numbersPanel.add(numbersField);
        inputPanel.add(numbersPanel);

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

        resultLabel = new JLabel("Coefficient of Variation: ");
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
                String input = numbersField.getText();
                if (input.isEmpty()) {
                    resultLabel.setText("Please enter some numbers.");
                    return;
                }

                String[] numbers = input.split(",");
                if (numbers.length == 1) {
                    resultLabel.setText("Please enter more than one number.");
                    return;
                }

                double[] doubleNumbers = Arrays.stream(numbers).mapToDouble(Double::parseDouble).toArray();
                double mean = calculateMean(doubleNumbers);
                double standardDeviation = calculateStandardDeviation(doubleNumbers, mean);
                double result = calculateCoefficientOfVariation(standardDeviation, mean);
                resultLabel.setText(String.format("Coefficient of Variation: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }

        private double calculateMean(double[] numbers) {
            return Arrays.stream(numbers).average().orElse(0);
        }

        private double calculateStandardDeviation(double[] numbers, double mean) {
            return Math.sqrt(Arrays.stream(numbers).map(x -> Math.pow(x - mean, 2)).sum() / numbers.length);
        }

        private double calculateCoefficientOfVariation(double standardDeviation, double mean) {
            return (standardDeviation / mean) * 100;
        }
    }
}