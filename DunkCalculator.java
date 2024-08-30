import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DunkCalculator extends JPanel {
    private JTextField heightField;
    private JTextField verticalLeapField;
    private JLabel resultLabel;

    public DunkCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // Add a heading
        JLabel heading = new JLabel("Dunk Calculator");
        heading.setFont(new Font("Arial", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        add(inputPanel, BorderLayout.CENTER);

        JPanel heightPanel = new JPanel();
        heightPanel.setLayout(new BoxLayout(heightPanel, BoxLayout.X_AXIS));
        heightPanel.add(new JLabel("Height (ft):"));
        heightField = new JTextField(10);
        heightPanel.add(heightField);
        inputPanel.add(heightPanel);

        JPanel verticalLeapPanel = new JPanel();
        verticalLeapPanel.setLayout(new BoxLayout(verticalLeapPanel, BoxLayout.X_AXIS));
        verticalLeapPanel.add(new JLabel("Vertical Leap (ft):"));
        verticalLeapField = new JTextField(10);
        verticalLeapPanel.add(verticalLeapField);
        inputPanel.add(verticalLeapPanel);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        add(buttonPanel, BorderLayout.SOUTH);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        resultLabel = new JLabel("Result: ");
        buttonPanel.add(resultLabel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double height = Double.parseDouble(heightField.getText());
                double verticalLeap = Double.parseDouble(verticalLeapField.getText());
                double rimHeight = 10.0;
                boolean canDunk = (height + verticalLeap) >= rimHeight;
                resultLabel.setText(canDunk ? "You can dunk!" : "You can't dunk.");
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}