import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SaunaCaloriesBurnedCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JLabel resultLabel;

    public SaunaCaloriesBurnedCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Sauna Calories Burned Calculator**
        JLabel calculatorLabel = new JLabel("Sauna Calories Burned Calculator");
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

        JPanel durationPanel = new JPanel();
        durationPanel.setLayout(new BoxLayout(durationPanel, BoxLayout.X_AXIS));
        durationPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel durationLabel = new JLabel("Duration (minutes): ");
        durationLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        durationPanel.add(durationLabel);
        durationPanel.add(field2);
        inputPanel.add(durationPanel);

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
                double weight = Double.parseDouble(field1.getText());
                int duration = Integer.parseInt(field2.getText());
                double metValue = 1.5; 
                double result = (metValue * 3.5 * weight / 200) * duration; 
                resultLabel.setText(String.format("Result: %.2f calories", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}