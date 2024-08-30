import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CalorieBurnCalculator extends JPanel {
    private JTextField weightField;
    private JTextField durationField;
    private JTextField metField;
    private JLabel resultLabel;

    public CalorieBurnCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // **Calorie Burn Calculator**
        JLabel calculatorLabel = new JLabel("Calorie Burn Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel weightPanel = new JPanel();
        weightPanel.setLayout(new BoxLayout(weightPanel, BoxLayout.X_AXIS));
        weightPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel weightLabel = new JLabel("Weight (kg): ");
        weightLabel.setFont(labelFont);
        weightField = new JTextField(10);
        weightField.setFont(textFieldFont);
        weightPanel.add(weightLabel);
        weightPanel.add(weightField);
        inputPanel.add(weightPanel);

        JPanel durationPanel = new JPanel();
        durationPanel.setLayout(new BoxLayout(durationPanel, BoxLayout.X_AXIS));
        durationPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel durationLabel = new JLabel("Duration (minutes): ");
        durationLabel.setFont(labelFont);
        durationField = new JTextField(10);
        durationField.setFont(textFieldFont);
        durationPanel.add(durationLabel);
        durationPanel.add(durationField);
        inputPanel.add(durationPanel);

        JPanel metPanel = new JPanel();
        metPanel.setLayout(new BoxLayout(metPanel, BoxLayout.X_AXIS));
        metPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel metLabel = new JLabel("MET: ");
        metLabel.setFont(labelFont);
        metField = new JTextField(10);
        metField.setFont(textFieldFont);
        metPanel.add(metLabel);
        metPanel.add(metField);
        inputPanel.add(metPanel);

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

        resultLabel = new JLabel("Calorie Burn: ");
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
                double weight = Double.parseDouble(weightField.getText());
                int duration = Integer.parseInt(durationField.getText());
                double met = Double.parseDouble(metField.getText()); 

                if (weight <= 0 || duration <= 0 || met <= 0) {
                    resultLabel.setText("Invalid input values. Please enter positive numbers.");
                    return;
                }

                double calorieBurn = calculateCalorieBurn(weight, duration, met);
                updateResultLabel(calorieBurn);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }

    private double calculateCalorieBurn(double weight, int duration, double met) {
        return 0.0175 * met * weight * duration;
    }

    private void updateResultLabel(double calorieBurn) {
        resultLabel.setText(String.format("Calorie Burn: %.2f", calorieBurn));
    }
}