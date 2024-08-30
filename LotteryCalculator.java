import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LotteryCalculator extends JPanel {
    private JTextField totalNumbersField;
    private JTextField numbersDrawnField;
    private JLabel resultLabel;

    private long combination(int n, int r) {
        if (r > n) return 0;
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    private long factorial(int num) {
        long result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public LotteryCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Lottery Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel totalNumbersPanel = new JPanel();
        totalNumbersPanel.setLayout(new BoxLayout(totalNumbersPanel, BoxLayout.X_AXIS));
        totalNumbersPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel totalNumbersLabel = new JLabel("Total Numbers: ");
        totalNumbersLabel.setFont(labelFont);
        totalNumbersField = new JTextField(5);
        totalNumbersField.setFont(textFieldFont);
        totalNumbersPanel.add(totalNumbersLabel);
        totalNumbersPanel.add(totalNumbersField);
        inputPanel.add(totalNumbersPanel);

        JPanel numbersDrawnPanel = new JPanel();
        numbersDrawnPanel.setLayout(new BoxLayout(numbersDrawnPanel, BoxLayout.X_AXIS));
        numbersDrawnPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel numbersDrawnLabel = new JLabel("Numbers Drawn: ");
        numbersDrawnLabel.setFont(labelFont);
        numbersDrawnField = new JTextField(5);
        numbersDrawnField.setFont(textFieldFont);
        numbersDrawnPanel.add(numbersDrawnLabel);
        numbersDrawnPanel.add(numbersDrawnField);
        inputPanel.add(numbersDrawnPanel);

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

        resultLabel = new JLabel("Lottery Probability: ");
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
                int totalNumbers = Integer.parseInt(totalNumbersField.getText());
                int numbersDrawn = Integer.parseInt(numbersDrawnField.getText());
                long combinations = combination(totalNumbers, numbersDrawn);
                double probability = 1.0 / combinations;
                resultLabel.setText(String.format("Lottery Probability: %.2f", probability));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}