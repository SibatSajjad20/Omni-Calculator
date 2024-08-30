import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TriangulationCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JLabel resultLabel;

    public TriangulationCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Triangulation Calculator**
        JLabel calculatorLabel = new JLabel("Triangulation Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel aPanel = new JPanel();
        aPanel.setLayout(new BoxLayout(aPanel, BoxLayout.X_AXIS));
        aPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel aLabel = new JLabel("a: ");
        aLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        aPanel.add(aLabel);
        aPanel.add(field1);
        inputPanel.add(aPanel);

        JPanel bPanel = new JPanel();
        bPanel.setLayout(new BoxLayout(bPanel, BoxLayout.X_AXIS));
        bPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel bLabel = new JLabel("b: ");
        bLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        bPanel.add(bLabel);
        bPanel.add(field2);
        inputPanel.add(bPanel);

        JPanel angleCPanel = new JPanel();
        angleCPanel.setLayout(new BoxLayout(angleCPanel, BoxLayout.X_AXIS));
        angleCPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel angleCLabel = new JLabel("Angle C (degrees): ");
        angleCLabel.setFont(labelFont);
        field3 = new JTextField(10);
        field3.setFont(textFieldFont);
        angleCPanel.add(angleCLabel);
        angleCPanel.add(field3);
        inputPanel.add(angleCPanel);

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
                double a = Double.parseDouble(field1.getText());
                double b = Double.parseDouble(field2.getText());
                double angleC = Double.parseDouble(field3.getText());
                double c = Math.sqrt(a*a + b*b - 2*a*b*Math.cos(Math.toRadians(angleC)));
                double result = c;
                resultLabel.setText(String.format("Result: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}