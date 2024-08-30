import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BowlingAverageCalculator extends JPanel {
    private JTextField runsConcededField;
    private JTextField wicketsTakenField;
    private JLabel resultLabel;

    public BowlingAverageCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Bowling Average Calculator**
        JLabel calculatorLabel = new JLabel("Bowling Average Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel runsConcededPanel = new JPanel();
        runsConcededPanel.setLayout(new BoxLayout(runsConcededPanel, BoxLayout.X_AXIS));
        runsConcededPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel runsConcededLabel = new JLabel("Runs Conceded: ");
        runsConcededLabel.setFont(labelFont);
        runsConcededField = new JTextField(10);
        runsConcededField.setFont(textFieldFont);
        runsConcededPanel.add(runsConcededLabel);
        runsConcededPanel.add(runsConcededField);
        inputPanel.add(runsConcededPanel);

        JPanel wicketsTakenPanel = new JPanel();
        wicketsTakenPanel.setLayout(new BoxLayout(wicketsTakenPanel, BoxLayout.X_AXIS));
        wicketsTakenPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel wicketsTakenLabel = new JLabel("Wickets Taken: ");
        wicketsTakenLabel.setFont(labelFont);
        wicketsTakenField = new JTextField(10);
        wicketsTakenField.setFont(textFieldFont);
        wicketsTakenPanel.add(wicketsTakenLabel);
        wicketsTakenPanel.add(wicketsTakenField);
        inputPanel.add(wicketsTakenPanel);

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
                int runsConceded = Integer.parseInt(runsConcededField.getText());
                int wicketsTaken = Integer.parseInt(wicketsTakenField.getText());
                if (wicketsTaken == 0) {
                    throw new ArithmeticException("Wickets taken cannot be 0");
                }
                double bowlingAverage = calculateBowlingAverage(runsConceded, wicketsTaken);
                updateResultLabel(bowlingAverage);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            } catch (ArithmeticException ex) {
                resultLabel.setText("Wickets taken cannot be 0.");
            }
        }
    }

    private double calculateBowlingAverage(int runsConceded, int wicketsTaken) {
        return (double) runsConceded / wicketsTaken; // Bowling average
    }

    private void updateResultLabel(double bowlingAverage) {
        resultLabel.setText(String.format("Bowling Average: %.2f", bowlingAverage));
    }
}