import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

class NetForceCalculator extends JPanel {
    private JTextField forcesField;
    private JLabel resultLabel;

    public NetForceCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Net Force Calculator**
        JLabel calculatorLabel = new JLabel("Net Force Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel forcesPanel = new JPanel();
        forcesPanel.setLayout(new BoxLayout(forcesPanel, BoxLayout.X_AXIS));
        forcesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel forcesLabel = new JLabel("Forces (comma separated): ");
        forcesLabel.setFont(labelFont);
        forcesField = new JTextField(20);
        forcesField.setFont(textFieldFont);
        forcesPanel.add(forcesLabel);
        forcesPanel.add(forcesField);
        inputPanel.add(forcesPanel);

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

        resultLabel = new JLabel("Net Force: ");
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
                double[] forces = Arrays.stream(forcesField.getText().split(",")).mapToDouble(Double::parseDouble).toArray();
                double result = Arrays.stream(forces).sum();
                resultLabel.setText(String.format("Net Force: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}