import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class HeartRateZoneCalculator extends JPanel {
    private JTextField ageField;
    private JLabel resultLabel;

    public HeartRateZoneCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Heart Rate Zone Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel agePanel = new JPanel();
        agePanel.setLayout(new BoxLayout(agePanel, BoxLayout.X_AXIS));
        agePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel ageLabel = new JLabel("Age: ");
        ageLabel.setFont(labelFont);
        ageField = new JTextField(10);
        ageField.setFont(textFieldFont);
        agePanel.add(ageLabel);
        agePanel.add(ageField);
        inputPanel.add(agePanel);

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
                int age = Integer.parseInt(ageField.getText());
                int maxHeartRate = 220 - age;
                int[] heartRateZones = {
                    (int)(maxHeartRate * 0.5), // 50% of max heart rate
                    (int)(maxHeartRate * 0.6), // 60% of max heart rate
                    (int)(maxHeartRate * 0.7), // 70% of max heart rate
                    (int)(maxHeartRate * 0.8), // 80% of max heart rate
                    (int)(maxHeartRate * 0.9)  // 90% of max heart rate
                };
                resultLabel.setText(String.format("Max Heart Rate: %d%n" +
                        "Heart Rate Zones:%n" +
                        "50%%: %d%n" +
                        "60%%: %d%n" +
                        "70%%: %d%n" +
                        "80%%: %d%n" +
                        "90%%: %d", maxHeartRate, heartRateZones[0], heartRateZones[1], heartRateZones[2], heartRateZones[3], heartRateZones[4]));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}