import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GroundSpeedCalculator extends JPanel {
    private JTextField airSpeedField;
    private JTextField windSpeedField;
    private JTextField windAngleField;
    private JLabel resultLabel;

    public GroundSpeedCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Ground Speed Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel airSpeedPanel = new JPanel();
        airSpeedPanel.setLayout(new BoxLayout(airSpeedPanel, BoxLayout.X_AXIS));
        airSpeedPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel airSpeedLabel = new JLabel("Air Speed: ");
        airSpeedLabel.setFont(labelFont);
        airSpeedField = new JTextField(10);
        airSpeedField.setFont(textFieldFont);
        airSpeedPanel.add(airSpeedLabel);
        airSpeedPanel.add(airSpeedField);
        inputPanel.add(airSpeedPanel);

        JPanel windSpeedPanel = new JPanel();
        windSpeedPanel.setLayout(new BoxLayout(windSpeedPanel, BoxLayout.X_AXIS));
        windSpeedPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel windSpeedLabel = new JLabel("Wind Speed: ");
        windSpeedLabel.setFont(labelFont);
        windSpeedField = new JTextField(10);
        windSpeedField.setFont(textFieldFont);
        windSpeedPanel.add(windSpeedLabel);
        windSpeedPanel.add(windSpeedField);
        inputPanel.add(windSpeedPanel);

        JPanel windAnglePanel = new JPanel();
        windAnglePanel.setLayout(new BoxLayout(windAnglePanel, BoxLayout.X_AXIS));
        windAnglePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel windAngleLabel = new JLabel("Wind Angle (degrees): ");
        windAngleLabel.setFont(labelFont);
        windAngleField = new JTextField(10);
        windAngleField.setFont(textFieldFont);
        windAnglePanel.add(windAngleLabel);
        windAnglePanel.add(windAngleField);
        inputPanel.add(windAnglePanel);

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
                double airSpeed = Double.parseDouble(airSpeedField.getText());
                double windSpeed = Double.parseDouble(windSpeedField.getText());
                double windAngle = Math.toRadians(Double.parseDouble(windAngleField.getText()));
                double result = airSpeed + windSpeed * Math.cos(windAngle); // Ground speed formula
                resultLabel.setText(String.format("Ground Speed: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}