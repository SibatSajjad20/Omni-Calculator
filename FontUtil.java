import javax.swing.*;
import java.awt.*;

public class FontUtil {

    public static void setFontForAllComponents(Container container, Font font) {
        for (Component component : container.getComponents()) {
            component.setFont(font);
            if (component instanceof Container) {
                setFontForAllComponents((Container) component, font);
            }
        }
    }
}
