import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PermutationCalculator extends JPanel {
    private JTextField nField;
    private JTextField rField;
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

    public PermutationCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Permutation Calculator**
        JLabel calculatorLabel = new JLabel("Permutation Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel nPanel = new JPanel();
        nPanel.setLayout(new BoxLayout(nPanel, BoxLayout.X_AXIS));
        nPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel nLabel = new JLabel("N: ");
        nLabel.setFont(labelFont);
        nField = new JTextField(10);
        nField.setFont(textFieldFont);
        nPanel.add(nLabel);
        nPanel.add(nField);
        inputPanel.add(nPanel);

        JPanel rPanel = new JPanel();
        rPanel.setLayout(new BoxLayout(rPanel, BoxLayout.X_AXIS));
        rPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel rLabel = new JLabel("R: ");
        rLabel.setFont(labelFont);
        rField = new JTextField(10);
        rField.setFont(textFieldFont);
        rPanel.add(rLabel);
        rPanel.add(rField);
        inputPanel.add(rPanel);

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
                int n = Integer.parseInt(nField.getText());
                int r = Integer.parseInt(rField.getText());
                long result = factorial(n) / factorial(n - r); // Permutations (nPr)

                resultLabel.setText(String.format("Result: %,d", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}