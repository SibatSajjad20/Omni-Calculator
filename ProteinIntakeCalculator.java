import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ProteinIntakeCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JLabel resultLabel;

    public ProteinIntakeCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Protein Intake Calculator**
        JLabel calculatorLabel = new JLabel("Protein Intake Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel bodyWeightPanel = new JPanel();
        bodyWeightPanel.setLayout(new BoxLayout(bodyWeightPanel, BoxLayout.X_AXIS));
        bodyWeightPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel bodyWeightLabel = new JLabel("Body Weight (kg): ");
        bodyWeightLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        bodyWeightPanel.add(bodyWeightLabel);
        bodyWeightPanel.add(field1);
        inputPanel.add(bodyWeightPanel);

        JPanel activityLevelPanel = new JPanel();
        activityLevelPanel.setLayout(new BoxLayout(activityLevelPanel, BoxLayout.X_AXIS));
        activityLevelPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel activityLevelLabel = new JLabel("Activity Level (1-5): ");
        activityLevelLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        activityLevelPanel.add(activityLevelLabel);
        activityLevelPanel.add(field2);
        inputPanel.add(activityLevelPanel);

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
                double bodyWeight = Double.parseDouble(field1.getText());
                double activityLevel = Double.parseDouble(field2.getText());
                double result = bodyWeight * activityLevel;
                resultLabel.setText(String.format("Protein Intake: %.2f grams", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}