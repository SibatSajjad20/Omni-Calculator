import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class HealthyBodyFatRangeCalculator extends JPanel {
    private JTextField ageField;
    private JTextField genderField;
    private JLabel resultLabel;

    public HealthyBodyFatRangeCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add a heading panel
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        add(headingPanel, BorderLayout.NORTH);

        Font headingFont = new Font("Poppins", Font.BOLD, 24);
        JLabel headingLabel = new JLabel("Healthy Body Fat Range Calculator");
        headingLabel.setFont(headingFont);
        headingPanel.add(headingLabel);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel agePanel = new JPanel();
        agePanel.setLayout(new BoxLayout(agePanel, BoxLayout.X_AXIS));
        agePanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel ageLabel = new JLabel("Age: ");
        ageLabel.setFont(labelFont);
        ageField = new JTextField(10);
        ageField.setFont(textFieldFont);
        agePanel.add(ageLabel);
        agePanel.add(ageField);
        inputPanel.add(agePanel);

        JPanel genderPanel = new JPanel();
        genderPanel.setLayout(new BoxLayout(genderPanel, BoxLayout.X_AXIS));
        genderPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel genderLabel = new JLabel("Gender: ");
        genderLabel.setFont(labelFont);
        genderField = new JTextField(10);
        genderField.setFont(textFieldFont);
        genderPanel.add(genderLabel);
        genderPanel.add(genderField);
        inputPanel.add(genderPanel);

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
                int age = Integer.parseInt(ageField.getText());
                String gender = genderField.getText();
                double minResult, maxResult;
                if (gender.equalsIgnoreCase("male")) {
                    if (age < 20) {
                        minResult = 8;
                        maxResult = 19;
                    } else if (age < 40) {
                        minResult = 8;
                        maxResult = 19;
                    } else if (age < 60) {
                        minResult = 11;
                        maxResult = 22;
                    } else {
                        minResult = 13;
                        maxResult = 25;
                    }
                } else {
                    if (age < 20) {
                        minResult = 21;
                        maxResult = 33;
                    } else if (age < 40) {
                        minResult = 21;
                        maxResult = 33;
                    } else if (age < 60) {
                        minResult = 23;
                        maxResult = 35;
                    } else {
                        minResult = 24;
                        maxResult = 36;
                    }
                } // Healthy body fat range in percentage
                
                resultLabel.setText(String.format("Result: %.2f - %.2f %%", minResult, maxResult));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}