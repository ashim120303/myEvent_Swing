package RegEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegEv {
    public RegEv(JFrame window, JPanel panel) {
        new DelePanel(panel);
        // Создание панели внизу и добавление компонентов
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel labelD = new JLabel("Current date ");
        new DateReg();
        JTextField textEv = new JTextField(BufEv.currDate);
        textEv.setEditable(false); //запрет на ввод
        JLabel labelName = new JLabel("Event name ");
        DirEnum[] items = DirEnum.values();
        JComboBox editName = new JComboBox(items);
        editName.setEditable(false);

        JLabel labelTime = new JLabel("Duration of the event ");
        JTextField time = new JTextField(7);

        JLabel labelStatus = new JLabel("Event status ");
        String[] itemsStatus = {"Was", "Will"};
        JComboBox editStaus = new JComboBox(itemsStatus);
        BufEv.nameSos="Was";
        editStaus.setEditable(false);

        BufEv.futureDate = BufEv.currDate;
        JLabel labelFutureDate = new JLabel("Event date ");
        JTextField futureD = new JTextField(2);
        JLabel label1 = new JLabel("-");
        JTextField futureM = new JTextField(2);
        JLabel label2 = new JLabel("-");
        JTextField futureG = new JTextField(4);
        setFutureDate(futureD,futureM,futureG,false,false);

        JButton ButtonWr=new JButton("Writing to a file");
        //JButton jButtonNew=new JButton("Новое событие");

        panel.add(labelD);
        panel.add(textEv);
        panel.add(labelName);
        panel.add(editName);
        panel.add(labelTime);
        panel.add(time);
        panel.add(labelStatus);
        panel.add(editStaus);

        panel.add(labelFutureDate);
        panel.add(futureD);
        panel.add(label1);
        panel.add(futureM);
        panel.add(label2);
        panel.add(futureG);
        panel.add(ButtonWr);
        window.add(panel);
        window.setVisible(true);
        ActionListener actionListenerEditName = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BufEv.nameEv = editName.getSelectedItem().toString();
            }
        };
        ActionListener actionListenerTime = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new WrTimeEv(time.getText().toString());
            }
        };
        ActionListener actionListenereditStaus = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BufEv.nameSos = editStaus.getSelectedItem().toString();
                if (BufEv.nameSos.equals("Будет")) setFutureDate(futureD,futureM,futureG,true,true);
                else setFutureDate(futureD,futureM,futureG,false,false);
            }
        };
        ActionListener actionListenerfutureG = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                FutureDate futureDate = new FutureDate(futureD.getText() + "-" + futureM.getText() + "-" + futureG.getText());
                BufEv.futureDate = futureDate.getFutureDate();
                window.invalidate();    //обновить окно
            }
        };
        ActionListener actionListenerButtonWr = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MessageWr messageWr=new MessageWr();
                int ko=messageWr.getKo();
                if (ko==0) {
                    BufEv.nameEv = editName.getSelectedItem().toString();
                    FutureDate futureDate=new FutureDate(futureD.getText() + "-" + futureM.getText() + "-" + futureG.getText());
                    BufEv.futureDate= futureDate.getFutureDate();
                    new WrTimeEv(time.getText().toString());
                    new WrEv();
                }
            }
        };

        editName.addActionListener(actionListenerEditName);
        time.addActionListener(actionListenerTime);
        editStaus.addActionListener(actionListenereditStaus);
        futureD.addActionListener(actionListenerfutureG);
        futureM.addActionListener(actionListenerfutureG);
        futureG.addActionListener(actionListenerfutureG);
        ButtonWr.addActionListener(actionListenerButtonWr);
    }
    //D - день ДД
    //M - месяц ММ
    //G - год ГГГГ
    //b - активизация поля (true)
    //zero - обнуление поля (true)
    private void setFutureDate(JTextField D,JTextField M,JTextField G,boolean b,boolean zero){
        if (zero){
            D.setText(null);
            M.setText(null);
            G.setText(null);
        }
        else {
            D.setText(BufEv.futureDate.substring(0, 2));
            M.setText(BufEv.futureDate.substring(3, 5));
            G.setText(BufEv.futureDate.substring(6));
        }
        D.setEditable(b);
        M.setEditable(b);
        G.setEditable(b);
    }
}
