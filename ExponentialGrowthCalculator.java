import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ExponentialGrowthCalculator extends JPanel {
    private JTextField initialAmountField;
    private JTextField rateField;
    private JTextField timeField;
    private JLabel resultLabel;

    public ExponentialGrowthCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        JPanel headingPanel = new JPanel();
        JLabel headingLabel = new JLabel("Exponential Growth Calculator");
        headingLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        headingPanel.add(headingLabel);
        add(headingPanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel initialAmountPanel = new JPanel();
        initialAmountPanel.setLayout(new BoxLayout(initialAmountPanel, BoxLayout.X_AXIS));
        initialAmountPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel initialAmountLabel = new JLabel("Initial Amount: ");
        initialAmountLabel.setFont(labelFont);
        initialAmountField = new JTextField(10);
        initialAmountField.setFont(textFieldFont);
        initialAmountPanel.add(initialAmountLabel);
        initialAmountPanel.add(initialAmountField);
        inputPanel.add(initialAmountPanel);

        JPanel ratePanel = new JPanel();
        ratePanel.setLayout(new BoxLayout(ratePanel, BoxLayout.X_AXIS));
        ratePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel rateLabel = new JLabel("Rate (%): ");
        rateLabel.setFont(labelFont);
        rateField = new JTextField(10);
        rateField.setFont(textFieldFont);
        ratePanel.add(rateLabel);
        ratePanel.add(rateField);
        inputPanel.add(ratePanel);

        JPanel timePanel = new JPanel();
        timePanel.setLayout(new BoxLayout(timePanel, BoxLayout.X_AXIS));
        timePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel timeLabel = new JLabel("Time: ");
        timeLabel.setFont(labelFont);
        timeField = new JTextField(10);
        timeField.setFont(textFieldFont);
        timePanel.add(timeLabel);
        timePanel.add(timeField);
        inputPanel.add(timePanel);

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
                double initialAmount = Double.parseDouble(initialAmountField.getText());
                double rate = Double.parseDouble(rateField.getText()) / 100;
                int time = Integer.parseInt(timeField.getText());
                double result = initialAmount * Math.pow((1 + rate), time); // Exponential growth
                
                resultLabel.setText(String.format("Result: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}