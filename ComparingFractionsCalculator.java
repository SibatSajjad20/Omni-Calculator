import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class AddingFractionsCalculator extends JPanel {
private JTextField field1;
private JTextField field2;
private JTextField field3;
private JTextField field4;
private JLabel resultLabel;


public AddingFractionsCalculator(OmniCalculator mainFrame) {
setLayout(new GridLayout(6, 2));

add(new JLabel("Num 1:"));
field1 = new JTextField();
add(field1);

add(new JLabel("Den 1:"));
field2 = new JTextField();
add(field2);

add(new JLabel("Num 2:"));
field3 = new JTextField();
add(field3);

add(new JLabel("Den 2:"));
field4 = new JTextField();
add(field4);

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
    int num1 = Integer.parseInt(field1.getText());
int den1 = Integer.parseInt(field2.getText());
int num2 = Integer.parseInt(field3.getText());
int den2 = Integer.parseInt(field4.getText());
double fraction1 = (double) num1 / den1;
double fraction2 = (double) num2 / den2;
String result = fraction1 > fraction2 ? ">" : (fraction1 < fraction2 ? "<" : "=");
resultLabel.setText(String.format("Result: %.2f", result));
} catch (NumberFormatException ex) {
resultLabel.setText("Please enter valid numbers.");
}
}
}
}

