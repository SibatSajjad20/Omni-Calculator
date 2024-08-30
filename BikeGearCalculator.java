import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BikeGearCalculator extends JPanel {
    private JTextField frontTeethField;
    private JTextField rearTeethField;
    private JTextField wheelDiameterField;
    private JLabel resultLabel;

    public BikeGearCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Bike Gear Calculator**
        JLabel calculatorLabel = new JLabel("Bike Gear Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel frontTeethPanel = new JPanel();
        frontTeethPanel.setLayout(new BoxLayout(frontTeethPanel, BoxLayout.X_AXIS));
        frontTeethPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel frontTeethLabel = new JLabel("Front Teeth: ");
        frontTeethLabel.setFont(labelFont);
        frontTeethField = new JTextField(10);
        frontTeethField.setFont(textFieldFont);
        frontTeethPanel.add(frontTeethLabel);
        frontTeethPanel.add(frontTeethField);
        inputPanel.add(frontTeethPanel);

        JPanel rearTeethPanel = new JPanel();
        rearTeethPanel.setLayout(new BoxLayout(rearTeethPanel, BoxLayout.X_AXIS));
        rearTeethPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel rearTeethLabel = new JLabel("Rear Teeth: ");
        rearTeethLabel.setFont(labelFont);
        rearTeethField = new JTextField(10);
        rearTeethField.setFont(textFieldFont);
        rearTeethPanel.add(rearTeethLabel);
        rearTeethPanel.add(rearTeethField);
        inputPanel.add(rearTeethPanel);

        JPanel wheelDiameterPanel = new JPanel();
        wheelDiameterPanel.setLayout(new BoxLayout(wheelDiameterPanel, BoxLayout.X_AXIS));
        wheelDiameterPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel wheelDiameterLabel = new JLabel("Wheel Diameter (inches): ");
        wheelDiameterLabel.setFont(labelFont);
        wheelDiameterField = new JTextField(10);
        wheelDiameterField.setFont(textFieldFont);
        wheelDiameterPanel.add(wheelDiameterLabel);
        wheelDiameterPanel.add(wheelDiameterField);
        inputPanel.add(wheelDiameterPanel);

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
                int frontTeeth = Integer.parseInt(frontTeethField.getText());
                int rearTeeth = Integer.parseInt(rearTeethField.getText());
                if (rearTeeth == 0) {
                    throw new ArithmeticException("Rear teeth cannot be 0");
                }
                double wheelDiameter = Double.parseDouble(wheelDiameterField.getText());
                double distancePerPedalStroke = calculateDistancePerPedalStroke(frontTeeth, rearTeeth, wheelDiameter);
                resultLabel.setText(String.format("Distance per pedal stroke: %.2f inches", distancePerPedalStroke));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            } catch (ArithmeticException ex) {
                resultLabel.setText("Rear teeth cannot be 0.");
            }
        }
    }

    private double calculateDistancePerPedalStroke(int frontTeeth, int rearTeeth, double wheelDiameter) {
        return (frontTeeth / (double) rearTeeth) * wheelDiameter * Math.PI;
    }
}