package RegEvent;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FutureDate {
    String futureDate;
    public FutureDate(String str) {
            if (BufEv.nameSos.equals("Will")) {
                JFrame jF = new JFrame();
                String tempDate = str;
                SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    Date date = form.parse(tempDate);
                    if (form.format(date).equals(tempDate)) {
                        futureDate = tempDate;
                    } else JOptionPane.showMessageDialog(jF, "Invalid date", "My Events",JOptionPane.ERROR_MESSAGE);
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(jF, "Invalid date","My Events",JOptionPane.ERROR_MESSAGE);
                }
            }
            else futureDate=BufEv.currDate;
    }
    public String getFutureDate() {
        return futureDate;
    }
}
