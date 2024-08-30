import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class OddsCalculator extends JPanel {
    private JTextField probabilityField;
    private JLabel resultLabel;

    public OddsCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Odds Calculator**
        JLabel calculatorLabel = new JLabel("Odds Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel probabilityPanel = new JPanel();
        probabilityPanel.setLayout(new BoxLayout(probabilityPanel, BoxLayout.X_AXIS));
        probabilityPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel probabilityLabel = new JLabel("Probability: ");
        probabilityLabel.setFont(labelFont);
        probabilityField = new JTextField(10);
        probabilityField.setFont(textFieldFont);
        probabilityPanel.add(probabilityLabel);
        probabilityPanel.add(probabilityField);
        inputPanel.add(probabilityPanel);

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

        resultLabel = new JLabel("Odds: ");
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
                double probability = Double.parseDouble(probabilityField.getText());
                double oddsFor = probability / (1 - probability);
                double oddsAgainst = (1 - probability) / probability;
                resultLabel.setText(String.format("Odds For: %.2f, Odds Against: %.2f", oddsFor, oddsAgainst));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}