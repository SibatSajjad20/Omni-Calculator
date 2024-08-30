import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CoinFlipProbabilityCalculator extends JPanel {
    private JTextField flipsField;
    private JTextField desiredHeadsField;
    private JLabel resultLabel;

    public CoinFlipProbabilityCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // Add a heading
        JLabel heading = new JLabel("Coin Flip Probability Calculator");
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        add(inputPanel, BorderLayout.CENTER);

        inputPanel.add(new JLabel("Number of Flips:"));
        flipsField = new JTextField(10);
        inputPanel.add(flipsField);

        inputPanel.add(new JLabel("Desired Number of Heads:"));
        desiredHeadsField = new JTextField(10);
        inputPanel.add(desiredHeadsField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        add(buttonPanel, BorderLayout.SOUTH);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        resultLabel = new JLabel("Probability: ");
        buttonPanel.add(resultLabel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int flips = Integer.parseInt(flipsField.getText());
                int desiredHeads = Integer.parseInt(desiredHeadsField.getText());
                double result = binomialProbability(flips, desiredHeads, 0.5);
                resultLabel.setText(String.format("Probability: %.6f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }

    private double binomialProbability(int n, int k, double p) {
        return binomialCoefficient(n, k) * Math.pow(p, k) * Math.pow(1 - p, n - k);
    }

    private double binomialCoefficient(int n, int k) {
        if (k > n) return 0;
        if (k == 0 || k == n) return 1;
        double coefficient = 1;
        for (int i = 1; i <= k; i++) {
            coefficient *= (n - (k - i));
            coefficient /= i;
        }
        return coefficient;
    }
}