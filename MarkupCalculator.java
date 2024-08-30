import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MarkupCalculator extends JPanel {
    private JTextField costPriceField;
    private JTextField sellingPriceField;
    private JLabel resultLabel;

    public MarkupCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Markup Calculator**
        JLabel calculatorLabel = new JLabel("Markup Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel costPricePanel = new JPanel();
        costPricePanel.setLayout(new BoxLayout(costPricePanel, BoxLayout.X_AXIS));
        costPricePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel costPriceLabel = new JLabel("Cost Price: ");
        costPriceLabel.setFont(labelFont);
        costPriceField = new JTextField(20);
        costPriceField.setFont(textFieldFont);
        costPricePanel.add(costPriceLabel);
        costPricePanel.add(costPriceField);
        inputPanel.add(costPricePanel);

        JPanel sellingPricePanel = new JPanel();
        sellingPricePanel.setLayout(new BoxLayout(sellingPricePanel, BoxLayout.X_AXIS));
        sellingPricePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel sellingPriceLabel = new JLabel("Selling Price: ");
        sellingPriceLabel.setFont(labelFont);
        sellingPriceField = new JTextField(20);
        sellingPriceField.setFont(textFieldFont);
        sellingPricePanel.add(sellingPriceLabel);
        sellingPricePanel.add(sellingPriceField);
        inputPanel.add(sellingPricePanel);

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

        resultLabel = new JLabel("Markup in percentage: ");
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
                double costPrice = Double.parseDouble(costPriceField.getText());
                double sellingPrice = Double.parseDouble(sellingPriceField.getText());
                double result = ((sellingPrice - costPrice) / costPrice) * 100; // Result 
                resultLabel.setText(String.format("Markup in percentage: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}