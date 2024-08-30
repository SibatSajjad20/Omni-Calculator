import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DailyWaterIntakeCalculator extends JPanel {
    private JTextField weightField;
    private JCheckBox activeCheckBox;
    private JLabel resultLabel;

    public DailyWaterIntakeCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // Add a heading
        JLabel heading = new JLabel("Daily Water Intake Calculator");
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        add(inputPanel, BorderLayout.CENTER);

        inputPanel.add(new JLabel("Weight:"));
        weightField = new JTextField(10);
        inputPanel.add(weightField);

        inputPanel.add(new JLabel("Active:"));
        activeCheckBox = new JCheckBox();
        inputPanel.add(activeCheckBox);

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
                double weight = Double.parseDouble(weightField.getText());
                boolean isActive = activeCheckBox.isSelected();
                double result = weight * (isActive ? 0.04 : 0.03);
                resultLabel.setText(String.format("Daily Water Intake: %.2f liters", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}