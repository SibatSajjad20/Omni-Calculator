import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NicotineIntakeCalculator extends JPanel {
    private JTextField cigarettesField;
    private JLabel resultLabel;

    public NicotineIntakeCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Nicotine Intake Calculator**
        JLabel calculatorLabel = new JLabel("Nicotine Intake Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel cigarettesPanel = new JPanel();
        cigarettesPanel.setLayout(new BoxLayout(cigarettesPanel, BoxLayout.X_AXIS));
        cigarettesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel cigarettesLabel = new JLabel("Number of Cigarettes: ");
        cigarettesLabel.setFont(labelFont);
        cigarettesField = new JTextField(10);
        cigarettesField.setFont(textFieldFont);
        cigarettesPanel.add(cigarettesLabel);
        cigarettesPanel.add(cigarettesField);
        inputPanel.add(cigarettesPanel);

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

        resultLabel = new JLabel("Nicotine Intake: ");
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
                int cigarettes = Integer.parseInt(cigarettesField.getText());
                double result = cigarettes * 1.2;
                resultLabel.setText(String.format("Nicotine Intake: %.2f mg", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}