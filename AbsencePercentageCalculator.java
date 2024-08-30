import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AbsencePercentageCalculator extends JPanel {
    private JTextField totalEmployeesField;
    private JTextField totalWorkDaysField;
    private JTextField totalDaysAbsentField;
    private JLabel resultLabel;

    public AbsencePercentageCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add heading
        JLabel heading = new JLabel("Absence Percentage Calculator");
        heading.setFont(new Font("Poppins", Font.BOLD, 24));
        add(heading, BorderLayout.NORTH);

        // Create input panel with grid layout
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        inputPanel.add(new JLabel("Total Employees:"));
        totalEmployeesField = new JTextField();
        inputPanel.add(totalEmployeesField);

        inputPanel.add(new JLabel("Total Work Days:"));
        totalWorkDaysField = new JTextField();
        inputPanel.add(totalWorkDaysField);

        inputPanel.add(new JLabel("Total Days Absent:"));
        totalDaysAbsentField = new JTextField();
        inputPanel.add(totalDaysAbsentField);

        add(inputPanel, BorderLayout.CENTER);

        // Create button panel with flow layout
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        resultLabel = new JLabel("Absence Percentage: ");
        buttonPanel.add(resultLabel);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Set font and style for labels and buttons
        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font buttonFont = new Font("Poppins", Font.BOLD, 18);

        for (Component component : inputPanel.getComponents()) {
            if (component instanceof JTextField) {
                ((JTextField) component).setFont(labelFont);
            }
        }

        for (Component component : buttonPanel.getComponents()) {
            if (component instanceof JButton) {
                ((JButton) component).setFont(buttonFont);
            } else if (component instanceof JLabel) {
                ((JLabel) component).setFont(labelFont);
            }
        }
    }

    private class CalculateButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double totalEmployees = Double.parseDouble(totalEmployeesField.getText());
                double totalWorkDays = Double.parseDouble(totalWorkDaysField.getText());
                double totalDaysAbsent = Double.parseDouble(totalDaysAbsentField.getText());

                double result = (totalDaysAbsent / (totalEmployees * totalWorkDays)) * 100;
                resultLabel.setText(String.format("Absence Percentage: %.2f", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}