package Controller;

import Model.*;
import View.ChiTietHopDongFrm48;

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

    public ArrayList<ThongKeDongMH48> getListDongMH48(String start, String end) {
        ArrayList<ThongKeDongMH48> res = new ArrayList<ThongKeDongMH48>();
        String sql = "WITH unique_values AS (\n" +
                "    SELECT DISTINCT\n" +
                "        tblhoadonchokh48.id AS id_hoaDon,\n" +
                "        tblhoadonchokh48.TongTienThanhToan,\n" +
                "        tbldongmh48.id AS id_dongMH,\n" +
                "        tbldongmh48.DongMH\n" +
                "    FROM\n" +
                "        tblhoadonchokh48\n" +
                "    INNER JOIN\n" +
                "        tblhopdong48 ON tblhoadonchokh48.tblHopDong48ID = tblhopdong48.ID\n" +
                "    INNER JOIN\n" +
                "        tblhopdong_mhdt48 ON tblhopdong48.ID = tblhopdong_mhdt48.tblHopDong48ID\n" +
                "    INNER JOIN\n" +
                "        tblmh_dt48 ON tblhopdong_mhdt48.tblMH_DT48ID = tblmh_dt48.ID\n" +
                "    INNER JOIN\n" +
                "        tblmh48 ON tblmh_dt48.tblMH48ID = tblmh48.ID\n" +
                "    INNER JOIN\n" +
                "        tbldongmh48 ON tblmh48.tblDongMH48ID = tbldongmh48.ID\n" +
                "    WHERE\n" +
                "        tblhoadonchokh48.NgayPhaiThanhToan BETWEEN '"+ start+"' AND '"+end+"'\n" +
                ")\n" +
                "SELECT\n" +
                "    id_dongMH,\n" +
                "    dongMH,\n" +
                "    COUNT(id_hoaDon) AS tongSoHoaDon,\n" +
                "    SUM(TongTienThanhToan)*0.01 AS tongDoanhThu\n" +
                "FROM\n" +
                "    unique_values\n" +
                "GROUP BY\n" +
                "    id_dongMH, dongMH\n" +
                "ORDER BY\n" +
                "    tongDoanhThu DESC;\n";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            var rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeDongMH48 tkDongMH48 = new ThongKeDongMH48();
                tkDongMH48.setId(rs.getInt("id_dongMH"));
                tkDongMH48.setDongMH(rs.getString("dongMH"));
                tkDongMH48.setTongSoHoaDon(rs.getInt("tongSoHoaDon"));
                tkDongMH48.setTongDoanhThuLai(rs.getFloat("tongDoanhThu"));
                res.add(tkDongMH48);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public ArrayList<ThongKeMH48> getListMH48(String id_dongMH,String start, String end) {
        if (id_dongMH == null) id_dongMH = "1";
        if (start == null) start = "2023-01-01";
        if (end == null) end = "2023-12-12";
        ArrayList<ThongKeMH48> res = new ArrayList<ThongKeMH48>();
        String sql = "WITH \n" +
                "    TongTienHopDong AS (\n" +
                "        SELECT\n" +
                "            tblhopdong48.id AS id_hopDong,\n" +
                "            SUM(tblmh_dt48.DonGiaMH) AS tongTienHopDong\n" +
                "        FROM\n" +
                "            tblhopdong48\n" +
                "        INNER JOIN\n" +
                "            tblhopdong_mhdt48 ON tblhopdong48.ID = tblhopdong_mhdt48.tblHopDong48ID\n" +
                "        INNER JOIN\n" +
                "            tblmh_dt48 ON tblhopdong_mhdt48.tblMH_DT48ID = tblmh_dt48.ID\n" +
                "        GROUP BY\n" +
                "            id_hopDong\n" +
                "    ), \n" +
                "    BangKq1 AS (\n" +
                "        SELECT\n" +
                "            id_MH,\n" +
                "            TenMH,\n" +
                "        \tid_dongMH,\n" +
                "            id_hopDong,\n" +
                "            COUNT(id_hoaDon) AS tongSoHoaDon,\n" +
                "            SUM(tongTienThanhToan) AS tongDoanhThu,\n" +
                "            DonGiaMH\n" +
                "        FROM\n" +
                "            (SELECT DISTINCT\n" +
                "                tblhoadonchokh48.id AS id_hoaDon,\n" +
                "                tblhoadonchokh48.TongTienThanhToan,\n" +
                "                tbldongmh48.id AS id_dongMH,\n" +
                "                tbldongmh48.DongMH,\n" +
                "                tblhopdong48.id AS id_hopDong,\n" +
                "                tblmh48.id AS id_MH,\n" +
                "                tblmh48.TenMH,\n" +
                "                tblmh_dt48.DonGiaMH\n" +
                "            FROM\n" +
                "                tblhoadonchokh48\n" +
                "            INNER JOIN\n" +
                "                tblhopdong48 ON tblhoadonchokh48.tblHopDong48ID = tblhopdong48.ID\n" +
                "            INNER JOIN\n" +
                "                tblhopdong_mhdt48 ON tblhopdong48.ID = tblhopdong_mhdt48.tblHopDong48ID\n" +
                "            INNER JOIN\n" +
                "                tblmh_dt48 ON tblhopdong_mhdt48.tblMH_DT48ID = tblmh_dt48.ID\n" +
                "            INNER JOIN\n" +
                "                tblmh48 ON tblmh_dt48.tblMH48ID = tblmh48.ID\n" +
                "            INNER JOIN\n" +
                "                tbldongmh48 ON tblmh48.tblDongMH48ID = tbldongmh48.ID\n" +
                "            WHERE\n" +
                "                tblhoadonchokh48.NgayPhaiThanhToan BETWEEN '"+start+"' AND '"+end+"') AS unique_values\n" +
                "        GROUP BY\n" +
                "            id_hopDong, id_MH, TenMH, DonGiaMH\n" +
                "        ORDER BY\n" +
                "            tongDoanhThu DESC\n" +
                "    )\n" +
                "\n" +
                "SELECT \n" +
                "    BangKq1.*, \n" +
                "    SUM(tongSoHoaDon) as tongHoaDonMH,\n" +
                "    (DonGiaMH / tongTienHopDong) * tongDoanhThu AS DoanhThuMH_1HD,\n" +
                "    TongTienHopDong.tongTienHopDong,\n" +
                "    SUM((DonGiaMH / tongTienHopDong) * tongDoanhThu) AS doanhThuMH,\n" +
                "    (SUM((DonGiaMH / tongTienHopDong) * tongDoanhThu) * 0.01) AS LaiThuVe\n" +
                "FROM \n" +
                "    BangKq1\n" +
                "LEFT JOIN \n" +
                "    TongTienHopDong ON BangKq1.id_hopDong = TongTienHopDong.id_hopDong\n" +
                "WHERE id_dongMH ="+ id_dongMH+ "\n" +
                "GROUP BY id_MH\n" +
                "ORDER BY doanhThuMH DESC\n";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            var rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeMH48 tkeMH48 = new ThongKeMH48();
                tkeMH48.setId(rs.getInt("id_MH"));
                tkeMH48.setMatHang(rs.getString("TenMH"));
                tkeMH48.setTongSoHoaDon(rs.getInt("tongHoaDonMH"));
                tkeMH48.setTongDoanhThuLai(rs.getFloat("LaiThuVe"));
                res.add(tkeMH48);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public ArrayList<ThongKeHopDong48> getListHopDong48(String id_mh, String start, String end) {
        ArrayList<ThongKeHopDong48> res = new ArrayList<ThongKeHopDong48>();
        String sql = "WITH\n" +
                "    TongTienHoaDon AS (\n" +
                "        SELECT\n" +
                "            tblhopdong48.NgayKi,\n" +
                "            tblhopdong48.id AS idHopDong,\n" +
                "            SUM(tblhoadonchokh48.TongTienThanhToan) AS tongTienHoaDon\n" +
                "        FROM\n" +
                "            tblhopdong48\n" +
                "        INNER JOIN\n" +
                "            tblhoadonchokh48 ON tblhopdong48.id = tblhoadonchokh48.tblHopDong48ID\n" +
                "        GROUP BY\n" +
                "            idHopDong\n" +
                "    ),\n" +
                "    TongTienHopDong AS (\n" +
                "        SELECT\n" +
                "            tblhopdong48.id AS id_hopDong,\n" +
                "            tblkh48.TenKH,\n" +
                "            SUM(tblmh_dt48.DonGiaMH) AS tongTienHopDong\n" +
                "        FROM\n" +
                "            tblhopdong48\n" +
                "        INNER JOIN\n" +
                "            tblhopdong_mhdt48 ON tblhopdong48.ID = tblhopdong_mhdt48.tblHopDong48ID\n" +
                "        INNER JOIN\n" +
                "            tblmh_dt48 ON tblhopdong_mhdt48.tblMH_DT48ID = tblmh_dt48.ID\n" +
                "        INNER JOIN\n" +
                "        \ttblkh48 ON tblkh48.id = tblhopdong48.tblKH48ID\n" +
                "        GROUP BY\n" +
                "            id_hopDong, tblkh48.TenKH\n" +
                "    ),\n" +
                "    MH_HopDong AS (\n" +
                "        SELECT\n" +
                "            tblmh_dt48.tblMH48ID,\n" +
                "            tblhopdong_mhdt48.tblHopDong48ID\n" +
                "        FROM\n" +
                "            tblmh_dt48\n" +
                "        INNER JOIN\n" +
                "            tblhopdong_mhdt48 ON tblmh_dt48.id = tblhopdong_mhdt48.tblMH_DT48ID\n" +
                "    )\n" +
                "\n" +
                "SELECT\n" +
                "    TongTienHoaDon.idHopDong,\n" +
                "    TongTienHopDong.TenKH,\n" +
                "    TongTienHopDong.tongTienHopDong,\n" +
                "    (TongTienHoaDon.tongTienHoaDon*0.01) AS tongLaiThuDuoc,\n" +
                "    tongtienhoadon.ngayKi,\n" +
                "    MH_HopDong.tblMH48ID,\n" +
                "    MH_HopDong.tblHopDong48ID\n" +
                "FROM\n" +
                "    TongTienHoaDon\n" +
                "INNER JOIN\n" +
                "    TongTienHopDong ON TongTienHoaDon.idHopDong = TongTienHopDong.id_hopDong\n" +
                "INNER JOIN\n" +
                "    MH_HopDong ON TongTienHopDong.id_hopDong = MH_HopDong.tblHopDong48ID\n" +
                "WHERE tblmh48id ="+id_mh+";";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            var rs = ps.executeQuery();
            while (rs.next()) {
                ThongKeHopDong48 tkeHD = new ThongKeHopDong48();
                KH48 kh = new KH48(0, rs.getString("TenKH"));
                tkeHD.setKhachHang(kh);
                tkeHD.setTongGiaTriVay(rs.getFloat("tongTienHopDong"));
                tkeHD.setTongTienLaiThuDuoc(rs.getFloat("tongLaiThuDuoc"));
                tkeHD.setNgayKi(rs.getDate("ngayKi"));
                tkeHD.setId(rs.getInt("idHopDong"));
                tkeHD.setMatHangDoiTac(new MH_DT48(0, rs.getInt("tblMH48ID"), 2,3,4,1));
                res.add(tkeHD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
    public ArrayList<HopDong48> getChiTietHopDong(String idHopDong) {
        ArrayList<HopDong48> res = new ArrayList<HopDong48>();
        String sql = "SELECT tblhopdong48.ID AS IdHopDong,\n" +
                "tblkh48.TenKH,\n" +
                "tbldt48.TenDT,\n" +
                "tblmh48.TenMH,\n" +
                "tblmh_dt48.DonGiaMH,\n" +
                "tblmh_dt48.LaiSuat,\n" +
                "tblmh_dt48.soLuong,\n" +
                "(soLuong*donGiaMH) AS TongTien,\n" +
                "tblhoadonchokh48.*\n" +
                "FROM\n" +
                "tblhopdong48 \n" +
                "INNER JOIN tblkh48 ON tblhopdong48.tblKH48ID = tblkh48.id \n" +
                "INNER JOIN tblhopdong_mhdt48 ON tblhopdong48.ID = tblhopdong_mhdt48.tblHopDong48ID\n" +
                "INNER JOIN tblmh_dt48 ON tblhopdong_mhdt48.tblMH_DT48ID = tblmh_dt48.id \n" +
                "INNER JOIN tbldt48 ON tblmh_dt48.tblDT48ID = tbldt48.ID\n" +
                "INNER JOIN tblmh48 ON tblmh_dt48.tblMH48ID = tblmh48.ID\n" +
                "INNER JOIN tblhoadonchokh48 ON tblHopDong48.ID = tblhoadonchokh48.tblHopDong48ID\n" +
                "WHERE tblhopdong48.ID ="+idHopDong+"";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            var rs = ps.executeQuery();
            while (rs.next()) {
                HopDong48 hd = new HopDong48();
                hd.setId(rs.getInt("IdHopDong"));
                hd.setKhachHang(new KH48(0, rs.getString("TenKH")));
                hd.setDoiTac(new DT48(0, rs.getString("TenDT")));
                hd.setMatHang(new MH48(0, rs.getString("TenMH")));
                hd.setMatHangDoiTac(new MH_DT48(0, 0, 0, rs.getFloat("DonGiaMH"), rs.getFloat("LaiSuat"), rs.getInt("soLuong")));
                HoaDonChoKH48 hdChoKH = new HoaDonChoKH48();
                hdChoKH.setId(rs.getInt("ID"));
                hdChoKH.setNgayPhaiThanhToan(rs.getDate("NgayPhaiThanhToan"));
                hdChoKH.setTongTienThanhToan(rs.getFloat("TongTienThanhToan"));
                hd.setHoaDonChoKH(hdChoKH);
                res.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

}
