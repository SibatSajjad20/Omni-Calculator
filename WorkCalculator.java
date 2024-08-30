import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class WorkCalculator extends JPanel {
private JTextField field1;
private JTextField field2;
private JTextField field3;
private JLabel resultLabel;

public WorkCalculator(OmniCalculator mainFrame) {
    setLayout(new BorderLayout());

JLabel headingLabel = new JLabel("Work Calculator", SwingConstants.CENTER);
headingLabel.setFont(new Font("POPPINS", Font.BOLD, 18));
add(headingLabel, BorderLayout.NORTH);

JPanel contentPanel = new JPanel(new GridLayout(5, 2));
contentPanel.add(new JLabel("force :"));
field1 = new JTextField();
contentPanel.add(field1);

contentPanel.add(new JLabel("distance :"));
field2 = new JTextField();
contentPanel.add(field2);
contentPanel.add(new JLabel("angle :"));
field3 = new JTextField();
contentPanel.add(field3);

JButton calculateButton = new JButton("Calculate");
calculateButton.addActionListener(new CalculateButtonListener());
contentPanel.add(calculateButton);

resultLabel = new JLabel("Work: ");
resultLabel.setFont(new Font("POPPINS", Font.BOLD, 18));
contentPanel.add(resultLabel);

JButton backButton = new JButton("Back");
backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
contentPanel.add(backButton);
contentPanel.setFont(new Font("POPPINS", Font.BOLD, 18));
add(contentPanel, BorderLayout.CENTER);
}

private class CalculateButtonListener implements ActionListener {
@Override
public void actionPerformed(ActionEvent e) {
try {
    double force = Double.parseDouble(field1.getText());
    double distance = Double.parseDouble(field2.getText());
    double angle = Math.toRadians(Double.parseDouble(field3.getText()));
    double result = force * distance * Math.cos(angle);
resultLabel.setText(String.format("Work: %.2f", result));
} catch (NumberFormatException ex) {
resultLabel.setText("Please enter valid numbers.");
}
}
}
}
