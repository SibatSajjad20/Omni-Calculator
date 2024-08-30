import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BreathRateCalculator extends JPanel {
    private JTextField breathsField;
    private JTextField durationField;
    private JLabel resultLabel;

    public BreathRateCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // **Breath Rate Calculator**
        JLabel calculatorLabel = new JLabel("Breath Rate Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel breathsPanel = new JPanel();
        breathsPanel.setLayout(new BoxLayout(breathsPanel, BoxLayout.X_AXIS));
        breathsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel breathsLabel = new JLabel("Breaths: ");
        breathsLabel.setFont(labelFont);
        breathsField = new JTextField(10);
        breathsField.setFont(textFieldFont);
        breathsPanel.add(breathsLabel);
        breathsPanel.add(breathsField);
        inputPanel.add(breathsPanel);

        JPanel durationPanel = new JPanel();
        durationPanel.setLayout(new BoxLayout(durationPanel, BoxLayout.X_AXIS));
        durationPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel durationLabel = new JLabel("Duration (minutes): ");
        durationLabel.setFont(labelFont);
        durationField = new JTextField(10);
        durationField.setFont(textFieldFont);
        durationPanel.add(durationLabel);
        durationPanel.add(durationField);
        inputPanel.add(durationPanel);

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

        resultLabel = new JLabel("Breath Rate in minutes: ");
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
                int breaths = Integer.parseInt(breathsField.getText());
                int duration = Integer.parseInt(durationField.getText()); 
                double result = (breaths * 60.0) / duration;
                resultLabel.setText(String.format("Breath Rate in minutes: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}