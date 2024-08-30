import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BikePaceCalculator extends JPanel {
    private JTextField distanceField;
    private JTextField timeField;
    private JLabel resultLabel;

    public BikePaceCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Bike Pace Calculator**
        JLabel calculatorLabel = new JLabel("Bike Pace Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel distancePanel = new JPanel();
        distancePanel.setLayout(new BoxLayout(distancePanel, BoxLayout.X_AXIS));
        distancePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel distanceLabel = new JLabel("Distance (km): ");
        distanceLabel.setFont(labelFont);
        distanceField = new JTextField(10);
        distanceField.setFont(textFieldFont);
        distancePanel.add(distanceLabel);
        distancePanel.add(distanceField);
        inputPanel.add(distancePanel);

        JPanel timePanel = new JPanel();
        timePanel.setLayout(new BoxLayout(timePanel, BoxLayout.X_AXIS));
        timePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel timeLabel = new JLabel("Time (hours): ");
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
                double distance = Double.parseDouble(distanceField.getText());
                double time = Double.parseDouble(timeField.getText());
                if (time == 0) {
                    throw new ArithmeticException("Time cannot be 0");
                }
                double bikePace = calculateBikePace(distance, time);
                resultLabel.setText(String.format("Bike Pace in km/h: %.2f", bikePace));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            } catch (ArithmeticException ex) {
                resultLabel.setText("Time cannot be 0.");
            }
        }
    }

    private double calculateBikePace(double distance, double time) {
        return distance / time;
    }
}