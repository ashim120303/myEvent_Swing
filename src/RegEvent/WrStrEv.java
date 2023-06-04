package RegEvent;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WrStrEv {
    private int ko;
    public WrStrEv() {
        try {
            FileWriter writer = new FileWriter(BufEv.path, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write("\n"+BufEv.currDate+"\n"+BufEv.nameEv+"\n"+BufEv.timeEv+"\n"+BufEv.nameSos+"\n"+BufEv.futureDate);
            bufferWriter.close();
            ko= 0;
        } catch (IOException e) {
            ko= 1;
        }
    }
    public int getKo() {
        return ko;
    }
}
