import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ExponentialSmoothingCalculator extends JPanel {
    private JTextField fieldValue;
    private JTextField alphaValue;
    private JLabel resultLabel;

    public ExponentialSmoothingCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // **Exponential Smoothing Calculator**
        JLabel calculatorLabel = new JLabel("Exponential Smoothing Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel fieldValuePanel = new JPanel();
        fieldValuePanel.setLayout(new BoxLayout(fieldValuePanel, BoxLayout.X_AXIS));
        fieldValuePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel fieldValueLabel = new JLabel("Field Value: ");
        fieldValueLabel.setFont(labelFont);
        fieldValue = new JTextField(10);
        fieldValue.setFont(textFieldFont);
        fieldValuePanel.add(fieldValueLabel);
        fieldValuePanel.add(fieldValue);
        inputPanel.add(fieldValuePanel);

        JPanel alphaValuePanel = new JPanel();
        alphaValuePanel.setLayout(new BoxLayout(alphaValuePanel, BoxLayout.X_AXIS));
        alphaValuePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel alphaValueLabel = new JLabel("Alpha Value: ");
        alphaValueLabel.setFont(labelFont);
        alphaValue = new JTextField(10);
        alphaValue.setFont(textFieldFont);
        alphaValuePanel.add(alphaValueLabel);
        alphaValuePanel.add(alphaValue);
        inputPanel.add(alphaValuePanel);

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
                double fieldValue = Double.parseDouble(ExponentialSmoothingCalculator.this.fieldValue.getText());
                double alphaValue = Double.parseDouble(ExponentialSmoothingCalculator.this.alphaValue.getText());
                double result = fieldValue * alphaValue;
                resultLabel.setText(String.format("Result: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}