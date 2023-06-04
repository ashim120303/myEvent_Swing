package RegEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;

public class RunEvent {
    String begP,endP,nameEv;
    public RunEvent(JFrame window, JPanel panel) throws ParseException {
        JFrame jF = new JFrame();
        new DelePanel(panel);
        JLabel beg = new JLabel("Beginning of the period   ");
        JTextField begPeriod = new JTextField(10);
        JLabel end = new JLabel("End of the period      ");
        JTextField endPeriod = new JTextField(10);
        JLabel labelName = new JLabel("Event name ");
        DirEnum[] items = DirEnum.values();
        JComboBox editName = new JComboBox(items);
        editName.setEditable(false);
        JLabel labelButtonT = new JLabel("Total time spent");
            labelButtonT.setForeground(Color.blue);
        JButton buttonT = new JButton("",new ImageIcon("images/T.png")  );
            //buttonT.setPreferredSize(new Dimension(25, 25));
        JLabel labelbuttonMin = new JLabel("Minimum time         ");
            labelbuttonMin.setForeground(Color.blue);
        JButton buttonMin = new JButton("",new ImageIcon("images/min.png"));
        JLabel labelbuttonMax = new JLabel("Maximum                    ");
            labelbuttonMax.setForeground(Color.blue);
        JButton buttonMax = new JButton("",new ImageIcon("images/max.png"));
        JLabel labelbuttonFuture = new JLabel("Future developments              ");
            labelbuttonFuture.setForeground(Color.RED);
        JButton buttonFuture = new JButton("",new ImageIcon("images/fut.png"));
        panel.add(beg);
        panel.add(begPeriod);
        panel.add(end);
        panel.add(endPeriod);
        panel.add(labelName);
        panel.add(editName);
        panel.add(labelButtonT);
        panel.add(buttonT);
        panel.add(labelbuttonMin);
        panel.add(buttonMin);
        panel.add(labelbuttonMax);
        panel.add(buttonMax);
        panel.add(labelbuttonFuture);
        panel.add(buttonFuture);
        window.add(panel);
        window.setVisible(true);

        ActionListener actionListenerBegPeriod = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                begP = begPeriod.getText().toString();
                ControlDate controlDate = new ControlDate(begP);
                controlDate.getKo();
            }
        };
        ActionListener actionListenerEndPeriod = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                endP = endPeriod.getText().toString();
                ControlDate controlDate = new ControlDate(endP);
                controlDate.getKo();
            }
        };
        ActionListener actionListenerEditName = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nameEv = editName.getSelectedItem().toString();
            }
        };
        ActionListener actionListenerButtonT = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new ReadMas(false,null,null);
                    begP = begPeriod.getText().toString();
                    endP = endPeriod.getText().toString();
                    nameEv = editName.getSelectedItem().toString();
                    TimeEventRun timeEventRun = new TimeEventRun(0,begP, endP, nameEv);
                    JOptionPane.showMessageDialog(jF, "Total time spent on the event: " + timeEventRun.getTe() + " hours", "Requests", JOptionPane.INFORMATION_MESSAGE);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(jF, "An incomprehensible error in calculating the duration", "Requests", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        ActionListener actionListenerButtonMin = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new ReadMas(false,null,null);
                    begP = begPeriod.getText().toString();
                    endP = endPeriod.getText().toString();
                    nameEv = editName.getSelectedItem().toString();
                    TimeEventRun timeEventRun = new TimeEventRun(1, begP, endP, nameEv);
                    JOptionPane.showMessageDialog(jF, "Minimum time per event: " + timeEventRun.getMin() + " hours", "Requests", JOptionPane.INFORMATION_MESSAGE);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(jF, "An incomprehensible error when calculating the minimum", "Requests", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        ActionListener actionListenerButtonMax = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    new ReadMas(false,null,null);
                    begP = begPeriod.getText().toString();
                    endP = endPeriod.getText().toString();
                    nameEv = editName.getSelectedItem().toString();
                    TimeEventRun timeEventRun = new TimeEventRun(2, begP, endP, nameEv);
                    JOptionPane.showMessageDialog(jF, "Maximum time per event: " + timeEventRun.getMax() + " hours", "Requests", JOptionPane.INFORMATION_MESSAGE);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(jF, "An incomprehensible error when calculating the maximum", "Requests", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
        ActionListener actionListenerButtonFuture = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //new ReadMas(true,null,null);
                begP = begPeriod.getText().toString();
                endP = endPeriod.getText().toString();
                //PrintEvFuture printEvFuture=new PrintEvFuture(begP,endP);
                //printEvFuture.createGUI(begP,endP);
                new PrintEvFuture(begP,endP);
            }
            };

        begPeriod.addActionListener(actionListenerBegPeriod);
        endPeriod.addActionListener(actionListenerEndPeriod);
        buttonT.addActionListener(actionListenerButtonT);
        buttonMin.addActionListener(actionListenerButtonMin);
        buttonMax.addActionListener(actionListenerButtonMax);
        buttonFuture.addActionListener(actionListenerButtonFuture);
    }
}
