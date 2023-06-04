package RegEvent;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ControlDate {
    int ko=1;
    public ControlDate(String str) {
        JFrame jF = new JFrame();
        String tempDate = str;
        SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = form.parse(tempDate);
            if (form.format(date).equals(tempDate)) ko=0;
            else JOptionPane.showMessageDialog(jF, "Invalid date", "My Events",JOptionPane.ERROR_MESSAGE);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(jF, "Invalid date","My Events",JOptionPane.ERROR_MESSAGE);
        }
    }
    public int getKo() {
        return ko;
    }
}
