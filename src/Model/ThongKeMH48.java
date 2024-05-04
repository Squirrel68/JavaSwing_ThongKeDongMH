package Model;

import java.util.Date;

public class ThongKeMH48 {
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private int tongSoHoaDon;
    private float tongDoanhThuLai;

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getTongSoHoaDon() {
        return tongSoHoaDon;
    }

    public void setTongSoHoaDon(int tongSoHoaDon) {
        this.tongSoHoaDon = tongSoHoaDon;
    }

    public float getTongDoanhThuLai() {
        return tongDoanhThuLai;
    }

    public void setTongDoanhThuLai(float tongDoanhThuLai) {
        this.tongDoanhThuLai = tongDoanhThuLai;
    }
}
