import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SignalToNoiseRatioCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JLabel resultLabel;

    public SignalToNoiseRatioCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Signal to Noise Ratio Calculator**
        JLabel calculatorLabel = new JLabel("Signal to Noise Ratio Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel signalPowerPanel = new JPanel();
        signalPowerPanel.setLayout(new BoxLayout(signalPowerPanel, BoxLayout.X_AXIS));
        signalPowerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel signalPowerLabel = new JLabel("Signal Power: ");
        signalPowerLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        signalPowerPanel.add(signalPowerLabel);
        signalPowerPanel.add(field1);
        inputPanel.add(signalPowerPanel);

        JPanel noisePowerPanel = new JPanel();
        noisePowerPanel.setLayout(new BoxLayout(noisePowerPanel, BoxLayout.X_AXIS));
        noisePowerPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel noisePowerLabel = new JLabel("Noise Power: ");
        noisePowerLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        noisePowerPanel.add(noisePowerLabel);
        noisePowerPanel.add(field2);
        inputPanel.add(noisePowerPanel);

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
                double signalPower = Double.parseDouble(field1.getText());
                double noisePower = Double.parseDouble(field2.getText());
                double result = 10 * Math.log10(signalPower / noisePower);
                resultLabel.setText(String.format("Signal to Noise Ratio: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}