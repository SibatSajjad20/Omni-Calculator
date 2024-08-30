import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BodyWaterPercentageCalculator extends JPanel {
    private JTextField weightField;
    private JCheckBox genderCheckBox;
    private JLabel resultLabel;

    public BodyWaterPercentageCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // **Body Water Percentage Calculator**
        JLabel calculatorLabel = new JLabel("Body Water Percentage Calculator");
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

        JPanel genderPanel = new JPanel();
        genderPanel.setLayout(new BoxLayout(genderPanel, BoxLayout.X_AXIS));
        genderPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel genderLabel = new JLabel("Gender: ");
        genderLabel.setFont(labelFont);
        genderCheckBox = new JCheckBox("Male");
        genderCheckBox.setFont(labelFont);
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

        resultLabel = new JLabel("Body Water Percentage: ");
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
                boolean isMale = genderCheckBox.isSelected();
                double bodyWaterPercentage = isMale ? 0.6 * weight : 0.55 * weight;
                resultLabel.setText(String.format("Body Water Percentage: %.2f%%", bodyWaterPercentage));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}