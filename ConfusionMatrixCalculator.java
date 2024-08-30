import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ConfusionMatrixCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JTextField field4;
    private JLabel resultLabel;

    public ConfusionMatrixCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // Add a heading
        JLabel heading = new JLabel("Confusion Matrix Calculator");
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        add(inputPanel, BorderLayout.CENTER);

        inputPanel.add(new JLabel("True Positives:"));
        field1 = new JTextField(10);
        inputPanel.add(field1);

        inputPanel.add(new JLabel("True Negatives:"));
        field2 = new JTextField(10);
        inputPanel.add(field2);

        inputPanel.add(new JLabel("False Positives:"));
        field3 = new JTextField(10);
        inputPanel.add(field3);

        inputPanel.add(new JLabel("False Negatives:"));
        field4 = new JTextField(10);
        inputPanel.add(field4);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        add(buttonPanel, BorderLayout.SOUTH);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        resultLabel = new JLabel("Result: ");
        buttonPanel.add(resultLabel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int truePositives = Integer.parseInt(field1.getText());
                int trueNegatives = Integer.parseInt(field2.getText());
                int falsePositives = Integer.parseInt(field3.getText());
                int falseNegatives = Integer.parseInt(field4.getText());
                double accuracy = (double)(truePositives + trueNegatives) / (truePositives + trueNegatives + falsePositives + falseNegatives);
                double precision = (double)truePositives / (truePositives + falsePositives);
                double recall = (double)truePositives / (truePositives + falseNegatives);
                double f1Score = 2 * (precision * recall) / (precision + recall);
                resultLabel.setText(String.format("Confusion Matrix: Accuracy=%.2f, Precision=%.2f, Recall=%.2f, F1 Score=%.2f", accuracy, precision, recall, f1Score));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}