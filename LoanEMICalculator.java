import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoanEMICalculator extends JPanel {
    private JTextField principalField;
    private JTextField rateField;
    private JTextField monthsField;
    private JLabel resultLabel;

    public LoanEMICalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Loan EMI Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel principalPanel = new JPanel();
        principalPanel.setLayout(new BoxLayout(principalPanel, BoxLayout.X_AXIS));
        principalPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel principalLabel = new JLabel("Principal: ");
        principalLabel.setFont(labelFont);
        principalField = new JTextField(5);
        principalField.setFont(textFieldFont);
        principalPanel.add(principalLabel);
        principalPanel.add(principalField);
        inputPanel.add(principalPanel);

        JPanel ratePanel = new JPanel();
        ratePanel.setLayout(new BoxLayout(ratePanel, BoxLayout.X_AXIS));
        ratePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel rateLabel = new JLabel("Rate (%): ");
        rateLabel.setFont(labelFont);
        rateField = new JTextField(5);
        rateField.setFont(textFieldFont);
        ratePanel.add(rateLabel);
        ratePanel.add(rateField);
        inputPanel.add(ratePanel);

        JPanel monthsPanel = new JPanel();
        monthsPanel.setLayout(new BoxLayout(monthsPanel, BoxLayout.X_AXIS));
        monthsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel monthsLabel = new JLabel("Months: ");
        monthsLabel.setFont(labelFont);
        monthsField = new JTextField(5);
        monthsField.setFont(textFieldFont);
        monthsPanel.add(monthsLabel);
        monthsPanel.add(monthsField);
        inputPanel.add(monthsPanel);

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

        resultLabel = new JLabel("Loan EMI: ");
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
                double principal = Double.parseDouble(principalField.getText());
                double rate = Double.parseDouble(rateField.getText()) / 12 / 100;
                int months = Integer.parseInt(monthsField.getText());
                double emi = (principal * rate * Math.pow(1 + rate, months)) / (Math.pow(1 + rate, months) - 1); 
                resultLabel.setText(String.format("Loan EMI: %.2f", emi));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}