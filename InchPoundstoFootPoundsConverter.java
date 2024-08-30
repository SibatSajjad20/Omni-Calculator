import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class InchPoundstoFootPoundsConverter extends JPanel {
    private JTextField inchPoundsField;
    private JLabel resultLabel;

    public InchPoundstoFootPoundsConverter(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Inch Pounds to Foot Pounds Converter");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel inchPoundsPanel = new JPanel();
        inchPoundsPanel.setLayout(new BoxLayout(inchPoundsPanel, BoxLayout.X_AXIS));
        inchPoundsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel inchPoundsLabel = new JLabel("Inch Pounds: ");
        inchPoundsLabel.setFont(labelFont);
        inchPoundsField = new JTextField(10);
        inchPoundsField.setFont(textFieldFont);
        inchPoundsPanel.add(inchPoundsLabel);
        inchPoundsPanel.add(inchPoundsField);
        inputPanel.add(inchPoundsPanel);

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

        resultLabel = new JLabel("Foot Pounds: ");
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
                double inchPounds = Double.parseDouble(inchPoundsField.getText());
                double result = inchPounds / 12; // 1 foot pound = 12 inch pounds
                resultLabel.setText(String.format("Foot Pounds: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}