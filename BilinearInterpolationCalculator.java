import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BilinearInterpolationCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JLabel resultLabel;

    public BilinearInterpolationCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        JPanel headingPanel = new JPanel();
        JLabel headingLabel = new JLabel("Bilinear Interpolation Calculator");
        headingLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        headingPanel.add(headingLabel);
        add(headingPanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel field1Panel = new JPanel();
        field1Panel.setLayout(new BoxLayout(field1Panel, BoxLayout.X_AXIS));
        field1Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel field1Label = new JLabel("Field 1: ");
        field1Label.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        field1Panel.add(field1Label);
        field1Panel.add(field1);
        inputPanel.add(field1Panel);

        JPanel field2Panel = new JPanel();
        field2Panel.setLayout(new BoxLayout(field2Panel, BoxLayout.X_AXIS));
        field2Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel field2Label = new JLabel("Field 2: ");
        field2Label.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        field2Panel.add(field2Label);
        field2Panel.add(field2);
        inputPanel.add(field2Panel);

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
                double value1 = Double.parseDouble(field1.getText());
                double value2 = Double.parseDouble(field2.getText());
                double result = value1 * value2; 
                resultLabel.setText(String.format("Bilinear Interpolation: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}