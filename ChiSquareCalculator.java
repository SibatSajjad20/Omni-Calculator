import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

class ChiSquareCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JLabel resultLabel;

    public ChiSquareCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);
        JLabel calculatorLabel = new JLabel("Chi Square Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);
        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel observedPanel = new JPanel();
        observedPanel.setLayout(new BoxLayout(observedPanel, BoxLayout.X_AXIS));
        observedPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel observedLabel = new JLabel("Observed: ");
        observedLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        observedPanel.add(observedLabel);
        observedPanel.add(field1);
        inputPanel.add(observedPanel);

        JPanel expectedPanel = new JPanel();
        expectedPanel.setLayout(new BoxLayout(expectedPanel, BoxLayout.X_AXIS));
        expectedPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel expectedLabel = new JLabel("Expected: ");
        expectedLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        expectedPanel.add(expectedLabel);
        expectedPanel.add(field2);
        inputPanel.add(expectedPanel);

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

        resultLabel = new JLabel("Chi Square: ");
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
                double[] observed = Arrays.stream(field1.getText().split(",")).mapToDouble(Double::parseDouble).toArray();
                double[] expected = Arrays.stream(field2.getText().split(",")).mapToDouble(Double::parseDouble).toArray();
                if (observed.length != expected.length) {
                    resultLabel.setText("The number of observed and expected values must be the same.");
                    return;
                }
                double result = 0;
                for (int i = 0; i < observed.length; i++) {
                    result += Math.pow(observed[i] - expected[i], 2) / expected[i];
                }
                resultLabel.setText(String.format("Chi Square: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}