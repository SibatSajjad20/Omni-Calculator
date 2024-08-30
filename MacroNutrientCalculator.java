import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MacroNutrientCalculator extends JPanel {
    private JTextField totalCaloriesField;
    private JTextField proteinPercentageField;
    private JTextField carbsPercentageField;
    private JTextField fatPercentageField;
    private JLabel resultLabel;

    public MacroNutrientCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Macro Nutrient Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel totalCaloriesPanel = new JPanel();
        totalCaloriesPanel.setLayout(new BoxLayout(totalCaloriesPanel, BoxLayout.X_AXIS));
        totalCaloriesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel totalCaloriesLabel = new JLabel("Total Calories: ");
        totalCaloriesLabel.setFont(labelFont);
        totalCaloriesField = new JTextField(5);
        totalCaloriesField.setFont(textFieldFont);
        totalCaloriesPanel.add(totalCaloriesLabel);
        totalCaloriesPanel.add(totalCaloriesField);
        inputPanel.add(totalCaloriesPanel);

        JPanel proteinPercentagePanel = new JPanel();
        proteinPercentagePanel.setLayout(new BoxLayout(proteinPercentagePanel, BoxLayout.X_AXIS));
        proteinPercentagePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel proteinPercentageLabel = new JLabel("Protein Percentage: ");
        proteinPercentageLabel.setFont(labelFont);
        proteinPercentageField = new JTextField(5);
        proteinPercentageField.setFont(textFieldFont);
        proteinPercentagePanel.add(proteinPercentageLabel);
        proteinPercentagePanel.add(proteinPercentageField);
        inputPanel.add(proteinPercentagePanel);

        JPanel carbsPercentagePanel = new JPanel();
        carbsPercentagePanel.setLayout(new BoxLayout(carbsPercentagePanel, BoxLayout.X_AXIS));
        carbsPercentagePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel carbsPercentageLabel = new JLabel("Carbs Percentage: ");
        carbsPercentageLabel.setFont(labelFont);
        carbsPercentageField = new JTextField(5);
        carbsPercentageField.setFont(textFieldFont);
        carbsPercentagePanel.add(carbsPercentageLabel);
        carbsPercentagePanel.add(carbsPercentageField);
        inputPanel.add(carbsPercentagePanel);

        JPanel fatPercentagePanel = new JPanel();
        fatPercentagePanel.setLayout(new BoxLayout(fatPercentagePanel, BoxLayout.X_AXIS));
        fatPercentagePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel fatPercentageLabel = new JLabel("Fat Percentage: ");
        fatPercentageLabel.setFont(labelFont);
        fatPercentageField = new JTextField(5);
        fatPercentageField.setFont(textFieldFont);
        fatPercentagePanel.add(fatPercentageLabel);
        fatPercentagePanel.add(fatPercentageField);
        inputPanel.add(fatPercentagePanel);

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

        resultLabel = new JLabel("Macro Nutrients: ");
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
                double totalCalories = Double.parseDouble(totalCaloriesField.getText());
                double proteinPercentage = Double.parseDouble(proteinPercentageField.getText()) / 100;
                double carbsPercentage = Double.parseDouble(carbsPercentageField.getText()) / 100;
                double fatPercentage = Double.parseDouble(fatPercentageField.getText()) / 100;
                double proteinGrams = (totalCalories * proteinPercentage) / 4; // 1 gram of protein = 4 calories
                double carbsGrams = (totalCalories * carbsPercentage) / 4;
                double fatGrams = (totalCalories * fatPercentage) / 9; // 1 gram of fat = 9 calories
                
            resultLabel.setText(String.format("Macro Nutrients: %.2f", proteinGrams,carbsGrams,fatGrams));
            } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter valid numbers.");
            }
            
        }
    }
}
