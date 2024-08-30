import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

class MedianCalculator extends JPanel {
    private JTextField numbersField;
    private JLabel resultLabel;

    public MedianCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Median Calculator**
        JLabel calculatorLabel = new JLabel("Median Calculator");
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

        resultLabel = new JLabel("Median: ");
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
                double[] doubleNumbers = Arrays.stream(numbers).mapToDouble(Double::parseDouble).sorted().toArray();
                double result;
                if (doubleNumbers.length % 2 == 0) {
                    result = (doubleNumbers[doubleNumbers.length/2 - 1] + doubleNumbers[doubleNumbers.length/2]) / 2;
                } else {
                    result = doubleNumbers[doubleNumbers.length/2];
                }
                resultLabel.setText(String.format("Median: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}