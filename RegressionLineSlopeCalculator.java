import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.stream.IntStream;

class RegressionLineSlopeCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JLabel resultLabel;

    public RegressionLineSlopeCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Regression Line Slope Calculator**
        JLabel calculatorLabel = new JLabel("Regression Line Slope Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel xValuesPanel = new JPanel();
        xValuesPanel.setLayout(new BoxLayout(xValuesPanel, BoxLayout.X_AXIS));
        xValuesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel xValuesLabel = new JLabel("Values of X (comma separated): ");
        xValuesLabel.setFont(labelFont);
        field1 = new JTextField(20);
        field1.setFont(textFieldFont);
        xValuesPanel.add(xValuesLabel);
        xValuesPanel.add(field1);
        inputPanel.add(xValuesPanel);

        JPanel yValuesPanel = new JPanel();
        yValuesPanel.setLayout(new BoxLayout(yValuesPanel, BoxLayout.X_AXIS));
        yValuesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel yValuesLabel = new JLabel("Values of Y (comma separated): ");
        yValuesLabel.setFont(labelFont);
        field2 = new JTextField(20);
        field2.setFont(textFieldFont);
        yValuesPanel.add(yValuesLabel);
        yValuesPanel.add(field2);
        inputPanel.add(yValuesPanel);

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
                String[] xValues = field1.getText().split(",");
                String[] yValues = field2.getText().split(",");
                double[] x = Arrays.stream(xValues).mapToDouble(Double::parseDouble).toArray();
                double[] y = Arrays.stream(yValues).mapToDouble(Double::parseDouble).toArray();
                double meanX = Arrays.stream(x).average().orElse(0.0);
                double meanY = Arrays.stream(y).average().orElse(0.0);
                double numerator = IntStream.range(0, x.length).mapToDouble(i -> (x[i] - meanX) * (y[i] - meanY)).sum();
                double denominator = Arrays.stream(x).map(val -> Math.pow(val - meanX, 2)).sum();
                double result = numerator / denominator; 

                resultLabel.setText(String.format("Result: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}