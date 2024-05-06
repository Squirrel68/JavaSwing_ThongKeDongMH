package Model;

import java.util.ArrayList;
import java.util.Date;

public class HopDong48 {
    private int id;
    private Date ngayKi;
    private int thoiHanVay;
    private NV48 nhanVien;
    private KH48 khachHang;
    private HoaDonChoKH48 hoaDonChoKH;
    private MH_DT48 matHangDoiTac;
    private DT48 doiTac;
    private MH48 matHang;

    public MH48 getMatHang() {
        return matHang;
    }

    public void setMatHang(MH48 matHang) {
        this.matHang = matHang;
    }

    public HopDong48() {
    }

    public HopDong48(int id, Date ngayKi, int thoiHanVay, NV48 nhanVien, KH48 khachHang, HoaDonChoKH48 hoaDonChoKHs, MH_DT48 matHangDoiTac, DT48 doiTac, MH48 matHang) {
        this.id = id;
        this.ngayKi = ngayKi;
        this.thoiHanVay = thoiHanVay;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.hoaDonChoKH = hoaDonChoKHs;
        this.matHangDoiTac = matHangDoiTac;
        this.doiTac = doiTac;
        this.matHang = matHang;
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

    public HoaDonChoKH48 getHoaDonChoKH() {
        return hoaDonChoKH;
    }

    public void setHoaDonChoKH(HoaDonChoKH48 hoaDonChoKHs) {
        this.hoaDonChoKH = hoaDonChoKHs;
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
