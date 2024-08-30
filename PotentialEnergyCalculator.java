import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PotentialEnergyCalculator extends JPanel {
    private JTextField massField;
    private JTextField heightField;
    private JLabel resultLabel;

    public PotentialEnergyCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Potential Energy Calculator**
        JLabel calculatorLabel = new JLabel("Potential Energy Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel massPanel = new JPanel();
        massPanel.setLayout(new BoxLayout(massPanel, BoxLayout.X_AXIS));
        massPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel massLabel = new JLabel("Mass (kg): ");
        massLabel.setFont(labelFont);
        massField = new JTextField(10);
        massField.setFont(textFieldFont);
        massPanel.add(massLabel);
        massPanel.add(massField);
        inputPanel.add(massPanel);

        JPanel heightPanel = new JPanel();
        heightPanel.setLayout(new BoxLayout(heightPanel, BoxLayout.X_AXIS));
        heightPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel heightLabel = new JLabel("Height (m): ");
        heightLabel.setFont(labelFont);
        heightField = new JTextField(10);
        heightField.setFont(textFieldFont);
        heightPanel.add(heightLabel);
        heightPanel.add(heightField);
        inputPanel.add(heightPanel);

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

        resultLabel = new JLabel("Potential Energy: ");
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
                double mass = Double.parseDouble(massField.getText());
                double height = Double.parseDouble(heightField.getText());
                double g = 9.81; // acceleration due to gravity
                double result = mass * g * height;
                
                resultLabel.setText(String.format("Potential Energy: %.2f J", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}