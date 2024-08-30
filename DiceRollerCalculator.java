import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

class DiceRollerCalculator extends JPanel {
    private JTextField sidesField;
    private JTextField rollsField;
    private JLabel resultLabel;

    public DiceRollerCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // Add a heading
        JLabel heading = new JLabel("Dice Roller Calculator");
        heading.setFont(new Font("Poppins", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        add(inputPanel, BorderLayout.CENTER);

        JPanel sidesPanel = new JPanel();
        sidesPanel.setLayout(new BoxLayout(sidesPanel, BoxLayout.X_AXIS));
        sidesPanel.add(new JLabel("Sides:"));
        sidesField = new JTextField(10);
        sidesPanel.add(sidesField);
        inputPanel.add(sidesPanel);

        JPanel rollsPanel = new JPanel();
        rollsPanel.setLayout(new BoxLayout(rollsPanel, BoxLayout.X_AXIS));
        rollsPanel.add(new JLabel("Rolls:"));
        rollsField = new JTextField(10);
        rollsPanel.add(rollsField);
        inputPanel.add(rollsPanel);

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
                int sides = Integer.parseInt(sidesField.getText());
                int rolls = Integer.parseInt(rollsField.getText());
                Random random = new Random();
                int[] result = new int[rolls];
                for (int i = 0; i < rolls; i++) {
                    result[i] = random.nextInt(sides) + 1;
                }
                StringBuilder resultText = new StringBuilder("Dice: ");
                for (int roll : result) {
                    resultText.append(roll).append(" ");
                }
                resultLabel.setText(resultText.toString());
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}