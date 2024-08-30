import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DecimeterToMeterConverter extends JPanel {
    private JTextField inputField;
    private JLabel resultLabel;

    public DecimeterToMeterConverter(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // Add a heading
        JLabel heading = new JLabel("Decimeter to Meter Converter");
        heading.setFont(new Font("Poppins", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.X_AXIS));
        add(inputPanel, BorderLayout.CENTER);

        inputPanel.add(new JLabel("Decimeters:"));
        inputField = new JTextField(10);
        inputPanel.add(inputField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        add(buttonPanel, BorderLayout.SOUTH);

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ConvertButtonListener());
        buttonPanel.add(convertButton);

        resultLabel = new JLabel("Meters: ");
        buttonPanel.add(resultLabel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);
    }

    private class ConvertButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double decimeters = Double.parseDouble(inputField.getText());
                double meters = decimeters / 10;
                resultLabel.setText(String.format("Meters: %.4f", meters));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number.");
            }
        }
    }
}