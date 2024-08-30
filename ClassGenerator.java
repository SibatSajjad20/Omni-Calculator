import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ClassGenerator {
    private static final String TEMPLATE = 
        "import javax.swing.*;\n" +
        "import java.awt.*;\n" +
        "import java.awt.event.ActionEvent;\n" +
        "import java.awt.event.ActionListener;\n\n" +
        "class {class_name} extends JPanel {\n" +
        "    private JTextField field1;\n" +
        "    private JTextField field2;\n" +
        "    private JLabel resultLabel;\n\n" +
        "    public {class_name}(OmniCalculator mainFrame) {\n" +
        "        setLayout(new GridLayout(4, 2));\n\n" +
        "        add(new JLabel(\"Field:\"));\n" +
        "        field1 = new JTextField();\n" +
        "        add(field1);\n\n" +
        "        add(new JLabel(\"Field:\"));\n" +
        "        field2 = new JTextField();\n" +
        "        add(field2);\n\n" +
        "        JButton calculateButton = new JButton(\"Calculate\");\n" +
        "        calculateButton.addActionListener(new CalculateButtonListener());\n" +
        "        add(calculateButton);\n\n" +
        "        resultLabel = new JLabel(\"Result: \");\n" +
        "        add(resultLabel);\n\n" +
        "        JButton backButton = new JButton(\"Back\");\n" +
        "        backButton.addActionListener(e -> mainFrame.switchToSubcategoryPanel());\n" +
        "        add(backButton);\n" +
        "    }\n\n" +
        "    private class CalculateButtonListener implements ActionListener {\n" +
        "        @Override\n" +
        "        public void actionPerformed(ActionEvent e) {\n" +
        "            try {\n" +
        "                double value1 = Double.parseDouble(field1.getText());\n" +
        "                double value2 = Double.parseDouble(field2.getText());\n" +
        "                double result = value1 * value2;\n" +
        "                resultLabel.setText(String.format(\"Result: %.2f\", result));\n" +
        "            } catch (NumberFormatException ex) {\n" +
        "                resultLabel.setText(\"Please enter valid numbers.\");\n" +
        "            }\n" +
        "        }\n" +
        "    }\n" +
        "}\n";

    public static void main(String[] args) {
        String subcategoriesFile = "subcategories.txt";
        try {
            List<String> subcategories = Files.readAllLines(Paths.get(subcategoriesFile));
            for (String subcategory : subcategories) {
                generateClassFile(subcategory, TEMPLATE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateClassFile(String className, String template) {
        String content = template.replace("{class_name}", className);
        String fileName = className + ".java";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
