import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class SpeedOfLightCalculator extends JPanel {
private JLabel resultLabel;

public SpeedOfLightCalculator(OmniCalculator mainFrame) {
setLayout(new GridLayout(4, 2));



JButton calculateButton = new JButton("Calculate");
calculateButton.addActionListener(new CalculateButtonListener());
add(calculateButton);

resultLabel = new JLabel("Result: ");
add(resultLabel);

JButton backButton = new JButton("Back");
backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());
add(backButton);
}

private class CalculateButtonListener implements ActionListener {
@Override
public void actionPerformed(ActionEvent e) {
try {
    double result = 299792458;
resultLabel.setText(String.format("Speed of Light: %.2f", result));
} catch (NumberFormatException ex) {
resultLabel.setText("Please enter valid numbers.");
}
}
}
}
