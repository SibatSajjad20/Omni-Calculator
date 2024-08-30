import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BilliontoTrillionConverter extends JPanel {
    private JTextField lengthField;
    private JLabel resultLabel;

    public BilliontoTrillionConverter(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // Heading
        JLabel heading = new JLabel("Billion to Trillion Converter");
        heading.setFont(new Font("Poppins", Font.BOLD, 24));
        heading.setHorizontalAlignment(JLabel.CENTER);
        add(heading, BorderLayout.NORTH);

        // Input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel lengthPanel = new JPanel();
        lengthPanel.setLayout(new BoxLayout(lengthPanel, BoxLayout.X_AXIS));
        lengthPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel lengthLabel = new JLabel("Money (billions): ");
        lengthLabel.setFont(labelFont);
        lengthField = new JTextField(10);
        lengthField.setFont(textFieldFont);
        lengthPanel.add(lengthLabel);
        lengthPanel.add(lengthField);
        inputPanel.add(lengthPanel);

        // Calculate button
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setFont(textFieldFont);
        calculateButton.addActionListener(new CalculateButtonListener());
        inputPanel.add(calculateButton);

        // Result panel
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.X_AXIS));
        resultPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        resultPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(resultPanel, BorderLayout.SOUTH);

        resultLabel = new JLabel("Money (trillions): ");
        resultLabel.setFont(labelFont);
        resultPanel.add(resultLabel);

        resultPanel.add(Box.createHorizontalGlue());

        JButton backButton = new JButton("Back");
        backButton.setFont(textFieldFont);
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        resultPanel.add(backButton);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double money = Double.parseDouble(lengthField.getText());
                double result = money / 1000;
                resultLabel.setText(String.format("Money (trillions): %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}