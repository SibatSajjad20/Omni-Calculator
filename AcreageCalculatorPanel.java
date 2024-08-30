import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AcreageCalculatorPanel extends JPanel {
    private JTextField lengthField;
    private JTextField widthField;
    private JLabel resultLabel;

    public AcreageCalculatorPanel(OmniCalculator mainFrame) {
        setLayout(new GridLayout(4, 2));

        add(new JLabel("Length (feet):"));
        lengthField = new JTextField();
        add(lengthField);

        add(new JLabel("Width (feet):"));
        widthField = new JTextField();
        add(widthField);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        add(calculateButton);

        resultLabel = new JLabel("Area (acres): ");
        add(resultLabel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        add(backButton);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double length = Double.parseDouble(lengthField.getText());
                double width = Double.parseDouble(widthField.getText());
                double area = (length * width) / 43560;
                resultLabel.setText(String.format("Area (acres): %.2f", area));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}
