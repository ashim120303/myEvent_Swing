package RegEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class DateReg {
    public DateReg() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        BufEv.currDate = (String) date.format(form);
    }
}
