package Model;

import java.util.Date;

public class ThongKeHopDong48 extends HopDong48 {
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private float tongGiaTriVay;
    private float tongTienLaiThuDuoc;

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

    public float getTongGiaTriVay() {
        return tongGiaTriVay;
    }

    public void setTongGiaTriVay(float tongGiaTriVay) {
        this.tongGiaTriVay = tongGiaTriVay;
    }

    public float getTongTienLaiThuDuoc() {
        return tongTienLaiThuDuoc;
    }

    public void setTongTienLaiThuDuoc(float tongTienLaiThuDuoc) {
        this.tongTienLaiThuDuoc = tongTienLaiThuDuoc;
    }
}
