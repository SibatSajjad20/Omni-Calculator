import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

class NumberSummaryCalculator extends JPanel {
    private JTextField numbersField;
    private JLabel resultLabel;

    public NumberSummaryCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Number Summary Calculator**
        JLabel calculatorLabel = new JLabel("Number Summary Calculator");
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

        resultLabel = new JLabel("Number Summary: ");
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
                String[] numbers = numbersField.getText().split(",");
                double[] doubleNumbers = Arrays.stream(numbers).mapToDouble(Double::parseDouble).toArray();
                double sum = Arrays.stream(doubleNumbers).sum();
                double mean = sum / doubleNumbers.length;
                double variance = Arrays.stream(doubleNumbers).map(x -> Math.pow(x - mean, 2)).sum() / doubleNumbers.length;
                double standardDeviation = Math.sqrt(variance);
                resultLabel.setText(String.format("Number Summary: Sum = %.2f, Mean = %.2f, Variance = %.2f, Standard Deviation = %.2f", sum, mean, variance, standardDeviation));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}