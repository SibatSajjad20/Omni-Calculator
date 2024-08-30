import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AdjointMatrixCalculator extends JPanel {
    private JTextField[][] fields;
    private JLabel resultLabel;

    public AdjointMatrixCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // Add heading
        JLabel heading = new JLabel("Adjoint Matrix Calculator");
        heading.setFont(new Font("Poppins", Font.BOLD, 24));
        add(heading, BorderLayout.NORTH);

        // Create input panel with grid layout
        JPanel inputPanel = new JPanel(new GridLayout(3, 3));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        fields = new JTextField[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                fields[i][j] = new JTextField();
                inputPanel.add(fields[i][j]);
            }
        }

        add(inputPanel, BorderLayout.CENTER);

        // Create button panel with flow layout
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        buttonPanel.add(calculateButton);

        resultLabel = new JLabel("Result: ");
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
                double[][] matrix = new double[3][3];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        matrix[i][j] = Double.parseDouble(fields[i][j].getText());
                    }
                }
                double[][] adjoint = new double[3][3];
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        adjoint[j][i] = (matrix[(i+1)%3][(j+1)%3] * matrix[(i+2)%3][(j+2)%3] - 
                                         matrix[(i+1)%3][(j+2)%3] * matrix[(i+2)%3][(j+1)%3]);
                    }
                }
                StringBuilder result = new StringBuilder("Result:\n");
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        result.append(String.format("%.2f ", adjoint[i][j]));
                    }
                    result.append("\n");
                }
                resultLabel.setText(result.toString());
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}