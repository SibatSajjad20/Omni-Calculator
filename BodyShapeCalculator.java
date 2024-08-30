import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BodyShapeCalculator extends JPanel {
    private JTextField waistField;
    private JTextField hipField;
    private JLabel resultLabel;

    public BodyShapeCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // **Body Shape Calculator**
        JLabel calculatorLabel = new JLabel("Body Shape Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel waistPanel = new JPanel();
        waistPanel.setLayout(new BoxLayout(waistPanel, BoxLayout.X_AXIS));
        waistPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel waistLabel = new JLabel("Waist: ");
        waistLabel.setFont(labelFont);
        waistField = new JTextField(10);
        waistField.setFont(textFieldFont);
        waistPanel.add(waistLabel);
        waistPanel.add(waistField);
        inputPanel.add(waistPanel);

        JPanel hipPanel = new JPanel();
        hipPanel.setLayout(new BoxLayout(hipPanel, BoxLayout.X_AXIS));
        hipPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel hipLabel = new JLabel("Hip: ");
        hipLabel.setFont(labelFont);
        hipField = new JTextField(10);
        hipField.setFont(textFieldFont);
        hipPanel.add(hipLabel);
        hipPanel.add(hipField);
        inputPanel.add(hipPanel);

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

        resultLabel = new JLabel("Body Shape: ");
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
                double waist = Double.parseDouble(waistField.getText());
                double hip = Double.parseDouble(hipField.getText());
                double result = waist / hip;

                if (result < 0.9) {
                    resultLabel.setText(String.format("Body Shape: %.2f (Underweight)", result));
                } else if (result < 1.1) {
                    resultLabel.setText(String.format("Body Shape: %.2f (Normal)", result));
                } else {
                    resultLabel.setText(String.format("Body Shape: %.2f (Overweight)", result));
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}