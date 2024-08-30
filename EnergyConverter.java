import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class EnergyConverter extends JPanel {
    private JTextField joulesField;
    private JLabel resultLabel;

    public EnergyConverter(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing
        JLabel heading = new JLabel("Energy Converter");
        heading.setFont(new Font("Poppins", Font.BOLD, 24));
        add(heading, BorderLayout.NORTH);
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        add(inputPanel, BorderLayout.CENTER);

        JPanel joulesPanel = new JPanel();
        joulesPanel.setLayout(new BoxLayout(joulesPanel, BoxLayout.X_AXIS));
        joulesPanel.add(new JLabel("Energy in Joules:"));
        joulesField = new JTextField(10);
        joulesPanel.add(joulesField);
        inputPanel.add(joulesPanel);

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
                double joules = Double.parseDouble(joulesField.getText());
                double result = joules / 3600; // Convert Joules to Watt-hours
                
                resultLabel.setText(String.format("Energy in Watt-Hours: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}