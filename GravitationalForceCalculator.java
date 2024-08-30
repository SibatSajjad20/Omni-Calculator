import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GravitationalForceCalculator extends JPanel {
    private JTextField mass1Field;
    private JTextField mass2Field;
    private JTextField distanceField;
    private JLabel resultLabel;

    public GravitationalForceCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Gravitational Force Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel mass1Panel = new JPanel();
        mass1Panel.setLayout(new BoxLayout(mass1Panel, BoxLayout.X_AXIS));
        mass1Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel mass1Label = new JLabel("Mass 1 (kg): ");
        mass1Label.setFont(labelFont);
        mass1Field = new JTextField(10);
        mass1Field.setFont(textFieldFont);
        mass1Panel.add(mass1Label);
        mass1Panel.add(mass1Field);
        inputPanel.add(mass1Panel);

        JPanel mass2Panel = new JPanel();
        mass2Panel.setLayout(new BoxLayout(mass2Panel, BoxLayout.X_AXIS));
        mass2Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel mass2Label = new JLabel("Mass 2 (kg): ");
        mass2Label.setFont(labelFont);
        mass2Field = new JTextField(10);
        mass2Field.setFont(textFieldFont);
        mass2Panel.add(mass2Label);
        mass2Panel.add(mass2Field);
        inputPanel.add(mass2Panel);

        JPanel distancePanel = new JPanel();
        distancePanel.setLayout(new BoxLayout(distancePanel, BoxLayout.X_AXIS));
        distancePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel distanceLabel = new JLabel("Distance (m): ");
        distanceLabel.setFont(labelFont);
        distanceField = new JTextField(10);
        distanceField.setFont(textFieldFont);
        distancePanel.add(distanceLabel);
        distancePanel.add(distanceField);
        inputPanel.add(distancePanel);

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
                double mass1 = Double.parseDouble(mass1Field.getText());
                double mass2 = Double.parseDouble(mass2Field.getText());
                double distance = Double.parseDouble(distanceField.getText());
                double G = 6.674e-11; // Gravitational constant
                double result = G * mass1 * mass2 / Math.pow(distance, 2);
                resultLabel.setText(String.format("Gravitational Force: %.2e N", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}