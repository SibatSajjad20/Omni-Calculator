import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LensFormulaCalculator extends JPanel {
    private JTextField focalLengthField;
    private JTextField objectDistanceField;
    private JLabel resultLabel;

    public LensFormulaCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Lens Formula Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel focalLengthPanel = new JPanel();
        focalLengthPanel.setLayout(new BoxLayout(focalLengthPanel, BoxLayout.X_AXIS));
        focalLengthPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel focalLengthLabel = new JLabel("Focal Length: ");
        focalLengthLabel.setFont(labelFont);
        focalLengthField = new JTextField(5);
        focalLengthField.setFont(textFieldFont);
        focalLengthPanel.add(focalLengthLabel);
        focalLengthPanel.add(focalLengthField);
        inputPanel.add(focalLengthPanel);

        JPanel objectDistancePanel = new JPanel();
        objectDistancePanel.setLayout(new BoxLayout(objectDistancePanel, BoxLayout.X_AXIS));
        objectDistancePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel objectDistanceLabel = new JLabel("Object Distance: ");
        objectDistanceLabel.setFont(labelFont);
        objectDistanceField = new JTextField(5);
        objectDistanceField.setFont(textFieldFont);
        objectDistancePanel.add(objectDistanceLabel);
        objectDistancePanel.add(objectDistanceField);
        inputPanel.add(objectDistancePanel);

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

        resultLabel = new JLabel("Image Distance: ");
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
                double focalLength = Double.parseDouble(focalLengthField.getText());
                double objectDistance = Double.parseDouble(objectDistanceField.getText());
                double result = (focalLength * objectDistance) / (objectDistance - focalLength); // Image distance
                
                resultLabel.setText(String.format("Image Distance: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}