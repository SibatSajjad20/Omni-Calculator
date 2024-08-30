import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SleepDurationCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JTextField field4;
    private JLabel resultLabel;

    public SleepDurationCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Sleep Duration Calculator**
        JLabel calculatorLabel = new JLabel("Sleep Duration Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel sleepTimePanel = new JPanel();
        sleepTimePanel.setLayout(new BoxLayout(sleepTimePanel, BoxLayout.X_AXIS));
        sleepTimePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel sleepTimeLabel = new JLabel("Sleep time: ");
        sleepTimeLabel.setFont(labelFont);
        JPanel sleepHourPanel = new JPanel();
        sleepHourPanel.setLayout(new BoxLayout(sleepHourPanel, BoxLayout.X_AXIS));
        JLabel sleepHourLabel = new JLabel("Hour: ");
        sleepHourLabel.setFont(labelFont);
        field1 = new JTextField(5);
        field1.setFont(textFieldFont);
        sleepHourPanel.add(sleepHourLabel);
        sleepHourPanel.add(field1);
        JPanel sleepMinutePanel = new JPanel();
        sleepMinutePanel.setLayout(new BoxLayout(sleepMinutePanel, BoxLayout.X_AXIS));
        JLabel sleepMinuteLabel = new JLabel("Minute: ");
        sleepMinuteLabel.setFont(labelFont);
        field2 = new JTextField(5);
        field2.setFont(textFieldFont);
        sleepMinutePanel.add(sleepMinuteLabel);
        sleepMinutePanel.add(field2);
        sleepTimePanel.add(sleepTimeLabel);
        sleepTimePanel.add(sleepHourPanel);
        sleepTimePanel.add(sleepMinutePanel);
        inputPanel.add(sleepTimePanel);

        JPanel wakeTimePanel = new JPanel();
        wakeTimePanel.setLayout(new BoxLayout(wakeTimePanel, BoxLayout.X_AXIS));
        wakeTimePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel wakeTimeLabel = new JLabel("Wake time: ");
        wakeTimeLabel.setFont(labelFont);
        JPanel wakeHourPanel = new JPanel();
        wakeHourPanel.setLayout(new BoxLayout(wakeHourPanel, BoxLayout.X_AXIS));
        JLabel wakeHourLabel = new JLabel("Hour: ");
        wakeHourLabel.setFont(labelFont);
        field3 = new JTextField(5);
        field3.setFont(textFieldFont);
        wakeHourPanel.add(wakeHourLabel);
        wakeHourPanel.add(field3);
        JPanel wakeMinutePanel = new JPanel();
        wakeMinutePanel.setLayout(new BoxLayout(wakeMinutePanel, BoxLayout.X_AXIS));
        JLabel wakeMinuteLabel = new JLabel("Minute: ");
        wakeMinuteLabel.setFont(labelFont);
        field4 = new JTextField(5);
        field4.setFont(textFieldFont);
        wakeMinutePanel.add(wakeMinuteLabel);
        wakeMinutePanel.add(field4);
        wakeTimePanel.add(wakeTimeLabel);
        wakeTimePanel.add(wakeHourPanel);
        wakeTimePanel.add(wakeMinutePanel);
        inputPanel.add(wakeTimePanel);

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
                int sleepHour = Integer.parseInt(field1.getText());
                int sleepMinute = Integer.parseInt(field2.getText());
                int wakeHour = Integer.parseInt(field3.getText());
                int wakeMinute = Integer.parseInt(field4.getText());
                int result = ((wakeHour * 60 + wakeMinute) - (sleepHour * 60 + sleepMinute) + 1440) % 1440;
resultLabel.setText(String.format("Result: %.2f", result));
} catch (NumberFormatException ex) {
resultLabel.setText("Please enter valid numbers.");
}
}
}
}
