import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AccuracyCalculator extends JPanel {
    private JTextField truePositivesField;
    private JTextField trueNegativesField;
    private JTextField falsePositivesField;
    private JTextField falseNegativesField;
    private JLabel resultLabel;

    public AccuracyCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add heading
        JLabel heading = new JLabel("Accuracy Calculator");
        heading.setFont(new Font("Poppins", Font.BOLD, 24));
        add(heading, BorderLayout.NORTH);

        // Create input panel with grid layout
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        inputPanel.add(new JLabel("True Positives:"));
        truePositivesField = new JTextField();
        inputPanel.add(truePositivesField);

        inputPanel.add(new JLabel("True Negatives:"));
        trueNegativesField = new JTextField();
        inputPanel.add(trueNegativesField);

        inputPanel.add(new JLabel("False Positives:"));
        falsePositivesField = new JTextField();
        inputPanel.add(falsePositivesField);

        inputPanel.add(new JLabel("False Negatives:"));
        falseNegativesField = new JTextField();
        inputPanel.add(falseNegativesField);

        add(inputPanel, BorderLayout.CENTER);

        // Create button panel with flow layout
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        resultLabel = new JLabel("Result: ");
        buttonPanel.add(resultLabel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Set font and style for labels and buttons
        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font buttonFont = new Font("Poppins", Font.BOLD, 18);

        for (Component component : inputPanel.getComponents()) {
            if (component instanceof JTextField) {
                ((JTextField) component).setFont(labelFont);
            }
        }

        for (Component component : buttonPanel.getComponents()) {
            if (component instanceof JButton) {
                ((JButton) component).setFont(buttonFont);
            } else if (component instanceof JLabel) {
                ((JLabel) component).setFont(labelFont);
            }
        }
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int truePositives = Integer.parseInt(truePositivesField.getText());
                int trueNegatives = Integer.parseInt(trueNegativesField.getText());
                int falsePositives = Integer.parseInt(falsePositivesField.getText());
                int falseNegatives = Integer.parseInt(falseNegativesField.getText());
                double result = (double) (truePositives + trueNegatives) / (truePositives + trueNegatives + falsePositives + falseNegatives);
                resultLabel.setText(String.format("Accuracy: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}