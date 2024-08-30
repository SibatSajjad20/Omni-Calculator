import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AverageRateOfChangeCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JTextField field4;
    private JLabel resultLabel;

    public AverageRateOfChangeCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        JLabel heading = new JLabel("Average Rate Of Change Converter");
        heading.setFont(new Font("Poppins", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);
        // Create input panel with grid layout
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        inputPanel.add(new JLabel("x1:"));
        field1 = new JTextField();
        inputPanel.add(field1);

        inputPanel.add(new JLabel("x2:"));
        field2 = new JTextField();
        inputPanel.add(field2);

        inputPanel.add(new JLabel("y1:"));
        field3 = new JTextField();
        inputPanel.add(field3);

        inputPanel.add(new JLabel("y2:"));
        field4 = new JTextField();
        inputPanel.add(field4);

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
                double x1 = Double.parseDouble(field1.getText());
                double y1 = Double.parseDouble(field3.getText());
                double x2 = Double.parseDouble(field2.getText());
                double y2 = Double.parseDouble(field4.getText());
                double result = (y2 - y1) / (x2 - x1);
                resultLabel.setText(String.format("Average Rate Of Change: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}