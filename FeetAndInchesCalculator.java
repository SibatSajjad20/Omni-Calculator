import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class FeetAndInchesCalculator extends JPanel {
    private JTextField feetField;
    private JTextField inchesField;
    private JLabel resultLabel;

    public FeetAndInchesCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing
        JLabel heading = new JLabel("Feet And Inches Calculator");
        heading.setFont(new Font("Poppins", Font.BOLD, 24));
        add(heading, BorderLayout.NORTH);
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel feetPanel = new JPanel();
        feetPanel.setLayout(new BoxLayout(feetPanel, BoxLayout.X_AXIS));
        feetPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel feetLabel = new JLabel("Feet: ");
        feetLabel.setFont(labelFont);
        feetField = new JTextField(10);
        feetField.setFont(textFieldFont);
        feetPanel.add(feetLabel);
        feetPanel.add(feetField);
        inputPanel.add(feetPanel);

        JPanel inchesPanel = new JPanel();
        inchesPanel.setLayout(new BoxLayout(inchesPanel, BoxLayout.X_AXIS));
        inchesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel inchesLabel = new JLabel("Inches: ");
        inchesLabel.setFont(labelFont);
        inchesField = new JTextField(10);
        inchesField.setFont(textFieldFont);
        inchesPanel.add(inchesLabel);
        inchesPanel.add(inchesField);
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
                int feet = Integer.parseInt(feetField.getText());
                int inches = Integer.parseInt(inchesField.getText());

                if (feet < 0 || inches < 0) {
                    resultLabel.setText("Invalid input values. Please enter non-negative numbers.");
                    return;
                }

                int totalInches = feet * 12 + inches;
                resultLabel.setText(String.format("Total Inches: %d", totalInches));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}