import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class WattConverter extends JPanel {
    // **Watt Converter**
    private JTextField field1;
    private JLabel resultLabel;

    public WattConverter(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        JLabel calculatorLabel = new JLabel("Watt Converter");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel wattPanel = new JPanel();
        wattPanel.setLayout(new BoxLayout(wattPanel, BoxLayout.X_AXIS));
        wattPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel wattLabel = new JLabel("Watts: ");
        wattLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        wattPanel.add(wattLabel);
        wattPanel.add(field1);
        inputPanel.add(wattPanel);

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
                double watts = Double.parseDouble(field1.getText());
                double horsepower = watts / 745.7;
                double kilowatts = watts / 1000;
                resultLabel.setText(String.format("Horsepower: %.2f, Kilowatts: %.2f", horsepower, kilowatts));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}