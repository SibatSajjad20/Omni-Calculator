import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CatenaryCurveCalculator extends JPanel {
    private JTextField sagParameterField;
    private JTextField horizontalPositionField;
    private JLabel resultLabel;

    public CatenaryCurveCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        JPanel headingPanel = new JPanel();
        JLabel headingLabel = new JLabel("Catenary Curve Calculator");
        headingLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        headingPanel.add(headingLabel);
        add(headingPanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel sagParameterPanel = new JPanel();
        sagParameterPanel.setLayout(new BoxLayout(sagParameterPanel, BoxLayout.X_AXIS));
        sagParameterPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel sagParameterLabel = new JLabel("Sag Parameter (a): ");
        sagParameterLabel.setFont(labelFont);
        sagParameterField = new JTextField(10);
        sagParameterField.setFont(textFieldFont);
        sagParameterPanel.add(sagParameterLabel);
        sagParameterPanel.add(sagParameterField);
        inputPanel.add(sagParameterPanel);

        JPanel horizontalPositionPanel = new JPanel();
        horizontalPositionPanel.setLayout(new BoxLayout(horizontalPositionPanel, BoxLayout.X_AXIS));
        horizontalPositionPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel horizontalPositionLabel = new JLabel("Horizontal Position (x): ");
        horizontalPositionLabel.setFont(labelFont);
        horizontalPositionField = new JTextField(10);
        horizontalPositionField.setFont(textFieldFont);
        horizontalPositionPanel.add(horizontalPositionLabel);
        horizontalPositionPanel.add(horizontalPositionField);
        inputPanel.add(horizontalPositionPanel);

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
                double a = Double.parseDouble(sagParameterField.getText());
                double x = Double.parseDouble(horizontalPositionField.getText());
                double result = a * Math.cosh(x / a);
                resultLabel.setText(String.format("Catenary Curve: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}