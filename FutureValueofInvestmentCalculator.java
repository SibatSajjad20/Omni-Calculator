import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class FutureValueofInvestmentCalculator extends JPanel {
    private JTextField principalField;
    private JTextField rateField;
    private JTextField yearsField;
    private JLabel resultLabel;

    public FutureValueofInvestmentCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Future Value of Investment Calculator");
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
        principalField = new JTextField(10);
        principalField.setFont(textFieldFont);
        principalPanel.add(principalLabel);
        principalPanel.add(principalField);
        inputPanel.add(principalPanel);

        JPanel ratePanel = new JPanel();
        ratePanel.setLayout(new BoxLayout(ratePanel, BoxLayout.X_AXIS));
        ratePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel rateLabel = new JLabel("Rate (%): ");
        rateLabel.setFont(labelFont);
        rateField = new JTextField(10);
        rateField.setFont(textFieldFont);
        ratePanel.add(rateLabel);
        ratePanel.add(rateField);
        inputPanel.add(ratePanel);

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
                double principal = Double.parseDouble(principalField.getText());
                double rate = Double.parseDouble(rateField.getText()) / 100;
                int years = Integer.parseInt(yearsField.getText());
                double result = principal * Math.pow(1 + rate, years);

                resultLabel.setText(String.format("Future Value of Investment: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}