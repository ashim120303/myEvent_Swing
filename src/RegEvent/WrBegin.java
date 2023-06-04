package RegEvent;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class WrBegin {
    private int ko;
    public WrBegin() {
        try {
            File file = new File(BufEv.path);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(BufEv.header.getBytes());
            fileOutputStream.close();
            ko= 0;
        } catch (IOException e) {
            ko= 1;
        }
    }
    public int getKo() {
        return ko;
    }
}
