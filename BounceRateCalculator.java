import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BounceRateCalculator extends JPanel {
    private JTextField visitsField;
    private JTextField onePageVisitsField;
    private JLabel resultLabel;

    public BounceRateCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        JPanel headingPanel = new JPanel();
        JLabel headingLabel = new JLabel("Bounce Rate Calculator");
        headingLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        headingPanel.add(headingLabel);
        add(headingPanel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel visitsPanel = new JPanel();
        visitsPanel.setLayout(new BoxLayout(visitsPanel, BoxLayout.X_AXIS));
        visitsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel visitsLabel = new JLabel("Number of Visits: ");
        visitsLabel.setFont(labelFont);
        visitsField = new JTextField(10);
        visitsField.setFont(textFieldFont);
        visitsPanel.add(visitsLabel);
        visitsPanel.add(visitsField);
        inputPanel.add(visitsPanel);

        JPanel onePageVisitsPanel = new JPanel();
        onePageVisitsPanel.setLayout(new BoxLayout(onePageVisitsPanel, BoxLayout.X_AXIS));
        onePageVisitsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel onePageVisitsLabel = new JLabel("Number of One-Page Visits: ");
        onePageVisitsLabel.setFont(labelFont);
        onePageVisitsField = new JTextField(10);
        onePageVisitsField.setFont(textFieldFont);
        onePageVisitsPanel.add(onePageVisitsLabel);
        onePageVisitsPanel.add(onePageVisitsField);
        inputPanel.add(onePageVisitsPanel);

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

        resultLabel = new JLabel("Bounce Rate: ");
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
                double onePageVisits = Double.parseDouble(onePageVisitsField.getText());
                double visits = Double.parseDouble(visitsField.getText());
                double bounceRate = onePageVisits / visits;
                resultLabel.setText(String.format("Bounce Rate: %.2f", bounceRate));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}