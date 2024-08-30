import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CaffeineIntakeCalculator extends JPanel {
    private JTextField coffeeField;
    private JTextField teaField;
    private JTextField sodaField;
    private JLabel resultLabel;

    public CaffeineIntakeCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // **Caffeine Intake Calculator**
        JLabel calculatorLabel = new JLabel("Caffeine Intake Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel coffeePanel = new JPanel();
        coffeePanel.setLayout(new BoxLayout(coffeePanel, BoxLayout.X_AXIS));
        coffeePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel coffeeLabel = new JLabel("Coffee (oz): ");
        coffeeLabel.setFont(labelFont);
        coffeeField = new JTextField(10);
        coffeeField.setFont(textFieldFont);
        coffeePanel.add(coffeeLabel);
        coffeePanel.add(coffeeField);
        inputPanel.add(coffeePanel);

        JPanel teaPanel = new JPanel();
        teaPanel.setLayout(new BoxLayout(teaPanel, BoxLayout.X_AXIS));
        teaPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel teaLabel = new JLabel("Tea (oz): ");
        teaLabel.setFont(labelFont);
        teaField = new JTextField(10);
        teaField.setFont(textFieldFont);
        teaPanel.add(teaLabel);
        teaPanel.add(teaField);
        inputPanel.add(teaPanel);

        JPanel sodaPanel = new JPanel();
        sodaPanel.setLayout(new BoxLayout(sodaPanel, BoxLayout.X_AXIS));
        sodaPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel sodaLabel = new JLabel("Soda (oz): ");
        sodaLabel.setFont(labelFont);
        sodaField = new JTextField(10);
        sodaField.setFont(textFieldFont);
        sodaPanel.add(sodaLabel);
        sodaPanel.add(sodaField);
        inputPanel.add(sodaPanel);

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

        resultLabel = new JLabel("Caffeine Intake: ");
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
                double coffeeOz = Double.parseDouble(coffeeField.getText());
                double teaOz = Double.parseDouble(teaField.getText());
                double sodaOz = Double.parseDouble(sodaField.getText());
                double result = (coffeeOz * 12) + (teaOz * 5) + (sodaOz * 3.5);
                resultLabel.setText(String.format("Caffeine Intake: %.2f mg", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}