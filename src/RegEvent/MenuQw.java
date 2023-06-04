package RegEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class MenuQw {
    public JMenu createQwMenu(JFrame window, JPanel panel)
    {
        JFrame jF = new JFrame();
        JMenu file = new JMenu("Requests");
        JMenuItem qt = new JMenuItem("Request",new ImageIcon("images/qt.png"));
        file.add(qt);
        //file.addSeparator();
        JMenuItem help = new JMenuItem("Help",new ImageIcon("images/help.png"));
        file.add(help);

        qt.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    new RunEvent(window,panel);
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(jF,"An incomprehensible error in MenuQw", "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        help.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                PrintHelp printHelp=new PrintHelp(4,580,300);
                printHelp.printTop();
            }
        });
        return file;
    }
}
