import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DopplerEffectCalculator extends JPanel {
    private JTextField sourceFrequencyField;
    private JTextField velocitySourceField;
    private JTextField velocityObserverField;
    private JLabel resultLabel;

    public DopplerEffectCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // Add a heading
        JLabel heading = new JLabel("Doppler Effect Calculator");
        heading.setFont(new Font("Poppins", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        add(inputPanel, BorderLayout.CENTER);

        JPanel sourceFrequencyPanel = new JPanel();
        sourceFrequencyPanel.setLayout(new BoxLayout(sourceFrequencyPanel, BoxLayout.X_AXIS));
        sourceFrequencyPanel.add(new JLabel("Source Frequency (Hz):"));
        sourceFrequencyField = new JTextField(10);
        sourceFrequencyPanel.add(sourceFrequencyField);
        inputPanel.add(sourceFrequencyPanel);

        JPanel velocitySourcePanel = new JPanel();
        velocitySourcePanel.setLayout(new BoxLayout(velocitySourcePanel, BoxLayout.X_AXIS));
        velocitySourcePanel.add(new JLabel("Velocity of Source (m/s):"));
        velocitySourceField = new JTextField(10);
        velocitySourcePanel.add(velocitySourceField);
        inputPanel.add(velocitySourcePanel);

        JPanel velocityObserverPanel = new JPanel();
        velocityObserverPanel.setLayout(new BoxLayout(velocityObserverPanel, BoxLayout.X_AXIS));
        velocityObserverPanel.add(new JLabel("Velocity of Observer (m/s):"));
        velocityObserverField = new JTextField(10);
        velocityObserverPanel.add(velocityObserverField);
        inputPanel.add(velocityObserverPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        add(buttonPanel, BorderLayout.SOUTH);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        resultLabel = new JLabel("Observed Frequency: ");
        buttonPanel.add(resultLabel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double sourceFrequency = Double.parseDouble(sourceFrequencyField.getText());
                double velocitySource = Double.parseDouble(velocitySourceField.getText());
                double velocityObserver = Double.parseDouble(velocityObserverField.getText());
                double speedOfSound = 343.2; // Speed of sound in air in m/s
                double result = sourceFrequency * (speedOfSound + velocityObserver) / (speedOfSound - velocitySource); // Observed frequency
                
                resultLabel.setText(String.format("Observed Frequency: %.2f Hz", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}