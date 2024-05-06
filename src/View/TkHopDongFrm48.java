package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TkHopDongFrm48 {
    private JButton backButton;
    private JTable table1;
    private JPanel TkHopDongFrm48;

    public static void main(String[] args) {
        String iddongmh="", idmh="";
        if (args.length == 0) idmh = "error in dongMH48 id";
        else {
            iddongmh = args[0];
            idmh = args[1];
        }
        JFrame frame = new JFrame("TkHopDongFrm48");
        frame.setContentPane(new TkHopDongFrm48(iddongmh, idmh).TkHopDongFrm48);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void tableLoad(String iddongmh, String idMH) {
        // code to load table
        String [] columnNames = {"MaHopDong", "Tên KH", "Tổng giá trị vay", "Tổng tiền lãi thu được", "Ngày ký", "ID MH"};
        Controller.ThongKeDAO thongKeDAO = new Controller.ThongKeDAO();
        var list = thongKeDAO.getListHopDong48(idMH,"2023-01-01", "2023-12-12");
        Object[][] data = new Object[list.size()][7];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getId();
            data[i][1] = list.get(i).getKhachHang().getTenKH();
            // Format tong gia tri vay to 2 decimal places
            data[i][2] = String.format("%.2f", list.get(i).getTongGiaTriVay());
            data[i][3] = list.get(i).getTongTienLaiThuDuoc();
            data[i][4] = list.get(i).getNgayKi();
            data[i][5] = list.get(i).getMatHangDoiTac().getIdMH();
        }
        table1.setModel(new DefaultTableModel(data, columnNames));
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table1.setModel(model);
    }

    public TkHopDongFrm48(String iddongmh, String idMH) {
        tableLoad(iddongmh, idMH);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // click to redirect to ThongKeFrm48
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(backButton);
                frame.dispose();
                TkMHFrm48 tkMHFrm48 = new TkMHFrm48(iddongmh);
                String[] args = {iddongmh};
                tkMHFrm48.main(args);
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int row = table1.getSelectedRow();
                String idHopDong = table1.getModel().getValueAt(row, 0).toString();
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(backButton);
                frame.dispose();
                ChiTietHopDongFrm48 chiTietHopDongFrm48 = new ChiTietHopDongFrm48(iddongmh, idMH, idHopDong);
                String[] args = {iddongmh, idMH, idHopDong};
                chiTietHopDongFrm48.main(args);
            }
        });
    }
}
