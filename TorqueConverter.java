import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TorqueConverter extends JPanel {
    private JTextField field1;
    private JLabel resultLabel;

    public TorqueConverter(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Torque Converter**
        JLabel converterLabel = new JLabel("Torque Converter");
        converterLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        converterLabel.setHorizontalAlignment(JLabel.CENTER);
        add(converterLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel torquePanel = new JPanel();
        torquePanel.setLayout(new BoxLayout(torquePanel, BoxLayout.X_AXIS));
        torquePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel torqueLabel = new JLabel("Torque in Newton Meters: ");
        torqueLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        torquePanel.add(torqueLabel);
        torquePanel.add(field1);
        inputPanel.add(torquePanel);

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
                double newtonMeters = Double.parseDouble(field1.getText());
                double result = newtonMeters * 0.737562; // Convert Newton Meters to Foot-pounds
                
                resultLabel.setText(String.format("Torque in Foot-pounds: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}