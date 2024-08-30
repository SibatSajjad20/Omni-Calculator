import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MagicNumberCalculator extends JPanel {
    private JTextField winsField;
    private JTextField lossesField;
    private JLabel resultLabel;

    public MagicNumberCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Magic Number Calculator**
        JLabel calculatorLabel = new JLabel("Magic Number Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel winsPanel = new JPanel();
        winsPanel.setLayout(new BoxLayout(winsPanel, BoxLayout.X_AXIS));
        winsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel winsLabel = new JLabel("Wins: ");
        winsLabel.setFont(labelFont);
        winsField = new JTextField(20);
        winsField.setFont(textFieldFont);
        winsPanel.add(winsLabel);
        winsPanel.add(winsField);
        inputPanel.add(winsPanel);

        JPanel lossesPanel = new JPanel();
        lossesPanel.setLayout(new BoxLayout(lossesPanel, BoxLayout.X_AXIS));
        lossesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel lossesLabel = new JLabel("Losses: ");
        lossesLabel.setFont(labelFont);
        lossesField = new JTextField(20);
        lossesField.setFont(textFieldFont);
        lossesPanel.add(lossesLabel);
        lossesPanel.add(lossesField);
        inputPanel.add(lossesPanel);

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

        resultLabel = new JLabel("Magic Number: ");
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
                int wins = Integer.parseInt(winsField.getText());
                int losses = Integer.parseInt(lossesField.getText());
                int result = 162 - (wins + losses) + 1;
                resultLabel.setText(String.format("Magic Number: %d", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}