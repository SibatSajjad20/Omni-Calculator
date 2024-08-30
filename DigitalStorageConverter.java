import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DigitalStorageConverter extends JPanel {
    private JTextField gigabytesField;
    private JLabel resultLabel;

    public DigitalStorageConverter(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // Add a heading
        JLabel heading = new JLabel("Digital Storage Converter");
        heading.setFont(new Font("Poppins", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        add(inputPanel, BorderLayout.CENTER);

        JPanel gigabytesPanel = new JPanel();
        gigabytesPanel.setLayout(new BoxLayout(gigabytesPanel, BoxLayout.X_AXIS));
        gigabytesPanel.add(new JLabel("Storage in Gigabytes:"));
        gigabytesField = new JTextField(10);
        gigabytesPanel.add(gigabytesField);
        inputPanel.add(gigabytesPanel);

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
                double gigabytes = Double.parseDouble(gigabytesField.getText());
                double result = gigabytes * 1024; // Convert Gigabytes to Megabytes
                resultLabel.setText(String.format("Storage in Megabytes: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}