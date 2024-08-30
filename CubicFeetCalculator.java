import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CubicFeetCalculator extends JPanel {
    private JTextField lengthField;
    private JTextField widthField;
    private JTextField heightField;
    private JLabel resultLabel;

    public CubicFeetCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Add some spacing

        // Add a heading
        JLabel heading = new JLabel("Cubic Feet Calculator");
        heading.setFont(new Font("Poppins", Font.BOLD, 18));
        add(heading, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        add(inputPanel, BorderLayout.CENTER);

        inputPanel.add(new JLabel("Length (feet):"));
        lengthField = new JTextField(10);
        inputPanel.add(lengthField);

        inputPanel.add(new JLabel("Width (feet):"));
        widthField = new JTextField(10);
        inputPanel.add(widthField);

        inputPanel.add(new JLabel("Height (feet):"));
        heightField = new JTextField(10);
        inputPanel.add(heightField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        add(buttonPanel, BorderLayout.SOUTH);

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        resultLabel = new JLabel("Volume: ");
        buttonPanel.add(resultLabel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double length = Double.parseDouble(lengthField.getText());
                double width = Double.parseDouble(widthField.getText());
                double height = Double.parseDouble(heightField.getText());
                double volume = length * width * height;
                resultLabel.setText(String.format("Volume: %.2f cubic feet", volume));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}