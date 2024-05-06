package Model;

public class MH_DT48 {
    private int id;
    private int idMH;
    private int idDT;
    private float donGiaMH;
    private float laiSuat;
    private int soLuong;

    public MH_DT48() {
    }

    public MH_DT48(int id, int idMH, int idDT, float donGiaMH, float laiSuat, int soLuong) {
        this.id = id;
        this.idMH = idMH;
        this.idDT = idDT;
        this.donGiaMH = donGiaMH;
        this.laiSuat = laiSuat;
        this.soLuong = soLuong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDonGiaMH() {
        return donGiaMH;
    }

    public void setDonGiaMH(float donGiaMH) {
        this.donGiaMH = donGiaMH;
    }

    public float getLaiSuat() {
        return laiSuat;
    }

    public void setLaiSuat(float laiSuat) {
        this.laiSuat = laiSuat;
    }

    public int getIdMH() {
        return idMH;
    }

    public void setIdMH(int idMH) {
        this.idMH = idMH;
    }

    public int getIdDT() {
        return idDT;
    }

    public void setIdDT(int idDT) {
        this.idDT = idDT;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
