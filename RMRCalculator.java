import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class RMRCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JTextField field4;
    private JLabel resultLabel;

    public RMRCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Resting Metabolic Rate (RMR) Calculator**
        JLabel calculatorLabel = new JLabel("Resting Metabolic Rate (RMR) Calculator");
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

        JPanel heightPanel = new JPanel();
        heightPanel.setLayout(new BoxLayout(heightPanel, BoxLayout.X_AXIS));
        heightPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel heightLabel = new JLabel("Height (cm): ");
        heightLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        heightPanel.add(heightLabel);
        heightPanel.add(field2);
        inputPanel.add(heightPanel);

        JPanel agePanel = new JPanel();
        agePanel.setLayout(new BoxLayout(agePanel, BoxLayout.X_AXIS));
        agePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel ageLabel = new JLabel("Age (years): ");
        ageLabel.setFont(labelFont);
        field3 = new JTextField(10);
        field3.setFont(textFieldFont);
        agePanel.add(ageLabel);
        agePanel.add(field3);
        inputPanel.add(agePanel);

        JPanel genderPanel = new JPanel();
        genderPanel.setLayout(new BoxLayout(genderPanel, BoxLayout.X_AXIS));
        genderPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel genderLabel = new JLabel("Gender (male/female): ");
        genderLabel.setFont(labelFont);
        field4 = new JTextField(10);
        field4.setFont(textFieldFont);
        genderPanel.add(genderLabel);
        genderPanel.add(field4);
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
    double height = Double.parseDouble(field2.getText());
    int age = Integer.parseInt(field3.getText());
    String gender = field4.getText();
    double result;
    if (gender.equalsIgnoreCase("male")) {
        result = 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
    } else {
        result = 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
    } // RMR in calories per day
    
resultLabel.setText(String.format("RMR: %.2f", result));
} catch (NumberFormatException ex) {
resultLabel.setText("Please enter valid numbers.");
}
}
}
}
