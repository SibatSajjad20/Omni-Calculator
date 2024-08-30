import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ROICalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JLabel resultLabel;

    public ROICalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Return on Investment (ROI) Calculator**
        JLabel calculatorLabel = new JLabel("Return on Investment (ROI) Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel investmentGainPanel = new JPanel();
        investmentGainPanel.setLayout(new BoxLayout(investmentGainPanel, BoxLayout.X_AXIS));
        investmentGainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel investmentGainLabel = new JLabel("Investment Gain: ");
        investmentGainLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        investmentGainPanel.add(investmentGainLabel);
        investmentGainPanel.add(field1);
        inputPanel.add(investmentGainPanel);

        JPanel investmentCostPanel = new JPanel();
        investmentCostPanel.setLayout(new BoxLayout(investmentCostPanel, BoxLayout.X_AXIS));
        investmentCostPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel investmentCostLabel = new JLabel("Investment Cost: ");
        investmentCostLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        investmentCostPanel.add(investmentCostLabel);
        investmentCostPanel.add(field2);
        inputPanel.add(investmentCostPanel);

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
                double investmentGain = Double.parseDouble(field1.getText());
                double investmentCost = Double.parseDouble(field2.getText());
                double result = (investmentGain - investmentCost) / investmentCost * 100; // Result in percentage ROI
                
                resultLabel.setText(String.format("Percentage ROI: %.2f%%", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}