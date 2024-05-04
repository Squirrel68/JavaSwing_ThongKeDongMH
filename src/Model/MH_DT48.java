package Model;

public class MH_DT48 {
    private int id;
    private float donGiaMH;
    private float laiSuat;

    public MH_DT48() {
    }

    public MH_DT48(int id, float donGiaMH, float laiSuat) {
        this.id = id;
        this.donGiaMH = donGiaMH;
        this.laiSuat = laiSuat;
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
}
