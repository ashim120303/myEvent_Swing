package RegEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ReadDate {
    private String newDate;
    public ReadDate() throws IOException {
        while (true){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String tempDate = reader.readLine();
            SimpleDateFormat form = new SimpleDateFormat("dd-MM-yyyy");
            try {
                Date date = form.parse(tempDate);
                if (form.format(date).equals(tempDate)) {
                    var format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy", Locale.ENGLISH);
                    var newFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
                    var d = format.parse(date.toString());
                    newDate = newFormat.format(d);
                    break;
                }
                else
                    System.err.println("Date error. Repeat the input - ");
            }
            catch (ParseException e)
            {
                newDate=null;
                break;
            }
        }
    }

    public String getNewDate() {
        return newDate;
    }
}
