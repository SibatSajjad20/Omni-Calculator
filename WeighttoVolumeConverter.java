import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class WeighttoVolumeConverter extends JPanel {
    private JTextField field1;
    private JTextField field2;
    private JLabel resultLabel;

    public WeighttoVolumeConverter(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());
// Add a heading panel
JPanel headingPanel = new JPanel();
headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
add(headingPanel, BorderLayout.NORTH);

Font headingFont = new Font("Poppins", Font.BOLD, 24);
JLabel headingLabel = new JLabel("Weight to Volume Converter");
headingLabel.setFont(headingFont);
headingPanel.add(headingLabel);
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel valuePanel = new JPanel();
        valuePanel.setLayout(new BoxLayout(valuePanel, BoxLayout.X_AXIS));
        valuePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel valueLabel = new JLabel("Weight: ");
        valueLabel.setFont(labelFont);
        field1 = new JTextField(5);
        field1.setFont(textFieldFont);
        valuePanel.add(valueLabel);
        valuePanel.add(field1);
        inputPanel.add(valuePanel);

        JPanel meanPanel = new JPanel();
        meanPanel.setLayout(new BoxLayout(meanPanel, BoxLayout.X_AXIS));
        meanPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel meanLabel = new JLabel("Density: ");
        meanLabel.setFont(labelFont);
        field2 = new JTextField(5);
        field2.setFont(textFieldFont);
        meanPanel.add(meanLabel);
        meanPanel.add(field2);
        inputPanel.add(meanPanel);
       

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

        resultLabel = new JLabel("Z Score: ");
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
          double weight = Double.parseDouble(field1.getText());
          double density = Double.parseDouble(field2.getText());
          double result = weight / density; // Result in volume units
          
          resultLabel.setText(String.format("Volume: %.2f", result));
          } catch (NumberFormatException ex) {
          resultLabel.setText("Please enter valid numbers.");
          }
          
        }
    }
}
