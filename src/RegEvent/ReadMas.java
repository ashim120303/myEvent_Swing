package RegEvent;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ReadMas {
    int iBeg, iEnd, ko;

    public ReadMas(boolean priznak, String beg, String end) {
        try {
            File file = new File(BufEv.path);
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            DateFormat formatOld = new SimpleDateFormat("dd-MM-yyyy");  //наш формат
            DateFormat formatNew = new SimpleDateFormat("yyyyMMdd");    //амер. формат
            double min = 999999;
            double max = -999999;
            boolean w;
            // считаем сначала первую строку
            String line = reader.readLine();
            if (line == null) {
                ko = 1;
                return;
            }
            MasBuf masBuf = new MasBuf(true);             //обнуляем массив
            while (true) {
                // считываем очередную строку цикле
                line = reader.readLine();
                if (line != null) {
                    BufEv.currDate = line;
                    BufEv.nameEv = reader.readLine();
                    BufEv.timeEv = reader.readLine();
                    BufEv.nameSos = reader.readLine();
                    BufEv.futureDate = reader.readLine();
                    if (priznak) {
                        if (BufEv.nameSos.equals("Will")) {
                            int iBD = Integer.parseInt(formatNew.format(formatOld.parse(BufEv.futureDate)));
                            if (beg.equals("")) iBeg = 0;
                            else iBeg = Integer.parseInt(formatNew.format(formatOld.parse(beg)));
                            if (end.equals("")) iEnd = 99990000;
                            else iEnd = Integer.parseInt(formatNew.format(formatOld.parse(end)));
                            if (iBD >= iBeg && iBD <= iEnd) new MasBuf(false);
                        }
                    }
                    else new MasBuf(false);
                }
                else break;
                ko=0;
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            ko=2;
        } catch (IOException e) {
            ko=2;
        } catch (ParseException e) {
            ko=2;
        }
    }
}
