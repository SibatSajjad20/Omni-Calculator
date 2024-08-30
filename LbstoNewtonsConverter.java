import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LbstoNewtonsConverter extends JPanel {
    private JTextField forceInLbsField;
    private JLabel resultLabel;

    public LbstoNewtonsConverter(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Pounds to Newtons Converter");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel forceInLbsPanel = new JPanel();
        forceInLbsPanel.setLayout(new BoxLayout(forceInLbsPanel, BoxLayout.X_AXIS));
        forceInLbsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel forceInLbsLabel = new JLabel("Force (lbs): ");
        forceInLbsLabel.setFont(labelFont);
        forceInLbsField = new JTextField(10);
        forceInLbsField.setFont(textFieldFont);
        forceInLbsPanel.add(forceInLbsLabel);
        forceInLbsPanel.add(forceInLbsField);
        inputPanel.add(forceInLbsPanel);

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

        resultLabel = new JLabel("Force (newtons): ");
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
                double forceInLbs = Double.parseDouble(forceInLbsField.getText());
                double result = forceInLbs * 4.44822;
                resultLabel.setText(String.format("Force (newtons): %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}