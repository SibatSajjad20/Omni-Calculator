import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AverageFixedCostCalculator extends JPanel {
    private JTextField totalFixedCostField;
    private JTextField numberOfUnitsField;
    private JLabel resultLabel;

    public AverageFixedCostCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        JLabel heading = new JLabel("Average Fixed Cost Calculator");
        heading.setFont(new Font("Poppins", Font.BOLD, 24));
        add(heading, BorderLayout.NORTH);
        // Create input panel with grid layout
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        inputPanel.add(new JLabel("Total Fixed Cost:"));
        totalFixedCostField = new JTextField();
        inputPanel.add(totalFixedCostField);

        inputPanel.add(new JLabel("Number of Units:"));
        numberOfUnitsField = new JTextField();
        inputPanel.add(numberOfUnitsField);

        add(inputPanel, BorderLayout.CENTER);

        // Create button panel with flow layout
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        resultLabel = new JLabel("Average Fixed Cost: ");
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
                double totalFixedCost = Double.parseDouble(totalFixedCostField.getText());
                double numberOfUnits = Double.parseDouble(numberOfUnitsField.getText());
                double averageFixedCost = totalFixedCost / numberOfUnits;
                resultLabel.setText(String.format("Average Fixed Cost: %.2f", averageFixedCost));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}