import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PixelsToInchesConverter extends JPanel {
    private JTextField pixelsField;
    private JTextField dpiField;
    private JLabel resultLabel;

    public PixelsToInchesConverter(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Pixels to Inches Converter**
        JLabel converterLabel = new JLabel("Pixels to Inches Converter");
        converterLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        converterLabel.setHorizontalAlignment(JLabel.CENTER);
        add(converterLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel pixelsPanel = new JPanel();
        pixelsPanel.setLayout(new BoxLayout(pixelsPanel, BoxLayout.X_AXIS));
        pixelsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel pixelsLabel = new JLabel("Pixels: ");
        pixelsLabel.setFont(labelFont);
        pixelsField = new JTextField(10);
        pixelsField.setFont(textFieldFont);
        pixelsPanel.add(pixelsLabel);
        pixelsPanel.add(pixelsField);
        inputPanel.add(pixelsPanel);

        JPanel dpiPanel = new JPanel();
        dpiPanel.setLayout(new BoxLayout(dpiPanel, BoxLayout.X_AXIS));
        dpiPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel dpiLabel = new JLabel("DPI: ");
        dpiLabel.setFont(labelFont);
        dpiField = new JTextField(10);
        dpiField.setFont(textFieldFont);
        dpiPanel.add(dpiLabel);
        dpiPanel.add(dpiField);
        inputPanel.add(dpiPanel);

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

        resultLabel = new JLabel("Inches: ");
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
                double pixels = Double.parseDouble(pixelsField.getText());
                double dpi = Double.parseDouble(dpiField.getText());
                double inches = pixels / dpi;
                resultLabel.setText(String.format("Inches: %.2f", inches));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}