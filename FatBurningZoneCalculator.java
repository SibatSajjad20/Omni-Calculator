import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class FatBurningZoneCalculator extends JPanel {
    private JTextField feetTextField;
    private JTextField inchesTextField;
    private JLabel resultLabel;

    public FatBurningZoneCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // **Fat Burning Zone Calculator**
        JLabel calculatorLabel = new JLabel("Fat Burning Zone Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel feetPanel = new JPanel();
        feetPanel.setLayout(new BoxLayout(feetPanel, BoxLayout.X_AXIS));
        feetPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel feetLabel = new JLabel("Enter feet: ");
        feetLabel.setFont(labelFont);
        feetTextField = new JTextField(10);
        feetTextField.setFont(textFieldFont);
        feetPanel.add(feetLabel);
        feetPanel.add(feetTextField);
        inputPanel.add(feetPanel);

        JPanel inchesPanel = new JPanel();
        inchesPanel.setLayout(new BoxLayout(inchesPanel, BoxLayout.X_AXIS));
        inchesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel inchesLabel = new JLabel("Enter inches: ");
        inchesLabel.setFont(labelFont);
        inchesTextField = new JTextField(10);
        inchesTextField.setFont(textFieldFont);
        inchesPanel.add(inchesLabel);
        inchesPanel.add(inchesTextField);
        inputPanel.add(inchesPanel);

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

        resultLabel = new JLabel("Total Inches: ");
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
                int feet = Integer.parseInt(feetTextField.getText());
                int inches = Integer.parseInt(inchesTextField.getText());

                if (feet < 0 || inches < 0) {
                    resultLabel.setText("Invalid input values. Please enter non-negative numbers.");
                    return;
                }

                int totalInches = calculateTotalInches(feet, inches);
                updateResultLabel(totalInches);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }

    private int calculateTotalInches(int feet, int inches) {
        return feet * 12 + inches;
    }

    private void updateResultLabel(int totalInches) {
        resultLabel.setText(String.format("Total Inches: %d", totalInches));
    }
}