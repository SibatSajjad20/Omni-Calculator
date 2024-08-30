import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PerimeterCalculator extends JPanel {
    private JTextField lengthField;
    private JTextField widthField;
    private JLabel resultLabel;

    public PerimeterCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Perimeter Calculator**
        JLabel calculatorLabel = new JLabel("Perimeter Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel lengthPanel = new JPanel();
        lengthPanel.setLayout(new BoxLayout(lengthPanel, BoxLayout.X_AXIS));
        lengthPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel lengthLabel = new JLabel("Length: ");
        lengthLabel.setFont(labelFont);
        lengthField = new JTextField(10);
        lengthField.setFont(textFieldFont);
        lengthPanel.add(lengthLabel);
        lengthPanel.add(lengthField);
        inputPanel.add(lengthPanel);

        JPanel widthPanel = new JPanel();
        widthPanel.setLayout(new BoxLayout(widthPanel, BoxLayout.X_AXIS));
        widthPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel widthLabel = new JLabel("Width: ");
        widthLabel.setFont(labelFont);
        widthField = new JTextField(10);
        widthField.setFont(textFieldFont);
        widthPanel.add(widthLabel);
        widthPanel.add(widthField);
        inputPanel.add(widthPanel);

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
                double length = Double.parseDouble(lengthField.getText());
                double width = Double.parseDouble(widthField.getText());
                double result = 2 * (length + width); // Perimeter of a rectangle

                resultLabel.setText(String.format("Perimeter of a rectangle: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}