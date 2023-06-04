package RegEvent;

import java.util.Scanner;

public class WrEv {
    public WrEv() {
        ContrFile contrFile=new ContrFile();                    //проверка наличия файла
        if (contrFile.getKo()) {new WrStrEv();} //запись в базу строку
        else {
            new WrBegin();                      //пишем новый файл myEvent.txt
            new WrStrEv();                     //пишем в базу строку
            }
    }
}

