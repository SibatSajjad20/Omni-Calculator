import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class KarvonenFormulaCalculator extends JPanel {
    private JTextField ageField;
    private JTextField restingHeartRateField;
    private JTextField intensityField;
    private JLabel resultLabel;

    public KarvonenFormulaCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Karvonen Formula Calculator");
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

        JPanel restingHeartRatePanel = new JPanel();
        restingHeartRatePanel.setLayout(new BoxLayout(restingHeartRatePanel, BoxLayout.X_AXIS));
        restingHeartRatePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel restingHeartRateLabel = new JLabel("Resting Heart Rate (bpm): ");
        restingHeartRateLabel.setFont(labelFont);
        restingHeartRateField = new JTextField(10);
        restingHeartRateField.setFont(textFieldFont);
        restingHeartRatePanel.add(restingHeartRateLabel);
        restingHeartRatePanel.add(restingHeartRateField);
        inputPanel.add(restingHeartRatePanel);

        JPanel intensityPanel = new JPanel();
        intensityPanel.setLayout(new BoxLayout(intensityPanel, BoxLayout.X_AXIS));
        intensityPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel intensityLabel = new JLabel("Intensity (%): ");
        intensityLabel.setFont(labelFont);
        intensityField = new JTextField(10);
        intensityField.setFont(textFieldFont);
        intensityPanel.add(intensityLabel);
        intensityPanel.add(intensityField);
        inputPanel.add(intensityPanel);

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

        resultLabel = new JLabel("Target Heart Rate: ");
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
                int restingHeartRate = Integer.parseInt(restingHeartRateField.getText());
                double intensity = Double.parseDouble(intensityField.getText()) / 100;
                int maxHeartRate = 220 - age;
                double result = ((maxHeartRate - restingHeartRate) * intensity) + restingHeartRate;
                resultLabel.setText(String.format("Target Heart Rate: %.2f bpm", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}