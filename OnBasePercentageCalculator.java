import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class OnBasePercentageCalculator extends JPanel {
    private JTextField hitsField;
    private JTextField walksField;
    private JTextField hitByPitchField;
    private JTextField atBatsField;
    private JTextField sacrificeFliesField;
    private JLabel resultLabel;

    public OnBasePercentageCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **On Base Percentage Calculator**
        JLabel calculatorLabel = new JLabel("On Base Percentage Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel hitsPanel = new JPanel();
        hitsPanel.setLayout(new BoxLayout(hitsPanel, BoxLayout.X_AXIS));
        hitsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel hitsLabel = new JLabel("Hits: ");
        hitsLabel.setFont(labelFont);
        hitsField = new JTextField(10);
        hitsField.setFont(textFieldFont);
        hitsPanel.add(hitsLabel);
        hitsPanel.add(hitsField);
        inputPanel.add(hitsPanel);

        JPanel walksPanel = new JPanel();
        walksPanel.setLayout(new BoxLayout(walksPanel, BoxLayout.X_AXIS));
        walksPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel walksLabel = new JLabel("Walks: ");
        walksLabel.setFont(labelFont);
        walksField = new JTextField(10);
        walksField.setFont(textFieldFont);
        walksPanel.add(walksLabel);
        walksPanel.add(walksField);
        inputPanel.add(walksPanel);

        JPanel hitByPitchPanel = new JPanel();
        hitByPitchPanel.setLayout(new BoxLayout(hitByPitchPanel, BoxLayout.X_AXIS));
        hitByPitchPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel hitByPitchLabel = new JLabel("Hit By Pitch: ");
        hitByPitchLabel.setFont(labelFont);
        hitByPitchField = new JTextField(10);
        hitByPitchField.setFont(textFieldFont);
        hitByPitchPanel.add(hitByPitchLabel);
        hitByPitchPanel.add(hitByPitchField);
        inputPanel.add(hitByPitchPanel);

        JPanel atBatsPanel = new JPanel();
        atBatsPanel.setLayout(new BoxLayout(atBatsPanel, BoxLayout.X_AXIS));
        atBatsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel atBatsLabel = new JLabel("At Bats: ");
        atBatsLabel.setFont(labelFont);
        atBatsField = new JTextField(10);
        atBatsField.setFont(textFieldFont);
        atBatsPanel.add(atBatsLabel);
        atBatsPanel.add(atBatsField);
        inputPanel.add(atBatsPanel);

        JPanel sacrificeFliesPanel = new JPanel();
        sacrificeFliesPanel.setLayout(new BoxLayout(sacrificeFliesPanel, BoxLayout.X_AXIS));
        sacrificeFliesPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel sacrificeFliesLabel = new JLabel("Sacrifice Flies: ");
        sacrificeFliesLabel.setFont(labelFont);
        sacrificeFliesField = new JTextField(10);
        sacrificeFliesField.setFont(textFieldFont);
        sacrificeFliesPanel.add(sacrificeFliesLabel);
        sacrificeFliesPanel.add(sacrificeFliesField);
        inputPanel.add(sacrificeFliesPanel);

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

        resultLabel = new JLabel("OBP: ");
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
                int hits = Integer.parseInt(hitsField.getText());
                int walks = Integer.parseInt(walksField.getText());
    int hitByPitch = Integer.parseInt(hitByPitchField.getText());
    int atBats = Integer.parseInt(atBatsField.getText());
    int sacrificeFlies = Integer.parseInt(sacrificeFliesField.getText());
    double result = (double)(hits + walks + hitByPitch) / (atBats + walks + hitByPitch + sacrificeFlies); // 
    
resultLabel.setText(String.format("OBP: %.2f", result));
} catch (NumberFormatException ex) {
resultLabel.setText("Please enter valid numbers.");
}
}
}
}
