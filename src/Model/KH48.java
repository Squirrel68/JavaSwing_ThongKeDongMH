package Model;

public class KH48 {
    private int id;
    private String tenKH;

    public KH48() {
    }

    public KH48(int id, String tenKH) {
        this.id = id;
        this.tenKH = tenKH;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }
}
