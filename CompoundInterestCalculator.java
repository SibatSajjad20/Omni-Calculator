import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CompoundInterestCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JTextField field4;
    private JLabel resultLabel;

    public CompoundInterestCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // Add a heading
        JLabel heading = new JLabel("Compound Interest Calculator");
        heading.setFont(new Font("Poppins", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2));
        add(inputPanel, BorderLayout.CENTER);

        inputPanel.add(new JLabel("Principal:"));
        field1 = new JTextField(10);
        inputPanel.add(field1);

        inputPanel.add(new JLabel("Rate (%):"));
        field2 = new JTextField(10);
        inputPanel.add(field2);

        inputPanel.add(new JLabel("Time (years):"));
        field3 = new JTextField(10);
        inputPanel.add(field3);

        inputPanel.add(new JLabel("Compound Frequency:"));
        field4 = new JTextField(10);
        inputPanel.add(field4);

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
                double principal = Double.parseDouble(field1.getText());
                double rate = Double.parseDouble(field2.getText()) / 100;
                int time = Integer.parseInt(field3.getText());
                int compoundFrequency = Integer.parseInt(field4.getText());
                double result = principal * Math.pow(1 + (rate / compoundFrequency), compoundFrequency * time);
                resultLabel.setText(String.format("Compound Interest: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}