import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

class CovarianceCalculator extends JPanel {
    private JTextField xValuesField;
    private JTextField yValuesField;
    private JLabel resultLabel;

    public CovarianceCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // **Covariance Calculator**
        JLabel calculatorLabel = new JLabel("Covariance Calculator");
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
        JLabel xValuesLabel = new JLabel("X Values (comma separated): ");
        xValuesLabel.setFont(labelFont);
        xValuesField = new JTextField(20);
        xValuesField.setFont(textFieldFont);
        xValuesPanel.add(xValuesLabel);
        xValuesPanel.add(xValuesField);
        inputPanel.add(xValuesPanel);

        JPanel yValuesPanel = new JPanel();
        yValuesPanel.setLayout(new BoxLayout(yValuesPanel, BoxLayout.X_AXIS));
        yValuesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel yValuesLabel = new JLabel("Y Values (comma separated): ");
        yValuesLabel.setFont(labelFont);
        yValuesField = new JTextField(20);
        yValuesField.setFont(textFieldFont);
        yValuesPanel.add(yValuesLabel);
        yValuesPanel.add(yValuesField);
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
                String xValuesString = xValuesField.getText();
                String yValuesString = yValuesField.getText();
                if (xValuesString.isEmpty() || yValuesString.isEmpty()) {
                    resultLabel.setText("Please enter valid values.");
                    return;
                }

                String[] xValuesArray = xValuesString.split(",");
                String[] yValuesArray = yValuesString.split(",");
                if (xValuesArray.length != yValuesArray.length) {
                    resultLabel.setText("Please enter the same number of values for X and Y.");
                    return;
                }

                double[] xValues = Arrays.stream(xValuesArray).mapToDouble(Double::parseDouble).toArray();
                double[] yValues = Arrays.stream(yValuesArray).mapToDouble(Double::parseDouble).toArray();

                double xMean = Arrays.stream(xValues).average().orElse(0.0);
                double yMean = Arrays.stream(yValues).average().orElse(0.0);

                // Calculate covariance
                double covariance = 0;
                for (int i = 0; i < xValues.length; i++) {
                    covariance += (xValues[i] - xMean) * (yValues[i] - yMean);
                }
                covariance /= xValues.length;

                resultLabel.setText(String.format("Result: %.2f", covariance));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}