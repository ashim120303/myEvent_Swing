package RegEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import java.awt.*;

public class PrintEv {
    public PrintEv() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(false);
                createGUI();
            }
        });
    }
    public static void createGUI() {
        JFrame frame = new JFrame("My Events");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        String[] columnNames = {
                "Date of entry",
                "Event",
                "Duration",
                "Status",
                "Event date"
        };
        new ReadMas(false,null,null);
        String[][] data= BufEv.masMyEvent.toArray(new String[0][]);
        JTable table = new JTable(data, columnNames);
        TableColumn columData = table.getColumnModel().getColumn(0);
        columData.setPreferredWidth(50);
        TableColumn columDlit = table.getColumnModel().getColumn(2);
        columDlit.setPreferredWidth(35);
        TableColumn columnStatus = table.getColumnModel().getColumn(3);
        columnStatus.setPreferredWidth(10);
        TableColumn columnFuture = table.getColumnModel().getColumn(4);
        columnFuture.setPreferredWidth(30);
        JScrollPane scrollPane = new JScrollPane(table);

        frame.getContentPane().add(scrollPane);
        frame.setPreferredSize(new Dimension(550, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
