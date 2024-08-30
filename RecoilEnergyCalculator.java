import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class RecoilEnergyCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JLabel resultLabel;

    public RecoilEnergyCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Recoil Energy Calculator**
        JLabel calculatorLabel = new JLabel("Recoil Energy Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel bulletMassPanel = new JPanel();
        bulletMassPanel.setLayout(new BoxLayout(bulletMassPanel, BoxLayout.X_AXIS));
        bulletMassPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel bulletMassLabel = new JLabel("Bullet Mass (kg): ");
        bulletMassLabel.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        bulletMassPanel.add(bulletMassLabel);
        bulletMassPanel.add(field1);
        inputPanel.add(bulletMassPanel);

        JPanel bulletVelocityPanel = new JPanel();
        bulletVelocityPanel.setLayout(new BoxLayout(bulletVelocityPanel, BoxLayout.X_AXIS));
        bulletVelocityPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel bulletVelocityLabel = new JLabel("Bullet Velocity (m/s): ");
        bulletVelocityLabel.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        bulletVelocityPanel.add(bulletVelocityLabel);
        bulletVelocityPanel.add(field2);
        inputPanel.add(bulletVelocityPanel);

        JPanel gunMassPanel = new JPanel();
        gunMassPanel.setLayout(new BoxLayout(gunMassPanel, BoxLayout.X_AXIS));
        gunMassPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel gunMassLabel = new JLabel("Gun Mass (kg): ");
        gunMassLabel.setFont(labelFont);
        field3 = new JTextField(10);
        field3.setFont(textFieldFont);
        gunMassPanel.add(gunMassLabel);
        gunMassPanel.add(field3);
        inputPanel.add(gunMassPanel);

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
                double bulletMass = Double.parseDouble(field1.getText());
                double bulletVelocity = Double.parseDouble(field2.getText());
                double gunMass = Double.parseDouble(field3.getText());
                double result = 0.5 * bulletMass * Math.pow(bulletVelocity, 2) * (bulletMass / (bulletMass + gunMass));
                resultLabel.setText(String.format("Recoil Energy: %.2f J", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}