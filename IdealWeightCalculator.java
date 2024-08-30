import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class IdealWeightCalculator extends JPanel {
    private JTextField heightField;
    private JCheckBox genderCheckBox;
    private JLabel resultLabel;

    public IdealWeightCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Ideal Weight Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel heightPanel = new JPanel();
        heightPanel.setLayout(new BoxLayout(heightPanel, BoxLayout.X_AXIS));
        heightPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel heightLabel = new JLabel("Height (cm): ");
        heightLabel.setFont(labelFont);
        heightField = new JTextField(10);
        heightField.setFont(textFieldFont);
        heightPanel.add(heightLabel);
        heightPanel.add(heightField);
        inputPanel.add(heightPanel);

        JPanel genderPanel = new JPanel();
        genderPanel.setLayout(new BoxLayout(genderPanel, BoxLayout.X_AXIS));
        genderPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel genderLabel = new JLabel("Gender: ");
        genderLabel.setFont(labelFont);
        genderCheckBox = new JCheckBox("Male");
        genderCheckBox.setFont(textFieldFont);
        genderPanel.add(genderLabel);
        genderPanel.add(genderCheckBox);
        inputPanel.add(genderPanel);

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

        resultLabel = new JLabel("Ideal Weight: ");
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
                double height = Double.parseDouble(heightField.getText());
                boolean isMale = genderCheckBox.isSelected();
                double result = isMale ?
                    50 + 2.3 * ((height - 152.4) / 2.54) :
                    45.5 + 2.3 * ((height - 152.4) / 2.54);
                resultLabel.setText(String.format("Ideal Weight: %.2f kg", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}