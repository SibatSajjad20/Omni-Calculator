import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MilliontoBillionConverter extends JPanel {
    private JTextField moneyField;
    private JLabel resultLabel;

    public MilliontoBillionConverter(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Million to Billion Converter**
        JLabel converterLabel = new JLabel("Million to Billion Converter");
        converterLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        converterLabel.setHorizontalAlignment(JLabel.CENTER);
        add(converterLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel moneyPanel = new JPanel();
        moneyPanel.setLayout(new BoxLayout(moneyPanel, BoxLayout.X_AXIS));
        moneyPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel moneyLabel = new JLabel("Money (million): ");
        moneyLabel.setFont(labelFont);
        moneyField = new JTextField(20);
        moneyField.setFont(textFieldFont);
        moneyPanel.add(moneyLabel);
        moneyPanel.add(moneyField);
        inputPanel.add(moneyPanel);

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

        resultLabel = new JLabel("Money (billion): ");
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
                double money = Double.parseDouble(moneyField.getText());
                double result = money / 1000;
                resultLabel.setText(String.format("Money (billion): %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}