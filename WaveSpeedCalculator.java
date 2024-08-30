import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class WaveSpeedCalculator extends JPanel {
    // **Wave Speed Calculator**
    private JTextField field1;
    private JTextField field2;
    private JLabel resultLabel;

    public WaveSpeedCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);
        JLabel calculatorLabel = new JLabel("Wave Speed Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);
        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel frequencyPanel = new JPanel();
        frequencyPanel.setLayout(new BoxLayout(frequencyPanel, BoxLayout.X_AXIS));
        frequencyPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel frequencyLabel = new JLabel("Frequency: ");
        frequencyLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        frequencyPanel.add(frequencyLabel);
        frequencyPanel.add(field1);
        inputPanel.add(frequencyPanel);

        JPanel wavelengthPanel = new JPanel();
        wavelengthPanel.setLayout(new BoxLayout(wavelengthPanel, BoxLayout.X_AXIS));
        wavelengthPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel wavelengthLabel = new JLabel("Wavelength: ");
        wavelengthLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        wavelengthPanel.add(wavelengthLabel);
        wavelengthPanel.add(field2);
        inputPanel.add(wavelengthPanel);

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

        resultLabel = new JLabel("Wave Speed: ");
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
                double frequency = Double.parseDouble(field1.getText());
                double wavelength = Double.parseDouble(field2.getText());
                double result = frequency * wavelength; 
                resultLabel.setText(String.format("Wave Speed: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}