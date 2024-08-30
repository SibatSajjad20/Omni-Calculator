import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class WaistToHipRatioCalculator extends JPanel {
    // **Waist to Hip Ratio Calculator**
    private JTextField field1;
    private JTextField field2;
    private JLabel resultLabel;

    public WaistToHipRatioCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel waistPanel = new JPanel();
        waistPanel.setLayout(new BoxLayout(waistPanel, BoxLayout.X_AXIS));
        waistPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel waistLabel = new JLabel("Waist (cm): ");
        waistLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        waistPanel.add(waistLabel);
        waistPanel.add(field1);
        inputPanel.add(waistPanel);

        JPanel hipPanel = new JPanel();
        hipPanel.setLayout(new BoxLayout(hipPanel, BoxLayout.X_AXIS));
        hipPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel hipLabel = new JLabel("Hip (cm): ");
        hipLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        hipPanel.add(hipLabel);
        hipPanel.add(field2);
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
                double waist = Double.parseDouble(field1.getText());
                double hip = Double.parseDouble(field2.getText());
                double result = waist / hip;
                resultLabel.setText(String.format("Result: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}