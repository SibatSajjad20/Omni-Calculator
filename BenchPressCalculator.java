import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BenchPressCalculator extends JPanel {
    private static final double BENCH_PRESS_CONSTANT = 30.0;

    private JTextField weightField;
    private JTextField repsField;
    private JLabel resultLabel;

    public BenchPressCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Bench Press Calculator**
        JLabel calculatorLabel = new JLabel("Bench Press Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel weightPanel = new JPanel();
        weightPanel.setLayout(new BoxLayout(weightPanel, BoxLayout.X_AXIS));
        weightPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel weightLabel = new JLabel("Weight (kg): ");
        weightLabel.setFont(labelFont);
        weightField = new JTextField(10);
        weightField.setFont(textFieldFont);
        weightPanel.add(weightLabel);
        weightPanel.add(weightField);
        inputPanel.add(weightPanel);

        JPanel repsPanel = new JPanel();
        repsPanel.setLayout(new BoxLayout(repsPanel, BoxLayout.X_AXIS));
        repsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel repsLabel = new JLabel("Number of Reps: ");
        repsLabel.setFont(labelFont);
        repsField = new JTextField(10);
        repsField.setFont(textFieldFont);
        repsPanel.add(repsLabel);
        repsPanel.add(repsField);
        inputPanel.add(repsPanel);

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

        resultLabel = new JLabel("Result: ");
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
                double weight = Double.parseDouble(weightField.getText());
                int reps = Integer.parseInt(repsField.getText());
                double benchPress = calculateBenchPress(weight, reps);
                resultLabel.setText(String.format("Bench Press: %.2f kg", benchPress));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }

    private double calculateBenchPress(double weight, int reps) {
        return weight * (1 + reps / BENCH_PRESS_CONSTANT);
    }
}