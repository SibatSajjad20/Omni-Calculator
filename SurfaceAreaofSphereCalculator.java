import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SurfaceAreaofSphereCalculator extends JPanel {
    private JTextField field1;
    private JLabel resultLabel;

    public SurfaceAreaofSphereCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Surface Area of a Sphere Calculator**
        JLabel calculatorLabel = new JLabel("Surface Area of a Sphere Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel radiusPanel = new JPanel();
        radiusPanel.setLayout(new BoxLayout(radiusPanel, BoxLayout.X_AXIS));
        radiusPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel radiusLabel = new JLabel("Radius: ");
        radiusLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        radiusPanel.add(radiusLabel);
        radiusPanel.add(field1);
        inputPanel.add(radiusPanel);

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

        resultLabel = new JLabel("Surface area of a sphere: ");
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
                double radius = Double.parseDouble(field1.getText());
                double result = 4 * Math.PI * Math.pow(radius, 2); // Surface area of a sphere
                
                resultLabel.setText(String.format("Surface area of a sphere: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}