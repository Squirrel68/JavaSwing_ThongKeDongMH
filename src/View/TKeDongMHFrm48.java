package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TKeDongMHFrm48 {
    private JPanel ThongKeDongMHFrm48;
    private JButton quayLạiButton;
    private JTable table1;

    public void close() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(ThongKeDongMHFrm48);
        frame.dispose();
    }
    public TKeDongMHFrm48() {
        tableLoad();
        quayLạiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // click to redirect to ThongKeFrm48
                close();
                ThongKeFrm48 thongKeFrm48 = new ThongKeFrm48();
                thongKeFrm48.main(null);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ThongKeDongMHFrm48");
        frame.setContentPane(new TKeDongMHFrm48().ThongKeDongMHFrm48);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

//    code table
    private void tableLoad() {
        String[] columnNames = {"Dòng MH", "Tổng số hóa đơn", "Tổng doanh thu lãi"};
//        Object[][] data = {
//                {"Dòng MH 1", 100, 1000000},
//                {"Dòng MH 2", 200, 2000000},
//                {"Dòng MH 3", 300, 3000000},
//                {"Dòng MH 4", 400, 4000000},
//                {"Dòng MH 5", 500, 5000000},
//        };
//        Load Data from ThongKeDAO
        Controller.ThongKeDAO thongKeDAO = new Controller.ThongKeDAO();
        var list = thongKeDAO.getListDongMH48();
        Object[][] data = new Object[list.size()][3];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getDongMH();
            data[i][1] = 0;
            data[i][2] = 0;
        }
        table1.setModel(new DefaultTableModel(data, columnNames));
    }
}
