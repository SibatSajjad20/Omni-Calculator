import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CaloriesBurnedCalculator extends JPanel {
    private JTextField weightField;
    private JTextField metValueField;
    private JTextField durationField;
    private JLabel resultLabel;

    public CaloriesBurnedCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // **Calories Burned Calculator**
        JLabel calculatorLabel = new JLabel("Calories Burned Calculator");
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
        weightField = new JTextField(10);
        weightField.setFont(textFieldFont);
        weightPanel.add(weightLabel);
        weightPanel.add(weightField);
        inputPanel.add(weightPanel);

        JPanel metValuePanel = new JPanel();
        metValuePanel.setLayout(new BoxLayout(metValuePanel, BoxLayout.X_AXIS));
        metValuePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel metValueLabel = new JLabel("MET Value: ");
        metValueLabel.setFont(labelFont);
        metValueField = new JTextField(10);
        metValueField.setFont(textFieldFont);
        metValuePanel.add(metValueLabel);
        metValuePanel.add(metValueField);
        inputPanel.add(metValuePanel);

        JPanel durationPanel = new JPanel();
        durationPanel.setLayout(new BoxLayout(durationPanel, BoxLayout.X_AXIS));
        durationPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel durationLabel = new JLabel("Duration (min): ");
        durationLabel.setFont(labelFont);
        durationField = new JTextField(10);
        durationField.setFont(textFieldFont);
        durationPanel.add(durationLabel);
        durationPanel.add(durationField);
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

        resultLabel = new JLabel("Calories Burned: ");
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
                double weight = Double.parseDouble(weightField.getText());
                double metValue = Double.parseDouble(metValueField.getText());
                int duration = Integer.parseInt(durationField.getText());
                double result = (metValue * 3.5 * weight / 200) * duration; // Calories burned
                
                resultLabel.setText(String.format("Calories Burned: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}