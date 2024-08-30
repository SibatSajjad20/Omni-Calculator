import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

class KurtosisCalculator extends JPanel {
    private JTextField value1Field;
    private JTextField value2Field;
    private JTextField value3Field;
    private JLabel resultLabel;

    public KurtosisCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Kurtosis Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

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
        value1Field = new JTextField(10);
        value1Field.setFont(textFieldFont);
        value1Panel.add(value1Label);
        value1Panel.add(value1Field);
        inputPanel.add(value1Panel);

        JPanel value2Panel = new JPanel();
        value2Panel.setLayout(new BoxLayout(value2Panel, BoxLayout.X_AXIS));
        value2Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel value2Label = new JLabel("Value 2: ");
        value2Label.setFont(labelFont);
        value2Field = new JTextField(10);
        value2Field.setFont(textFieldFont);
        value2Panel.add(value2Label);
        value2Panel.add(value2Field);
        inputPanel.add(value2Panel);

        JPanel value3Panel = new JPanel();
        value3Panel.setLayout(new BoxLayout(value3Panel, BoxLayout.X_AXIS));
        value3Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel value3Label = new JLabel("Value 3: ");
        value3Label.setFont(labelFont);
        value3Field = new JTextField(10);
        value3Field.setFont(textFieldFont);
        value3Panel.add(value3Label);
        value3Panel.add(value3Field);
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

        resultLabel = new JLabel("Kurtosis: ");
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
                double[] values = {Double.parseDouble(value1Field.getText()), Double.parseDouble(value2Field.getText()), Double.parseDouble(value3Field.getText())}; // Add more as needed
                double mean = Arrays.stream(values).average().orElse(0.0);
                double stdDev = Math.sqrt(Arrays.stream(values).map(v -> Math.pow(v - mean, 2)).sum() / values.length);
                double n = values.length;
                double kurtosis = (n * (n + 1) * Arrays.stream(values).map(v -> Math.pow((v - mean) / stdDev, 4)).sum() / ((n - 1) * (n - 2) * (n - 3))) - (3 * Math.pow(n - 1, 2) / ((n - 2) * (n - 3)));
                // Result is kurtosis

                resultLabel.setText(String.format("Kurtosis: %.2f", kurtosis));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}