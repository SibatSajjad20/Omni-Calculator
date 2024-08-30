import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class HikingCalculator extends JPanel {
    private JTextField distanceField;
    private JTextField elevationGainField;
    private JTextField weightField;
    private JLabel resultLabel;

    public HikingCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Hiking Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel distancePanel = new JPanel();
        distancePanel.setLayout(new BoxLayout(distancePanel, BoxLayout.X_AXIS));
        distancePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel distanceLabel = new JLabel("Distance (miles): ");
        distanceLabel.setFont(labelFont);
        distanceField = new JTextField(10);
        distanceField.setFont(textFieldFont);
        distancePanel.add(distanceLabel);
        distancePanel.add(distanceField);
        inputPanel.add(distancePanel);

        JPanel elevationGainPanel = new JPanel();
        elevationGainPanel.setLayout(new BoxLayout(elevationGainPanel, BoxLayout.X_AXIS));
        elevationGainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel elevationGainLabel = new JLabel("Elevation Gain (feet): ");
        elevationGainLabel.setFont(labelFont);
        elevationGainField = new JTextField(10);
        elevationGainField.setFont(textFieldFont);
        elevationGainPanel.add(elevationGainLabel);
        elevationGainPanel.add(elevationGainField);
        inputPanel.add(elevationGainPanel);

        JPanel weightPanel = new JPanel();
        weightPanel.setLayout(new BoxLayout(weightPanel, BoxLayout.X_AXIS));
        weightPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel weightLabel = new JLabel("Weight (pounds): ");
        weightLabel.setFont(labelFont);
        weightField = new JTextField(10);
        weightField.setFont(textFieldFont);
        weightPanel.add(weightLabel);
        weightPanel.add(weightField);
        inputPanel.add(weightPanel);

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

        resultLabel = new JLabel("Calories burned: ");
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
                double distance = Double.parseDouble(distanceField.getText());
                double elevationGain = Double.parseDouble(elevationGainField.getText());
                double weight = Double.parseDouble(weightField.getText());
                double result = (distance * 0.5 + elevationGain * 1.5) * (weight / 2.2) * 0.1; // calories burned per mile

                resultLabel.setText(String.format("Calories burned: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}