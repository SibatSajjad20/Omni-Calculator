import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AddingFractionsCalculator extends JPanel {
    private JTextField numerator1Field;
    private JTextField denominator1Field;
    private JTextField numerator2Field;
    private JTextField denominator2Field;
    private JLabel resultLabel;

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public AddingFractionsCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add heading
        JLabel heading = new JLabel("Adding Fractions Calculator");
        heading.setFont(new Font("Poppins", Font.BOLD, 24));
        add(heading, BorderLayout.NORTH);

        // Create input panel with grid layout
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        inputPanel.add(new JLabel("Numerator 1:"));
        numerator1Field = new JTextField();
        inputPanel.add(numerator1Field);

        inputPanel.add(new JLabel("Denominator 1:"));
        denominator1Field = new JTextField();
        inputPanel.add(denominator1Field);

        inputPanel.add(new JLabel("Numerator 2:"));
        numerator2Field = new JTextField();
        inputPanel.add(numerator2Field);

        inputPanel.add(new JLabel("Denominator 2:"));
        denominator2Field = new JTextField();
        inputPanel.add(denominator2Field);

        add(inputPanel, BorderLayout.CENTER);

        // Create button panel with flow layout
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        resultLabel = new JLabel("Result: ");
        buttonPanel.add(resultLabel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Set font and style for labels and buttons
        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font buttonFont = new Font("Poppins", Font.BOLD, 18);

        for (Component component : inputPanel.getComponents()) {
            if (component instanceof JTextField) {
                ((JTextField) component).setFont(labelFont);
            }
        }

        for (Component component : buttonPanel.getComponents()) {
            if (component instanceof JButton) {
                ((JButton) component).setFont(buttonFont);
            } else if (component instanceof JLabel) {
                ((JLabel) component).setFont(labelFont);
            }
        }
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int numerator1 = Integer.parseInt(numerator1Field.getText());
                int denominator1 = Integer.parseInt(denominator1Field.getText());
                int numerator2 = Integer.parseInt(numerator2Field.getText());
                int denominator2 = Integer.parseInt(denominator2Field.getText());

                int resultNumerator = numerator1 * denominator2 + numerator2 * denominator1;
                int resultDenominator = denominator1 * denominator2;
                int gcd = gcd(resultNumerator, resultDenominator);

                resultLabel.setText(String.format("Result: %d/%d", resultNumerator / gcd, resultDenominator / gcd));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}