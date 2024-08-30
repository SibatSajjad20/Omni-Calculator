import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class FractionExponentCalculator extends JPanel {
    private JTextField numeratorField;
    private JTextField denominatorField;
    private JTextField exponentField;
    private JLabel resultLabel;

    Font poppinsFont = new Font("Poppins", Font.PLAIN, 18);

    public FractionExponentCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Fraction Exponent Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        JPanel numeratorPanel = new JPanel();
        numeratorPanel.setLayout(new BoxLayout(numeratorPanel, BoxLayout.X_AXIS));
        numeratorPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel numeratorLabel = new JLabel("Numerator: ");
        numeratorLabel.setFont(poppinsFont);
        numeratorField = new JTextField(10);
        numeratorField.setFont(poppinsFont);
        numeratorPanel.add(numeratorLabel);
        numeratorPanel.add(numeratorField);
        inputPanel.add(numeratorPanel);

        JPanel denominatorPanel = new JPanel();
        denominatorPanel.setLayout(new BoxLayout(denominatorPanel, BoxLayout.X_AXIS));
        denominatorPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel denominatorLabel = new JLabel("Denominator: ");
        denominatorLabel.setFont(poppinsFont);
        denominatorField = new JTextField(10);
        denominatorField.setFont(poppinsFont);
        denominatorPanel.add(denominatorLabel);
        denominatorPanel.add(denominatorField);
        inputPanel.add(denominatorPanel);

        JPanel exponentPanel = new JPanel();
        exponentPanel.setLayout(new BoxLayout(exponentPanel, BoxLayout.X_AXIS));
        exponentPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel exponentLabel = new JLabel("Exponent: ");
        exponentLabel.setFont(poppinsFont);
        exponentField = new JTextField(10);
        exponentField.setFont(poppinsFont);
        exponentPanel.add(exponentLabel);
        exponentPanel.add(exponentField);
        inputPanel.add(exponentPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(buttonPanel, BorderLayout.SOUTH);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.setFont(poppinsFont);
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        buttonPanel.add(Box.createHorizontalGlue());

        resultLabel = new JLabel("Result: ");
        resultLabel.setFont(poppinsFont);
        buttonPanel.add(resultLabel);

        buttonPanel.add(Box.createHorizontalGlue());

        JButton backButton = new JButton("Back");
        backButton.setFont(poppinsFont);
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int numerator = Integer.parseInt(numeratorField.getText());
                int denominator = Integer.parseInt(denominatorField.getText());
                int exponent = Integer.parseInt(exponentField.getText());
                if (denominator == 0) {
                    resultLabel.setText("Denominator cannot be zero.");
                } else {
                    double result = Math.pow((double) numerator / denominator, exponent);
                    resultLabel.setText(String.format("Fraction Exponent: %.2f", result));
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}