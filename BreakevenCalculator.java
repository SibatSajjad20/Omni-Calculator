import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BreakevenCalculator extends JPanel {
    private JTextField lengthField;
    private JTextField widthField;
    private JTextField varcostField;
    private JLabel resultLabel;

    public BreakevenCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        JPanel headingPanel = new JPanel();
        JLabel headingLabel = new JLabel("Break-Even Calculator");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headingPanel.add(headingLabel);
        add(headingPanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Fixed Cost (PKR):"));
        lengthField = new JTextField();
        inputPanel.add(lengthField);

        inputPanel.add(new JLabel("Revenue per Unit (PKR):"));
        widthField = new JTextField();
        inputPanel.add(widthField);

        inputPanel.add(new JLabel("Variable Cost per Unit (PKR):"));
        varcostField = new JTextField();
        inputPanel.add(varcostField);

        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);

        resultLabel = new JLabel("Break-Even: ");
        add(resultLabel, BorderLayout.EAST);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double fixedCost = Double.parseDouble(lengthField.getText());
                double rev = Double.parseDouble(widthField.getText());
                double varcost = Double.parseDouble(varcostField.getText());
                double result = fixedCost / (rev - varcost);
                resultLabel.setText(String.format("Break-even (points): %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}