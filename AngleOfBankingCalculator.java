import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AngleOfBankingCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JLabel resultLabel;

    public AngleOfBankingCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add heading
        JLabel heading = new JLabel("Angle of Banking Calculator");
        heading.setFont(new Font("Poppins", Font.BOLD, 24));
        add(heading, BorderLayout.NORTH);

        // Create input panel with grid layout
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        inputPanel.add(new JLabel("Velocity:"));
        field1 = new JTextField();
        inputPanel.add(field1);

        inputPanel.add(new JLabel("Radius:"));
        field2 = new JTextField();
        inputPanel.add(field2);

        add(inputPanel, BorderLayout.CENTER);

        // Create button panel with flow layout
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        resultLabel = new JLabel("Result: ");
        buttonPanel.add(resultLabel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Set font and style for labels and buttons
        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font buttonFont = new Font("Poppins", Font.BOLD, 18);

        for (Component component : inputPanel.getComponents()) {
            if (component instanceof JLabel) {
                ((JLabel) component).setFont(labelFont);
            }
        }

        for (Component component : buttonPanel.getComponents()) {
            if (component instanceof JButton) {
                ((JButton) component).setFont(buttonFont);
            } else if (component instanceof JLabel) {
                ((JLabel) component).setFont(labelFont);
            }
        }
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double velocity = Double.parseDouble(field1.getText());
                double radius = Double.parseDouble(field2.getText());
                double g = 9.81;
                double result = Math.toDegrees(Math.atan(Math.pow(velocity, 2) / (radius * g)));
                resultLabel.setText(String.format("Angle Of Banking: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}