import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ZScoreCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JLabel resultLabel;

    public ZScoreCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);
        JLabel calculatorLabel = new JLabel("Z Score Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);
        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel valuePanel = new JPanel();
        valuePanel.setLayout(new BoxLayout(valuePanel, BoxLayout.X_AXIS));
        valuePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel valueLabel = new JLabel("Value: ");
        valueLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        valuePanel.add(valueLabel);
        valuePanel.add(field1);
        inputPanel.add(valuePanel);

        JPanel meanPanel = new JPanel();
        meanPanel.setLayout(new BoxLayout(meanPanel, BoxLayout.X_AXIS));
        meanPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel meanLabel = new JLabel("Mean: ");
        meanLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        meanPanel.add(meanLabel);
        meanPanel.add(field2);
        inputPanel.add(meanPanel);

        JPanel stdDevPanel = new JPanel();
        stdDevPanel.setLayout(new BoxLayout(stdDevPanel, BoxLayout.X_AXIS));
        stdDevPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel stdDevLabel = new JLabel("StdDev: ");
        stdDevLabel.setFont(labelFont);
        field3 = new JTextField(10);
        field3.setFont(textFieldFont);
        stdDevPanel.add(stdDevLabel);
        stdDevPanel.add(field3);
        inputPanel.add(stdDevPanel);

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

        resultLabel = new JLabel("Z Score: ");
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
                double value = Double.parseDouble(field1.getText());
                double mean = Double.parseDouble(field2.getText());
                double stdDev = Double.parseDouble(field3.getText());
                double result = (value - mean) / stdDev;
                resultLabel.setText(String.format("Z Score: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}
