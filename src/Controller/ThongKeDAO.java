package Controller;

import Model.DongMH48;
import Model.ThongKeDongMH48;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class ThongKeDAO {
    private Connection con;
    public ThongKeDAO() {
        String dbUrl = "jdbc:mysql://localhost/cnpm61";
        try {
            con = DriverManager.getConnection(dbUrl, "root", "");
            System.out.println("Connect success!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<DongMH48> getListDongMH48() {
        ArrayList<DongMH48> res = new ArrayList<DongMH48>();
        String sql = "SELECT dongMH, COUNT(id) AS tongSoHD, SUM(tongTien) AS tongDoanhThuLai FROM tblhoadonchokh48 GROUP BY dongMH";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            var rs = ps.executeQuery();
            while (rs.next()) {
                DongMH48 dongMH48 = new DongMH48();
                ThongKeDongMH48 tkeDongMH48 = new ThongKeDongMH48();
                dongMH48.setId(rs.getInt("id"));
                dongMH48.setDongMH(rs.getString("dongMH"));
                tkeDongMH48.setTongSoHoaDon(rs.getInt("tongSoHD"));
                tkeDongMH48.setTongDoanhThuLai(rs.getFloat("tongDoanhThuLai"));
                res.add(dongMH48);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
