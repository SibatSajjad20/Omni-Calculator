import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MeshToMicronConverter extends JPanel {
    private JTextField meshField;
    private JLabel resultLabel;

    public MeshToMicronConverter(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Mesh to Micron Converter**
        JLabel converterLabel = new JLabel("Mesh to Micron Converter");
        converterLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        converterLabel.setHorizontalAlignment(JLabel.CENTER);
        add(converterLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel meshPanel = new JPanel();
        meshPanel.setLayout(new BoxLayout(meshPanel, BoxLayout.X_AXIS));
        meshPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel meshLabel = new JLabel("Mesh: ");
        meshLabel.setFont(labelFont);
        meshField = new JTextField(20);
        meshField.setFont(textFieldFont);
        meshPanel.add(meshLabel);
        meshPanel.add(meshField);
        inputPanel.add(meshPanel);

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

        resultLabel = new JLabel("Microns: ");
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
                double mesh = Double.parseDouble(meshField.getText());
                double microns = 25400 / mesh;
                resultLabel.setText(String.format("Microns: %.2f", microns));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter a valid number.");
            }
        }
    }
}