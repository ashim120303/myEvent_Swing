import RegEvent.MenuFile;
import RegEvent.MenuQw;
import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class Main{
    public static void main(String args[])
    {
        final JFrame window = new JFrame("My event");
        window.setDefaultCloseOperation( EXIT_ON_CLOSE );
        window.setLocation(520,120);
        JPanel panel = new JPanel();
        JMenuBar menuBar = new JMenuBar();
        // Добавление в главное меню выпадающих пунктов меню
        MenuFile menuFile=new MenuFile();
        menuBar.add(menuFile.createFileMenu(window,panel));
        MenuQw menuQw=new MenuQw();
        menuBar.add(menuQw.createQwMenu(window, panel));
        // Подключаем меню к интерфейсу приложения
        window.setJMenuBar(menuBar);
        // Открытие окна
        window.setSize(270, 300);
        window.setVisible(true);
    }
}