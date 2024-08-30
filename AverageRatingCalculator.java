import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

class AverageRatingCalculator extends JPanel {
    private JTextField field1;
    private JLabel resultLabel;

    public AverageRatingCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Create input panel with grid layout
        JPanel inputPanel = new JPanel(new GridLayout(1, 2));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JLabel calculatorLabel = new JLabel("Average Rating Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);
        inputPanel.add(new JLabel("Ratings (comma separated):"));
        field1 = new JTextField();
        inputPanel.add(field1);

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
            if (component instanceof JLabel) {
                ((JLabel) component).setFont(labelFont);
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
                String[] ratings = field1.getText().split(",");
                double[] doubleRatings = Arrays.stream(ratings).mapToDouble(Double::parseDouble).toArray();
                double result = Arrays.stream(doubleRatings).average().orElse(0);
                resultLabel.setText(String.format("Average Rating: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}