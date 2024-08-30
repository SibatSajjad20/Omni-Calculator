import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DecimalToFractionCalculator extends JPanel {
    private JTextField decimalField;
    private JLabel resultLabel;

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public DecimalToFractionCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // Add a heading
        JLabel heading = new JLabel("Decimal to Fraction Calculator");
        heading.setFont(new Font("Poppins", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        add(inputPanel, BorderLayout.CENTER);

        inputPanel.add(new JLabel("Decimal:"));
        decimalField = new JTextField(10);
        inputPanel.add(decimalField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        add(buttonPanel, BorderLayout.SOUTH);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        resultLabel = new JLabel("Fraction: ");
        buttonPanel.add(resultLabel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double decimal = Double.parseDouble(decimalField.getText());
                int precision = 1000000;
                int gcd = gcd((int) (decimal * precision), precision);
                int num = (int) (decimal * precision) / gcd;
                int den = precision / gcd;
                resultLabel.setText(String.format("Fraction: %d/%d", num, den));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number.");
            }
        }
    }
}