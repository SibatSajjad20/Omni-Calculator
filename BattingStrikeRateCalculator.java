import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BattingStrikeRateCalculator extends JPanel {
    private JTextField runsField;
    private JTextField ballsFacedField;
    private JLabel resultLabel;

    public BattingStrikeRateCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Batting Strike Rate Calculator**
        JLabel calculatorLabel = new JLabel("Batting Strike Rate Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel runsPanel = new JPanel();
        runsPanel.setLayout(new BoxLayout(runsPanel, BoxLayout.X_AXIS));
        runsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel runsLabel = new JLabel("Runs: ");
        runsLabel.setFont(labelFont);
        runsField = new JTextField(10);
        runsField.setFont(textFieldFont);
        runsPanel.add(runsLabel);
        runsPanel.add(runsField);
        inputPanel.add(runsPanel);

        JPanel ballsFacedPanel = new JPanel();
        ballsFacedPanel.setLayout(new BoxLayout(ballsFacedPanel, BoxLayout.X_AXIS));
        ballsFacedPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel ballsFacedLabel = new JLabel("Balls Faced: ");
        ballsFacedLabel.setFont(labelFont);
        ballsFacedField = new JTextField(10);
        ballsFacedField.setFont(textFieldFont);
        ballsFacedPanel.add(ballsFacedLabel);
        ballsFacedPanel.add(ballsFacedField);
        inputPanel.add(ballsFacedPanel);

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
                int runs = Integer.parseInt(runsField.getText());
                int ballsFaced = Integer.parseInt(ballsFacedField.getText());
                if (ballsFaced == 0) {
                    throw new ArithmeticException("Balls faced cannot be 0");
                }
                double strikeRate = calculateStrikeRate(runs, ballsFaced);
                updateResultLabel(strikeRate);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            } catch (ArithmeticException ex) {
                resultLabel.setText("Balls faced cannot be 0.");
            }
        }
    }

    private double calculateStrikeRate(int runs, int ballsFaced) {
        return (double) runs / ballsFaced * 100; // Strike rate
    }

    private void updateResultLabel(double strikeRate) {
        resultLabel.setText(String.format("Batting Strike Rate: %.2f", strikeRate));
    }
}