import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CramersRuleCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JLabel resultLabel;

    public CramersRuleCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // Add a heading
        JLabel heading = new JLabel("Cramer's Rule Calculator");
        heading.setFont(new Font("Poppins", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        add(inputPanel, BorderLayout.CENTER);

        inputPanel.add(new JLabel("Field 1:"));
        field1 = new JTextField(10);
        inputPanel.add(field1);

        inputPanel.add(new JLabel("Field 2:"));
        field2 = new JTextField(10);
        inputPanel.add(field2);

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
                double value1 = Double.parseDouble(field1.getText());
                double value2 = Double.parseDouble(field2.getText());
                double result = value1 * value2; // Modify this line according to your formula
                resultLabel.setText(String.format("Result: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}