package RegEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuFile{
    public JMenu createFileMenu(JFrame window, JPanel panel) {
        // Создание выпадающего меню
        JMenu file = new JMenu("File");
        // Пункт меню "Открыть" с изображением
        JMenuItem wr = new JMenuItem("Input", new ImageIcon("images/wr.png"));
        file.add(wr);
        JMenuItem print = new JMenuItem("Viewing", new ImageIcon("images/find.png"));
        file.add(print);
        JMenuItem help = new JMenuItem("Help", new ImageIcon("images/help.png"));
        file.add(help);
        // Пункт меню из команды с выходом из программы
        JMenuItem exit = new JMenuItem(new ExitAction());
        exit.setIcon(new ImageIcon("images/exit.png"));
        file.addSeparator();
        file.add(exit);
        wr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new RegEv(window, panel);
            }
        });
        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                new ReadMas(false, null, null);
                new PrintEv();
            }
        });
        help.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                    PrintHelp printHelp=new PrintHelp(0,580,300);
                    printHelp.printTop();
            }
        });
        return file;
    }
}
