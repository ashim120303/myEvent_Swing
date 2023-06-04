package RegEvent;
import javax.swing.*;

public class MessageWr {
    private int ko;
    public MessageWr() {
        JFrame jF = new JFrame();
        Object[] options = {"Yes","No"};
        ko = JOptionPane.showOptionDialog(jF,
                "Write an event to a file?",
                "Write an event to a file",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,       //do not use a custom Icon
                options,        //the titles of buttons
                options[0]);    //default button title
    }

    public int getKo(){
        return ko;
    }
}
