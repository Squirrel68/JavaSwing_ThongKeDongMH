package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class TkMHFrm48 {

    private JButton backButton;
    private JTable table1;
    private JPanel TkMHFrm48;
    private String id_dongMH;

    public String getId_dongMH() {
        return id_dongMH;
    }

    public void setId_dongMH(String id_dongMH) {
        this.id_dongMH = id_dongMH;
    }

    public static void main(String[] args) {
        String inp;
//        if arg null
        if (args.length == 0) inp = "1";
        else inp = args[0];

        JFrame frame = new JFrame("TkMHFrm48");
        frame.setContentPane(new TkMHFrm48(inp).TkMHFrm48);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void close() {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(backButton);
        frame.dispose();
    }

    private void tableLoad(String id_dongMH) {
        String [] columnNames = {"Mã MH", "Mặt hàng", "Tổng số hóa đơn", "Tổng doanh thu lãi"};
        Controller.ThongKeDAO thongKeDAO = new Controller.ThongKeDAO();
//        System.out.println("id_dongMH: " + id_dongMH);
        var list = thongKeDAO.getListMH48(id_dongMH, "2023-01-01", "2023-12-12");
        Object[][] data = new Object[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getId();
            data[i][1] = list.get(i).getMatHang();
            data[i][2] = list.get(i).getTongSoHoaDon();
            data[i][3] = list.get(i).getTongDoanhThuLai();
        }
        table1.setModel(new DefaultTableModel(data, columnNames));
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table1.setModel(model);
    }


    public TkMHFrm48(String id_dongMH) {
        tableLoad(id_dongMH);
        this.id_dongMH = id_dongMH;
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // click to redirect to ThongKeDongMHFrm48
                close();
                TkDongMHFrm48 tkeDongMH = new TkDongMHFrm48();
                tkeDongMH.main(null);
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = table1.getSelectedRow();
                String idMH = table1.getModel().getValueAt(row, 0).toString();
                String id_dongMH = getId_dongMH();
                close();
                TkHopDongFrm48 tkeHDFrm48 = new TkHopDongFrm48(id_dongMH, idMH);
                String[] list = {id_dongMH, idMH};
                tkeHDFrm48.main(list);
            }
        });
    }
}
