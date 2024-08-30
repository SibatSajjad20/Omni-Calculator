import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LBMCalculator extends JPanel {
    private JTextField weightField;
    private JTextField bodyFatPercentageField;
    private JLabel resultLabel;

    public LBMCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Lean Body Mass Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

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

        JPanel bodyFatPercentagePanel = new JPanel();
        bodyFatPercentagePanel.setLayout(new BoxLayout(bodyFatPercentagePanel, BoxLayout.X_AXIS));
        bodyFatPercentagePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel bodyFatPercentageLabel = new JLabel("Body Fat Percentage (%): ");
        bodyFatPercentageLabel.setFont(labelFont);
        bodyFatPercentageField = new JTextField(10);
        bodyFatPercentageField.setFont(textFieldFont);
        bodyFatPercentagePanel.add(bodyFatPercentageLabel);
        bodyFatPercentagePanel.add(bodyFatPercentageField);
        inputPanel.add(bodyFatPercentagePanel);

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

        resultLabel = new JLabel("Lean Body Mass: ");
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
                double bodyFatPercentage = Double.parseDouble(bodyFatPercentageField.getText()) / 100;
                double result = weight * (1 - bodyFatPercentage); // Lean Body Mass
                
                resultLabel.setText(String.format("Lean Body Mass: %.2f kg", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}