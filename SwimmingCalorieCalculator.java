import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SwimmingCalorieCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JLabel resultLabel;

    public SwimmingCalorieCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Swimming Calorie Calculator**
        JLabel calculatorLabel = new JLabel("Swimming Calorie Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel weightPanel = new JPanel();
        weightPanel.setLayout(new BoxLayout(weightPanel, BoxLayout.X_AXIS));
        weightPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel weightLabel = new JLabel("Weight (kg): ");
        weightLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        weightPanel.add(weightLabel);
        weightPanel.add(field1);
        inputPanel.add(weightPanel);

        JPanel metPanel = new JPanel();
        metPanel.setLayout(new BoxLayout(metPanel, BoxLayout.X_AXIS));
        metPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel metLabel = new JLabel("MET: ");
        metLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        metPanel.add(metLabel);
        metPanel.add(field2);
        inputPanel.add(metPanel);

        JPanel timePanel = new JPanel();
        timePanel.setLayout(new BoxLayout(timePanel, BoxLayout.X_AXIS));
        timePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel timeLabel = new JLabel("Time (hours): ");
        timeLabel.setFont(labelFont);
        field3 = new JTextField(10);
        field3.setFont(textFieldFont);
        timePanel.add(timeLabel);
        timePanel.add(field3);
        inputPanel.add(timePanel);

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
                double weight = Double.parseDouble(field1.getText()); // in kg
                double MET = Double.parseDouble(field2.getText()); // MET value for swimming activity
                double time = Double.parseDouble(field3.getText()); // in hours
                double result = MET * weight * time * 3.5 / 200; // 

                resultLabel.setText(String.format("Calories burned: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}