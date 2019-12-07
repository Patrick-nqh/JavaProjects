package model;

public class KhachHang {
    private static int maKH = 100000;
    private String tenKH;
    private String sdt;
    private int soCMND;

    public KhachHang() {
    }

    public KhachHang(int maKH) {
        this.maKH = maKH;
    }

    public KhachHang( int maKH, String tenKH, String sdt, int soCMND) {
        this.maKH =maKH;
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.soCMND = soCMND;
    }

    public static int getMaKH() {
        return maKH;
    }

    public static void setMaKH(int maKH) {
        KhachHang.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(int soCMND) {
        this.soCMND = soCMND;
    }
}
