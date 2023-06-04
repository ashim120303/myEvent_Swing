package RegEvent;

import java.util.ArrayList;
import java.util.List;
public abstract class Help {
    protected static int nTop,xTop,yTop;

    public Help(int n,int x, int y) {
        nTop=n;
        xTop=x;
        yTop=y;
        BufEv.textHelp.add(BufEv.topic0);
        BufEv.textHelp.add(BufEv.topic1);
        BufEv.textHelp.add(BufEv.topic2);
        BufEv.textHelp.add(BufEv.topic3);
        BufEv.textHelp.add(BufEv.topic4);
    }

    public void printTop(){};
};
