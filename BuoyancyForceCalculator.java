import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BuoyancyForceCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JLabel resultLabel;

    public BuoyancyForceCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        JPanel headingPanel = new JPanel();
        JLabel headingLabel = new JLabel("Buoyancy Force Calculator");
        headingLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        headingPanel.add(headingLabel);
        add(headingPanel, BorderLayout.NORTH);

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

        JPanel fluidDensityPanel = new JPanel();
        fluidDensityPanel.setLayout(new BoxLayout(fluidDensityPanel, BoxLayout.X_AXIS));
        fluidDensityPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel fluidDensityLabel = new JLabel("Fluid Density (kg/m³): ");
        fluidDensityLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        fluidDensityPanel.add(fluidDensityLabel);
        fluidDensityPanel.add(field2);
        inputPanel.add(fluidDensityPanel);

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
                double fluidDensity = Double.parseDouble(field2.getText());
                double gravitationalAcceleration = 9.81; // m/s^2
                double result = fluidDensity * volume * gravitationalAcceleration; // Buoyant force
                
                resultLabel.setText(String.format("Buoyant Force: %.2f N", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}