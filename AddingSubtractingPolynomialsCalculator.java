import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

class AddingSubtractingPolynomialsCalculator extends JPanel {
    private JTextField poly1CoeffsField;
    private JTextField poly2CoeffsField;
    private JTextField poly1Field;
    private JTextField poly2Field;
    private JTextField maxLengthField;
    private JLabel resultLabel;

    public AddingSubtractingPolynomialsCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add heading
        JLabel heading = new JLabel("Adding/Subtracting Polynomials Calculator");
        heading.setFont(new Font("Poppins", Font.BOLD, 24));
        add(heading, BorderLayout.NORTH);

        // Create input panel with grid layout
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        inputPanel.add(new JLabel("Poly 1 Coefficients:"));
        poly1CoeffsField = new JTextField();
        inputPanel.add(poly1CoeffsField);

        inputPanel.add(new JLabel("Poly 2 Coefficients:"));
        poly2CoeffsField = new JTextField();
        inputPanel.add(poly2CoeffsField);

        inputPanel.add(new JLabel("Poly 1:"));
        poly1Field = new JTextField();
        inputPanel.add(poly1Field);

        inputPanel.add(new JLabel("Poly 2:"));
        poly2Field = new JTextField();
        inputPanel.add(poly2Field);

        inputPanel.add(new JLabel("Max Length:"));
        maxLengthField = new JTextField();
        inputPanel.add(maxLengthField);

        add(inputPanel, BorderLayout.CENTER);

        // Create button panel with flow layout
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        resultLabel = new JLabel("Result: ");
        buttonPanel.add(resultLabel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Set font and style for labels and buttons
        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font buttonFont = new Font("Poppins", Font.BOLD, 18);

        for (Component component : inputPanel.getComponents()) {
            if (component instanceof JTextField) {
                ((JTextField) component).setFont(labelFont);
            }
        }

        for (Component component : buttonPanel.getComponents()) {
            if (component instanceof JButton) {
                ((JButton) component).setFont(buttonFont);
            } else if (component instanceof JLabel) {
                ((JLabel) component).setFont(labelFont);
            }
        }
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String[] poly1Coeffs = poly1CoeffsField.getText().split(",");
                String[] poly2Coeffs = poly2CoeffsField.getText().split(",");
                double[] poly1 = Arrays.stream(poly1Coeffs).mapToDouble(Double::parseDouble).toArray();
                double[] poly2 = Arrays.stream(poly2Coeffs).mapToDouble(Double::parseDouble).toArray();
                int maxLength = Math.max(poly1.length, poly2.length);
                double[] result = new double[maxLength];
                for (int i = 0; i < maxLength; i++) {
                    result[i] = (i < poly1.length ? poly1[i] : 0) + (i < poly2.length ? poly2[i] : 0);
                }
                StringBuilder resultString = new StringBuilder("Result: ");
                for (double value : result) {
                    resultString.append(String.format("%.2f ", value));
                }
                resultLabel.setText(resultString.toString());
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}