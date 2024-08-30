import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.stream.IntStream;

class CorrelationCoefficientCalculator extends JPanel {
    private JTextField xField;
    private JTextField yField;
    private JLabel resultLabel;

    public CorrelationCoefficientCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // **Correlation Coefficient Calculator**
        JLabel calculatorLabel = new JLabel("Correlation Coefficient Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel xPanel = new JPanel();
        xPanel.setLayout(new BoxLayout(xPanel, BoxLayout.X_AXIS));
        xPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel xLabel = new JLabel("X: ");
        xLabel.setFont(labelFont);
        xField = new JTextField(20);
        xField.setFont(textFieldFont);
        xPanel.add(xLabel);
        xPanel.add(xField);
        inputPanel.add(xPanel);

        JPanel yPanel = new JPanel();
        yPanel.setLayout(new BoxLayout(yPanel, BoxLayout.X_AXIS));
        yPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel yLabel = new JLabel("Y: ");
        yLabel.setFont(labelFont);
        yField = new JTextField(20);
        yField.setFont(textFieldFont);
        yPanel.add(yLabel);
        yPanel.add(yField);
        inputPanel.add(yPanel);

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

        resultLabel = new JLabel("Correlation Coefficient: ");
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
                double[] x = Arrays.stream(xField.getText().split(",")).mapToDouble(Double::parseDouble).toArray();
                double[] y = Arrays.stream(yField.getText().split(",")).mapToDouble(Double::parseDouble).toArray();
                double xMean = Arrays.stream(x).average().orElse(0);
                double yMean = Arrays.stream(y).average().orElse(0);
                double numerator = IntStream.range(0, x.length).mapToDouble(i -> (x[i] - xMean) * (y[i] - yMean)).sum();
                double denominatorX = Arrays.stream(x).map(xi -> Math.pow(xi - xMean, 2)).sum();
                double denominatorY = Arrays.stream(y).map(yi -> Math.pow(yi - yMean, 2)).sum();
                double result = numerator / Math.sqrt(denominatorX * denominatorY);
                resultLabel.setText(String.format("Correlation Coefficient: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}