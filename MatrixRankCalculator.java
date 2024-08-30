import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MatrixRankCalculator extends JPanel {
    private JTextField matrixRowsField;
    private JTextField matrixColumnsField;
    private JLabel resultLabel;

    public MatrixRankCalculator(OmniCalculator mainFrame) {
        setLayout(new BorderLayout());

        // **Matrix Rank Calculator**
        JLabel calculatorLabel = new JLabel("Matrix Rank Calculator");
        calculatorLabel.setFont(new Font("Poppins", Font.BOLD, 24));
        calculatorLabel.setHorizontalAlignment(JLabel.CENTER);
        add(calculatorLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(inputPanel, BorderLayout.CENTER);

        Font labelFont = new Font("Poppins", Font.PLAIN, 18);
        Font textFieldFont = new Font("Poppins", Font.PLAIN, 18);

        JPanel matrixRowsPanel = new JPanel();
        matrixRowsPanel.setLayout(new BoxLayout(matrixRowsPanel, BoxLayout.X_AXIS));
        matrixRowsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel matrixRowsLabel = new JLabel("Matrix Rows: ");
        matrixRowsLabel.setFont(labelFont);
        matrixRowsField = new JTextField(20);
        matrixRowsField.setFont(textFieldFont);
        matrixRowsPanel.add(matrixRowsLabel);
        matrixRowsPanel.add(matrixRowsField);
        inputPanel.add(matrixRowsPanel);

        JPanel matrixColumnsPanel = new JPanel();
        matrixColumnsPanel.setLayout(new BoxLayout(matrixColumnsPanel, BoxLayout.X_AXIS));
        matrixColumnsPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        JLabel matrixColumnsLabel = new JLabel("Matrix Columns: ");
        matrixColumnsLabel.setFont(labelFont);
        matrixColumnsField = new JTextField(20);
        matrixColumnsField.setFont(textFieldFont);
        matrixColumnsPanel.add(matrixColumnsLabel);
        matrixColumnsPanel.add(matrixColumnsField);
        inputPanel.add(matrixColumnsPanel);

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

        resultLabel = new JLabel("Matrix Rank: ");
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
                int rows = Integer.parseInt(matrixRowsField.getText());
                int columns = Integer.parseInt(matrixColumnsField.getText());
                // Calculate the matrix rank based on the number of rows and columns
                // For example, the rank of a matrix is the minimum of its number of rows and columns
                int result = Math.min(rows, columns);
                resultLabel.setText(String.format("Matrix Rank: %d", result));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Please enter valid numbers.");
            }
        }
    }
}