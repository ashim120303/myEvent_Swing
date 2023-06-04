package RegEvent;
import javax.swing.*;

public class WrTimeEv {
    public WrTimeEv(String time) {
        JFrame jF = new JFrame();
        try {
            BufEv.timeEv= String.valueOf(Double.parseDouble(time));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(jF, "The duration of the event is specified incorrectly!","My Events",JOptionPane.ERROR_MESSAGE);
            BufEv.timeEv=null;
        }
    }
}
