import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LandLoanCalculator extends JPanel {
    private JTextField landPriceField;
    private JTextField downPaymentField;
    private JLabel resultLabel;

    public LandLoanCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Land Loan Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel landPricePanel = new JPanel();
        landPricePanel.setLayout(new BoxLayout(landPricePanel, BoxLayout.X_AXIS));
        landPricePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel landPriceLabel = new JLabel("Land Price ($): ");
        landPriceLabel.setFont(labelFont);
        landPriceField = new JTextField(10);
        landPriceField.setFont(textFieldFont);
        landPricePanel.add(landPriceLabel);
        landPricePanel.add(landPriceField);
        inputPanel.add(landPricePanel);

        JPanel downPaymentPanel = new JPanel();
        downPaymentPanel.setLayout(new BoxLayout(downPaymentPanel, BoxLayout.X_AXIS));
        downPaymentPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel downPaymentLabel = new JLabel("Down Payment (%): ");
        downPaymentLabel.setFont(labelFont);
        downPaymentField = new JTextField(10);
        downPaymentField.setFont(textFieldFont);
        downPaymentPanel.add(downPaymentLabel);
        downPaymentPanel.add(downPaymentField);
        inputPanel.add(downPaymentPanel);

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

        resultLabel = new JLabel("Land Loan: ");
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
                double landPrice = Double.parseDouble(landPriceField.getText());
                double downPaymentPercentage = Double.parseDouble(downPaymentField.getText()) / 100;
                double downPaymentAmount = landPrice * downPaymentPercentage;
                double landLoan = landPrice - downPaymentAmount;
                resultLabel.setText(String.format("Land Loan: $%.2f", landLoan));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}