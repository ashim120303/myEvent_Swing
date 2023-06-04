package RegEvent;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ReadNameEv {
    private String nameEv;
    public ReadNameEv(boolean b) {
        if (b) {
            Dimension labelSize = new Dimension(80, 80);
            Border solidBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BorderLayout());

            JPanel alignmentPanel = new JPanel(new FlowLayout());
            alignmentPanel.setBorder(BorderFactory.createTitledBorder("Ввод"));

            Font font = new Font("Verdana", Font.PLAIN, 12);

            JLabel topLabel = new JLabel("Event name");
            alignmentPanel.add(topLabel);
        }
        else BufEv.nameEv=null;
    }

}
