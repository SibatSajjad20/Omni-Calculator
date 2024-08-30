import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class InducedEMFCalculator extends JPanel {
    private JTextField magneticFluxChangeField;
    private JTextField timeField;
    private JLabel resultLabel;

    public InducedEMFCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Induced EMF Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel magneticFluxChangePanel = new JPanel();
        magneticFluxChangePanel.setLayout(new BoxLayout(magneticFluxChangePanel, BoxLayout.X_AXIS));
        magneticFluxChangePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel magneticFluxChangeLabel = new JLabel("Magnetic Flux Change (Wb): ");
        magneticFluxChangeLabel.setFont(labelFont);
        magneticFluxChangeField = new JTextField(10);
        magneticFluxChangeField.setFont(textFieldFont);
        magneticFluxChangePanel.add(magneticFluxChangeLabel);
        magneticFluxChangePanel.add(magneticFluxChangeField);
        inputPanel.add(magneticFluxChangePanel);

        JPanel timePanel = new JPanel();
        timePanel.setLayout(new BoxLayout(timePanel, BoxLayout.X_AXIS));
        timePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel timeLabel = new JLabel("Time (s): ");
        timeLabel.setFont(labelFont);
        timeField = new JTextField(10);
        timeField.setFont(textFieldFont);
        timePanel.add(timeLabel);
        timePanel.add(timeField);
        inputPanel.add(timePanel);

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

        resultLabel = new JLabel("Induced EMF: ");
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
                double magneticFluxChange = Double.parseDouble(magneticFluxChangeField.getText());
                double time = Double.parseDouble(timeField.getText());
                double result = -magneticFluxChange / time; // Induced EMF (Faraday's law of induction)
                
                resultLabel.setText(String.format("Induced EMF: %.2f V", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}