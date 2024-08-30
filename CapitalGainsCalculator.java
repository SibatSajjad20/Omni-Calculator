import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CapitalGainsCalculator extends JPanel {
    private JTextField originalPriceField;
    private JTextField sellingPriceField;
    private JLabel resultLabel;

    public CapitalGainsCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        JPanel headingPanel = new JPanel();
        JLabel headingLabel = new JLabel("Capital Gains Calculator");
        headingLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        headingPanel.add(headingLabel);
        add(headingPanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel originalPricePanel = new JPanel();
        originalPricePanel.setLayout(new BoxLayout(originalPricePanel, BoxLayout.X_AXIS));
        originalPricePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel originalPriceLabel = new JLabel("Original Price: ");
        originalPriceLabel.setFont(labelFont);
        originalPriceField = new JTextField(10);
        originalPriceField.setFont(textFieldFont);
        originalPricePanel.add(originalPriceLabel);
        originalPricePanel.add(originalPriceField);
        inputPanel.add(originalPricePanel);

        JPanel sellingPricePanel = new JPanel();
        sellingPricePanel.setLayout(new BoxLayout(sellingPricePanel, BoxLayout.X_AXIS));
        sellingPricePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel sellingPriceLabel = new JLabel("Selling Price: ");
        sellingPriceLabel.setFont(labelFont);
        sellingPriceField = new JTextField(10);
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

        resultLabel = new JLabel("Capital Gains: ");
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
                double originalPrice = Double.parseDouble(originalPriceField.getText());
                double sellingPrice = Double.parseDouble(sellingPriceField.getText());
                if (originalPrice <= 0) {
                    resultLabel.setText("Please enter a positive number for the original price.");
                } else if (sellingPrice <= 0) {
                    resultLabel.setText("Please enter a positive number for the selling price.");
                } else {
                    double capitalGains = sellingPrice - originalPrice;
                    resultLabel.setText(String.format("Capital Gains: %.2f", capitalGains));
                }
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}