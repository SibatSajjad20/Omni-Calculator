import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class BattingAverageCalculator extends JPanel {
    private JTextField runsScoredField;
    private JTextField timesOutField;
    private JLabel resultLabel;

    public BattingAverageCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Heading
        JLabel heading = new JLabel("Batting Average Calculator");
        heading.setFont(new Font("Poppins", Font.BOLD, 24));
        add(heading, BorderLayout.NORTH);

        // Input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        add(inputPanel, BorderLayout.CENTER);

        inputPanel.add(new JLabel("Runs Scored:"));
        runsScoredField = new JTextField();
        inputPanel.add(runsScoredField);

        inputPanel.add(new JLabel("Times Out:"));
        timesOutField = new JTextField();
        inputPanel.add(timesOutField);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2));
        add(buttonPanel, BorderLayout.SOUTH);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        resultLabel = new JLabel("Average : ");
        buttonPanel.add(resultLabel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double runsScored = Double.parseDouble(runsScoredField.getText());
                double timesOut = Double.parseDouble(timesOutField.getText());
                double avg = runsScored / timesOut;
                resultLabel.setText(String.format("Average: %.2f", avg));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}
