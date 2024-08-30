import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CalorieIntakeCalculator extends JPanel {
    private JTextField weightField;
    private JTextField heightField;
    private JTextField ageField;
    private JTextField activityFactorField;
    private JCheckBox genderCheckBox;
    private JLabel resultLabel;

    public CalorieIntakeCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // **Calorie Intake Calculator**
        JLabel calculatorLabel = new JLabel("Calorie Intake Calculator");
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

        JPanel heightPanel = new JPanel();
        heightPanel.setLayout(new BoxLayout(heightPanel, BoxLayout.X_AXIS));
        heightPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel heightLabel = new JLabel("Height (cm): ");
        heightLabel.setFont(labelFont);
        heightField = new JTextField(10);
        heightField.setFont(textFieldFont);
        heightPanel.add(heightLabel);
        heightPanel.add(heightField);
        inputPanel.add(heightPanel);

        JPanel agePanel = new JPanel();
        agePanel.setLayout(new BoxLayout(agePanel, BoxLayout.X_AXIS));
        agePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel ageLabel = new JLabel("Age (years): ");
        ageLabel.setFont(labelFont);
        ageField = new JTextField(10);
        ageField.setFont(textFieldFont);
        agePanel.add(ageLabel);
        agePanel.add(ageField);
        inputPanel.add(agePanel);

        JPanel activityFactorPanel = new JPanel();
        activityFactorPanel.setLayout(new BoxLayout(activityFactorPanel, BoxLayout.X_AXIS));
        activityFactorPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel activityFactorLabel = new JLabel("Activity Factor: ");
        activityFactorLabel.setFont(labelFont);
        activityFactorField = new JTextField(10);
        activityFactorField.setFont(textFieldFont);
        activityFactorPanel.add(activityFactorLabel);
        activityFactorPanel.add(activityFactorField);
        inputPanel.add(activityFactorPanel);

        JPanel genderPanel = new JPanel();
        genderPanel.setLayout(new BoxLayout(genderPanel, BoxLayout.X_AXIS));
        genderPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel genderLabel = new JLabel("Gender: ");
        genderLabel.setFont(labelFont);
        genderCheckBox = new JCheckBox("Male");
        genderCheckBox.setFont(textFieldFont);
        genderPanel.add(genderLabel);
        genderPanel.add(genderCheckBox);
        inputPanel.add(genderPanel);

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

        resultLabel = new JLabel("Calorie Intake: ");
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
                double height = Double.parseDouble(heightField.getText());
                int age = Integer.parseInt(ageField.getText());
                boolean isMale = genderCheckBox.isSelected();
                double activityFactor = Double.parseDouble(activityFactorField.getText());
                double bmr = isMale ?
                        88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age) :
                        447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
                double result = bmr * activityFactor;
                resultLabel.setText(String.format("Calorie Intake: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}