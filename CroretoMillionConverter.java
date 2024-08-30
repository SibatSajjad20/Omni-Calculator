import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CroretoMillionConverter extends JPanel {
    private JTextField lengthField;
    private JLabel resultLabel;

    public CroretoMillionConverter(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // Add a heading
        JLabel heading = new JLabel("Crore to Million Converter");
        heading.setFont(new Font("Poppins", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(1, 2));
        add(inputPanel, BorderLayout.CENTER);

        inputPanel.add(new JLabel("Money (crore):"));
        lengthField = new JTextField(10);
        inputPanel.add(lengthField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        add(buttonPanel, BorderLayout.SOUTH);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        resultLabel = new JLabel("Money (million): ");
        buttonPanel.add(resultLabel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double money = Double.parseDouble(lengthField.getText());
                double result = money * 10;
                resultLabel.setText(String.format("Money (million): %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}