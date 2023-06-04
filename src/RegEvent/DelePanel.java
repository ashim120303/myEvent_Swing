package RegEvent;
import javax.swing.*;

public class DelePanel {
    public DelePanel(JPanel panel) {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
    }
}
