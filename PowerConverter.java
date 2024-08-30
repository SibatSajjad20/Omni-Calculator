import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PowerConverter extends JPanel {
    private JTextField wattsField;
    private JLabel resultLabel;

    public PowerConverter(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Power Converter**
        JLabel converterLabel = new JLabel("Power Converter (Watts to Horsepower)");
        converterLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        converterLabel.setHorizontalAlignment(JLabel.CENTER);
        add(converterLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel wattsPanel = new JPanel();
        wattsPanel.setLayout(new BoxLayout(wattsPanel, BoxLayout.X_AXIS));
        wattsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel wattsLabel = new JLabel("Watts (W): ");
        wattsLabel.setFont(labelFont);
        wattsField = new JTextField(10);
        wattsField.setFont(textFieldFont);
        wattsPanel.add(wattsLabel);
        wattsPanel.add(wattsField);
        inputPanel.add(wattsPanel);

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

        resultLabel = new JLabel("Power in Horsepower: ");
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
                double watts = Double.parseDouble(wattsField.getText());
                double result = watts / 745.7; // Convert Watts to Horsepower
                
                resultLabel.setText(String.format("Power in Horsepower: %.2f HP", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}