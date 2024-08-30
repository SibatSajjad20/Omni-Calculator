import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LoanPaymentCalculator extends JPanel {
    private JTextField loanAmountField;
    private JTextField interestRateField;
    private JTextField loanTermField;
    private JLabel resultLabel;

    public LoanPaymentCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Loan Payment Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel loanAmountPanel = new JPanel();
        loanAmountPanel.setLayout(new BoxLayout(loanAmountPanel, BoxLayout.X_AXIS));
        loanAmountPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel loanAmountLabel = new JLabel("Loan Amount: ");
        loanAmountLabel.setFont(labelFont);
        loanAmountField = new JTextField(5);
        loanAmountField.setFont(textFieldFont);
        loanAmountPanel.add(loanAmountLabel);
        loanAmountPanel.add(loanAmountField);
        inputPanel.add(loanAmountPanel);

        JPanel interestRatePanel = new JPanel();
        interestRatePanel.setLayout(new BoxLayout(interestRatePanel, BoxLayout.X_AXIS));
        interestRatePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel interestRateLabel = new JLabel("Interest Rate (%): ");
        interestRateLabel.setFont(labelFont);
        interestRateField = new JTextField(5);
        interestRateField.setFont(textFieldFont);
        interestRatePanel.add(interestRateLabel);
        interestRatePanel.add(interestRateField);
        inputPanel.add(interestRatePanel);

        JPanel loanTermPanel = new JPanel();
        loanTermPanel.setLayout(new BoxLayout(loanTermPanel, BoxLayout.X_AXIS));
        loanTermPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel loanTermLabel = new JLabel("Loan Term (years): ");
        loanTermLabel.setFont(labelFont);
        loanTermField = new JTextField(5);
        loanTermField.setFont(textFieldFont);
        loanTermPanel.add(loanTermLabel);
        loanTermPanel.add(loanTermField);
        inputPanel.add(loanTermPanel);

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

        resultLabel = new JLabel("Loan Payment: ");
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
                double loanAmount = Double.parseDouble(loanAmountField.getText());
                double interestRate = Double.parseDouble(interestRateField.getText()) / 100 / 12;
                int loanTerm = Integer.parseInt(loanTermField.getText()) * 12;
                double result = (loanAmount * interestRate * Math.pow(1 + interestRate, loanTerm)) / (Math.pow(1 + interestRate, loanTerm) - 1);
                resultLabel.setText(String.format("Loan Payment: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}