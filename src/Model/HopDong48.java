package Model;

import java.util.ArrayList;
import java.util.Date;

public class HopDong48 {
    private int id;
    private Date ngayKi;
    private int thoiHanVay;
    private NV48 nhanVien;
    private KH48 khachHang;
    private ArrayList<HoaDonChoKH48> hoaDonChoKHs;
    private MH_DT48 matHangDoiTac;
    private DT48 doiTac;

    public HopDong48() {
    }

    public HopDong48(int id, Date ngayKi, int thoiHanVay, NV48 nhanVien, KH48 khachHang, ArrayList<HoaDonChoKH48> hoaDonChoKHs, MH_DT48 matHangDoiTac, DT48 doiTac) {
        this.id = id;
        this.ngayKi = ngayKi;
        this.thoiHanVay = thoiHanVay;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.hoaDonChoKHs = hoaDonChoKHs;
        this.matHangDoiTac = matHangDoiTac;
        this.doiTac = doiTac;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getNgayKi() {
        return ngayKi;
    }

    public void setNgayKi(Date ngayKi) {
        this.ngayKi = ngayKi;
    }

    public int getThoiHanVay() {
        return thoiHanVay;
    }

    public void setThoiHanVay(int thoiHanVay) {
        this.thoiHanVay = thoiHanVay;
    }

    public NV48 getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NV48 nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KH48 getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KH48 khachHang) {
        this.khachHang = khachHang;
    }

    public ArrayList<HoaDonChoKH48> getHoaDonChoKHs() {
        return hoaDonChoKHs;
    }

    public void setHoaDonChoKHs(ArrayList<HoaDonChoKH48> hoaDonChoKHs) {
        this.hoaDonChoKHs = hoaDonChoKHs;
    }

    public MH_DT48 getMatHangDoiTac() {
        return matHangDoiTac;
    }

    public void setMatHangDoiTac(MH_DT48 matHangDoiTac) {
        this.matHangDoiTac = matHangDoiTac;
    }

    public DT48 getDoiTac() {
        return doiTac;
    }

    public void setDoiTac(DT48 doiTac) {
        this.doiTac = doiTac;
    }
}
