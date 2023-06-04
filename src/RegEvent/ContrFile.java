package RegEvent;

import java.io.File;

public class ContrFile {
    boolean ko;
    public ContrFile() {
        if (new File(BufEv.path).isFile()) {ko=true;}
        else {ko=false;}
    }
    public boolean getKo() {
        return ko;
    }
}
