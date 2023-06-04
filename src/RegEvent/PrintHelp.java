package RegEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.List;

public class PrintHelp extends Help {
    public PrintHelp(int nTop,int xTop,int yTop) {
        super(nTop,xTop,yTop);
   }
    @Override
    public void printTop() {
        JFrame frame = new JFrame("Help");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JButton buttonCont = new JButton("Continue viewing?");
        panel2.add(buttonCont);
        List s = List.of(BufEv.textHelp.get(nTop));
        JList list = new JList(s.toArray());
        panel.add(list);
        JScrollPane scrollPane = new JScrollPane(list);
        frame.add(panel, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.SOUTH);
        frame.getContentPane().add(scrollPane);
        frame.setPreferredSize(new Dimension(xTop, yTop));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        buttonCont.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
                if (nTop==4)nTop=0;
                else {
                    nTop++;
                    printTop();
                }
            }
        });
    }
}
