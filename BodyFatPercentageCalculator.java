import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BodyFatPercentageCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JLabel resultLabel;

    public BodyFatPercentageCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        JPanel headingPanel = new JPanel();
        JLabel headingLabel = new JLabel("Body Fat Percentage Calculator");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headingPanel.add(headingLabel);
        add(headingPanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Waist Circumference (inches):"));
        field1 = new JTextField();
        inputPanel.add(field1);

        inputPanel.add(new JLabel("Hip Circumference (inches):"));
        field2 = new JTextField();
        inputPanel.add(field2);

        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);

        resultLabel = new JLabel("Result: ");
        add(resultLabel, BorderLayout.EAST);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double waist = Double.parseDouble(field1.getText());
                double hip = Double.parseDouble(field2.getText());
                double result = 495 / (1.295 - 0.350 * Math.log10(waist - hip) + 0.221 * Math.log10(waist));

                resultLabel.setText(String.format("Body Fat Percentage: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}