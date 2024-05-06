package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChiTietHopDongFrm48 {
    private JButton button1;
    private JLabel fieldName;
    private JPanel ChiTietHopDongFrm48;
    private JTable table1;
    private JTable table2;
    private JTable table3;
    private JTextField nhânViên1TextField;
    private JTextField a2TextField;
    private JTextField a20230102TextField;
    private JTextField a5ThángTextField;

    public static void main(String[] args) {
        String iddongmh="", idmh="", idHopDong="";
        if (args.length == 0) idmh = "error in dongMH48 id";
        else {
            iddongmh = args[0];
            idmh = args[1];
            idHopDong = args[2];
        }
        JFrame frame = new JFrame("ChiTietHopDongFrm48");
        frame.setContentPane(new ChiTietHopDongFrm48(iddongmh,idmh,idHopDong).ChiTietHopDongFrm48);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void setTable1(String idHopDong) {
        // set table1
        String[] columnNames = {"Ten Khách hàng"};
        Controller.ThongKeDAO thongKeDAO = new Controller.ThongKeDAO();
        var list = thongKeDAO.getChiTietHopDong(idHopDong);
        System.out.println("list: " + list.size());
        Object[][] data = new Object[1][1];
        data[0][0] = list.get(0).getKhachHang().getTenKH();
        table1.setModel(new DefaultTableModel(data, columnNames));
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        table1.setModel(model);
    }

    private void setTable2(String idHopDong) {
        // set table2
        String[] columnNames = {"Tên MH","Tên đối tác", "Đơn giá", "Lãi suất", "Số lượng"};
        Controller.ThongKeDAO thongKeDAO = new Controller.ThongKeDAO();
        var list = thongKeDAO.getChiTietHopDong(idHopDong);
        Object[][] data = new Object[list.size()][5];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getMatHang().getMatHang();
            data[i][1] = list.get(i).getDoiTac().getTenDT();
            data[i][2] = list.get(i).getMatHangDoiTac().getDonGiaMH();
            data[i][3] = list.get(i).getMatHangDoiTac().getLaiSuat();
            data[i][4] = list.get(i).getMatHangDoiTac().getSoLuong();
        }
        // Gop nhung dong có cùng tên MH và tên đối tác
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (data[i][0].equals(data[j][0]) && data[i][1].equals(data[j][1])) {
                    data[i][4] = data[j][4];
                    data[j][0] = "";
                    data[j][1] = "";
                    data[j][2] = "";
                    data[j][3] = "";
                    data[j][4] = "";
                }
            }
        }
        // Dem so dong khac rong
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (!data[i][0].equals("")) {
                count++;
            }
        }
        // Tao mang moi de luu nhung dong khac rong
        Object[][] data2 = new Object[count][5];
        int k = 0;
        for (int i = 0; i < list.size(); i++) {
            if (!data[i][0].equals("")) {
                data2[k][0] = data[i][0];
                data2[k][1] = data[i][1];
                data2[k][2] = data[i][2];
                data2[k][3] = data[i][3];
                data2[k][4] = data[i][4];
                k++;
            }
        }
        // Set table2
        table2.setModel(new DefaultTableModel(data2, columnNames));
        DefaultTableModel model = new DefaultTableModel(data2, columnNames);
        table2.setModel(model);
    }

    private void setTable3(String idHopDong) {
        // set table3
        String[] columnNames = {"Mã hóa đơn", "Ngày thanh toán", "Số tiền thanh toán", "Trạng thái"};
        Controller.ThongKeDAO thongKeDAO = new Controller.ThongKeDAO();
        var list = thongKeDAO.getChiTietHopDong(idHopDong);
        Object[][] data = new Object[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            data[i][0] = list.get(i).getHoaDonChoKH().getId();
            data[i][1] = list.get(i).getHoaDonChoKH().getNgayPhaiThanhToan();
            data[i][2] = list.get(i).getHoaDonChoKH().getTongTienThanhToan();
            data[i][3] = list.get(i).getHoaDonChoKH().getTrangThai();
        }
        // Gop nhung dong có cùng mã hóa đơn
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (data[i][0].equals(data[j][0])) {
                    data[i][2] = data[j][2];
                    data[j][0] = "";
                    data[j][1] = "";
                    data[j][2] = "";
                    data[j][3] = "";
                }
            }
        }
        // Dem so dong khac rong
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (!data[i][0].equals("")) {
                count++;
            }
        }
        // Tao mang moi de luu nhung dong khac rong
        Object[][] data2 = new Object[count][4];
        int k = 0;
        for (int i = 0; i < list.size(); i++) {
            if (!data[i][0].equals("")) {
                data2[k][0] = data[i][0];
                data2[k][1] = data[i][1];
                data2[k][2] = data[i][2];
                data2[k][3] = data[i][3];
                k++;
            }
        }
        // Set table3
        table3.setModel(new DefaultTableModel(data2, columnNames));
        DefaultTableModel model = new DefaultTableModel(data2, columnNames);
        table3.setModel(model);
    }
    public ChiTietHopDongFrm48(String dongMH,String idMH, String idHopDong) {
        setTable1(idHopDong);
        setTable2(idHopDong);
        setTable3(idHopDong);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(ChiTietHopDongFrm48);
                frame.dispose();
                TkHopDongFrm48 tkHopDongFrm48 = new TkHopDongFrm48(dongMH, idMH);
                String[] args = {dongMH, idMH};
                tkHopDongFrm48.main(args);
            }
        });
    }
}
