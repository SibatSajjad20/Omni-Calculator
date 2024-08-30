import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class FieldingPercentageCalculator extends JPanel {
    private JTextField putOutsField;
    private JTextField assistsField;
    private JTextField errorsField;
    private JLabel resultLabel;

    public FieldingPercentageCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // **Fielding Percentage Calculator**
        JLabel calculatorLabel = new JLabel("Fielding Percentage Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel putOutsPanel = new JPanel();
        putOutsPanel.setLayout(new BoxLayout(putOutsPanel, BoxLayout.X_AXIS));
        putOutsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel putOutsLabel = new JLabel("Put Outs: ");
        putOutsLabel.setFont(labelFont);
        putOutsField = new JTextField(10);
        putOutsField.setFont(textFieldFont);
        putOutsPanel.add(putOutsLabel);
        putOutsPanel.add(putOutsField);
        inputPanel.add(putOutsPanel);

        JPanel assistsPanel = new JPanel();
        assistsPanel.setLayout(new BoxLayout(assistsPanel, BoxLayout.X_AXIS));
        assistsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel assistsLabel = new JLabel("Assists: ");
        assistsLabel.setFont(labelFont);
        assistsField = new JTextField(10);
        assistsField.setFont(textFieldFont);
        assistsPanel.add(assistsLabel);
        assistsPanel.add(assistsField);
        inputPanel.add(assistsPanel);

        JPanel errorsPanel = new JPanel();
        errorsPanel.setLayout(new BoxLayout(errorsPanel, BoxLayout.X_AXIS));
        errorsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel errorsLabel = new JLabel("Errors: ");
        errorsLabel.setFont(labelFont);
        errorsField = new JTextField(10);
        errorsField.setFont(textFieldFont);
        errorsPanel.add(errorsLabel);
        errorsPanel.add(errorsField);
        inputPanel.add(errorsPanel);

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

        resultLabel = new JLabel("Fielding Percentage: ");
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
                int putOuts = Integer.parseInt(putOutsField.getText());
                int assists = Integer.parseInt(assistsField.getText());
                int errors = Integer.parseInt(errorsField.getText());

                if (putOuts < 0 || assists < 0 || errors < 0) {
                    resultLabel.setText("Invalid input values. Please enter non-negative numbers.");
                    return;
                }

                double fieldingPercentage = calculateFieldingPercentage(putOuts, assists, errors);
                updateResultLabel(fieldingPercentage);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }

    private double calculateFieldingPercentage(int putOuts, int assists, int errors) {
        return (double) (putOuts + assists) / (putOuts + assists + errors);
    }

    private void updateResultLabel(double fieldingPercentage) {
        resultLabel.setText(String.format("Fielding Percentage: %.2f", fieldingPercentage));
    }
}