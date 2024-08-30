import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ReducedMassCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JLabel resultLabel;

    public ReducedMassCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Reduced Mass Calculator**
        JLabel calculatorLabel = new JLabel("Reduced Mass Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel mass1Panel = new JPanel();
        mass1Panel.setLayout(new BoxLayout(mass1Panel, BoxLayout.X_AXIS));
        mass1Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel mass1Label = new JLabel("Mass 1: ");
        mass1Label.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        mass1Panel.add(mass1Label);
        mass1Panel.add(field1);
        inputPanel.add(mass1Panel);

        JPanel mass2Panel = new JPanel();
        mass2Panel.setLayout(new BoxLayout(mass2Panel, BoxLayout.X_AXIS));
        mass2Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel mass2Label = new JLabel("Mass 2: ");
        mass2Label.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        mass2Panel.add(mass2Label);
        mass2Panel.add(field2);
        inputPanel.add(mass2Panel);

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
                double mass1 = Double.parseDouble(field1.getText());
                double mass2 = Double.parseDouble(field2.getText());
                double result = (mass1 * mass2) / (mass1 + mass2);
                resultLabel.setText(String.format("Reduced Mass: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}