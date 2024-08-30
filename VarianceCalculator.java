import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

class VarianceCalculator extends JPanel {
    private JTextField field1;
    private JLabel resultLabel;

    public VarianceCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Variance Calculator**
        JLabel calculatorLabel = new JLabel("Variance Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel valuesPanel = new JPanel();
        valuesPanel.setLayout(new BoxLayout(valuesPanel, BoxLayout.X_AXIS));
        valuesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel valuesLabel = new JLabel("Values (comma separated): ");
        valuesLabel.setFont(labelFont);
        field1 = new JTextField(20);
        field1.setFont(textFieldFont);
        valuesPanel.add(valuesLabel);
        valuesPanel.add(field1);
        inputPanel.add(valuesPanel);

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
                String[] values = field1.getText().split(",");
                double[] data = Arrays.stream(values).mapToDouble(Double::parseDouble).toArray();
                double mean = Arrays.stream(data).average().orElse(0.0);
                double sumSquaredDiffs = Arrays.stream(data).map(val -> Math.pow(val - mean, 2)).sum();
                double result = sumSquaredDiffs / data.length;

                resultLabel.setText(String.format("Result: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}