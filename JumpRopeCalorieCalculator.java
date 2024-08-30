import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class JumpRopeCalorieCalculator extends JPanel {
    private JTextField jumpsField;
    private JTextField weightField;
    private JLabel resultLabel;

    public JumpRopeCalorieCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Jump Rope Calorie Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel jumpsPanel = new JPanel();
        jumpsPanel.setLayout(new BoxLayout(jumpsPanel, BoxLayout.X_AXIS));
        jumpsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel jumpsLabel = new JLabel("Jumps: ");
        jumpsLabel.setFont(labelFont);
        jumpsField = new JTextField(10);
        jumpsField.setFont(textFieldFont);
        jumpsPanel.add(jumpsLabel);
        jumpsPanel.add(jumpsField);
        inputPanel.add(jumpsPanel);

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

        resultLabel = new JLabel("Calories burned: ");
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
                int jumps = Integer.parseInt(jumpsField.getText());
                double weight = Double.parseDouble(weightField.getText());
                double result = jumps * (weight / 2.2) * 0.1; // Calories burned per jump
                
                resultLabel.setText(String.format("Calories burned: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}