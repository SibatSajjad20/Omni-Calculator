import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CubicYardstoTonsCalculator extends JPanel {
    private JTextField volumeField;
    private JTextField densityField;
    private JLabel resultLabel;

    public CubicYardstoTonsCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // Add a heading
        JLabel heading = new JLabel("Cubic Yards to Tons Calculator");
        heading.setFont(new Font("Poppins", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        add(inputPanel, BorderLayout.CENTER);

        inputPanel.add(new JLabel("Volume (cubic yards):"));
        volumeField = new JTextField(10);
        inputPanel.add(volumeField);

        inputPanel.add(new JLabel("Density (kg/m^3):"));
        densityField = new JTextField(10);
        inputPanel.add(densityField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        add(buttonPanel, BorderLayout.SOUTH);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        resultLabel = new JLabel("Mass (tons): ");
        buttonPanel.add(resultLabel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double volume = Double.parseDouble(volumeField.getText());
                double density = Double.parseDouble(densityField.getText());
                volume = volume * 0.76;
                volume = volume * density;
                double result = volume / 1000;
                resultLabel.setText(String.format("Mass (tons): %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}