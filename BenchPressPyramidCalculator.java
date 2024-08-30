import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BenchPressPyramidCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JLabel resultLabel;
    public BenchPressPyramidCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Bench Press Pyramid Calculator**
        JLabel calculatorLabel = new JLabel("Bench Press Pyramid Calculator");
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
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        weightPanel.add(weightLabel);
        weightPanel.add(field1);
        inputPanel.add(weightPanel);

        JPanel setsPanel = new JPanel();
        setsPanel.setLayout(new BoxLayout(setsPanel, BoxLayout.X_AXIS));
        setsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel setsLabel = new JLabel("Number of Sets: ");
        setsLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        setsPanel.add(setsLabel);
        setsPanel.add(field2);
        inputPanel.add(setsPanel);

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
                double weight = Double.parseDouble(field1.getText());
                int sets = Integer.parseInt(field2.getText());
                double result = weight * sets * (sets + 1) / 2; // Total weight lifted in kg
                
                resultLabel.setText(String.format("Total weight lifted: %.2f kg", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}