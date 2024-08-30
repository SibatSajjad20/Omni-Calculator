import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

class StandardDeviationCalculator extends JPanel {
    private JTextField field1;
    private JLabel resultLabel;

    public StandardDeviationCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Standard Deviation Calculator**
        JLabel calculatorLabel = new JLabel("Standard Deviation Calculator");
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
        field1 = new JTextField(20);
        field1.setFont(textFieldFont);
        numbersPanel.add(numbersLabel);
        numbersPanel.add(field1);
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

        resultLabel = new JLabel("Standard Deviation: ");
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
                double[] numbers = Arrays.stream(field1.getText().split(",")).mapToDouble(Double::parseDouble).toArray();
                double mean = Arrays.stream(numbers).average().orElse(0);
                double variance = Arrays.stream(numbers).map(x -> Math.pow(x - mean, 2)).average().orElse(0);
                double result = Math.sqrt(variance);
                resultLabel.setText(String.format("Standard Deviation: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}