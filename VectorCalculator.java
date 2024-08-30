import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class VectorCalculator extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JTextField field3;
    private JTextField field4;
    private JLabel resultLabel;

    public VectorCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Vector Calculator**
        JLabel calculatorLabel = new JLabel("Vector Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel vector1Panel = new JPanel();
        vector1Panel.setLayout(new BoxLayout(vector1Panel, BoxLayout.X_AXIS));
        vector1Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel vector1Label = new JLabel("Vector 1:");
        vector1Label.setFont(labelFont);
        vector1Panel.add(vector1Label);

        JPanel x1Panel = new JPanel();
        x1Panel.setLayout(new BoxLayout(x1Panel, BoxLayout.X_AXIS));
        x1Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel x1Label = new JLabel("X 1: ");
        x1Label.setFont(labelFont);
        field1 = new JTextField(10);
        field1.setFont(textFieldFont);
        x1Panel.add(x1Label);
        x1Panel.add(field1);
        inputPanel.add(x1Panel);

        JPanel y1Panel = new JPanel();
        y1Panel.setLayout(new BoxLayout(y1Panel, BoxLayout.X_AXIS));
        y1Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel y1Label = new JLabel("Y 1: ");
        y1Label.setFont(labelFont);
        field2 = new JTextField(10);
        field2.setFont(textFieldFont);
        y1Panel.add(y1Label);
        y1Panel.add(field2);
        inputPanel.add(y1Panel);

        JPanel vector2Panel = new JPanel();
        vector2Panel.setLayout(new BoxLayout(vector2Panel, BoxLayout.X_AXIS));
        vector2Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel vector2Label = new JLabel("Vector 2:");
        vector2Label.setFont(labelFont);
        vector2Panel.add(vector2Label);
        inputPanel.add(vector2Panel);

        JPanel x2Panel = new JPanel();
        x2Panel.setLayout(new BoxLayout(x2Panel, BoxLayout.X_AXIS));
        x2Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel x2Label = new JLabel("X 2: ");
        x2Label.setFont(labelFont);
        field3 = new JTextField(10);
        field3.setFont(textFieldFont);
        x2Panel.add(x2Label);
        x2Panel.add(field3);
        inputPanel.add(x2Panel);

        JPanel y2Panel = new JPanel();
        y2Panel.setLayout(new BoxLayout(y2Panel, BoxLayout.X_AXIS));
        y2Panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel y2Label = new JLabel("Y 2: ");
        y2Label.setFont(labelFont);
        field4 = new JTextField(10);
        field4.setFont(textFieldFont);
        y2Panel.add(y2Label);
        y2Panel.add(field4);
        inputPanel.add(y2Panel);

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
                double x1 = Double.parseDouble(field1.getText());
                double y1 = Double.parseDouble(field2.getText());
                double x2 = Double.parseDouble(field3.getText());
                double y2 = Double.parseDouble(field4.getText());
                double resultX = x2 - x1;
    double resultY = y2 - y1; 
resultLabel.setText(String.format("Result: %.2f", resultX,resultY));
} catch (NumberFormatException ex) {
resultLabel.setText("Please enter valid numbers.");
}
}
}
}
