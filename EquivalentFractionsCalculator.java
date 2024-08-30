import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EquivalentFractionsCalculator extends JPanel {
    private JTextField numeratorField;
    private JTextField denominatorField;
    private JTextField factorField;
    private JLabel resultLabel;

    public EquivalentFractionsCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing
        JLabel heading = new JLabel("Equivalent Fractions Converter");
        heading.setFont(new Font("Poppins", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        add(inputPanel, BorderLayout.CENTER);

        JPanel numeratorPanel = new JPanel();
        numeratorPanel.setLayout(new BoxLayout(numeratorPanel, BoxLayout.X_AXIS));
        numeratorPanel.add(new JLabel("Numerator:"));
        numeratorField = new JTextField(10);
        numeratorPanel.add(numeratorField);
        inputPanel.add(numeratorPanel);

        JPanel denominatorPanel = new JPanel();
        denominatorPanel.setLayout(new BoxLayout(denominatorPanel, BoxLayout.X_AXIS));
        denominatorPanel.add(new JLabel("Denominator:"));
        denominatorField = new JTextField(10);
        denominatorPanel.add(denominatorField);
        inputPanel.add(denominatorPanel);

        JPanel factorPanel = new JPanel();
        factorPanel.setLayout(new BoxLayout(factorPanel, BoxLayout.X_AXIS));
        factorPanel.add(new JLabel("Factor:"));
        factorField = new JTextField(10);
        factorPanel.add(factorField);
        inputPanel.add(factorPanel);

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
                int numerator = Integer.parseInt(numeratorField.getText());
                int denominator = Integer.parseInt(denominatorField.getText());
                int factor = Integer.parseInt(factorField.getText());
                int resultNumerator = numerator * factor;
                int resultDenominator = denominator * factor;
                resultLabel.setText(String.format("Result: %d/%d", resultNumerator, resultDenominator));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}