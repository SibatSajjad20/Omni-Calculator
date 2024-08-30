import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CholesterolRatioCalculator extends JPanel {
    private JTextField totalCholesterolField;
    private JTextField hdlCholesterolField;
    private JLabel resultLabel;

    public CholesterolRatioCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // **Cholesterol Ratio Calculator**
        JLabel calculatorLabel = new JLabel("Cholesterol Ratio Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel totalCholesterolPanel = new JPanel();
        totalCholesterolPanel.setLayout(new BoxLayout(totalCholesterolPanel, BoxLayout.X_AXIS));
        totalCholesterolPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel totalCholesterolLabel = new JLabel("Total Cholesterol (mg/dL): ");
        totalCholesterolLabel.setFont(labelFont);
        totalCholesterolField = new JTextField(10);
        totalCholesterolField.setFont(textFieldFont);
        totalCholesterolPanel.add(totalCholesterolLabel);
        totalCholesterolPanel.add(totalCholesterolField);
        inputPanel.add(totalCholesterolPanel);

        JPanel hdlCholesterolPanel = new JPanel();
        hdlCholesterolPanel.setLayout(new BoxLayout(hdlCholesterolPanel, BoxLayout.X_AXIS));
        hdlCholesterolPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel hdlCholesterolLabel = new JLabel("HDL Cholesterol (mg/dL): ");
        hdlCholesterolLabel.setFont(labelFont);
        hdlCholesterolField = new JTextField(10);
        hdlCholesterolField.setFont(textFieldFont);
        hdlCholesterolPanel.add(hdlCholesterolLabel);
        hdlCholesterolPanel.add(hdlCholesterolField);
        inputPanel.add(hdlCholesterolPanel);

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

        resultLabel = new JLabel("Cholesterol Ratio: ");
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
                double totalCholesterol = Double.parseDouble(totalCholesterolField.getText());
                double hdlCholesterol = Double.parseDouble(hdlCholesterolField.getText());
                int wholeNumber = (int) Math.round(totalCholesterol / hdlCholesterol);
                resultLabel.setText(String.format("Cholesterol Ratio: %d:%d", wholeNumber, 1));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}