package RegEvent;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class TimeEventRun {
    String te,mi,ma;
    public TimeEventRun(int r,String beg,String end,String nameEv) throws ParseException {
        int iBeg,iEnd;
        DateFormat formatOld = new SimpleDateFormat("dd-MM-yyyy");  //наш формат
        DateFormat formatNew = new SimpleDateFormat("yyyyMMdd");    //амер. формат
        double min=999999;
        double max=-999999;
        double sum=0;
        boolean w;
        for (int i = 0; i < BufEv.masMyEvent.size(); i++) {
            List s = List.of(BufEv.masMyEvent.get(i));                     //очередную i-я строка пишем в s
            //перевод даты из базы в число с учетом статуса Было и Будет
            int iBD = Integer.parseInt(formatNew.format(formatOld.parse(r==3?s.get(4).toString():s.get(0).toString())));
            if (beg.equals("")) iBeg = 0;
            else iBeg = Integer.parseInt(formatNew.format(formatOld.parse(beg)));
            if (end.equals("")) iEnd = 99990000;
            else iEnd = Integer.parseInt(formatNew.format(formatOld.parse(end)));
            if (r==3) w=(iBD >= iBeg && iBD <= iEnd) && (s.get(3).equals("Будет"));
            else w=(iBD >= iBeg && iBD <= iEnd) && (s.get(1).equals(nameEv)) && (s.get(3).equals("Was"));
            if (w) {
                switch (r) {
                    case 0: {sum = sum + Double.parseDouble(s.get(2).toString()); break;}
                    case 1: {if (Double.parseDouble(s.get(2).toString()) < min) min = Double.parseDouble(s.get(2).toString());break;}
                    case 2: {if (Double.parseDouble(s.get(2).toString()) > max)max = Double.parseDouble(s.get(2).toString());break;}
                    default:break;
                }
            }
        };
        te= String.valueOf(sum);
        mi= String.valueOf(min);
        ma= String.valueOf(max);

    }
    public String getTe() {return te;}
    public String getMin() {return mi;}
    public String getMax() {return ma;}
}
