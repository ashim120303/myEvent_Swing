package RegEvent;

import javax.swing.*;
import java.awt.event.ActionEvent;

class ExitAction extends AbstractAction {
    private static final long serialVersionUID = 1L;
    ExitAction() {
        putValue(NAME, "Exit");
    }
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
