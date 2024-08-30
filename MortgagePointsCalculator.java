import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MortgagePointsCalculator extends JPanel {
    private JTextField mortgageAmountField;
    private JTextField pointsRateField;
    private JLabel resultLabel;

    public MortgagePointsCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Mortgage Points Calculator**
        JLabel calculatorLabel = new JLabel("Mortgage Points Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel mortgageAmountPanel = new JPanel();
        mortgageAmountPanel.setLayout(new BoxLayout(mortgageAmountPanel, BoxLayout.X_AXIS));
        mortgageAmountPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel mortgageAmountLabel = new JLabel("Mortgage Amount: ");
        mortgageAmountLabel.setFont(labelFont);
        mortgageAmountField = new JTextField(10);
        mortgageAmountField.setFont(textFieldFont);
        mortgageAmountPanel.add(mortgageAmountLabel);
        mortgageAmountPanel.add(mortgageAmountField);
        inputPanel.add(mortgageAmountPanel);

        JPanel pointsRatePanel = new JPanel();
        pointsRatePanel.setLayout(new BoxLayout(pointsRatePanel, BoxLayout.X_AXIS));
        pointsRatePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel pointsRateLabel = new JLabel("Points Rate (%): ");
        pointsRateLabel.setFont(labelFont);
        pointsRateField = new JTextField(10);
        pointsRateField.setFont(textFieldFont);
        pointsRatePanel.add(pointsRateLabel);
        pointsRatePanel.add(pointsRateField);
        inputPanel.add(pointsRatePanel);

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

        resultLabel = new JLabel("Mortgage Points: ");
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
                double mortgageAmount = Double.parseDouble(mortgageAmountField.getText());
                double pointsRate = Double.parseDouble(pointsRateField.getText());
                double result = (mortgageAmount * pointsRate) / 100;
                resultLabel.setText(String.format("Mortgage Points: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}