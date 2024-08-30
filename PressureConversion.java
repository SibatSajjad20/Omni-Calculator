import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PressureConversion extends JPanel {
    private JTextField pressureField;
    private JLabel resultLabel;

    public PressureConversion(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Pressure Conversion Calculator**
        JLabel calculatorLabel = new JLabel("Pressure Conversion Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel pressurePanel = new JPanel();
        pressurePanel.setLayout(new BoxLayout(pressurePanel, BoxLayout.X_AXIS));
        pressurePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel pressureLabel = new JLabel("Pressure (pascal): ");
        pressureLabel.setFont(labelFont);
        pressureField = new JTextField(10);
        pressureField.setFont(textFieldFont);
        pressurePanel.add(pressureLabel);
        pressurePanel.add(pressureField);
        inputPanel.add(pressurePanel);

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

        resultLabel = new JLabel("Pressure (bar): ");
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
                double pressure = Double.parseDouble(pressureField.getText());
                double result = pressure / 100000;
                resultLabel.setText(String.format("Pressure (bar): %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}