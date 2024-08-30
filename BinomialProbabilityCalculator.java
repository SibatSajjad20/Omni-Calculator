import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BinomialProbabilityCalculator extends JPanel {
    private JTextField trialsField;
    private JTextField successesField;
    private JTextField probabilityField;
    private JLabel resultLabel;

    public BinomialProbabilityCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // **Binomial Probability Calculator**
        JLabel calculatorLabel = new JLabel("Binomial Probability Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel trialsPanel = new JPanel();
        trialsPanel.setLayout(new BoxLayout(trialsPanel, BoxLayout.X_AXIS));
        trialsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel trialsLabel = new JLabel("N (trials): ");
        trialsLabel.setFont(labelFont);
        trialsField = new JTextField(10);
        trialsField.setFont(textFieldFont);
        trialsPanel.add(trialsLabel);
        trialsPanel.add(trialsField);
        inputPanel.add(trialsPanel);

        JPanel successesPanel = new JPanel();
        successesPanel.setLayout(new BoxLayout(successesPanel, BoxLayout.X_AXIS));
        successesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel successesLabel = new JLabel("K (successes): ");
        successesLabel.setFont(labelFont);
        successesField = new JTextField(10);
        successesField.setFont(textFieldFont);
        successesPanel.add(successesLabel);
        successesPanel.add(successesField);
        inputPanel.add(successesPanel);

        JPanel probabilityPanel = new JPanel();
        probabilityPanel.setLayout(new BoxLayout(probabilityPanel, BoxLayout.X_AXIS));
        probabilityPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel probabilityLabel = new JLabel("P (probability): ");
        probabilityLabel.setFont(labelFont);
        probabilityField = new JTextField(10);
        probabilityField.setFont(textFieldFont);
        probabilityPanel.add(probabilityLabel);
        probabilityPanel.add(probabilityField);
        inputPanel.add(probabilityPanel);

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

        resultLabel = new JLabel("Binomial Probability: ");
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
                int n = Integer.parseInt(trialsField.getText());
                int k = Integer.parseInt(successesField.getText());
                double p = Double.parseDouble(probabilityField.getText());

                if (n < 0 || k < 0 || p < 0 || p > 1) {
                    resultLabel.setText("Invalid input values. Please enter valid numbers.");
                    return;
                }

                double result = MathUtils.binomialCoefficient(n, k) * Math.pow(p, k) * Math.pow(1 - p, n - k);
                resultLabel.setText(String.format("Binomial Probability: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}

class MathUtils {
    public static long binomialCoefficient(int n, int k) {
        if (k > n - k) k = n - k;
        long b = 1;
        for (int i = 1, m = n; i <= k; i++, m--) 
            b = b * m / i;
        return b;
    }
}