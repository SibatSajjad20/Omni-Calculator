import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LeaseCalculator extends JPanel {
    private JTextField monthlyPaymentField;
    private JTextField leaseTermField;
    private JLabel resultLabel;

    public LeaseCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Lease Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel monthlyPaymentPanel = new JPanel();
        monthlyPaymentPanel.setLayout(new BoxLayout(monthlyPaymentPanel, BoxLayout.X_AXIS));
        monthlyPaymentPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel monthlyPaymentLabel = new JLabel("Monthly Payment: ");
        monthlyPaymentLabel.setFont(labelFont);
        monthlyPaymentField = new JTextField(10);
        monthlyPaymentField.setFont(textFieldFont);
        monthlyPaymentPanel.add(monthlyPaymentLabel);
        monthlyPaymentPanel.add(monthlyPaymentField);
        inputPanel.add(monthlyPaymentPanel);

        JPanel leaseTermPanel = new JPanel();
        leaseTermPanel.setLayout(new BoxLayout(leaseTermPanel, BoxLayout.X_AXIS));
        leaseTermPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel leaseTermLabel = new JLabel("Lease Term (months): ");
        leaseTermLabel.setFont(labelFont);
        leaseTermField = new JTextField(10);
        leaseTermField.setFont(textFieldFont);
        leaseTermPanel.add(leaseTermLabel);
        leaseTermPanel.add(leaseTermField);
        inputPanel.add(leaseTermPanel);

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

        resultLabel = new JLabel("Lease: ");
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
                double monthlyPayment = Double.parseDouble(monthlyPaymentField.getText());
                double leaseTerm = Double.parseDouble(leaseTermField.getText());
                double result = monthlyPayment * leaseTerm;
                resultLabel.setText(String.format("Lease: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}