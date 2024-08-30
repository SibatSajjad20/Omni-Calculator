import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class HourShiftPayCalculator extends JPanel {
    private JTextField hourlyRateField;
    private JTextField hoursWorkedField;
    private JLabel resultLabel;

    public HourShiftPayCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Hour Shift Pay Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel hourlyRatePanel = new JPanel();
        hourlyRatePanel.setLayout(new BoxLayout(hourlyRatePanel, BoxLayout.X_AXIS));
        hourlyRatePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel hourlyRateLabel = new JLabel("Hourly Rate ($): ");
        hourlyRateLabel.setFont(labelFont);
        hourlyRateField = new JTextField(10);
        hourlyRateField.setFont(textFieldFont);
        hourlyRatePanel.add(hourlyRateLabel);
        hourlyRatePanel.add(hourlyRateField);
        inputPanel.add(hourlyRatePanel);

        JPanel hoursWorkedPanel = new JPanel();
        hoursWorkedPanel.setLayout(new BoxLayout(hoursWorkedPanel, BoxLayout.X_AXIS));
        hoursWorkedPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel hoursWorkedLabel = new JLabel("Hours Worked: ");
        hoursWorkedLabel.setFont(labelFont);
        hoursWorkedField = new JTextField(10);
        hoursWorkedField.setFont(textFieldFont);
        hoursWorkedPanel.add(hoursWorkedLabel);
        hoursWorkedPanel.add(hoursWorkedField);
        inputPanel.add(hoursWorkedPanel);

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

        resultLabel = new JLabel("Hour Shift Pay: ");
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
                double hourlyRate = Double.parseDouble(hourlyRateField.getText());
                double hoursWorked = Double.parseDouble(hoursWorkedField.getText());
                double result = hourlyRate * hoursWorked;
                resultLabel.setText(String.format("Hour Shift Pay: $%.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}