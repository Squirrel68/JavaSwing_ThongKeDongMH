package Model;

import java.util.Date;

public class HoaDonChoKH48 {
    private int id;

    private Date ngayPhaiThanhToan;
    private float tongTienThanhToan;
    private float tongDuNo;
    private int trangThai;

    public HoaDonChoKH48() {
    }

    public HoaDonChoKH48(int id, Date ngayPhaiThanhToan, float tongTienThanhToan, float tongDuNo, int trangThai) {
        this.id = id;
        this.ngayPhaiThanhToan = ngayPhaiThanhToan;
        this.tongTienThanhToan = tongTienThanhToan;
        this.tongDuNo = tongDuNo;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgayPhaiThanhToan() {
        return ngayPhaiThanhToan;
    }

    public void setNgayPhaiThanhToan(Date ngayPhaiThanhToan) {
        this.ngayPhaiThanhToan = ngayPhaiThanhToan;
    }

    public float getTongTienThanhToan() {
        return tongTienThanhToan;
    }

    public void setTongTienThanhToan(float tongTienThanhToan) {
        this.tongTienThanhToan = tongTienThanhToan;
    }

    public float getTongDuNo() {
        return tongDuNo;
    }

    public void setTongDuNo(float tongDuNo) {
        this.tongDuNo = tongDuNo;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
}
