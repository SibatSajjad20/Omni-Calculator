import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NetWorthCalculator extends JPanel {
    private JTextField assetField;
    private JTextField liabilityField;
    private JLabel resultLabel;

    public NetWorthCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Net Worth Calculator**
        JLabel calculatorLabel = new JLabel("Net Worth Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel assetPanel = new JPanel();
        assetPanel.setLayout(new BoxLayout(assetPanel, BoxLayout.X_AXIS));
        assetPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel assetLabel = new JLabel("Total Assets: ");
        assetLabel.setFont(labelFont);
        assetField = new JTextField(10);
        assetField.setFont(textFieldFont);
        assetPanel.add(assetLabel);
        assetPanel.add(assetField);
        inputPanel.add(assetPanel);

        JPanel liabilityPanel = new JPanel();
        liabilityPanel.setLayout(new BoxLayout(liabilityPanel, BoxLayout.X_AXIS));
        liabilityPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel liabilityLabel = new JLabel("Total Liabilities: ");
        liabilityLabel.setFont(labelFont);
        liabilityField = new JTextField(10);
        liabilityField.setFont(textFieldFont);
        liabilityPanel.add(liabilityLabel);
        liabilityPanel.add(liabilityField);
        inputPanel.add(liabilityPanel);

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

        resultLabel = new JLabel("Net Worth: ");
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
                double assets = Double.parseDouble(assetField.getText());
                double liabilities = Double.parseDouble(liabilityField.getText());
                double result = assets - liabilities;
                resultLabel.setText(String.format("Net Worth: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}