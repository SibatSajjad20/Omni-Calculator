import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class HarmonicMeanCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JLabel resultLabel;

    public HarmonicMeanCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Harmonic Mean Calculator");
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
                double sum = 0.0;
                for (double v : values) {
                    sum += 1.0 / v;
                }
                double result = values.length / sum; // Harmonic mean formula
                
                resultLabel.setText(String.format("Harmonic mean: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}