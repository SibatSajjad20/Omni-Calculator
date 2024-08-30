import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ScreenTimeCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JLabel resultLabel;

    public ScreenTimeCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Screen Time Calculator**
        JLabel calculatorLabel = new JLabel("Screen Time Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel hoursPanel = new JPanel();
        hoursPanel.setLayout(new BoxLayout(hoursPanel, BoxLayout.X_AXIS));
        hoursPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel hoursLabel = new JLabel("Hours: ");
        hoursLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        hoursPanel.add(hoursLabel);
        hoursPanel.add(field1);
        inputPanel.add(hoursPanel);

        JPanel minutesPanel = new JPanel();
        minutesPanel.setLayout(new BoxLayout(minutesPanel, BoxLayout.X_AXIS));
        minutesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel minutesLabel = new JLabel("Minutes: ");
        minutesLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        minutesPanel.add(minutesLabel);
        minutesPanel.add(field2);
        inputPanel.add(minutesPanel);

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
                int hours = Integer.parseInt(field1.getText());
                int minutes = Integer.parseInt(field2.getText());
                int result = hours * 60 + minutes;
                resultLabel.setText(String.format("Screen Time: %d minutes", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}