import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LightYearConversion extends JPanel {
    private JTextField lightYearsField;
    private JLabel resultLabel;

    public LightYearConversion(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing
        JLabel heading = new JLabel("Light Year Conversion");
        heading.setFont(new Font("Poppins", Font.BOLD, 24));
        add(heading, BorderLayout.NORTH);
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel lightYearsPanel = new JPanel();
        lightYearsPanel.setLayout(new BoxLayout(lightYearsPanel, BoxLayout.X_AXIS));
        lightYearsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel lightYearsLabel = new JLabel("Light Years: ");
        lightYearsLabel.setFont(labelFont);
        lightYearsField = new JTextField(10);
        lightYearsField.setFont(textFieldFont);
        lightYearsPanel.add(lightYearsLabel);
        lightYearsPanel.add(lightYearsField);
        inputPanel.add(lightYearsPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(buttonPanel, BorderLayout.SOUTH);

        JButton convertButton = new JButton("Convert");
        convertButton.setFont(textFieldFont);
        convertButton.addActionListener(new ConvertButtonListener());
        buttonPanel.add(convertButton);

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

    private class ConvertButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double lightYears = Double.parseDouble(lightYearsField.getText());
                double kilometers = lightYears * 9.461e12;
                double miles = lightYears * 5.879e12;
                resultLabel.setText(String.format("Result: %.2f kilometers, %.2f miles", kilometers, miles));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number.");
            }
        }
    }
}