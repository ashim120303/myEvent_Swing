package RegEvent;

public class MasBuf {
    public MasBuf(boolean b) {
        if (b) BufEv.masMyEvent.clear();    //обнуление нашей базы
        else {
            String[] str = new String[] {BufEv.currDate,BufEv.nameEv,BufEv.timeEv,BufEv.nameSos,BufEv.futureDate};
            BufEv.masMyEvent.add(str);      //дозапись в базу текущего события
        }
    }
}
