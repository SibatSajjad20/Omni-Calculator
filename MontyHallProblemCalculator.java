import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class MontyHallProblemCalculator extends JPanel {
    private JTextField trialsField;
    private JLabel resultLabel;

    public MontyHallProblemCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Monty Hall Problem Calculator**
        JLabel calculatorLabel = new JLabel("Monty Hall Problem Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel trialsPanel = new JPanel();
        trialsPanel.setLayout(new BoxLayout(trialsPanel, BoxLayout.X_AXIS));
        trialsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel trialsLabel = new JLabel("Trials: ");
        trialsLabel.setFont(labelFont);
        trialsField = new JTextField(10);
        trialsField.setFont(textFieldFont);
        trialsPanel.add(trialsLabel);
        trialsPanel.add(trialsField);
        inputPanel.add(trialsPanel);

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
                int trials = Integer.parseInt(trialsField.getText());
                Random random = new Random();
                int switchWins = 0, stayWins = 0;
                for (int i = 0; i < trials; i++) {
                    int carDoor = random.nextInt(3);
                    int chosenDoor = random.nextInt(3);
                    if (carDoor == chosenDoor) stayWins++;
                    else switchWins++;
                }
                double stayWinPercentage = (double) stayWins / trials * 100;
                double switchWinPercentage = (double) switchWins / trials * 100;

                resultLabel.setText(String.format("Monty Hall Problem: Stay wins %.2f%%, Switch wins %.2f%%", stayWinPercentage, switchWinPercentage));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}