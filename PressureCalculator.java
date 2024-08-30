import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PressureCalculator extends JPanel {
    private JTextField forceField;
    private JTextField areaField;
    private JLabel resultLabel;

    public PressureCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Pressure Calculator**
        JLabel calculatorLabel = new JLabel("Pressure Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel forcePanel = new JPanel();
        forcePanel.setLayout(new BoxLayout(forcePanel, BoxLayout.X_AXIS));
        forcePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel forceLabel = new JLabel("Force (N): ");
        forceLabel.setFont(labelFont);
        forceField = new JTextField(10);
        forceField.setFont(textFieldFont);
        forcePanel.add(forceLabel);
        forcePanel.add(forceField);
        inputPanel.add(forcePanel);

        JPanel areaPanel = new JPanel();
        areaPanel.setLayout(new BoxLayout(areaPanel, BoxLayout.X_AXIS));
        areaPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel areaLabel = new JLabel("Area (m²): ");
        areaLabel.setFont(labelFont);
        areaField = new JTextField(10);
        areaField.setFont(textFieldFont);
        areaPanel.add(areaLabel);
        areaPanel.add(areaField);
        inputPanel.add(areaPanel);

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

        resultLabel = new JLabel("Pressure: ");
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
                double force = Double.parseDouble(forceField.getText());
                double area = Double.parseDouble(areaField.getText());
                double result = force / area;
                resultLabel.setText(String.format("Pressure: %.2f Pa", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}