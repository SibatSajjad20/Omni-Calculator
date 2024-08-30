import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ConfidenceIntervalCalculator extends JPanel {
    private JTextField meanField;
    private JTextField stdDevField;
    private JTextField sampleSizeField;
    private JTextField confidenceLevelField;
    private JLabel resultLabel;

    private static double getZScore(double confidenceLevel) {
        // This is a simplified approach. In a real application, you'd use a more comprehensive method.
        if (confidenceLevel == 0.90) return 1.645;
        if (confidenceLevel == 0.95) return 1.96;
        if (confidenceLevel == 0.99) return 2.576;
        return 0; // Default case
    }

    public ConfidenceIntervalCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // **Confidence Interval Calculator**
        JLabel calculatorLabel = new JLabel("Confidence Interval Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel meanPanel = new JPanel();
        meanPanel.setLayout(new BoxLayout(meanPanel, BoxLayout.X_AXIS));
        meanPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel meanLabel = new JLabel("Mean: ");
        meanLabel.setFont(labelFont);
        meanField = new JTextField(10);
        meanField.setFont(textFieldFont);
        meanPanel.add(meanLabel);
        meanPanel.add(meanField);
        inputPanel.add(meanPanel);

        JPanel stdDevPanel = new JPanel();
        stdDevPanel.setLayout(new BoxLayout(stdDevPanel, BoxLayout.X_AXIS));
        stdDevPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel stdDevLabel = new JLabel("Standard Deviation: ");
        stdDevLabel.setFont(labelFont);
        stdDevField = new JTextField(10);
        stdDevField.setFont(textFieldFont);
        stdDevPanel.add(stdDevLabel);
        stdDevPanel.add(stdDevField);
        inputPanel.add(stdDevPanel);

        JPanel sampleSizePanel = new JPanel();
        sampleSizePanel.setLayout(new BoxLayout(sampleSizePanel, BoxLayout.X_AXIS));
        sampleSizePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel sampleSizeLabel = new JLabel("Sample Size: ");
        sampleSizeLabel.setFont(labelFont);
        sampleSizeField = new JTextField(10);
        sampleSizeField.setFont(textFieldFont);
        sampleSizePanel.add(sampleSizeLabel);
        sampleSizePanel.add(sampleSizeField);
        inputPanel.add(sampleSizePanel);

        JPanel confidenceLevelPanel = new JPanel();
        confidenceLevelPanel.setLayout(new BoxLayout(confidenceLevelPanel, BoxLayout.X_AXIS));
        confidenceLevelPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel confidenceLevelLabel = new JLabel("Confidence Level: ");
        confidenceLevelLabel.setFont(labelFont);
        confidenceLevelField = new JTextField(10);
        confidenceLevelField.setFont(textFieldFont);
        confidenceLevelPanel.add(confidenceLevelLabel);
        confidenceLevelPanel.add(confidenceLevelField);
        inputPanel.add(confidenceLevelPanel);

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

        resultLabel = new JLabel("Confidence Interval: ");
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
                double mean = Double.parseDouble(meanField.getText());
                double stdDev = Double.parseDouble(stdDevField.getText());
                int sampleSize = Integer.parseInt(sampleSizeField.getText());
                double confidenceLevel = Double.parseDouble(confidenceLevelField.getText());
                double zScore = getZScore(confidenceLevel);
               
                double marginOfError = zScore * (stdDev / Math.sqrt(sampleSize));
                double lowerBound = mean - marginOfError;
                double upperBound = mean + marginOfError;
                resultLabel.setText(String.format("Confidence Interval: [%.2f, %.2f]", lowerBound, upperBound));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}