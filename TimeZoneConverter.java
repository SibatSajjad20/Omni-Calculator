import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TimeZoneConverter extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JLabel resultLabel;

    public TimeZoneConverter(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Time Zone Converter**
        JLabel converterLabel = new JLabel("Time Zone Converter");
        converterLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        converterLabel.setHorizontalAlignment(JLabel.CENTER);
        add(converterLabel, BorderLayout.NORTH);

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

        JPanel offsetPanel = new JPanel();
        offsetPanel.setLayout(new BoxLayout(offsetPanel, BoxLayout.X_AXIS));
        offsetPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel offsetLabel = new JLabel("Offset: ");
        offsetLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        offsetPanel.add(offsetLabel);
        offsetPanel.add(field2);
        inputPanel.add(offsetPanel);

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
                int offset = Integer.parseInt(field2.getText());
                int result = (hours + offset + 24) % 24; // Result in new time zone hour
                
                resultLabel.setText(String.format("New Time Zone Hour: %d", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}