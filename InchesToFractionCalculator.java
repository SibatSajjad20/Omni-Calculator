import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class InchesToFractionCalculator extends JPanel {
    private JTextField inchesField;
    private JLabel resultLabel;

    public InchesToFractionCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Inches to Fraction Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel inchesPanel = new JPanel();
        inchesPanel.setLayout(new BoxLayout(inchesPanel, BoxLayout.X_AXIS));
        inchesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel inchesLabel = new JLabel("Decimal inches: ");
        inchesLabel.setFont(labelFont);
        inchesField = new JTextField(10);
        inchesField.setFont(textFieldFont);
        inchesPanel.add(inchesLabel);
        inchesPanel.add(inchesField);
        inputPanel.add(inchesPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(buttonPanel, BorderLayout.SOUTH);

        JButton calculateButton = new JButton("Convert");
        calculateButton.setFont(textFieldFont);
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        buttonPanel.add(Box.createHorizontalGlue());

        resultLabel = new JLabel("Fraction: ");
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
                double inches = Double.parseDouble(inchesField.getText());
                String fraction = decimalToFraction(inches);
                resultLabel.setText(String.format("Fraction: %s", fraction));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number.");
            }
        }

        private String decimalToFraction(double decimal) {
            int wholePart = (int) decimal;
            double fractionalPart = decimal - wholePart;
            
            if (fractionalPart == 0) {
                return wholePart + "";
            }

            int numerator = (int) Math.round(fractionalPart * 16);
            int denominator = 16;
            int gcd = gcd(numerator, denominator);
            
            numerator /= gcd;
            denominator /= gcd;

            if (wholePart == 0) {
                return numerator + "/" + denominator;
            } else {
                return wholePart + " " + numerator + "/" + denominator;
            }
        }

        private int gcd(int a, int b) {
            if (b == 0) return a;
            return gcd(b, a % b);
        }
    }
}