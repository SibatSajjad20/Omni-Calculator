import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class DistanceCalculator extends JPanel {
    private JTextField x1Field;
    private JTextField y1Field;
    private JTextField x2Field;
    private JTextField y2Field;
    private JLabel resultLabel;

    public DistanceCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // Add a heading
        JLabel heading = new JLabel("Distance Calculator");
        heading.setFont(new Font("Poppins", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        add(inputPanel, BorderLayout.CENTER);

        JPanel point1Panel = new JPanel();
        point1Panel.setLayout(new BoxLayout(point1Panel, BoxLayout.X_AXIS));
        point1Panel.add(new JLabel("Point 1:"));
        JPanel x1Panel = new JPanel();
        x1Panel.setLayout(new BoxLayout(x1Panel, BoxLayout.X_AXIS));
        x1Panel.add(new JLabel("x:"));
        x1Field = new JTextField(5);
        x1Panel.add(x1Field);
        point1Panel.add(x1Panel);
        JPanel y1Panel = new JPanel();
        y1Panel.setLayout(new BoxLayout(y1Panel, BoxLayout.X_AXIS));
        y1Panel.add(new JLabel("y:"));
        y1Field = new JTextField(5);
        y1Panel.add(y1Field);
        point1Panel.add(y1Panel);
        inputPanel.add(point1Panel);

        JPanel point2Panel = new JPanel();
        point2Panel.setLayout(new BoxLayout(point2Panel, BoxLayout.X_AXIS));
        point2Panel.add(new JLabel("Point 2:"));
        JPanel x2Panel = new JPanel();
        x2Panel.setLayout(new BoxLayout(x2Panel, BoxLayout.X_AXIS));
        x2Panel.add(new JLabel("x:"));
        x2Field = new JTextField(5);
        x2Panel.add(x2Field);
        point2Panel.add(x2Panel);
        JPanel y2Panel = new JPanel();
        y2Panel.setLayout(new BoxLayout(y2Panel, BoxLayout.X_AXIS));
        y2Panel.add(new JLabel("y:"));
        y2Field = new JTextField(5);
        y2Panel.add(y2Field);
        point2Panel.add(y2Panel);
        inputPanel.add(point2Panel);

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
                double x1 = Double.parseDouble(x1Field.getText());
                double y1 = Double.parseDouble(y1Field.getText());
                double x2 = Double.parseDouble(x2Field.getText());
                double y2 = Double.parseDouble(y2Field.getText());
                double result = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
                resultLabel.setText(String.format("Distance: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}