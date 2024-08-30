import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

class SkewnessCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JLabel resultLabel;

    public SkewnessCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Skewness Calculator**
        JLabel calculatorLabel = new JLabel("Skewness Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel value1Panel = new JPanel();
        value1Panel.setLayout(new BoxLayout(value1Panel, BoxLayout.X_AXIS));
        value1Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel value1Label = new JLabel("Value 1: ");
        value1Label.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        value1Panel.add(value1Label);
        value1Panel.add(field1);
        inputPanel.add(value1Panel);

        JPanel value2Panel = new JPanel();
        value2Panel.setLayout(new BoxLayout(value2Panel, BoxLayout.X_AXIS));
        value2Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel value2Label = new JLabel("Value 2: ");
        value2Label.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        value2Panel.add(value2Label);
        value2Panel.add(field2);
        inputPanel.add(value2Panel);

        JPanel value3Panel = new JPanel();
        value3Panel.setLayout(new BoxLayout(value3Panel, BoxLayout.X_AXIS));
        value3Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel value3Label = new JLabel("Value 3: ");
        value3Label.setFont(labelFont);
        field3 = new JTextField(10);
        field3.setFont(textFieldFont);
        value3Panel.add(value3Label);
        value3Panel.add(field3);
        inputPanel.add(value3Panel);

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
                double[] values = {Double.parseDouble(field1.getText()), Double.parseDouble(field2.getText()), Double.parseDouble(field3.getText())}; // Add more as needed
                double mean = Arrays.stream(values).average().orElse(0.0);
                double stdDev = Math.sqrt(Arrays.stream(values).map(v -> Math.pow(v - mean, 2)).sum() / values.length);
                double n = values.length;
                double skewness = (n * Arrays.stream(values).map(v -> Math.pow((v - mean) / stdDev, 3)).sum()) / ((n - 1) * (n - 2));
                // Result is skewness

                resultLabel.setText(String.format("Skewness: %.2f", skewness));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}