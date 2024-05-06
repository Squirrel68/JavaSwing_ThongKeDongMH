package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class TkDongMHFrm48 {
    private JPanel ThongKeDongMHFrm48;
    private JButton quayLạiButton;
    private JTable table1;
    private JTextField start;
    private JTextField end;
    private JButton getButton;

    public void close() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(ThongKeDongMHFrm48);
        frame.dispose();
    }
    public TkDongMHFrm48() {
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
        getButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableLoad();
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = table1.getSelectedRow();
                String id = table1.getModel().getValueAt(row, 0).toString();
                close();
                TkMHFrm48 tkMHFrm48 = new TkMHFrm48(id);
                String[] list = {String.valueOf(id)};
                tkMHFrm48.main(list);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ThongKeDongMHFrm48");
        frame.setContentPane(new TkDongMHFrm48().ThongKeDongMHFrm48);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

//    code table
    private void tableLoad() {
        String start = this.start.getText();
        String end = this.end.getText();
        String[] columnNames = {"Mã dòng MH","Dòng MH", "Tổng số hóa đơn", "Tổng doanh thu lãi"};
        Controller.ThongKeDAO thongKeDAO = new Controller.ThongKeDAO();
        var list = thongKeDAO.getListDongMH48(start, end);
        Object[][] data = new Object[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getId();
            data[i][1] = list.get(i).getDongMH();
//            Format float to 1 decimal places
            data[i][2] = list.get(i).getTongSoHoaDon();
            data[i][3] = list.get(i).getTongDoanhThuLai();
            //            Format float to 1 decimal places
            data[i][3] = String.format("%.1f", list.get(i).getTongDoanhThuLai());
        }
        table1.setModel(new DefaultTableModel(data, columnNames));
    }
}
