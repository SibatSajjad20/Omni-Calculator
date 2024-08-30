import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PoissonDistributionCalculator extends JPanel {
    private JTextField lambdaField;
    private JTextField kField;
    private JLabel resultLabel;

    private long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public PoissonDistributionCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Poisson Distribution Calculator**
        JLabel calculatorLabel = new JLabel("Poisson Distribution Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel lambdaPanel = new JPanel();
        lambdaPanel.setLayout(new BoxLayout(lambdaPanel, BoxLayout.X_AXIS));
        lambdaPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel lambdaLabel = new JLabel("λ (lambda): ");
        lambdaLabel.setFont(labelFont);
        lambdaField = new JTextField(10);
        lambdaField.setFont(textFieldFont);
        lambdaPanel.add(lambdaLabel);
        lambdaPanel.add(lambdaField);
        inputPanel.add(lambdaPanel);

        JPanel kPanel = new JPanel();
        kPanel.setLayout(new BoxLayout(kPanel, BoxLayout.X_AXIS));
        kPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel kLabel = new JLabel("k: ");
        kLabel.setFont(labelFont);
        kField = new JTextField(10);
        kField.setFont(textFieldFont);
        kPanel.add(kLabel);
        kPanel.add(kField);
        inputPanel.add(kPanel);

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

        resultLabel = new JLabel("Poisson probability: ");
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
                double lambda = Double.parseDouble(lambdaField.getText());
                int k = Integer.parseInt(kField.getText());
                double result = (Math.pow(lambda, k) * Math.exp(-lambda)) / factorial(k);
                resultLabel.setText(String.format("Poisson probability: %.4f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}