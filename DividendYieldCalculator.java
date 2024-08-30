import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DividendYieldCalculator extends JPanel {
    private JTextField annualDividendsPerShareField;
    private JTextField pricePerShareField;
    private JLabel resultLabel;

    public DividendYieldCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // Add a heading
        JLabel heading = new JLabel("Dividend Yield Calculator");
        heading.setFont(new Font("Poppins", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        add(inputPanel, BorderLayout.CENTER);

        JPanel annualDividendsPerSharePanel = new JPanel();
        annualDividendsPerSharePanel.setLayout(new BoxLayout(annualDividendsPerSharePanel, BoxLayout.X_AXIS));
        annualDividendsPerSharePanel.add(new JLabel("Annual Dividends Per Share:"));
        annualDividendsPerShareField = new JTextField(10);
        annualDividendsPerSharePanel.add(annualDividendsPerShareField);
        inputPanel.add(annualDividendsPerSharePanel);

        JPanel pricePerSharePanel = new JPanel();
        pricePerSharePanel.setLayout(new BoxLayout(pricePerSharePanel, BoxLayout.X_AXIS));
        pricePerSharePanel.add(new JLabel("Price Per Share:"));
        pricePerShareField = new JTextField(10);
        pricePerSharePanel.add(pricePerShareField);
        inputPanel.add(pricePerSharePanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        add(buttonPanel, BorderLayout.SOUTH);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        resultLabel = new JLabel("Result: ");
        buttonPanel.add(resultLabel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double annualDividendsPerShare = Double.parseDouble(annualDividendsPerShareField.getText());
                double pricePerShare = Double.parseDouble(pricePerShareField.getText());
                double result = (annualDividendsPerShare / pricePerShare) * 100; // Result 

                resultLabel.setText(String.format("Dividend Yield in percentage: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}