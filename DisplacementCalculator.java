import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DisplacementCalculator extends JPanel {
    private JTextField initialPositionField;
    private JTextField finalPositionField;
    private JLabel resultLabel;

    public DisplacementCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // Add a heading
        JLabel heading = new JLabel("Displacement Calculator");
        heading.setFont(new Font("Poppins", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        add(inputPanel, BorderLayout.CENTER);

        JPanel initialPositionPanel = new JPanel();
        initialPositionPanel.setLayout(new BoxLayout(initialPositionPanel, BoxLayout.X_AXIS));
        initialPositionPanel.add(new JLabel("Initial Position:"));
        initialPositionField = new JTextField(10);
        initialPositionPanel.add(initialPositionField);
        inputPanel.add(initialPositionPanel);

        JPanel finalPositionPanel = new JPanel();
        finalPositionPanel.setLayout(new BoxLayout(finalPositionPanel, BoxLayout.X_AXIS));
        finalPositionPanel.add(new JLabel("Final Position:"));
        finalPositionField = new JTextField(10);
        finalPositionPanel.add(finalPositionField);
        inputPanel.add(finalPositionPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        add(buttonPanel, BorderLayout.SOUTH);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        resultLabel = new JLabel("Result: ");
        buttonPanel.add(resultLabel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double initialPosition = Double.parseDouble(initialPositionField.getText());
                double finalPosition = Double.parseDouble(finalPositionField.getText());
                double result = finalPosition - initialPosition;
                resultLabel.setText(String.format("Displacement: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}