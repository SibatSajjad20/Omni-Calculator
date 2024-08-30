import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class FractionsCalculator extends JPanel {
    private JTextField numeratorField1;
    private JTextField denominatorField1;
    private JTextField numeratorField2;
    private JTextField denominatorField2;
    private JLabel resultLabel;

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public FractionsCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Fractions Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel fraction1Panel = new JPanel();
        fraction1Panel.setLayout(new BoxLayout(fraction1Panel, BoxLayout.X_AXIS));
        fraction1Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel numeratorLabel1 = new JLabel("Numerator 1: ");
        numeratorLabel1.setFont(labelFont);
        numeratorField1 = new JTextField(10);
        numeratorField1.setFont(textFieldFont);
        fraction1Panel.add(numeratorLabel1);
        fraction1Panel.add(numeratorField1);

        JLabel denominatorLabel1 = new JLabel("Denominator 1: ");
        denominatorLabel1.setFont(labelFont);
        denominatorField1 = new JTextField(10);
        denominatorField1.setFont(textFieldFont);
        fraction1Panel.add(denominatorLabel1);
        fraction1Panel.add(denominatorField1);
        inputPanel.add(fraction1Panel);

        JPanel fraction2Panel = new JPanel();
        fraction2Panel.setLayout(new BoxLayout(fraction2Panel, BoxLayout.X_AXIS));
        fraction2Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel numeratorLabel2 = new JLabel("Numerator 2: ");
        numeratorLabel2.setFont(labelFont);
        numeratorField2 = new JTextField(10);
        numeratorField2.setFont(textFieldFont);
        fraction2Panel.add(numeratorLabel2);
        fraction2Panel.add(numeratorField2);

        JLabel denominatorLabel2 = new JLabel("Denominator 2: ");
        denominatorLabel2.setFont(labelFont);
        denominatorField2 = new JTextField(10);
        denominatorField2.setFont(textFieldFont);
        fraction2Panel.add(denominatorLabel2);
        fraction2Panel.add(denominatorField2);
        inputPanel.add(fraction2Panel);

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
                int num1 = Integer.parseInt(numeratorField1.getText());
                int den1 = Integer.parseInt(denominatorField1.getText());
                int num2 = Integer.parseInt(numeratorField2.getText());
                int den2 = Integer.parseInt(denominatorField2.getText());
                int resultNum = num1 * den2 + num2 * den1;
                int resultDen = den1 * den2;
                int gcd = gcd(resultNum, resultDen);
                int[] result = {resultNum / gcd, resultDen / gcd};
                resultLabel.setText(String.format("Fractions: %d/%d", result[0], result[1]));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}