import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NormalForceCalculator extends JPanel {
    private JTextField massField;
    private JTextField angleField;
    private JLabel resultLabel;

    public NormalForceCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Normal Force Calculator**
        JLabel calculatorLabel = new JLabel("Normal Force Calculator");
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

        JPanel anglePanel = new JPanel();
        anglePanel.setLayout(new BoxLayout(anglePanel, BoxLayout.X_AXIS));
        anglePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel angleLabel = new JLabel("Angle (degrees): ");
        angleLabel.setFont(labelFont);
        angleField = new JTextField(10);
        angleField.setFont(textFieldFont);
        anglePanel.add(angleLabel);
        anglePanel.add(angleField);
        inputPanel.add(anglePanel);

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

        resultLabel = new JLabel("Normal Force: ");
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
                double angle = Math.toRadians(Double.parseDouble(angleField.getText()));
                double g = 9.81;
                double result = mass * g * Math.cos(angle);
                resultLabel.setText(String.format("Normal Force: %.2f N", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}