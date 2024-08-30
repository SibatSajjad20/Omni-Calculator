import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CAGRCalculator extends JPanel {
    private JTextField beginningValueField;
    private JTextField endingValueField;
    private JTextField yearsField;
    private JLabel resultLabel;

    public CAGRCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        JPanel headingPanel = new JPanel();
        JLabel headingLabel = new JLabel("CAGR Calculator");
        headingLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        headingPanel.add(headingLabel);
        add(headingPanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel beginningValuePanel = new JPanel();
        beginningValuePanel.setLayout(new BoxLayout(beginningValuePanel, BoxLayout.X_AXIS));
        beginningValuePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel beginningValueLabel = new JLabel("Beginning Value: ");
        beginningValueLabel.setFont(labelFont);
        beginningValueField = new JTextField(10);
        beginningValueField.setFont(textFieldFont);
        beginningValuePanel.add(beginningValueLabel);
        beginningValuePanel.add(beginningValueField);
        inputPanel.add(beginningValuePanel);

        JPanel endingValuePanel = new JPanel();
        endingValuePanel.setLayout(new BoxLayout(endingValuePanel, BoxLayout.X_AXIS));
        endingValuePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel endingValueLabel = new JLabel("Ending Value: ");
        endingValueLabel.setFont(labelFont);
        endingValueField = new JTextField(10);
        endingValueField.setFont(textFieldFont);
        endingValuePanel.add(endingValueLabel);
        endingValuePanel.add(endingValueField);
        inputPanel.add(endingValuePanel);

        JPanel yearsPanel = new JPanel();
        yearsPanel.setLayout(new BoxLayout(yearsPanel, BoxLayout.X_AXIS));
        yearsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel yearsLabel = new JLabel("Years: ");
        yearsLabel.setFont(labelFont);
        yearsField = new JTextField(10);
        yearsField.setFont(textFieldFont);
        yearsPanel.add(yearsLabel);
        yearsPanel.add(yearsField);
        inputPanel.add(yearsPanel);

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

        resultLabel = new JLabel("CAGR percentage: ");
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
                double beginningValue = Double.parseDouble(beginningValueField.getText());
                double endingValue = Double.parseDouble(endingValueField.getText());
                int years = Integer.parseInt(yearsField.getText());
                double result = Math.pow((endingValue / beginningValue), 1.0 / years) - 1; // Result in CAGR percentage
                resultLabel.setText(String.format("CAGR percentage: %.2f%%", result * 100));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}