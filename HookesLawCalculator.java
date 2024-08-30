import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class HookesLawCalculator extends JPanel {
    private JTextField springConstantField;
    private JTextField displacementField;
    private JLabel resultLabel;

    public HookesLawCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Hooke's Law Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel springConstantPanel = new JPanel();
        springConstantPanel.setLayout(new BoxLayout(springConstantPanel, BoxLayout.X_AXIS));
        springConstantPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel springConstantLabel = new JLabel("Spring Constant (N/m): ");
        springConstantLabel.setFont(labelFont);
        springConstantField = new JTextField(10);
        springConstantField.setFont(textFieldFont);
        springConstantPanel.add(springConstantLabel);
        springConstantPanel.add(springConstantField);
        inputPanel.add(springConstantPanel);

        JPanel displacementPanel = new JPanel();
        displacementPanel.setLayout(new BoxLayout(displacementPanel, BoxLayout.X_AXIS));
        displacementPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel displacementLabel = new JLabel("Displacement (m): ");
        displacementLabel.setFont(labelFont);
        displacementField = new JTextField(10);
        displacementField.setFont(textFieldFont);
        displacementPanel.add(displacementLabel);
        displacementPanel.add(displacementField);
        inputPanel.add(displacementPanel);

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

        resultLabel = new JLabel("Force: ");
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
                double springConstant = Double.parseDouble(springConstantField.getText());
                double displacement = Double.parseDouble(displacementField.getText());
                double result = springConstant * displacement;
                resultLabel.setText(String.format("Force: %.2f N", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}