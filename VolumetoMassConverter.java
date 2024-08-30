import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class VolumetoMassConverter extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JLabel resultLabel;

    public VolumetoMassConverter(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Volume to Mass Converter**
        JLabel calculatorLabel = new JLabel("Volume to Mass Converter");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel volumePanel = new JPanel();
        volumePanel.setLayout(new BoxLayout(volumePanel, BoxLayout.X_AXIS));
        volumePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel volumeLabel = new JLabel("Volume (m³): ");
        volumeLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        volumePanel.add(volumeLabel);
        volumePanel.add(field1);
        inputPanel.add(volumePanel);

        JPanel densityPanel = new JPanel();
        densityPanel.setLayout(new BoxLayout(densityPanel, BoxLayout.X_AXIS));
        densityPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel densityLabel = new JLabel("Density (kg/m³): ");
        densityLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        densityPanel.add(densityLabel);
        densityPanel.add(field2);
        inputPanel.add(densityPanel);

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
                double volume = Double.parseDouble(field1.getText());
                double density = Double.parseDouble(field2.getText());
                double result = volume * density;
                resultLabel.setText(String.format("Result: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}