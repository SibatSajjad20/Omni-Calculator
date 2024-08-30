import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LeaseMileageCalculator extends JPanel {
    private JTextField annualMileageField;
    private JTextField leaseTermField;
    private JLabel resultLabel;

    public LeaseMileageCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Lease Mileage Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel annualMileagePanel = new JPanel();
        annualMileagePanel.setLayout(new BoxLayout(annualMileagePanel, BoxLayout.X_AXIS));
        annualMileagePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel annualMileageLabel = new JLabel("Annual Mileage: ");
        annualMileageLabel.setFont(labelFont);
        annualMileageField = new JTextField(10);
        annualMileageField.setFont(textFieldFont);
        annualMileagePanel.add(annualMileageLabel);
        annualMileagePanel.add(annualMileageField);
        inputPanel.add(annualMileagePanel);

        JPanel leaseTermPanel = new JPanel();
        leaseTermPanel.setLayout(new BoxLayout(leaseTermPanel, BoxLayout.X_AXIS));
        leaseTermPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel leaseTermLabel = new JLabel("Lease Term (years): ");
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

        resultLabel = new JLabel("Lease Mileage: ");
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
                double annualMileage = Double.parseDouble(annualMileageField.getText());
                double leaseTerm = Double.parseDouble(leaseTermField.getText());
                double result = annualMileage * leaseTerm;
                resultLabel.setText(String.format("Lease Mileage: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}