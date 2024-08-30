import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SmokingRiskCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JLabel resultLabel;

    public SmokingRiskCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Smoking Risk Calculator**
        JLabel calculatorLabel = new JLabel("Smoking Risk Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel cigarettesPerDayPanel = new JPanel();
        cigarettesPerDayPanel.setLayout(new BoxLayout(cigarettesPerDayPanel, BoxLayout.X_AXIS));
        cigarettesPerDayPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel cigarettesPerDayLabel = new JLabel("Cigarettes per day: ");
        cigarettesPerDayLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        cigarettesPerDayPanel.add(cigarettesPerDayLabel);
        cigarettesPerDayPanel.add(field1);
        inputPanel.add(cigarettesPerDayPanel);

        JPanel yearsSmokedPanel = new JPanel();
        yearsSmokedPanel.setLayout(new BoxLayout(yearsSmokedPanel, BoxLayout.X_AXIS));
        yearsSmokedPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel yearsSmokedLabel = new JLabel("Years smoked: ");
        yearsSmokedLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        yearsSmokedPanel.add(yearsSmokedLabel);
        yearsSmokedPanel.add(field2);
        inputPanel.add(yearsSmokedPanel);

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

        resultLabel = new JLabel("Risk factor: ");
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
                int cigarettesPerDay = Integer.parseInt(field1.getText());
                int yearsSmoked = Integer.parseInt(field2.getText());
                double packYears = (cigarettesPerDay / 20.0) * yearsSmoked; // Pack-years
                double riskFactor = packYears * 0.05; // Simple estimation for risk factor
                
                resultLabel.setText(String.format("Risk factor: %.2f", riskFactor));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}