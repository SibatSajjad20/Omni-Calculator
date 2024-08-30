import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DividingFractionsCalculator extends JPanel {
    private JTextField num1Field;
    private JTextField den1Field;
    private JTextField num2Field;
    private JTextField den2Field;
    private JLabel resultLabel;

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public DividingFractionsCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // Add a heading
        JLabel heading = new JLabel("Dividing Fractions Calculator");
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        add(inputPanel, BorderLayout.CENTER);

        JPanel fraction1Panel = new JPanel();
        fraction1Panel.setLayout(new BoxLayout(fraction1Panel, BoxLayout.X_AXIS));
        fraction1Panel.add(new JLabel("Fraction 1:"));
        JPanel num1Panel = new JPanel();
        num1Panel.setLayout(new BoxLayout(num1Panel, BoxLayout.X_AXIS));
        num1Panel.add(new JLabel("Numerator:"));
        num1Field = new JTextField(5);
        num1Panel.add(num1Field);
        fraction1Panel.add(num1Panel);
        JPanel den1Panel = new JPanel();
        den1Panel.setLayout(new BoxLayout(den1Panel, BoxLayout.X_AXIS));
        den1Panel.add(new JLabel("Denominator:"));
        den1Field = new JTextField(5);
        den1Panel.add(den1Field);
        fraction1Panel.add(den1Panel);
        inputPanel.add(fraction1Panel);

        JPanel fraction2Panel = new JPanel();
        fraction2Panel.setLayout(new BoxLayout(fraction2Panel, BoxLayout.X_AXIS));
        fraction2Panel.add(new JLabel("Fraction 2:"));
        JPanel num2Panel = new JPanel();
        num2Panel.setLayout(new BoxLayout(num2Panel, BoxLayout.X_AXIS));
        num2Panel.add(new JLabel("Numerator:"));
        num2Field = new JTextField(5);
        num2Panel.add(num2Field);
        fraction2Panel.add(num2Panel);
        JPanel den2Panel = new JPanel();
        den2Panel.setLayout(new BoxLayout(den2Panel, BoxLayout.X_AXIS));
        den2Panel.add(new JLabel("Denominator:"));
        den2Field = new JTextField(5);
        den2Panel.add(den2Field);
        fraction2Panel.add(den2Panel);
        inputPanel.add(fraction2Panel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        add(buttonPanel, BorderLayout.SOUTH);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        resultLabel = new JLabel("Result: ");
        buttonPanel.add(resultLabel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int num1 = Integer.parseInt(num1Field.getText());
                int den1 = Integer.parseInt(den1Field.getText());
                int num2 = Integer.parseInt(num2Field.getText());
                int den2 = Integer.parseInt(den2Field.getText());
                int resultNum = num1 * den2;
                int resultDen = den1 * num2;
                int gcd = gcd(resultNum, resultDen);
                int[] result = {resultNum / gcd, resultDen / gcd};
                resultLabel.setText(String.format("Result: %d/%d", result[0], result[1]));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}